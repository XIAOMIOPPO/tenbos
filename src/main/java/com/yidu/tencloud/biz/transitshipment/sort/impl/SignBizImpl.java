package com.yidu.tencloud.biz.transitshipment.sort.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.transitshipment.sort.Outstorage;
import com.yidu.tencloud.bean.transitshipment.sort.OutstorageDetail;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;
import com.yidu.tencloud.bean.transitshipment.sort.Storagein;
import com.yidu.tencloud.bean.transitshipment.sort.StorageinDetail;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.biz.transitshipment.sort.SignBiz;
import com.yidu.tencloud.dao.system.userdao.UserMapper;
import com.yidu.tencloud.dao.transitshipment.sort.SignDao;
import com.yidu.tencloud.util.CommPOIUtil;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

@Service
public class SignBizImpl implements SignBiz{
	
	/**
	 * 入库dao
	 */
	@Autowired
	private SignDao signDao;
	
	/**
	 * 工作单biz
	 */
	@Autowired
	private WorkSheetBiz workSheetBiz;
	
	
	/**
	 * 用户mapper
	 */
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 获取用户mapper
	 * @return 用户mapper
	 */
	public UserMapper getUserMapper() {
		return userMapper;
	}

	
	/**
	 * 设置用户mapper
	 * @param userMapper  用户mapper
	 */
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;

	
	}

	
	/**
	 * 获取工作单biz
	 * @return 工作单biz
	 */
	public WorkSheetBiz getWorkSheetBiz() {
		return workSheetBiz;
	}

	
	/**
	 * 设置工作单biz
	 * @param workSheetBiz 工作单biz
	 */
	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}

	
	/**
	 * 获取入库dao
	 * @return 入库mapper
	 */
	public SignDao getSignDao() {
		return signDao;
	}

	/**
	 * 设置入库mapper
	 * @param signDao 入库mapper
	 */
	public void setSignDao(SignDao signDao) {
		this.signDao = signDao;
	}

	@Override
	public List<Storagein> findStorages(Map<String, Object> params) {
		//模糊查询入库信息
		return signDao.findStorages(params);
	}

	@Override
	public List<StorageinDetail> findStorageDetailById(Map<String, Object> params) {
		//通过id查询入库详情
		return signDao.findStorageDetailById(params);
	}

	@Override
	public List<StorageinDetail> parseExecel(MultipartFile myFile) {
		List<StorageinDetail> sdetail = new ArrayList<StorageinDetail>();
		//解析execel文档获取单号可能是工作单号，可能是合包号
		//获取工作簿
		Workbook wb = CommPOIUtil.getWorkBook(myFile);
		//获取工作簿中的数据
		List<List<Object>> lists = CommPOIUtil.commReadExecel(wb);
		//遍历集合
		for (int i = 1; i < lists.size(); i++) {
			//判断是工作单号还是合包号
			List<Object> olist = lists.get(i);
			//判断size是否为1
			if(olist.size()==1) {
				//获取单号
				String wno = (String) olist.get(0);
				//判断是否为合包号
				if (wno.indexOf("hbh")==-1) {
					//工作单号 查询出相关信息
					StorageinDetail detail = new StorageinDetail();
					//获取工作单对象
					WorkSheet worksheet = workSheetBiz.findWorkSheet(wno);
					//获取重量
					Double weight = worksheet.getRule().getActualWeight();
					//设置重量
					detail.setWeight(new BigDecimal(weight));
					//设置详情no
					detail.setSdetailNo(wno);
					//添加详情对象
					sdetail.add(detail);
				} else {
					//合包号 执行自动拆包
					List<StorageinDetail> details = demoPack(wno);
					//添加所有集合
					sdetail.addAll(details);
				}
			}
			
			
			
		}
		//返回集合
		return sdetail;
	}

	
	@Override
	public List<StorageinDetail> findSheetDetailByNo(String wno){
		//创建入库详情集合
		List<StorageinDetail> sdetail = new ArrayList<StorageinDetail>();
		//判断是否为合包号
		if (wno.indexOf("hbh")==-1) {
			//工作单号 查询出相关信息
			StorageinDetail detail = new StorageinDetail();
			//找到工作单对象
			WorkSheet worksheet = workSheetBiz.findWorkSheet(wno);
			//判断是否有工作单
			if(worksheet!=null) {
				//获取重量
				Double weight = worksheet.getRule().getActualWeight();
				//设置重量
				detail.setWeight(new BigDecimal(weight));
				//设置no
				detail.setSdetailNo(wno);
				//提交对象
				sdetail.add(detail);
			}
		} else {
			//合包号 执行自动拆包
			List<StorageinDetail> details = demoPack(wno);
			//添加所有集合
			sdetail.addAll(details);
		}
		
		//返回集合
		return sdetail;
		
	}
	
	
	@Override
	public int countStorages(Map<String, Object> params) {
		//返回入库计数
		return signDao.countStorages(params);
	}

	@Override
	public int countStorageDetail(Map<String, Object> params) {
		//返回入库详情计数
		return signDao.countStorageDetail(params);
	}

	@Override
	public int addStoragein(List<StorageinDetail> storageinDetail) {
		//获取分单
		Map<String,List<StorageinDetail>> sheets = masterBill(storageinDetail);
		//键集合
		Set<String> sets = sheets.keySet();
		//遍历set
		for (String set : sets) {
			//获取详情集合
			List<StorageinDetail> sheet = sheets.get(set);
			//生成工作单
			createSheet(sheet,set);
		}
		//返回影响的行数
		return 1;
	}

	
	/**
	 * 创建入库工作单
	 * @param sheet 工作单集合
	 */
	private boolean createSheet(List<StorageinDetail> sheet,String sendName) {
		//创建入库对象
		Storagein sin = new Storagein();
		//设置入库id
		sin.setStorageinId(IDGenderatorUtil.generateId());
		//设置入库单号
		sin.setStorageinNo(FlowOddNumber.AtomicRangeInteger("入库"));
		//获取当前用户
		User user = ShiroUtil.getUser();
		//设置收货人id
		sin.setRecPersonId(user.getUserId());
		//设置接受人名
		sin.setRecPersonName(user.getUserName());
		//设置接受时间
		sin.setRecDate(new Date());
		//设置接收人单位
		sin.setRecOrgId(user.getOrgId());
		//设置接收人单位名
		sin.setRecOrgName(user.getOrgName());
		//设置发送人名
		sin.setSendPersonName(sendName);
		//判断是否有为初次入库
		if(sendName.equals("eoutno")) {
			//设置发送人为当前用户
			sin.setSendPersonName(user.getUserName());
			//设置发送阻止id
			sin.setSendOrgId(user.getOrgId());
			//设置发送人id
			sin.setSendPersonId(user.getUserId());
		}
		
		//发送人对象
		User sendUser = userMapper.findUserByName(sendName);
		
		//设置发货人相关信息
		sin.setSendOrgId(sendUser.getOrgId());
		//设置发送组织名
		sin.setSendOrgName(sendUser.getOrgName());
		//设置发送人id
		sin.setSendPersonId(sendUser.getUserId());
		
		//设置详情bean
		for (StorageinDetail storageinDetail : sheet) {
			//设置签收id
			storageinDetail.setSdetailId(IDGenderatorUtil.generateId());
			if(sendName=="eoutno") {
				storageinDetail.setRstatus("初次入库");
			}
			//设置状态
			storageinDetail.setRstatus("中转入库");
		}
		//添加主表信息
		int resultin = signDao.addStorageIn(sin);
		//添加从表数据
		for (StorageinDetail storageinDetail : sheet) {
			//添加入库详情
			signDao.addStorageInDetail(storageinDetail);
		}
		
		//返回结果
		return resultin>0?true:false;
	}


	
	/**
	 * 分单号
	 * @param storageinDetail 入库详情集合
	 */
	private Map<String,List<StorageinDetail>> masterBill(List<StorageinDetail> storageinDetail) {
		Map<String,List<StorageinDetail>> sheet = new HashMap<String,List<StorageinDetail>>();
		//拆分关联出入库，按出库人合并，判断需要生成几张入库单
		for (StorageinDetail sdetail : storageinDetail) {
			//获得关联出库单号
			String outno = sdetail.getOutstorageno();
			//判断是否有关联出库单号
			if(outno==null) {
				//无关联出库交接单号
				if(sheet.containsKey("eoutno")) {
					//往map中的集合添加数据
					sheet.get("eoutno").add(sdetail);
				}else {
					//创建初始添加数据
					List<StorageinDetail> nolist = new ArrayList<StorageinDetail>();
					//添加数据
					nolist.add(sdetail);
				}
				
			}else {
				//根据出库交接单号查询返货人
				String outPer = signDao.findOutPerByOutNo(outno);
				//判断outper是否为空
				if(outPer!=null) {
					//判断是否同一个人
					if(sheet.containsKey(outPer)) {
						//添加值同一个人的集合中
						sheet.get(outPer).add(sdetail);
					}else {
						//创建一个新的集合
						List<StorageinDetail> sdetailList = new ArrayList<StorageinDetail>();
						//往集合中添加数据
						sdetailList.add(sdetail);
						//放进map集合
						sheet.put(outPer, sdetailList);
					}
				}
			}
		}
		return sheet;
	}

	@Override
	public int addOutStorage(List<OutstorageDetail> outstorage) {
		
		return 0;
	}

	@Override
	public List<StorageinDetail> demoPack(String packageNo) {
		//创建详情集合
		List<StorageinDetail> storages = new ArrayList<StorageinDetail>();
		//合包集合
		List<Packagelist> sdetail = signDao.demoPack(packageNo);
		//获取关联的交接单号
		String outno=signDao.findOutStoragenoByCopackNo(packageNo);
		//生成详情对象
		for (Packagelist packagelist : sdetail) {
			StorageinDetail detail = new StorageinDetail();
			detail.setSdetailId(IDGenderatorUtil.generateId());
			//设置关联交接号
			detail.setOutstorageno(outno);
			//设置重量
			detail.setWeight(packagelist.getActualWeight());
			//设置单号
			detail.setSdetailNo(packagelist.getWorkSheetNo());
			//设置合包号
			detail.setCopackno(packageNo);
			//添加详情对象
			storages.add(detail);
		}
		
		return storages;
	}

	
	@Override
	public List<OutstorageDetail> findOutDetialByNo(String outNo) {
		//通过详情no找出库详情
		List<OutstorageDetail> details = signDao.findOutstorageDetailByNo(outNo);
		for (OutstorageDetail outstorageDetail : details) {
			//设置出库单号
			outstorageDetail.setOutdetailId(outNo);
		}
		//返回查询结果
		return details;
	}

	@Override
	public List<Map<String, String>> findOutStatus(List<String> outno) {
		List<Map<String,String>> maps = new ArrayList<Map<String,String>>();
		User user = ShiroUtil.getUser();
		//遍历集合
		for (String no : outno) {
			//创建map
			Map<String,String> tmap = new HashMap<String,String>();
			//获取出库对象
			Outstorage out = signDao.findOutstorageByNo(no);
			//判断物流方向是否指向本单位
			//放入单号
			tmap.put("outstorageno", no);
			if(out==null) {
				continue;
			}
			if(out.getLogdir().equals(user.getOrgName())) {
				//物流方向指向本单位  上环节入库 或 二次入库
				//判断是否为本单位
				if(out.getDelivererOrg().equals(user.getOrgId())) {
					//二次入库
					tmap.put("type", "本环节");
				}else {
					//上环节入库
					tmap.put("type", "上环节");
				}
				
			}else {
				//物流方向不指向本单位 	它环节入库 特殊情况发生
				tmap.put("type", "它环节");
			}
			
			//添加至集合
			maps.add(tmap);
			
		}
		
		return maps;
	}

	@Override
	public List<Outstorage> findPageOutstorage(Map<String, Object> params) {
		//模糊查询出库
		return signDao.findPageOutstorage(params);
	}

	@Override
	public int countPageOutstorage(Map<String, Object> params) {
		//统计出详情
		return signDao.countPageOutstorage(params);
	}

}

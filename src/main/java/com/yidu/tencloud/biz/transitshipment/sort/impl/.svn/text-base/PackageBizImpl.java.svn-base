package com.yidu.tencloud.biz.transitshipment.sort.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.transitshipment.sort.Packageinfo;
import com.yidu.tencloud.bean.transitshipment.sort.Packagelist;
import com.yidu.tencloud.biz.transitshipment.sort.PackageBiz;
import com.yidu.tencloud.dao.transitshipment.sort.PackageMapper;
import com.yidu.tencloud.util.CommPOIUtil;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;
/**
 * 合包业务层
 * @author 刘勇杰
 *
 */
@Service
public class PackageBizImpl implements PackageBiz{

	@Autowired
	private PackageMapper pMapper;

	public void setpMapper(PackageMapper pMapper) {
		this.pMapper = pMapper;
	}
	
	/**
	 * 分页查询合包主表
	 */
	public List<Packageinfo> findPackageinfoPagenation(Map<String, Integer> paramMap) {
		return pMapper.findPackageinfoPagenation(paramMap);
	}

	/**
	 * 查询合包主表总记录数
	 */
	public int countPackageinfo() {
		return pMapper.countPackageinfo();
	}
	
	/**
	 * 上传EXCEL文件
	 * @param myFile 文件名
	 * @return 返回所获得的文件
	 * @throws IOException 异常
	 */
	@Override
	public List<Packagelist> parseExecel(MultipartFile myFile) throws IOException {
		//定义一个合包集合
		List<Packagelist> sheets = new ArrayList<>();
		//获得文件，调用表格方法，且在里面调用文档方法解析
		List<List<Object>> list = CommPOIUtil.commReadExecel(CommPOIUtil.getWorkBook(myFile));
		//遍历循环，定义个变量等于7
		for (int j = 7; j < list.size(); j++) {
			//创建obj集合，获得第j个元素
			List<Object> tmpList = list.get(j);
			//判断是否为空或判断集合的大小是否为1
			if(!tmpList.isEmpty()&&tmpList.size()==1) {
				//创建一个明细对象 
				Packagelist packagelist = new Packagelist();
				//设置合包明细表单号，将从表格里获得的数据进行强转为字符串
				packagelist.setOddNo((String)tmpList.get(0));
				//把工作单导入的数据添加进集合
				sheets.add(packagelist);
			}
		}
		//返回集合
		return sheets;
	}
	
	/**
	 * 添加合包主表信息
	 */
	@Override
	public boolean addPackageinfo(Packageinfo packageinfo) {
		//获得当前用户相关信息
		User user=ShiroUtil.getUser();
		//获得当前用户名字
		packageinfo.setPackageUnit(user.getOrgName());
		//设置拆包状态，保存默认为未拆包
		packageinfo.setPstatus("1");//未拆包
		//设置合包转台，默认为未作废
		packageinfo.setStatus("0");//未作废
		//送达时限
		packageinfo.setServiceTimeLimit(new Date());
		//设置总件数
		packageinfo.setTotalPackages(new BigDecimal(33.00));
		//设置总体积
		packageinfo.setDestination("上海市");
		packageinfo.setTotalVolume(new BigDecimal(22.00));
		//生成合包Id
		String packageId = IDGenderatorUtil.generateId();
		//设置合包Id
		packageinfo.setPackageId(packageId);
		//合包时间
		packageinfo.setPackageTime(new Date());
		//调用Mapper的添加主方法
		pMapper.addPackageinfo(packageinfo);
		//调用合包明细，通过合包Id
		addPackagelist(packageinfo.getPkgDetailList(),packageId);
		
		return  true;
	}
	
	/**
	 * 添加合包明细信息
	 */
	public boolean addPackagelist(List<Packagelist> packagelist,String packageId) {
		//遍历获得的明细表集合
		for (Packagelist packagelist1:packagelist) {
			//在明细表设置合包Id
			packagelist1.setPackageId(packageId);
			//设置送达时限
			packagelist1.setServiceTimeLimit(new Date());
			//调用Mapper的添加合包明细方法
			pMapper.addPackagelist(packagelist1);
		}
		return true;
	}
	
	/**
	 * 根据拆解后的单号查找相关信息
	 */
	@Override
	public Packagelist findPackagelistByOddNo(Map<String, String> paramMap) {
		return pMapper.findPackagelistByOddNo(paramMap);
	}
	
	/**
	 * 查询当前时间
	 * @param date 日期
	 * @return 查询的数量
	 */
	@Override
	public int datePackageSizeQuery(String date) {
	  
		return pMapper.datePackageSizeQuery(date);
	}

	/**
	 * 作废（根据合包号修改合包状态）
	 */
	public boolean deletePackageStatus(String[] packageNo) {
		//创建集合对象
		List<String> items = new ArrayList<>();
		//遍历数组
		for (String item : packageNo) {
			//将遍历得到的数据添加到集合对象中
			items.add(item);
		}
		return pMapper.deletePackageStatus(items)>0?true:false;
	}

	/**
	 * 根据合包Id查询合包信息
	 * @param packageId
	 * @return
	 */
	public Packageinfo findPackageinfoById(String packageId) {
		//创建主表合包对象获得合包主表的数据
		Packageinfo package1=pMapper.findPackageinfoById(packageId);
		//创建集合对象获得合包明细的数据集合
		List<Packagelist> pList=findPackagelistByPackageId(packageId);
		//设置主表的一对多的明细对象
		package1.setPkgDetailList(pList);
		return package1;
	}

	/**
	 * 根据合包主Id查询合包子表信息
	 */
	public List<Packagelist> findPackagelistByPackageId(String packageId) {
		return pMapper.findPackagelistByPackageId(packageId);
	}
	
	/**
	 * 根据合包Id修改相关信息
	 */
	public boolean updatePackageinfo(Packageinfo pacakgeinfo) {
		return pMapper.updatePackageinfo(pacakgeinfo) > 0 ? true : false;
	}
	
	/**
	 * 查询合包条数
	 */
	@Override
	public int countPackageNumber() {
		//获取Session
		Session session = SecurityUtils.getSubject().getSession();
		//定义一个变量将Mapper方法查询到的结果赋值给它
		int number = pMapper.countPackageNumber();
		return number;
	}
}

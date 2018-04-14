package com.yidu.tencloud.biz.taketosend.worksheetBiz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.Supplement;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.dao.taketosend.fastEntering.FastEnteringMapper;
import com.yidu.tencloud.dao.taketosend.worksheetDao.WorkSheetMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.ShiroUtil;
/**
 * 业务逻辑层 实现类
 * @author 陈涛
 *
 */
@Service
public class WorkSheetBizImpl implements WorkSheetBiz{

	/**
	 * 引用工作单数据访问层
	 */
	@Autowired
	private WorkSheetMapper workSheetMapper;
	/**
	 * 引用快速录入数据访问层
	 */
	@Autowired
	private FastEnteringMapper fastEnteringMapper;
	/**
	 * 引用职员数据访问层
	 */
	@Autowired
	private EmpBiz empBiz;
	
	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
	 * 赋值
	 * @param fastEnteringMapper
	 */
	public void setFastEnteringMapper(FastEnteringMapper fastEnteringMapper) {
		this.fastEnteringMapper = fastEnteringMapper;
	}

	/**
	 * 赋值
	 * @param workSheetMapper
	 */
	public void setWorkSheetMapper(WorkSheetMapper workSheetMapper) {
		this.workSheetMapper = workSheetMapper;
	}

	/**
	 * 找到业务通知单
	 */
	@Override
	public List<String> findBusinessNoticeNo(Map<String,Object> workSheetNo) {
		return workSheetMapper.findBusinessNoticeNo(workSheetNo);
	}
	/**
	 * 找到辅助档案名
	 */
	@Override
	public List<String> findHelpFile(String recordName) {
		return workSheetMapper.findHelpFile(recordName);
	}
	
	/**
	 * 根据工作单号查找工作单号
	 * @param workSheetNo 工作单号
	 * @return 返回字符
	 */
	public String findWorkSheetNoByWorkSheetNo(String workSheetNo) {
		if(fastEnteringMapper.findWorkSheetNoByWorkSheetNo(workSheetNo).isEmpty()) {
			return "success";
		}else{
		    return "fail";	
		}
	};

	/**
	 * 根据业务通知单编号查找需要的信息
	 */
	@Override
	public BusinessRecsipt findBusinessRecsiptByBus(String businessNoticeNo) {
		return workSheetMapper.findBusinessRecsiptByBus(businessNoticeNo);
	}
	/**
	 * 根据业务通知单查找工单
	 */
	@Override
	public WorkOrder findWorkOrderByBus(String businessNoticeNo) {
		return workSheetMapper.findWorkOrderByBus(businessNoticeNo);
	}
	/**
	 * 找到工作单信息
	 */
	@Override
	public WorkSheet findWorkSheet(String workSheetNo) {
		return workSheetMapper.findWorkSheet(workSheetNo);
	}
	
	/**
	 * 添加工作单
	 */
	@Override
	public String addWorkSheet(WorkSheet workSheet,Sender sender,Addresses addresses,Rule rule) {
		//设置寄件人Id
		sender.setSenderId(IDGenderatorUtil.generateId());
		
		//设置收件人Id
		addresses.setAddressesId(IDGenderatorUtil.generateId());
		
		//设置规则Id
		rule.setRuleId(IDGenderatorUtil.generateId());
		
		//创建一个补单对象
		Supplement supplement = new Supplement();
		//设置补单人Id
		supplement.setSupplementId(IDGenderatorUtil.generateId());
		//设置补单人编号
		supplement.setSupplementNo(Num.creatNum("补单"));
		//设置工作单编号
		supplement.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		//创建一个开单人对象
		Drawer drawer = new Drawer();
		//设置开单人Id
		drawer.setDrawerId(IDGenderatorUtil.generateId());
		//获得shiro中用户名赋值给开单人名
		drawer.setDrawerName(ShiroUtil.getUser().getUserName());
		//设置开单人编号
		drawer.setDrawerNo(Num.creatNum("开单"));
		//获得shiro中组织结构Id赋值给开单人单位
		drawer.setDrawerOperationCompany(ShiroUtil.getUser().getOrgId());
		//获得当前时间赋值给开单时间
		drawer.setDrawerTime(new Date(System.currentTimeMillis()));
		//设置工作单编号
		drawer.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		//设置工作单Id
		workSheet.setWorkSheetId(IDGenderatorUtil.generateId());
		//设置工作单类型
		workSheet.setWorkSheetSource("正常开单");
		//改变状态赋值给工作单状态
		workSheet.setIntegraliyStatus(changeStatus(workSheet,addresses,sender,rule));
		
		//添加工作单信息成功就调用添加其他信息的方法
		int result = workSheetMapper.addWorkSheet(workSheet);
		if(result==1) {
		   //添加补单人
		   workSheetMapper.addSupplement(supplement);
		   //添加开单人
		   workSheetMapper.addDrawer(drawer);
		   //添加寄件人
		   workSheetMapper.addSender(sender);
		   //添加收件人
		   workSheetMapper.addAddresses(addresses);
		   //添加规则
		   workSheetMapper.addRule(rule);
		   return "success";
		}else {
			return "fail";
		}	
	}

	
	/**
	 * 修改完整性状态
	 * @return 字符
	 */
	public String changeStatus(WorkSheet workSheet,Addresses addresses,Sender sender,Rule rule) {
		  //如果工作单六项基本信息不完整（工作单编号，产品，配载要求s，产品名，实际件数p，实际重量a）
		  if(workSheet.getWorkSheetNo()==null || workSheet.getProduct()==null
		  || workSheet.getStowageRequirement()==null
		  || rule.getProductAmount()==0 || rule.getActualWeight()==0) {
			 //则返回字符串：配置信息不全
			  return "配载信息不全";
		  //如果其他信息不全（寄件人名，寄件人编号，寄件人地址，寄件人电话，收件名，收件人地址，收件人电话）
		  }else if(sender.getSenderName()==null || sender.getSenderNo()==null
		  || sender.getSenderAddress()==null || sender.getSenderPhone()==null
		  || addresses.getAddressesName()==null || addresses.getAddressesAddress()==null
		  || addresses.getAddressesPhone()==null) {
			  //则返回字符串：其他信息不全
			  return "其他信息不全";
		  }else {
			//如果都不是则返回信息：信息完整
			  return "信息完整";
		  }
	}

    /**
     * 修改工作单
     */
	@Override
	public String updateWorksheet(WorkSheet workSheet,Addresses addresses,Sender sender,Rule rule) {
		//创建开单人对象
		Supplement supplement = new Supplement();
		//获得shiro中的用户名赋值给开单人名
		supplement.setSupplementName(ShiroUtil.getUser().getUserName());
		//获得当前时间赋值给开单时间
		supplement.setSupplementTime(new Date(System.currentTimeMillis()));
		//获得shiro中的组织结构Id赋值给开单人单位
		supplement.setSupplementCompany(ShiroUtil.getUser().getOrgId());
		//设置工作单编号
		supplement.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		//改变状态赋值给完整性状态
		workSheet.setIntegraliyStatus(changeStatus(workSheet,addresses,sender,rule));
		//修改工作单
		int resultW = workSheetMapper.updateWorksheet(workSheet);
		//修改收件人
		int resultA = workSheetMapper.updateAddresses(addresses);
		//修改寄件人
		int resultS = workSheetMapper.updateSender(sender);
		//修改规则
		int resultR = workSheetMapper.updateRule(rule);
		//修改开单人
		int resultP = workSheetMapper.updateSupplement(supplement);
		if(resultW==1 && resultA==1 && resultS==1 && resultR==1 && resultP==1) {
			return "success";
		}else {
			return "fail";
		}
	}

	/**
	 * 找到工作单信息
	 */
	@Override
	public Map<String,Object> findAllWorkSheet(String integraliyStatus,String workSheetSource,String drawerTime) {
		//创建一个map集合
		Map<String,Object> param = new HashMap<String,Object>();
		//完整性状态
		param.put("integraliyStatus", integraliyStatus);
		//工作单来源
		param.put("workSheetSource", workSheetSource);
		//开单时间
		param.put("drawerTime", drawerTime);
		//组织集合
		param.put("orgList", empBiz.orgListToString());
		//添加一个返回值map并赋值
		Map<String,Object> map = new HashMap<String, Object>();
		//找到工作单总记录数
		map.put("total",workSheetMapper.findAllWorkSheet(param).size());
		//找到工作单
		map.put("rows", workSheetMapper.findAllWorkSheet(param));
		return map;
	}
	/**
	 * 遍历获得最近一周时间的工作单数量
	 */
	@Override
	public List<Integer> creatBar() throws ParseException {
		//将日期格式化
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		//获得当前时间
		Date beginDate = new Date(System.currentTimeMillis());
		//获得一个Calendar类型的通用对象
		Calendar date = Calendar.getInstance();
		//把当前时间转为calendar类型时间
		date.setTime(beginDate);
		//定义一个int变量
		int num=0;
		//创建一个int数组
		List<Integer> ints = new ArrayList<Integer>();
		for(int i=0;i<=6;i++) {
			//把calendar类型的日期格式化并解析成日期字符串赋值给最终时间
			Date endDate = dft.parse(dft.format(date.getTime()));
			//把获得的工作单数量的数量赋值给int变量
			num = (int) findAllWorkSheet(null, null,dft.format(endDate)).get("total");
			//把calendar类型时间减1
			date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
			//把int变量放入int数组
			ints.add(num);
		}
		return ints;
	}

}

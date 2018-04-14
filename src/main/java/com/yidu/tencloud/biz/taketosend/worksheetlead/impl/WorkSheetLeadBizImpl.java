package com.yidu.tencloud.biz.taketosend.worksheetlead.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLead;
import com.yidu.tencloud.bean.taketosend.workSheetLead.WorkSheetLeads;
import com.yidu.tencloud.biz.taketosend.businessrecsiptbiz.BusinessRecsiptBiz;
import com.yidu.tencloud.biz.taketosend.worksheetlead.WorkSheetLeadBiz;
import com.yidu.tencloud.dao.taketosend.worksheetlead.WorkSheetLeadMapper;
import com.yidu.tencloud.util.BeanUtil;
import com.yidu.tencloud.util.CommPOIUtil;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.UpdateSta;
/**
 * 工作单导入实现类
 * @author 陈玉娟
 * @since 2017年12月20日10:39:39
 */

@Service
public class WorkSheetLeadBizImpl implements WorkSheetLeadBiz {
	/**
	 * 依赖注入businessRecsiptBiz
	 */
	@Autowired
	private BusinessRecsiptBiz businessRecsiptBiz;
	/**
	 * 依赖注入workSheetLeadMapper
	 */
	@Autowired
	private WorkSheetLeadMapper workSheetLeadMapper;
	public void setBusinessRecsiptBiz(BusinessRecsiptBiz businessRecsiptBiz) {
		this.businessRecsiptBiz = businessRecsiptBiz;
	}
	public void setWorkSheetLeadMapper(WorkSheetLeadMapper workSheetLeadMapper) {
		this.workSheetLeadMapper = workSheetLeadMapper;
	}
	/**
	 * 上传EXCEL文件
	 * @param myFile 文件名
	 * @return 返回所获得的文件
	 * @throws IOException 异常
	 */
	@Override
	public List<WorkSheetLeads> parseExecel(MultipartFile myFile) throws IOException {
		//定义一个工作单导入集合
		List<WorkSheetLeads> sheets = new ArrayList<>();
		//获得文件并解析
		List<List<Object>> list = CommPOIUtil.commReadExecel(CommPOIUtil.getWorkBook(myFile));
		//遍历循环
		for (int j = 7; j < list.size(); j++) {
			//获得第j个元素
			List<Object> workSheetList = list.get(j);
			//判断是否为空或判断集合的大小是否为32
			if(!workSheetList.isEmpty()&&workSheetList.size()==32) {
				//把List转化为实体类
				WorkSheetLeads worksheetleads = BeanUtil.convertListToBean(workSheetList, WorkSheetLeads.class);
				//把工作单导入的数据添加进集合
				sheets.add(worksheetleads);
			}
		}
		//返回集合
		return sheets;
	}
	/**
	 * 获取对应地址匹配小件员
	 * @param senderAddress 寄件人地址
	 * @return 返回获得的结果
	 */
	@Override
	public List<Emp> findAddressBySmallEmp(String senderAddress) {
		//定义一个集合
		List<Emp> emp = new ArrayList<Emp>();
		//调用方法查询定区
		FixedArea fixedArea = businessRecsiptBiz.findFetchAddress(senderAddress);
		//通过定区查找支援
		List<String> empIds = businessRecsiptBiz.findEmpIdByFixedAreaId(fixedArea.getFixedAreaId());
		//遍历循环
		for (String empId : empIds) {
			//根据ID查找职员
			Emp smallemp = businessRecsiptBiz.findEmpByEmpId(empId);
			//将查找到的小件员添加进入职员
			emp.add(smallemp);
		}

		return emp;
	}
	/**
	 * 添加数据
	 * @param workSheetLeads 工作单导入对象
	 * @return 返回添加结果
	 */
	@Override
	public List<String> addWorkSheetLead(List<WorkSheetLead> workSheetLeads) {
		//定义一个集合
		List<String> errors = new ArrayList<String>();
		//遍历循环
		for (WorkSheetLead workSheetLead : workSheetLeads) {
			//创建工作单对象
			WorkSheet workSheet = new WorkSheet();
			//创建寄件对象
			Sender sender = new Sender();
			//创建收件对象
			Addresses addresses = new Addresses();
			//创建规格对象
			Rule rule = new Rule();
			//给工作单ID辅助 自动生成工作单ID
			workSheet.setWorkSheetId(IDGenderatorUtil.generateId());
			//给工作单号赋值
			workSheet.setWorkSheetNo(workSheetLead.getWorkSheetNo());
			//给业务通知单号赋值
			workSheet.setBusinessNoticeNo(workSheetLead.getBusinessNoticeNo());
			//给客户单号赋值
			workSheet.setCustomerListNo(workSheetLead.getCustomerListNo());
			//给产品赋值
			workSheet.setProduct(workSheetLead.getProduct().trim());
			//给到达地赋值
			workSheet.setDestination(workSheetLead.getDestination().trim());
			//给取件人赋值
			workSheet.setEmpName(workSheetLead.getEmpName());
			//配载要求
			workSheet.setStowageRequirement(workSheetLead.getStowageRequirement().trim());
			//工作单类型
			workSheet.setWorkSheetType("正常工作单");
			//工作单来源
			workSheet.setWorkSheetSource("工作单导入");
			//工作单状态
			workSheet.setIntegraliyStatus(UpdateSta.changeStatus(workSheetLead));
			//寄件人ID 自动生成
			sender.setSenderId(IDGenderatorUtil.generateId());
			//寄件人姓名
			sender.setSenderName(workSheetLead.getSenderName().trim());
			//寄件人传真
			sender.setSenderFax(workSheetLead.getSenderFax().trim());
			//寄件人地址
			sender.setSenderAddress(workSheetLead.getSenderAddress().trim());
			//寄件人地址
			sender.setSenderCompany(workSheetLead.getSenderCompany().trim());
			//寄件人电话
			sender.setSenderPhone(workSheetLead.getSenderPhone().trim());
			//收货人ID 自动生成
			addresses.setAddressesId(IDGenderatorUtil.generateId());
			//收货人姓名
			addresses.setAddressesName(workSheetLead.getAddressesName().trim());
			//收货人传真
			addresses.setAddressesFax(workSheetLead.getAddressesFax().trim());
			//收获人地址
			addresses.setAddressesAddress(workSheetLead.getAddressesAddress().trim());
			//收货人公司
			addresses.setAddressesCompany(workSheetLead.getSenderCompany().trim());
			//收货人电话
			addresses.setAddressesPhone(workSheetLead.getAddressesPhone().trim());
			//规格ID 自动生成
			rule.setRuleId(IDGenderatorUtil.generateId());
			//实际重量
			rule.setActualWeight(workSheetLead.getActualWeight());
			//品名
			rule.setProductName(workSheetLead.getProductName());
			//体积
			rule.setSize(workSheetLead.getSize());
			//保险类型
			rule.setInsuranceType(workSheetLead.getInsuranceType());
			//保险费
			rule.setInsurancePremium(workSheetLead.getInsurancePremium());
			//声明价值
			rule.setDeclaredValue(workSheetLead.getDeclaredValue());
			//原包装
			rule.setOriginalPacking(workSheetLead.getOriginalPacking());
			//实际包装
			rule.setActualPacking(workSheetLead.getActualPacking());
			//包装费
			rule.setPackingCharges(workSheetLead.getPackingCharges());
			//包装要求
			rule.setPackagingRequirements(workSheetLead.getPackagingRequirements());
			//实际件数
			rule.setProductAmount(workSheetLead.getProductAmount());
			//计费重量
			rule.setBillingWeight(workSheetLead.getBillingWeight());
			//预计运费
			rule.setPreCharge(workSheetLead.getPreCharge());
			//结算方式
			rule.setSettlementMode(workSheetLead.getSettlementMode());
			//代收款
			rule.setReplaceReceivables(workSheetLead.getReplaceReceivables());
			//到付款
			rule.setPaymentArrival(workSheetLead.getPaymentArrival());
			//反馈签收
			rule.setFeedbackSign(workSheetLead.getFeedbackSign());
			//节假日可以收货
			rule.setHolidayIsCollect(workSheetLead.getHolidayIsCollect());
			//送达时限
			rule.setServiceTimeLimit(workSheetLead.getServiceTimeLimit());
			
			//添加工作单
			int add = workSheetLeadMapper.addWorkSheet(workSheet);
			//添加寄件人
			int addSender = workSheetLeadMapper.addSender(sender);
			//添加规格
			int addRule = workSheetLeadMapper.addRule(rule);
			//添加收件人
			int addAddresses = workSheetLeadMapper.addAddresses(addresses);
			//判断是否添加成功
			if (add + addSender + addRule + addAddresses != 4) {
				//添加工作单
				errors.add(workSheetLead.getWorkSheetNo());
			}

		}
		//返回集合
		return errors;

	}

}

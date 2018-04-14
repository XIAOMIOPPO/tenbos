package com.yidu.tencloud.web.controller.taketosend.workorder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workSheet.Addresses;
import com.yidu.tencloud.bean.taketosend.workSheet.Drawer;
import com.yidu.tencloud.bean.taketosend.workSheet.Rule;
import com.yidu.tencloud.bean.taketosend.workSheet.Sender;
import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.biz.taketosend.workorderbiz.WorkOrderBiz;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
import com.yidu.tencloud.util.ShiroUtil;
import com.yidu.tencloud.util.WorkSheetNo;

@Controller
@RequestMapping("/workOrder")
public class WorkOrderController {
	
	@Autowired
	private WorkOrderBiz workOrderBiz;
	
	@Autowired
	private WorkSheetBiz workSheetBiz;
	
	public WorkSheetBiz getWorkSheetBiz() {
		return workSheetBiz;
	}

	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}

	public WorkOrderBiz getWorkOrderBiz() {
		return workOrderBiz;
	}

	public void setWorkOrderBiz(WorkOrderBiz workOrderBiz) {
		this.workOrderBiz = workOrderBiz;
	}
	
	
	@RequestMapping(value="/findAllWorkOrder.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findAllWorkOrder(@RequestBody Map<?, ?> map) throws Exception{
		Integer limit=(Integer)map.get("limit");
        Integer offset=(Integer)map.get("offset");

		Map<String, Object> workOrderMap = new HashMap<String, Object>();
		workOrderMap.put("total", workOrderBiz.findAllWorkOrders().size());
		workOrderMap.put("rows", workOrderBiz.findAllWorkOrdersByPage(offset, limit));
		return workOrderMap;	
	}
	
	@RequestMapping(value="/findWorkOrderById.action",method={RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> findWorkOrderById(@RequestBody Map<?, ?> map) throws Exception{
		String businessRecsiptId = (String) map.get("businessRecsiptId");
		
		Map<String, Object> workOrderMap = new HashMap<String, Object>();
		workOrderMap.put("total", workOrderBiz.findWorkOrderById(businessRecsiptId).size());
		workOrderMap.put("rows", workOrderBiz.findWorkOrderById(businessRecsiptId));
		return workOrderMap;	
	}
	
	
	@RequestMapping(value = "/updateWorkOrderStatus.action")
	@ResponseBody
	public Map<String, Object> updateWorkOrderStatus(String Wstatus,String workOrderId){
		Map<String, Object> workOrderMap = new HashMap<String, Object>();
		boolean result = workOrderBiz.updateWorkOrderStatus(Wstatus, workOrderId);
		if (result == true) {
			workOrderMap.put("status", "success");
		} else {
			workOrderMap.put("status", "failed");
		}
		return workOrderMap;
	}
	
	@RequestMapping(value = "/addWorkSheet.action")
	@ResponseBody
	public Map<String, Object> addWorkSheet(String workOrderId){
		WorkOrder workOrder = workOrderBiz.findOneWorkOrderById(workOrderId);
		BusinessRecsipt busRecsipt = workOrderBiz.findBusinessRecsiptByWorkOrderId(workOrder.getBusinessRecsiptId());
		
		WorkSheet workSheet = new WorkSheet();
		Sender sender = new Sender();
		Addresses addresses = new Addresses();
		Rule rule = new Rule();
		
		//给寄件人信息赋值
		sender.setSenderId(IDGenderatorUtil.generateId());
		//给收件人信息赋值
		addresses.setAddressesId(IDGenderatorUtil.generateId());
		//给规则信息赋值
		rule.setRuleId(IDGenderatorUtil.generateId());

		//给工作单信息赋值
		workSheet.setWorkSheetId(IDGenderatorUtil.generateId());
		workSheet.setWorkSheetSource("正常开单");
		workSheet.setWorkSheetNo(WorkSheetNo.createWorkSheetNo());

		workSheet.setBusinessNoticeNo(busRecsipt.getBusinessRecsiptNo());
		workSheet.setEmpName(workOrder.getEmpName());
		workSheet.setCustomerListNo(busRecsipt.getCustomerNo());
		workSheet.setPickup(workOrder.getTakeOrgName());
		workSheet.setProduct(busRecsipt.getProduct());
		
		//添加一个开单人对象并赋值
		Drawer drawer = new Drawer();
		drawer.setDrawerId(IDGenderatorUtil.generateId());
		drawer.setDrawerName(ShiroUtil.getUser().getUserName());
		drawer.setDrawerNo(Num.creatNum("开单"));
		drawer.setDrawerOperationCompany(ShiroUtil.getUser().getOrgId());
		drawer.setDrawerTime(new Date(System.currentTimeMillis()));
		drawer.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		sender.setSenderName(busRecsipt.getCustomerName());
		sender.setSenderNo(busRecsipt.getCustomerNo());
		sender.setSenderPhone(busRecsipt.getPhoneNum());
		sender.setSenderAddress(busRecsipt.getFetchAddress());
		sender.setSenderCompany(workOrder.getTakeOrgName());
		sender.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		addresses.setAddressesAddress(busRecsipt.getServeAddress());
		addresses.setAddressesName(busRecsipt.getContacts());
		addresses.setAddressesPhone(busRecsipt.getTelephone());
		addresses.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		rule.setProductName(busRecsipt.getProductName());
		rule.setActualWeight(busRecsipt.getWeight().doubleValue());
		rule.setBillingQuantity(busRecsipt.getNumberPackages());
		rule.setWorkSheetNo(workSheet.getWorkSheetNo());
		
		String result = workSheetBiz.addWorkSheet(workSheet, sender, addresses, rule);
		Map<String, Object> workOrderMap = new HashMap<String, Object>();
		if(result.equals("success")){
			workOrderMap.put("status", "success");
		}else{
			workOrderMap.put("status", "failed");
		}
		return workOrderMap;
	}
}

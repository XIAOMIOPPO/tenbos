package com.yidu.tencloud.biz.taketosend.workorderbiz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.workorderbiz.WorkOrderBiz;
import com.yidu.tencloud.dao.taketosend.workorder.WorkOrderMapper;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 工作单业务逻辑层实现类
 * @author 张建勇
 * @date 2017年11月29日 08:55:33
 */
@Service
public class WorkOrderBizImpl implements WorkOrderBiz{
	
	@Autowired
	private WorkOrderMapper workOrderMapper;
	
	@Autowired
	private EmpBiz empBiz;
	
	

	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	public WorkOrderMapper getWorkOrderMapper() {
		return workOrderMapper;
	}

	public void setWorkOrderMapper(WorkOrderMapper workOrderMapper) {
		this.workOrderMapper = workOrderMapper;
	}

	@Override
	public boolean addWorkOrder(WorkOrder workOrder) {
		workOrder.setWorkOrderId(IDGenderatorUtil.generateId());
		if(workOrderMapper.addWorkOrder(workOrder) != 1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<WorkOrder> findAllWorkOrders() {
		return workOrderMapper.findAllWorkOrders(empBiz.orgListToString());
	}

	@Override
	public List<WorkOrder> findAllWorkOrdersByPage(Integer offset, Integer limit) {
		Map<String, Object> paremMap = new HashMap<String, Object>();
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		paremMap.put("orgList", empBiz.orgListToString());
		return workOrderMapper.findAllWorkOrdersByPage(paremMap);
	}

	@Override
	public List<WorkOrder> findWorkOrderById(String businessRecsiptId){
		return workOrderMapper.findWorkOrderById(businessRecsiptId);
	}

	@Override
	public boolean updateWorkOrderStatus(String Wstatus,String workOrderId) {
		Map<String, Object> paremMap = new HashMap<String, Object>();
		paremMap.put("Wstatus", Wstatus);
		paremMap.put("workOrderId", workOrderId);
		int result = workOrderMapper.updateWorkOrderStatus(paremMap);
		if(result < 1){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public BusinessRecsipt findBusinessRecsiptByWorkOrderId(String workOrderId) {
		
		return workOrderMapper.findBusinessRecsiptByWorkOrderId(workOrderId);
	}

	@Override
	public WorkOrder findOneWorkOrderById(String workOrderId) {
		return workOrderMapper.findOneWorkOrderById(workOrderId);
	}

}

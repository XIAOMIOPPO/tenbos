package com.yidu.tencloud.biz.taketosend.workorderbiz;

import java.util.List;

import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;

/**
 * 工作单业务逻辑层接口
 * @author 张建勇
 * @date 2017年11月28日 09:39:56
 */
public interface WorkOrderBiz {
	/**
	 * 添加工单信息方法
	 * @param workOrder  需要添加的工单对象
	 * @return  受影响的行数
	 */
	public boolean addWorkOrder(WorkOrder workOrder);
	
	/**
	 * 查询所有的工作单信息
	 * @return 所有的工作单信息
	 */
	public List<WorkOrder> findAllWorkOrders();
	
	/**
	 * 分页查询所有的工作单
	 * @param paremMap 分页查询条件
	 * @return 分页查询到的集合
	 */
	public List<WorkOrder> findAllWorkOrdersByPage(Integer offset , Integer limit);
	
	/**
	 * 查询受理单下面所有的工单信息
	 * @param businessRecsiptId 受理单Id
	 * @return 查询到的工单集合
	 */
	public List<WorkOrder> findWorkOrderById(String businessRecsiptId);
	
	/**
	 * 修改工单状态
	 * @param paremMap
	 * @return
	 */
	public boolean updateWorkOrderStatus(String Wstatus,String workOrderId);
	
	/**
	 * 根据工单Id查询业务受理单
	 * @param workOrderId
	 * @return
	 */
	public BusinessRecsipt findBusinessRecsiptByWorkOrderId(String workOrderId);
	
	/**
	 * 根据工单Id查询工单信息
	 * @param businessRecsiptId 工单Id
	 * @return 查询到的工单
	 */
	public WorkOrder findOneWorkOrderById(String workOrderId);
}

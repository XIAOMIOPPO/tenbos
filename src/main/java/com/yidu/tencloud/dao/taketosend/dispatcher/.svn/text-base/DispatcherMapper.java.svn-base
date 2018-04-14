package com.yidu.tencloud.dao.taketosend.dispatcher;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.dispatcher.DispatcherAnnals;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.bean.taketosend.returnGoods.ApplyGoods;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;

/**
 * 调度的数据访问层的接口类
 * @author 鲁静芝
 * @since 2017/12/25
 */
public interface DispatcherMapper {
	/**
	 * 查询需要进行调度的工单
	 * @param paramMap map接口
	 * @return 通知单集合
	 */
	public abstract List<BusinessRecsipt> findAllNeedDispatcherWorkOrder(Map<String,Object> paramMap);
	
	/**
	 * 记录总数 
	 * @param paramMap map接口
	 * @return 总数
	 */
	public abstract int countNum(Map<String,Object> paramMap);

	/**
	 * 记录所有需要调度的工单
	 * @return 总数
	 */
	public abstract int countNeedDispatcherOrder();
	
	/**
	 * 查询所有调度历史
	 * @param businessRecsiptId 通知单Id
	 * @return 调度历史集合
	 */
	public abstract List<DispatcherAnnals> findAllDispatcherAnnals(String businessRecsiptId);
	 
	/**
	 * 查询所有组织结构
	 * @return 组织结构集合
	 */
	public abstract List<Organization> findAllOrg();
	
	/**
	 * 查询分拣编码
	 * @param paramMap map接口
	 * @return 定区对象
	 */
	public abstract FixedArea findFetchAddress(Map<String, Object> paramMap);
	
	/**
	 * 通过定区编码查询定区Id
	 * @param paramMap map接口
	 * @return 定区对象
	 */
	public abstract FixedArea findFixedAreaIdByNum(Map<String,Object> paramMap);
	
	/**
	 * 通过定区Id查询正在上班的职员
	 * @param paramMap map接口
	 * @return 字符串集合
	 */
	public abstract List<String> findAllFixedAreaEmpIdByFixedAreaId(Map<String, Object> paramMap);
	
	/**
	 * 通过职员Id查询职员信息
	 * @param paramMap map接口
	 * @return 职员对象
	 */
	public abstract Emp findEmpByEmpId(Map<String, Object> paramMap);
	
	/**
	 * 通过通知单Id修改通知单类型
	 * @param paramMap map接口
	 * @return 是否成功
	 */
	public abstract int updateTypeById(Map<String,Object> paramMap);
	
	/**
	 * 通过通知单ID查询通知单号
	 * @param businessRecsiptId 通知单Id
	 * @return 字符串
	 */
	public abstract String findBusinessRecsiptNo(String businessRecsiptId);
	
	/**
	 * 通过通知单Id查询取件时间
	 * @param businessRecsiptId 通知单吗ID
	 * @return 时间类型
	 */
	public abstract Date findTakeTimeById(String businessRecsiptId);
	
	/**
	 * 添加工单
	 * @param workOrder 工单对象
	 * @return 是否成功
	 */
	public abstract int addWorkOrder(WorkOrder workOrder);
	
	/**
	 * 添加调度历史
	 * @param dispatcherAnnals 调度历史对象
	 * @return 是否成功
	 */
	public abstract int addDispatcherAnnals(DispatcherAnnals dispatcherAnnals);
	
	/**
	 * 添加工单详情
	 * @param workOrderDetail 工单详情对象
	 * @return 是否成功
	 */
	public abstract int addWorkOrderDetail(WorkOrderDetail workOrderDetail);
	
	/**
	 * 修改销单原因
	 * @param paramMap map接口
	 * @return 是否成功
	 */
	public abstract int updateDestoryCause(Map<String,Object> paramMap);
	
	/**
	 * 通过通知单Id查询工单信息
	 * @param businessRecsiptId 通知单Id
	 * @return 工单对象
	 */
	public abstract WorkOrder findWorkOrderById(String businessRecsiptId);
	
	/**
	 * 通过通知单Id修改工单状态和取件状态
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	public abstract int deleteWorkOrder(String businessRecsiptId);
	
	/**
	 * 修改返回原因
	 * @param paramMap map接口
	 * @return 是否成功
	 */
	public abstract int updateReturnCause(Map<String,Object> paramMap);
	
	/**
	 * 外部分配
	 */
	public abstract List<String> findEmpNameByOrgName(Map<String, Object> paramMap);
	
	public int countBusinessRecsipt(Map<String, Object> paramMap); 
	
	
	
	
	
	
	
}

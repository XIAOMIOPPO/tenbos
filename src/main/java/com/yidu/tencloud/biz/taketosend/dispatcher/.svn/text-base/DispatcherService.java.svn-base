package com.yidu.tencloud.biz.taketosend.dispatcher;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.dispatcher.DispatcherAnnals;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;

/**
 * 调度的业务层实现类
 * @author 鲁静芝
 * @since 2017/11/23
 */
public interface DispatcherService {
	/**
	 * 查询所有需要进行调度的工单
	 * @param paramMap map接口对象
	 * @return 业务通知单集合
	 */
	public abstract List<BusinessRecsipt> findAllNeedDispatcherWorkOrder(Map<String,Object> paramMap);
	
	/**
	 * 记录数
	 * @param paramMap map接口对象
	 * @return 总数量
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
	 * @param address 定区名
	 * @return 定区对象
	 */
	public abstract FixedArea findFetchAddress(String address);
	
	/**
	 * 通过定区编码查询定区Id
	 * @param fixedAreaNum 定区编码 
	 * @return 定区对象
	 */
	public abstract FixedArea findFixedAreaIdByNum(String fixedAreaNum);
	
	/**
	 * 通过定区Id查询正在上班的职员
	 * @param fixedArea 区域对象
	 * @return 字符串集合
	 */
	public abstract List<String> findAllFixedAreaEmpIdByFixedAreaId(FixedArea fixedArea);
	
	/**
	 * 通过职员Id查询职员
	 * @param empName 职员名
	 * @return 职员对象
	 */
	public abstract Emp findEmpByEmpId(String empName);
	
	/**
	 * 通过通知单Id修改通知单状态
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	public abstract int updateTypeById(String businessRecsiptId);
	
	/**
	 * 通过通知单Id查询通知单号
	 * @param businessRecsiptId 通知单Id
	 * @return 字符串
	 */
	public abstract String findBusinessRecsiptNo(String businessRecsiptId);
	
	/**
	 * 通过通知单Id查询取件时间
	 * @param businessRecsiptId 通知单Id
	 * @return 时间对象
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
	 * @param workOrderDetail 工单详情
	 * @return 是否成功
	 */
	public abstract int addWorkOrderDetail(WorkOrderDetail workOrderDetail);
	
	/**
	 * 通过通知单Id修改销单原因
	 * @param destoryCause 销单原因
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	public abstract int updateDestoryCause(String destoryCause,String businessRecsiptId);
	
	/**
	 * 通过通知单Id查询工单
	 * @param businessRecsiptId 通知单Id
	 * @return 工单对象
	 */
	public abstract WorkOrder findWorkOrderById(String businessRecsiptId);
	
	/**
	 * 通过通知单Id删除工单
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	public abstract int deleteWorkOrder(String businessRecsiptId);
	
	/**
	 * 修改返回原因
	 * @param returnCause 返回原因
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	public abstract int updateReturnCause(String returnCause,String businessRecsiptId);
	
	/**
	 * 通过组织结构名查询正在上班的职员
	 * @param orgName
	 * @return 集合
	 */
	public abstract List<String> findEmpNameByOrgName(String orgName);
	
	/**
	 * 画饼状图
	 * @return 集合对象
	 * @throws ParseException 异常
	 */
	List<Integer> creatPie()throws ParseException;
}

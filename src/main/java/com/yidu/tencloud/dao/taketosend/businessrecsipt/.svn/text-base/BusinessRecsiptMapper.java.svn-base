package com.yidu.tencloud.dao.taketosend.businessrecsipt;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;

/**
 * 业务受理通知单数据访问层接口
 * @author 张建勇
 * @date 2017.11.24
 */
public interface BusinessRecsiptMapper {
	
	/**
	 * 根据来电号码查询客户
	 * @param phoneNum  来电号码
	 * @return 所属客户
	 */
	public Client findClientPhoneNum(String phoneNum);
	
	/**
	 * 添加一个新的业务受理单
	 * @param businessRecsipt 要添加的业务受理单
	 * @return 受影响的行数
	 */
	public int addBusinessRecsipt(BusinessRecsipt businessRecsipt);
	
	/**
	 * 查询所有的业务通知单
	 * @return 所有的业务通知单
	 */
	public List<BusinessRecsipt> findAllRecsipts(List<String> orgList);
	
	/**
	 * 分页查询所有的业务通知单
	 * @param paremMap 条件集合
	 * @return  分页查询到的集合
	 */
	public List<BusinessRecsipt> findAllRecsiptsByPage(Map<String, Object> paremMap);
	
	/**
	 * 条件模糊查询
	 * @param paremMap 条件集合
	 * @return 模糊查询到的集合
	 */
	public List<BusinessRecsipt> findRecsiptByConditionVague(Map<String, Object> paremMap);
	
	/**
	 * 根据地址查询定区
	 * @param fetchAddress  取件地址
	 * @return 查询到的分拣编码
	 */
	public FixedArea findFetchAddress(Map<String, Object> parmMap);
	
	/**
	 * 根据定区Id查询该定区下的所有职员
	 * @param fixedAreaId 定区Id
	 * @return 所有职员Id集合
	 */
	public List<String> findAllFixedAreaEmpIdByFixedAreaId(Map<String, Object> parmMap);
	
	/**
	 * 查询正在上班的职员
	 * @return
	 */
	public Relay findEmpByRelay(Map<String, Object> parmMap);

	/**
	 * 根据职员Id查询职员
	 * @param parmMap 
	 * @return
	 */
	public Emp findEmpByEmpId(Map<String, Object> parmMap);
	
	/**
	 * 添加工单信息方法
	 * @param workOrder  需要添加的工单对象
	 * @return  受影响的行数
	 */
	public int addWorkOrder(WorkOrder workOrder);
	
	/**
	 * 根据业务受理单Id查询业务受理单
	 * @param businessRecsiptId 业务受理单Id
	 * @return 业务受理单
	 */
	public WorkOrder findWorkOrderById(String businessRecsiptId);
	
	/**
	 * 根据业务受理单Id统计查询工单
	 * @param businessRecsiptId
	 * @return
	 */
	public BusinessRecsipt findBusinessRecsiptIdById(String businessRecsiptId);
	
	
	/**
	 * 根据业务受理单Id修改业务受理单类型
	 * @param businessRecsiptId  业务受理单Id
	 * @return  受影响的行数
	 */
	public int updateWorkOrderTypeById(Map<String, Object> parmMap);
	
	/**
	 * 删除工单	
	 * @param parmMap  参数集合
	 * @return 受影响的行数
	 */
	public int deleteWorkOrder(Map<String, Object> parmMap);
	
	/**
	 * 修改销单原因
	 * @param destoryCause  销单原因
	 * @return  受影响的行数
	 */
	public int updateDestoryCause(Map<String, Object> parmMap);
	
	/**
	 * 添加一条工单详情
	 * @param workOrderDetail  要添加的工单详情
	 * @return  受影响的行数
	 */
	public int addWorkOrderDetail(WorkOrderDetail workOrderDetail);
	
	/**
	 * 改单
	 * @param parmMap
	 * @return
	 */
	public int updateBusinessRecsipt(Map<String, Object> parmMap);
	
	/**
	 * 根据受理单Id删除工单
	 * @param businessRecsiptId
	 * @return
	 */
	public int deleteWorkOrderByBusinessRecsiptId(String businessRecsiptId);
	
	/**
	 * 根据部门ID查询部门名字	
	 * @param orgId
	 * @return
	 */
	public String findOrgNameById(String orgId);
	
	/**
	 * 修改受理单的状态
	 * @return
	 */
	public int updateBusinessReceiptTpye(String businessRecsiptId);
	
	/**
	 * 查询已通知的工单单
	 * @return
	 */
	public WorkOrder findWorkOrderOne();
	
	/**
	 * 修改取件状态
	 * @return
	 */
	public int updatePickStatus(Map<String, Object> parmMap);
	
	/**
	 * 查询部分宣传任务
	 * @return
	 */
	public List<String> findPropagandaContent();
	
	/**
	 * 根据部门Id查询该部门下的受理单
	 * @param operatorOrg 部门名字
	 * @return 统计数
	 */
	public int countOrderNum(List<String> orgList);
}

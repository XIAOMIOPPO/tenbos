package com.yidu.tencloud.biz.taketosend.businessrecsiptbiz;

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
 * 业务受理单业务逻辑层接口
 * @author 张建勇
 * @date 2017年11月24日 10:15:36
 */
public interface BusinessRecsiptBiz {
	
	/**
	 * 根据来电号码查询客户
	 * @param phoneNum  来电号码
	 * @return 该来电号码的客户
	 */
	public Client findClientByPhoneNum(String phoneNum);
	
	/**
	 * 添加一个新的业务受理单
	 * @param businessRecsipt 要添加的业务受理单
	 * @return 受影响的行数
	 */
	public boolean addBusinessRecsipt(BusinessRecsipt businessRecsipt);
	
	/**
	 * 查询所有的业务通知单
	 * @return 所有的业务通知单
	 */
	public List<BusinessRecsipt> findAllRecsipts();
	
	/**
	 * 分页查询所有的业务通知单
	 * @return
	 */
	public List<BusinessRecsipt> findAllRecsiptsByPage(Integer offset , Integer limit);
	
	
	/**
	 * 带条件模糊查询并且分页
	 * @param phoneNum 手机号
	 * @param contacts 寄件人名字
	 * @param telephone 客户手机号
	 * @param productName 商品名字
	 * @param customerName  客户名字
	 * @param fetchAddress 寄件地址
	 * @param serveAddress 收件地址
	 * @param offset 页码
	 * @param limit 大小
	 * @return
	 */
	public List<BusinessRecsipt> findRecsiptByConditionVague(
			String phoneNum,String contacts,String telephone,
			String productName,String customerName , String fetchAddress,
			String serveAddress,Integer offset , Integer limit);
	
	
	/**
	 * 根据地址查询定区
	 * @param fetchAddress  取件地址
	 * @return 查询到的分拣编码
	 */
	public FixedArea findFetchAddress(String address);
	
	/**
	 * 查询定区下的职员
	 * @param fixedAreaId
	 * @return 查询到的Id集合
	 */
	public List<String> findEmpIdByFixedAreaId(String fixedAreaId);
	
	
	/**
	 * 查询正在上班的职员
	 * @return
	 */
	public Relay findEmpByRelay(String empId);

	/**
	 * 根据职员Id查询职员
	 * @param parmMap 
	 * @return
	 */
	public Emp findEmpByEmpId(String empId);
	
	/**
	 * 根据业务受理单Id修改业务受理单类型
	 * @param businessRecsiptId  业务受理单Id
	 * @return  受影响的行数
	 */
	public boolean updateWorkOrderTypeById(String businessRecsiptId , String workOrderType , String status);
	
	/**
	 * 根据业务受理单Id查询业务受理单
	 * @param businessRecsiptId 业务受理单Id
	 * @return 业务受理单
	 */
	public WorkOrder findWorkOrderById(String businessRecsiptId);
	
	/**
	 * 删除工单	
	 * @param parmMap  参数集合
	 * @return 受影响的行数
	 */
	public boolean deleteWorkOrder(String businessRecsiptId , String workOrderType );
	
	/**
	 * 修改销单原因
	 * @param destoryCause  销单原因
	 * @return  受影响的行数
	 */
	public boolean updateDestoryCause(String businessRecsiptId , String destoryCause );
	
	/**
	 * 添加一条工单详情
	 * @param workOrderDetail  要添加的工单详情
	 * @return  受影响的行数
	 */
	public boolean addWorkOrderDetail(WorkOrderDetail workOrderDetail);
	
	/**
	 * 根据Id修改业务受理单
	 * @param paramMap 条件集合
	 * @return 是否修改成功
	 */
	public boolean updateBusinessRecsiptById(Map<String, Object> paramMap);
	
	/**
	 * 根据部门Id查询部门名字
	 * @param orgId 部门Id
	 * @return 部门名
	 */
	public String findOrgNameById(String orgId);
	
	/**
	 * 根据业务受理单Id统计查询工单
	 * @param businessRecsiptId 业务受理单Id
	 * @return 查询到的业务受理单
	 */
	public BusinessRecsipt findBusinessRecsiptIdById(String businessRecsiptId);
	
	/**
	 * 查询已通知的工单单
	 * @return 查询到了一条工单
	 */
	public WorkOrder findWorkOrderOne();
	
	/**
	 * 修改取件状态
	 * @return 修改是否成功
	 */
	public boolean updatePickStatus(String Wstatus ,String businessRecsiptId);
	
	/**
	 * 查询部分宣传任务
	 * @return 宣传任务标题集合
	 */
	public List<String> findPropagandaContent();
	
	/**
	 * 根据部门Id查询该部门下的受理单
	 * @param operatorOrg 部门名字
	 * @return 统计数
	 */
	public int countOrderNum(String operatorOrg);
}

package com.yidu.tencloud.web.controller.taketosend.dispatcher;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.dispatcher.DispatcherAnnals;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;
import com.yidu.tencloud.biz.taketosend.dispatcher.DispatcherService;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 调度的控制器层
 * @author 鲁静芝
 * @since 2017/12/25
 */
@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

	/**
	 * 对调度业务层进行注入
	 */
	@Autowired
	private DispatcherService dispatcherServiceBiz;
	
	/**
	 * 设置业务层
	 * @param dispatcherServiceBiz 业务层对象
	 */
	public void setDispatcherServiceBiz(DispatcherService dispatcherServiceBiz) {
		this.dispatcherServiceBiz = dispatcherServiceBiz;
	}
	
	/**
	 * 查询所有的调度
	 * @param paramMap map接口
	 * @return 调度集合
	 */
	@RequestMapping("/findAllNeedDispatcherWorkOrder")
	@ResponseBody
	public Map<String,Object> findAllDispatcher(@RequestBody Map<String,Object> paramMap){
		//调用记录数的方法，对查询到的数据进行记录
		paramMap.put("total", dispatcherServiceBiz.countNum(paramMap));
		//调用查询需要调度的方法
		paramMap.put("rows", dispatcherServiceBiz.findAllNeedDispatcherWorkOrder(paramMap));
		//收件城市
		paramMap.put("arrivalCity", dispatcherServiceBiz.findAllNeedDispatcherWorkOrder(paramMap));
		//分拣编码
		paramMap.put("fetchAddress", dispatcherServiceBiz.findAllNeedDispatcherWorkOrder(paramMap));
		//返回map
		return paramMap;
	}
	
	/**
	 * 记录需要调度的工单
	 * @return 总数
	 */
	@RequestMapping("/countNeedDispatcher")
	@ResponseBody
	public int countNeedDispatcher(){
		//调用记录需要调度的工单
		return dispatcherServiceBiz.countNeedDispatcherOrder();
	}
	
	/**
	 * 查询所有调度历史
	 * @param businessRecsipt 通知单对象
	 * @return map集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/findAllDispatcherAnnals")
	@ResponseBody
	public Map<String,Object> findAllDispatcherAnnals(BusinessRecsipt businessRecsipt) throws Exception{
		//创建一个map接口对象
		Map<String,Object> map = new HashMap<String, Object>();
		//创建一个调度历史集合，并调用查询所有调度历史的方法
		List<DispatcherAnnals> dispatcherAnnalsList = dispatcherServiceBiz.findAllDispatcherAnnals(businessRecsipt.getBusinessRecsiptId());
		//调用查询所有调度历史的方法
		map.put("total",dispatcherServiceBiz.findAllDispatcherAnnals(businessRecsipt.getBusinessRecsiptId()).size());
		//查询到调度历史集合
		map.put("rows", dispatcherAnnalsList);
		
		return map;
	}
	
	/**
	 * 查询所有的组织结构 
	 * @param businessRecsipt 通知单对象
	 * @return 组织结构集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/findAllOrg")
	@ResponseBody
	public List<Organization> findAllOrg(BusinessRecsipt businessRecsipt) throws Exception{
		//返回组织结构集合
		return dispatcherServiceBiz.findAllOrg();
	}
	
	/**
	 * 销单的方法
	 * @param businessRecsiptId 通知单Id
	 * @param destoryCause 销单原因
	 * @return map集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/destroyDispatcher")
	@ResponseBody
	public Map<String,Object> destroyDispatcher(String businessRecsiptId,String destoryCause)
			throws Exception{
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//调用删除方法，判断是否删除完成
		if(dispatcherServiceBiz.deleteWorkOrder(businessRecsiptId) == 1) {
			//修改销单原因
			dispatcherServiceBiz.updateDestoryCause(destoryCause, businessRecsiptId);
			//创建一个工单详情对象
			WorkOrderDetail workOrderDetail = new WorkOrderDetail();
			//创建要给工单对象，并调用通过通知单Id查询工单的方法
			WorkOrder workOrder = dispatcherServiceBiz.findWorkOrderById(businessRecsiptId);
			//设置原工单Id
			workOrderDetail.setFormerId(workOrder.getWorkOrderId());
			//设置原工单号
			workOrderDetail.setFormerNo(workOrder.getWorkOrderNo());
			//设置原因
			workOrderDetail.setCause(destoryCause);
			//添加一条工单详情
			dispatcherServiceBiz.addWorkOrderDetail(workOrderDetail);
			//操作成功
			paramMap.put("status", "success");
		}else {
			//操作失败
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 分配的方法
	 * @param empName 职员名
	 * @param workOrder 工单对象
	 * @param businessRecsipt 通知单对象
	 * @param dispatcherAnnals 调度历史对象
	 * @return map接口集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/distributionDispatcher")
	@ResponseBody
	public Map<String,Object> distributionDispatcher(String empName,WorkOrder workOrder,BusinessRecsipt businessRecsipt,
			DispatcherAnnals dispatcherAnnals) throws Exception{
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//创建一个职员对象，并调用通过职员名查询职员的方法
		Emp emp = dispatcherServiceBiz.findEmpByEmpId(empName);
		
		//判断修改通知单类型是否成功
		if(dispatcherServiceBiz.updateTypeById(businessRecsipt.getBusinessRecsiptId()) == 1) {
			//设置工单Id
			workOrder.setWorkOrderId(IDGenderatorUtil.generateId());
			//设置工单编号
			workOrder.setWorkOrderNo(FlowOddNumber.AtomicRangeInteger("工作单"));
			//设置通知单Id
			workOrder.setBusinessRecsiptId(businessRecsipt.getBusinessRecsiptId());
			//设置通知单编号，通过查询通知单编号拿到
			workOrder.setBusinessRecsiptNo(dispatcherServiceBiz.findBusinessRecsiptNo(businessRecsipt.getBusinessRecsiptId()));
			//设置工单类型，默认是新单
			workOrder.setWorkOrderType("新单");
			//设置变量为1
			Integer noteNum = 1;
			//设置取件状态，默认为已通知
			workOrder.setWstatus("已通知");
			//设置短信序号，短信序号自加
			workOrder.setNoteNum(++noteNum);
			//设置工单生成时间，当前时间
			workOrder.setWorkOrderTime(new Date(System.currentTimeMillis()));
			//设置追单次数，默认为1
			workOrder.setTraceNum(1);
			//设置职员编号
			workOrder.setEmpNum(emp.getEmpNum());
			//设置职员名
			workOrder.setEmpName(emp.getEmpName());
			//设置职员Id
			workOrder.setEmpId(emp.getEmpId());
			//设置取件单位
			workOrder.setTakeOrgName(emp.getOrgName());
			//设置取件时间
			workOrder.setTakeTime(dispatcherServiceBiz.findTakeTimeById(businessRecsipt.getBusinessRecsiptId()));
			//设置分拣编码
			workOrder.setSortingCode(dispatcherServiceBiz.findBusinessRecsiptNo(businessRecsipt.getBusinessRecsiptId()));
			//添加一条工单记录
			dispatcherServiceBiz.addWorkOrder(workOrder);
			//添加一条调度历史记录
			dispatcherServiceBiz.addDispatcherAnnals(dispatcherAnnals);
			//操作成功
			paramMap.put("status", "success");
		}else {
			//操作失败
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 查询所有正在上班的职员
	 * @param fixedAreaNum 定区编码
	 * @param fixedArea 定区对象
	 * @param emp 职员对象
	 * @return 职员字符串集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/findOnJobEmp")
	@ResponseBody
	public List<String> findOnJobEmp(String fixedAreaNum,FixedArea fixedArea,Emp emp) throws Exception {
		//通过定区编码查询定区Id
		FixedArea fixedAreaId = dispatcherServiceBiz.findFixedAreaIdByNum(fixedAreaNum);
		
		//通过定区Id查询正在上班的职员
		List<String> empList = dispatcherServiceBiz.findAllFixedAreaEmpIdByFixedAreaId(fixedAreaId);
		//返回职员集合
		return empList;
	}
	
	/**
	 * 查询分拣编码
	 * @param fetchAddress 分拣编码
	 * @return map接口
	 * @throws Exception 异常
	 */
	@RequestMapping("/findFetchAddress")
	@ResponseBody
	public Map<String, Object> findFetchAddress(String fetchAddress) throws Exception {
		//查询分拣编码
		FixedArea fixedArea = dispatcherServiceBiz.findFetchAddress(fetchAddress);
		//获得到定区编码
		String assignCode = fixedArea.getFixedAreaNum();
		//创建map接口对象
		Map<String, Object> resultClientMap = new HashMap<String, Object>();
		//设置分拣编码的值
		resultClientMap.put("assignCode", assignCode);

		return resultClientMap;
	}
	
	/**
	 * 退回的方法
	 * @param dispatcherAnnals
	 * @param returnCause
	 * @param businessRecsiptId
	 * @return Map接口对象
	 * @throws Exception 异常
	 */
	@RequestMapping("/returnDispatcher")
	@ResponseBody
	public Map<String,Object> returnDispatcher(DispatcherAnnals dispatcherAnnals,
			String returnCause,String businessRecsiptId) throws Exception{
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//判断添加调度历史是否成功
		if(dispatcherServiceBiz.addDispatcherAnnals(dispatcherAnnals) == 1){
			//判断修改返回原因是否成功
			if(dispatcherServiceBiz.updateReturnCause(returnCause, businessRecsiptId) == 1) {
				//修改成功
				paramMap.put("status", "success");
			}else {
				//修改失败
				paramMap.put("status", "failed");
			}
		}else {
			//修改失败
			paramMap.put("status", "failed");
		}
		return paramMap;
	}
	
	/**
	 * 外部分配
	 * @param empName 职员名
	 * @param workOrder 工单对象
	 * @param businessRecsipt 通知单对象
	 * @param dispatcherAnnals 调度历史对象
	 * @return Map接口对象
	 * @throws Exception 异常
	 */
	@RequestMapping("/externalDistribution")
	@ResponseBody
	public Map<String,Object> externalDistribution(String empName,WorkOrder workOrder,BusinessRecsipt businessRecsipt,
			DispatcherAnnals dispatcherAnnals) throws Exception{
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//创建一个职员对象，并调用通过职员名查询职员的方法
		Emp emp = dispatcherServiceBiz.findEmpByEmpId(empName);
		
		//判断修改通知单类型是否成功
		if(dispatcherServiceBiz.updateTypeById(businessRecsipt.getBusinessRecsiptId()) == 1) {
			//设置工单Id
			workOrder.setWorkOrderId(IDGenderatorUtil.generateId());
			//设置工单编号
			workOrder.setWorkOrderNo(FlowOddNumber.AtomicRangeInteger("工作单"));
			//设置通知单Id
			workOrder.setBusinessRecsiptId(businessRecsipt.getBusinessRecsiptId());
			//设置通知单编号，通过查询通知单编号拿到
			workOrder.setBusinessRecsiptNo(dispatcherServiceBiz.findBusinessRecsiptNo(businessRecsipt.getBusinessRecsiptId()));
			//设置工单类型，默认是新单
			workOrder.setWorkOrderType("新单");
			//设置变量为1
			Integer noteNum = 1;
			//设置取件状态，默认为已通知
			workOrder.setWstatus("已通知");
			//设置短信序号，短信序号自加
			workOrder.setNoteNum(++noteNum);
			//设置工单生成时间，当前时间
			workOrder.setWorkOrderTime(new Date(System.currentTimeMillis()));
			//设置追单次数，默认为1
			workOrder.setTraceNum(1);
			//设置职员编号
			workOrder.setEmpNum(emp.getEmpNum());
			//设置职员名
			workOrder.setEmpName(emp.getEmpName());
			//设置职员Id
			workOrder.setEmpId(emp.getEmpId());
			//设置取件单位
			workOrder.setTakeOrgName(emp.getOrgName());
			//设置取件时间
			workOrder.setTakeTime(dispatcherServiceBiz.findTakeTimeById(businessRecsipt.getBusinessRecsiptId()));
			//设置分拣编码
			workOrder.setSortingCode(dispatcherServiceBiz.findBusinessRecsiptNo(businessRecsipt.getBusinessRecsiptId()));
			//添加一条工单记录
			dispatcherServiceBiz.addWorkOrder(workOrder);
			//添加一条调度历史记录
			dispatcherServiceBiz.addDispatcherAnnals(dispatcherAnnals);
			//操作成功
			paramMap.put("status", "success");
		}else {
			//操作失败
			paramMap.put("status", "failed");
		}
		
		return paramMap;
	}
	
	/**
	 * 通过组织结构名查询正在上班的职员
	 * @param orgName 组织结构名
	 * @return 职员集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/findEmpNameByOrgName")
	@ResponseBody
	public List<String> findEmpNameByOrgName(String orgName) throws Exception {
		//通过定区Id查询正在上班的职员
		List<String> empList = dispatcherServiceBiz.findEmpNameByOrgName(orgName);
		//返回职员集合
		return empList;
	}
	
	/**
	 * 画饼状图 
	 * @return 集合
	 * @throws Exception 异常
	 */
	@RequestMapping("/creatBusin")
	public @ResponseBody List<Integer> creatBusin()throws Exception{
		//调用画图的方法
		return dispatcherServiceBiz.creatPie();
	}
}

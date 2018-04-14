package com.yidu.tencloud.biz.taketosend.dispatcher.impl;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.dispatcher.DispatcherAnnals;
import com.yidu.tencloud.bean.taketosend.responsibilityDot.ResponsibilityDot;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.dispatcher.DispatcherService;
import com.yidu.tencloud.dao.taketosend.dispatcher.DispatcherMapper;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 调度的业务逻辑层的实现类
 * @author 鲁静芝
 * @since 2017/12/22
 */
@Service
public class DispatcherServiceImpl implements DispatcherService {

	//对调度Mapper接口进行注入
	@Autowired
	private DispatcherMapper dispatcherMapper;
	//对职员业务逻辑层进行注入
	@Autowired
	private EmpBiz empBiz;
	/**
	 * 获得职员业务逻辑层实现类对象
	 * @return 职员业务逻辑层实现类对象
	 */
	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	/**
	 * 设置职员业务逻辑层实现类对象
	 * @param empBiz 职员业务逻辑层实现类对象
	 */
	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
	 * 设置调度接口
	 * @param dispatcherMapper 调度接口
	 */
	public void setDispatcherMapper(DispatcherMapper dispatcherMapper) {
		this.dispatcherMapper = dispatcherMapper;
	}

	/**
	 * 查询所有需要调度的工单
	 * @param map map接口
	 * @return 通知单集合
	 */
	@Override
	public List<BusinessRecsipt> findAllNeedDispatcherWorkOrder(Map<String, Object> paramMap) {
		//调用职员业务逻辑层的方法设置值，使不同的用户看到的数据是不同的
		paramMap.put("orgList", empBiz.orgListToString());
		//调用查询所有需要调度的工单方法
		return dispatcherMapper.findAllNeedDispatcherWorkOrder(paramMap);
	}

	/**
	 * 记录数
	 */
	@Override
	public int countNum(Map<String, Object> paramMap) {
		//调用查询记录数的方法
		return dispatcherMapper.countNum(paramMap);
	}

	/**
	 * 记录所有需要调度的工单
	 * @return 总数
	 */
	@Override
	public int countNeedDispatcherOrder() {
		//调用记录所有需要进行调度的方法
		return dispatcherMapper.countNeedDispatcherOrder();
	}
	
	/**
	 * 查询所有调度历史
	 * @param businessRecsiptId 通知单Id
	 * @return 调度历史集合
	 */
	@Override
	public List<DispatcherAnnals> findAllDispatcherAnnals(String businessRecsiptId) {
		//调用查询所有调度历史的方法
		return dispatcherMapper.findAllDispatcherAnnals(businessRecsiptId);
	}

	/**
	 * 查询所有组织结构
	 */
	@Override
	public List<Organization> findAllOrg() {
		//调用查询所有组织结构的方法
		return dispatcherMapper.findAllOrg();
	}

	/**
	 * 查询分拣编码
	 * @param address 定区名
	 * @return 定区对象
	 */
	@Override
	public FixedArea findFetchAddress(String address) {
		//截取字符串
		String toAddress = address.substring(0,address.indexOf("区"));
		//创建Map对象
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//使用Map对象为定区名赋值
		paramMap.put("address", toAddress);
		//调用查询分拣编码的方法
		return dispatcherMapper.findFetchAddress(paramMap);
	}

	/**
	 * 通过定区编码查询定区Id
	 * @param fixedAreaNum 定区编码
	 * @return 定区对象
	 */
	@Override
	public FixedArea findFixedAreaIdByNum(String fixedAreaNum) {
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//为map对象赋值
		paramMap.put("fixedAreaNum", fixedAreaNum);
		//调用通过定区编码查询定区Id的方法
		return dispatcherMapper.findFixedAreaIdByNum(paramMap);
	}

	/**
	 * 通过定区Id查询正在上班的职员
	 * @param fixedArea 区域对象
	 * @return 字符串集合
	 */
	@Override
	public List<String> findAllFixedAreaEmpIdByFixedAreaId(FixedArea fixedArea) {
		//创建一个map对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为定区Id赋值
		paramMap.put("fixedAreaId", fixedArea.getFixedAreaId());
		//调用通过定区Id查询正在上班的职员的方法
		return dispatcherMapper.findAllFixedAreaEmpIdByFixedAreaId(paramMap);
	}

	/**
	 * 通过员工Id查询职员
	 * @param empName 职员名
	 * @return 职员对象
	 */
	@Override
	public Emp findEmpByEmpId(String empName) {
		//创建一个Map对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为职员名赋值
		paramMap.put("empName", empName);
		//调用通过职员Id查询职员的方法
		return dispatcherMapper.findEmpByEmpId(paramMap);
	}

	/**
	 * 通过通知单Id修改通知单类型
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	@Override
	public int updateTypeById(String businessRecsiptId) {
		//创建一个Map对象
		Map<String ,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为通知单Id赋值
		paramMap.put("businessRecsiptId", businessRecsiptId);
		//调用mapper接口中的通过通知单Id修改通知单类型的方法，判断是否修改成功
		if(dispatcherMapper.updateTypeById(paramMap) == 1) {
			//修改成功
			return 1;
		}
		//修改失败
		return 0;
	}
	
	/**
	 * 通过通知单Id查询通知单号
	 * @param businessRecsiptId 通知单Id
	 * @return 字符串
	 */
	@Override
	public String findBusinessRecsiptNo(String businessRecsiptId) {
		//调用通过通知单Id查询通知单号的方法
		return dispatcherMapper.findBusinessRecsiptNo(businessRecsiptId);
	}

	/**
	 * 通过通知单Id查询取件时间
	 * @param businessRecsiptId 通知单id
	 * @return 时间对象
	 */
	@Override
	public java.util.Date findTakeTimeById(String businessRecsiptId) {
		//调到用通过通知单Id查询取件时间的方法
		return dispatcherMapper.findTakeTimeById(businessRecsiptId);
	}

	/**
	 * 添加工单
	 * @param workOrder 工单对象
	 * @return 是否成功
	 */
	@Override
	public int addWorkOrder(WorkOrder workOrder) {
		//调用添加工单的方法，判断是否成功
		if(dispatcherMapper.addWorkOrder(workOrder) == 1) {
			//添加成功
			return 1;
		}
		//添加失败
		return 0;
	}

	/**
	 * 添加调度历史
	 * @param dispatcherAnnals 调度历史对象
	 * @return 调度历史
	 */
	@Override
	public int addDispatcherAnnals(DispatcherAnnals dispatcherAnnals) {
		//设置调度Id，使用工具类自动生成Id
		dispatcherAnnals.setDispatcherAnnalsId(IDGenderatorUtil.generateId());
		//设置调度序号，使用工具类自动生成调度序号
		dispatcherAnnals.setDispatcherNum(FlowOddNumber.AtomicRangeInteger("调度历史"));
		//设置状态，调度状态默认为“0”
		dispatcherAnnals.setStatus("0");
		//设置操作时间，操作时间为当前是时间
		dispatcherAnnals.setOperatorTime(new Date(System.currentTimeMillis()));
		//判断添加调度历史是否成功
		if (dispatcherMapper.addDispatcherAnnals(dispatcherAnnals) == 1) {
			//添加成功
			return 1;
		}
		//添加失败
		return 0;
	}

	/**
	 * 添加工单详情
	 * @param workOrderDetail 工单详情
	 * @return 是否添加成功
	 */
	@Override
	public int addWorkOrderDetail(WorkOrderDetail workOrderDetail) {
		//设置工单详情Id
		workOrderDetail.setWorkOrderDetailId(IDGenderatorUtil.generateId());
		//设置工单详情序号
		workOrderDetail.setWorkOrderDetailNo(FlowOddNumber.AtomicRangeInteger("工单详情"));
		//判断工单详情是否添加成功
		if(dispatcherMapper.addWorkOrderDetail(workOrderDetail) == 1) {
			//添加成功
			return 1;
		}
		//添加失败
		return 0;
	}
	
	/**
	 * 修改销单原因
	 * @param destoryCause 销单原因
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	@Override
	public int updateDestoryCause(String destoryCause, String businessRecsiptId) {
		//创建一个map对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为参数赋值
		paramMap.put("destoryCause", destoryCause);
		paramMap.put("businessRecsiptId", businessRecsiptId);
		//判断是否修改成功
		if(dispatcherMapper.updateDestoryCause(paramMap) == 1) {
			//修改成功
			return 1;
		}
		//修改失败
		return 0;
	}
	
	/**
	 * 通过通知单Id查询工单
	 * @param businessRecsiptId 通知单Id
	 * @return 工单对象
	 */
	@Override
	public WorkOrder findWorkOrderById(String businessRecsiptId) {
		//返回查到的工单信息
		return dispatcherMapper.findWorkOrderById(businessRecsiptId);
	}
	
	/**
	 * 通过通知单Id删除工单
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	@Override
	public int deleteWorkOrder(String businessRecsiptId) {
		//判断是否删除成功
		if(dispatcherMapper.deleteWorkOrder(businessRecsiptId) == 1) {
			//删除成功
			return 1;
		}
		//删除失败
		return 0;
	}
	
	/**
	 * 修改返回原因
	 * @param returnCause 返回原因
	 * @param businessRecsiptId 通知单Id
	 * @return 是否成功
	 */
	@Override
	public int updateReturnCause(String returnCause, String businessRecsiptId) {
		//创建一个map接口对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为参数赋值
		paramMap.put("returnCause", returnCause);
		paramMap.put("businessRecsiptId", businessRecsiptId);
		//调用方法判断修改返回原因是否成功
		if(dispatcherMapper.updateReturnCause(paramMap) == 1) {
			//修改成功
			return 1;
		}
		//修改失败
		return 0;
	}

	/**
	 * 通过组织结构名查询正在上班的职员
	 * @param orgName
	 * @return 集合
	 */
	@Override
	public List<String> findEmpNameByOrgName(String orgName) {
		//创建一个map对象
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//使用map接口为定区Id赋值
		paramMap.put("orgName", orgName);
		//调用通过定区Id查询正在上班的职员的方法
		return dispatcherMapper.findEmpNameByOrgName(paramMap);
	}

	/**
	 * 画饼状图
	 * @return 集合对象
	 * @throws ParseException 异常
	 */
	@Override
	public List<Integer> creatPie() throws ParseException {
		//创建一个map1对象
		Map<String,Object> map1 = new HashMap<String, Object>();
		//设置状态为下单成功的值
		map1.put("type", "0");//下单成功
		//筛选状态为下单成功的值，调用职员业务逻辑层的方法
		map1.put("orgList", empBiz.orgListToString());
		//调用记录受理单数据的方法，将map1对象放入
		int num1 = dispatcherMapper.countBusinessRecsipt(map1);
		
		//创建map2对象
		Map<String,Object> map2 = new HashMap<String, Object>();
		//设置状态为待调度的值
		map2.put("type", "1");//待调度
		//筛选状态为待调度的值，调用职员业务逻辑层的方法
		map2.put("orgList", empBiz.orgListToString());
		//调用记录受理单数据的方法，将map2对象放入
		int num2 = dispatcherMapper.countBusinessRecsipt(map2);
		
		//创建一个map3对象
		Map<String,Object> map3 = new HashMap<String, Object>();
		//设置状态为已调度的值
		map3.put("type", "2");//已调度
		//筛选状态为已调度的值，调用职员业务逻辑层的方法
		map3.put("orgList", empBiz.orgListToString());
		//调用记录受理单数据的方法，将map3对象放入
		int num3 = dispatcherMapper.countBusinessRecsipt(map3);
		
		//创建一个Integer集合对象
		List<Integer> ints = new ArrayList<Integer>();
		//使用添加方法将查询到的下单成功的值放入
		ints.add(num1);
		//使用添加方法将查询到的待调度的值放入
		ints.add(num2);
		//使用添加方法将查询到的已调度的值放入
		ints.add(num3);
		
		//直接返回int对象
		return ints;
	}
}

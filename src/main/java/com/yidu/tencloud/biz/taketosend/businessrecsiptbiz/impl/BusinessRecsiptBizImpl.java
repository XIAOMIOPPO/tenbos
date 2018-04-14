package com.yidu.tencloud.biz.taketosend.businessrecsiptbiz.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.basis.pickandrelaystandard.Emp;
import com.yidu.tencloud.bean.basis.pickandrelaystandard.Relay;
import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.freightCharge.FreightCharge;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;
import com.yidu.tencloud.biz.basis.pickandrelaystandardbiz.EmpBiz;
import com.yidu.tencloud.biz.taketosend.businessrecsiptbiz.BusinessRecsiptBiz;
import com.yidu.tencloud.dao.system.clientdao.ClientMapper;
import com.yidu.tencloud.dao.taketosend.businessrecsipt.BusinessRecsiptMapper;
import com.yidu.tencloud.dao.taketosend.freightCharge.FreightChargeMapper;
import com.yidu.tencloud.util.AcceptanceNote;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.NoteUtil;

/**
 * 业务受理单业务逻辑层
 * @author 张建勇
 * @date 2017年11月24日 10:15:36
 */
@Service
public class BusinessRecsiptBizImpl implements BusinessRecsiptBiz{
	
	//保留业务受理单 Mapper接口的引用
	@Autowired
	private BusinessRecsiptMapper recsiptMapper;
	
	//保留计算运费城市的Mapper接口引用
	@Autowired
	private FreightChargeMapper chargeMapper;
	
	@Autowired
	private EmpBiz empBiz;
	
	public EmpBiz getEmpBiz() {
		return empBiz;
	}

	public void setEmpBiz(EmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	//保留对客户Mapper接口的引用
	@Autowired
	private ClientMapper clientMapper;
	
	public ClientMapper getClientMapper() {
		return clientMapper;
	}

	public void setClientMapper(ClientMapper clientMapper) {
		this.clientMapper = clientMapper;
	}

	public FreightChargeMapper getChargeMapper() {
		return chargeMapper;
	}

	public void setChargeMapper(FreightChargeMapper chargeMapper) {
		this.chargeMapper = chargeMapper;
	}

	public BusinessRecsiptMapper getRecsiptMapper() {
		return recsiptMapper;
	}

	public void setRecsiptMapper(BusinessRecsiptMapper recsiptMapper) {
		this.recsiptMapper = recsiptMapper;
	}
	
	
	
	
	
	
	

	@Override
	public Client findClientByPhoneNum(String phoneNum) {
		//根据来电手机号码查询客户信息
		return recsiptMapper.findClientPhoneNum(phoneNum);
	}
	
	/**
	 * 计算运费的方法
	 * @param businessRecsipt 计算条件
	 * @return 运费金额
	 */
	public Double createMoney(BusinessRecsipt businessRecsipt){
		Map<String, Object> moneyParamMap = new HashMap<String,Object>();
		//拿到寄件城市
		String placeOfDispatch = businessRecsipt.getFetchAddress().substring(0, 2);
		//拿到收件城市
		String receivingLand = businessRecsipt.getServeAddress().substring(0, 2);
		//放入map集合
		moneyParamMap.put("placeOfDispatch", placeOfDispatch);
		moneyParamMap.put("receivingLand", receivingLand);
		//查询到寄件城市到收件城市的价格
		FreightCharge charge = chargeMapper.findFreightChargeByPlaceOfDispatchPYAndReceivingLandPY(moneyParamMap);
		//拿到首重价格
		Integer firstHeavy = charge.getFirstHeavy();
		//拿到次重价格
		Integer secondHeavy = charge.getSecondHeavy();
		//拿到寄件商品的重量
		BigDecimal weight = businessRecsipt.getWeight();
		//定义变量预收费金额，并初始化
		Double money = 0.0;
		//判断首重 如果大于0小于1
		if(weight.doubleValue() >0  && weight.doubleValue() <= 1){
			//直接调用首重价格
			money = firstHeavy.doubleValue();
		//如果重量大于1  
		}else if(weight.doubleValue() > 1){
			// 首重+次重的价格
			money = (weight.doubleValue() - 1.0 ) * secondHeavy + firstHeavy;
		}
		//返回预收费金额
		return money;
	}
	
	//新单
	@Override
	public boolean addBusinessRecsipt(BusinessRecsipt businessRecsipt) {
		//设置业务受理单Id
		businessRecsipt.setBusinessRecsiptId(IDGenderatorUtil.generateId());
		//计算运费
		BigDecimal money = new BigDecimal(createMoney(businessRecsipt));
		//设置预收费金额加入业务受理单对象中
		businessRecsipt.setPrecharge(money);
		businessRecsipt.setType("0");
		//如果添加一条业务受理单返回的受影响的行数小于1
		if(recsiptMapper.addBusinessRecsipt(businessRecsipt) < 1){
			//添加失败，返回false
			return false;
		}else{
			//受影响的行数大于等于1  根据业务通知单中的收件地址，得到分拣编码
			//再根据分拣编码查询定区下正在上班的职员
			Emp emp = findAreaEmp(businessRecsipt.getFetchAddress());
			//判定该定区下是否有职员上班
			if(emp != null){
				//添加业务受理单的时候同时添加一条工单
				//创建工单对象
				WorkOrder workOrder = new WorkOrder();
				workOrder.setWorkOrderId(IDGenderatorUtil.generateId());
				workOrder.setWorkOrderNo(FlowOddNumber.AtomicRangeInteger("工作单"));
				workOrder.setBusinessRecsiptId(businessRecsipt.getBusinessRecsiptId());
				workOrder.setBusinessRecsiptNo(businessRecsipt.getBusinessRecsiptNo());
				workOrder.setWorkOrderType("新单");
				//发送短信  给客户
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				NoteUtil.createNoteToClient(businessRecsipt.getPhoneNum(),
						businessRecsipt.getCustomerName(), 
						businessRecsipt.getBusinessRecsiptNo(), 
						emp.getEmpName(), emp.getPhoneNum(),
						formatter.format(businessRecsipt.getAppointmentDispatchTime()),
						money.toString());
				//短信发送成功，设置工单状态为已通知
				workOrder.setWstatus("已通知");
				//发送短信给职员
				AcceptanceNote.tranceOrderNote(emp.getPhoneNum(), 
						emp.getEmpName(), workOrder.getWorkOrderNo(),
						businessRecsipt.getFetchAddress(), 
						formatter.format(businessRecsipt.getAppointmentDispatchTime()));
				//设置短信序号
				workOrder.setNoteNum(1);
				//设置工单生成时间
				workOrder.setWorkOrderTime(new Date());
				//设置追单次数
				workOrder.setTraceNum(0);
				/**
				 * 设置该订单的取件员信息
				 */
				//设置职员编号
				workOrder.setEmpNum(emp.getEmpNum());
				//设置职员名字
				workOrder.setEmpName(emp.getEmpName());
				//设置职员Id
				workOrder.setEmpId(emp.getEmpId());
				//设置部门名字
				workOrder.setTakeOrgName(emp.getOrgName());
				//设置取件时间
				workOrder.setTakeTime(businessRecsipt.getAppointmentDispatchTime());
				//设置分拣编码
				workOrder.setSortingCode(businessRecsipt.getAssignCode());
				//添加新的工单
				int result = recsiptMapper.addWorkOrder(workOrder);
				//判断是否添加成功
				if(result != 1){
					//工单添加失败，转人工调度
					//修改受理单状态
					recsiptMapper.updateBusinessReceiptTpye(businessRecsipt.getBusinessRecsiptId());
					return false;
				}else{
					return true;
				}
				//如果没有职员上班直接返回false
			}else{
				//工单添加失败，转人工调度
				recsiptMapper.updateBusinessReceiptTpye(businessRecsipt.getBusinessRecsiptId());
				return false;
			}
		}
		
	}
	
	/**
	 * 根据地址查询正在上班的职员方法
	 * @param address
	 * @return
	 */
	public Emp findAreaEmp(String address){
		//截取地址字符串   格式XXX省 XXX 市 XXX 区
		// 截取市和区中间的城市
		String toAddress = address.substring(address.indexOf("市")+1,address.indexOf("区"));
		//创建查询条件Map集合
		Map<String, Object> parmMap = new HashMap<String, Object>();
		//传入参数地址
		parmMap.put("address", toAddress);
		//根据地址查询定区
		FixedArea fixedArea = recsiptMapper.findFetchAddress(parmMap);
		if(fixedArea != null){
			//生成一个随机数
			Random r = new Random();
			//根据定区Id查询到该定区下所有的职员Id集合
			List<String> empIds = findEmpIdByFixedAreaId(fixedArea.getFixedAreaId());
			//通过随机数查询到某个正在上班的职员
			//r.nextInt(empIds.size())  随机数的方法，最大数是职员集合的大小
			String empId = empIds.get(r.nextInt(empIds.size()));
			//再根据职员Id查询到具体的职员
			Emp emp = findEmpByEmpId(empId);
			//返回出去具体的职员
			return emp;
		}else{
			return null;
		}
	}
	
	
	//查询所有的业务受理单
	@Override
	public List<BusinessRecsipt> findAllRecsipts() {
		return recsiptMapper.findAllRecsipts(empBiz.orgListToString());
	}
	
	//分页查询所有的业务受理单
	@Override
	public List<BusinessRecsipt> findAllRecsiptsByPage(Integer offset , Integer limit) {
		Map<String, Object> paremMap = new HashMap<String, Object>();
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		paremMap.put("orgList", empBiz.orgListToString());
		return recsiptMapper.findAllRecsiptsByPage(paremMap);
	}
	
	//条件模糊查询
	@Override
	public List<BusinessRecsipt> findRecsiptByConditionVague(String phoneNum, String contacts, String telephone,
			String productName, String customerName, String fetchAddress, String serveAddress, Integer offset,
			Integer limit) {
		Map<String, Object> paremMap = new HashMap<String, Object>();
		paremMap.put("offset", offset);
		paremMap.put("limit", limit);
		paremMap.put("phoneNum", phoneNum);
		paremMap.put("contacts", contacts);
		paremMap.put("telephone", telephone);
		paremMap.put("productName", productName);
		paremMap.put("customerName", customerName);
		paremMap.put("fetchAddress", fetchAddress);
		paremMap.put("serveAddress", serveAddress);
		paremMap.put("orgList", empBiz.orgListToString());
		
		return recsiptMapper.findRecsiptByConditionVague(paremMap);
	}
	
	//根据寄件地址查询定区
	@Override
	public FixedArea findFetchAddress(String address) {
		String toAddress = address.substring(address.indexOf("市")+1,address.indexOf("区"));
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("address", toAddress);
		//判定我们公司的业务范围是否包含该定区
		FixedArea fixedArea = recsiptMapper.findFetchAddress(parmMap);
		if(fixedArea == null){
			return null;
		}else{
			return fixedArea;
		}
	}
	
	//根据定区Id查询该定区下正在上班的职员
	@Override
	public List<String> findEmpIdByFixedAreaId(String fixedAreaId) {
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("fixedAreaId", fixedAreaId);
		return recsiptMapper.findAllFixedAreaEmpIdByFixedAreaId(parmMap);
	}
	
	//查询替班信息
	@Override
	public Relay findEmpByRelay(String empId){
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("empId", empId);
		return recsiptMapper.findEmpByRelay(parmMap);
	}
	
	//查询员工信息
	@Override
	public Emp findEmpByEmpId(String empId) {
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("empId", empId);
		return recsiptMapper.findEmpByEmpId(parmMap);
	}
	
	//追单
	@Override
	public boolean updateWorkOrderTypeById(String businessRecsiptId,String workOrderType , String status) {
		//首先根据通知单Id查询是否是下单失败的
		WorkOrder workOrders = recsiptMapper.findWorkOrderById(businessRecsiptId);
		BusinessRecsipt buRecsipt = recsiptMapper.findBusinessRecsiptIdById(businessRecsiptId);
		if(workOrders == null){
			return false;
			//第二步判断，如果该工单的工单类型是销工单，禁止追单
		}else if(workOrders.getWorkOrderType().equals("销工单")){
			return false;
		}else{
			//修改工单状态，类型。生成追工单
			Map<String, Object> parmMap = new HashMap<String, Object>();
			parmMap.put("businessRecsiptId", businessRecsiptId);
			parmMap.put("workOrderType", workOrderType);
			if(recsiptMapper.updateWorkOrderTypeById(parmMap) != 1){
				return false;
			}else{
				Emp emp = findEmpByEmpId(workOrders.getEmpId());
				
				AcceptanceNote.tranceOrderNoteToEmp(emp.getPhoneNum(), 
						emp.getEmpName(), workOrders.getWorkOrderNo(), 
						buRecsipt.getFetchAddress(),workOrders.getTraceNum().toString());
				return true;
			}
		}
	}

	@Override
	public boolean addWorkOrderDetail(WorkOrderDetail workOrderDetail) {
		//添加工单详情
		//设置工单详情Id
		workOrderDetail.setWorkOrderDetailId(IDGenderatorUtil.generateId());
		//设置工单详情单号
		workOrderDetail.setWorkOrderDetailNo(FlowOddNumber.AtomicRangeInteger("工单详情"));
		//添加工单详情
		int result = recsiptMapper.addWorkOrderDetail(workOrderDetail);
		if(result != 1){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public WorkOrder findWorkOrderById(String businessRecsiptId) {
		//根据受理单Id查询工单
		return recsiptMapper.findWorkOrderById(businessRecsiptId);
	}

	@Override
	public boolean deleteWorkOrder(String businessRecsiptId , String workOrderType ) {
		//根据Id获得销单对象
		BusinessRecsipt bus = recsiptMapper.findBusinessRecsiptIdById(businessRecsiptId);
		//获得工单对象
		WorkOrder workOrder = recsiptMapper.findWorkOrderById(bus.getBusinessRecsiptId());
		//判断工单状态是否是不能销单 已取件||已取消||已销单||已收货
		if(workOrder.getWstatus().equals("已取件") || workOrder.getWstatus().equals("已取消")|| workOrder.getWstatus().equals("已收货")){
			return false;
		}else{
			Map<String, Object> parmMap = new HashMap<String, Object>();
			parmMap.put("businessRecsiptId", businessRecsiptId);
			parmMap.put("workOrderType", workOrderType);
			int result = recsiptMapper.deleteWorkOrder(parmMap);
			if(result != 1){
				return false;
			}else{
				//销单成功 发送通知短信  一个发给客户一个发给取件员
				AcceptanceNote.updateNote(bus.getPhoneNum(), bus.getCustomerName(), bus.getBusinessRecsiptNo());
				Emp emp = findEmpByEmpId(workOrder.getEmpId());
				//销单成功，通知原来的取件员停止取件
				AcceptanceNote.stopOrderNote(emp.getPhoneNum(),emp.getEmpName(), workOrder.getBusinessRecsiptNo());
				//销单成功，返回true
				return true;
			}
		}
		

	}

	@Override
	public boolean updateDestoryCause(String businessRecsiptId , String destoryCause) {
		//修改销单原因
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("businessRecsiptId", businessRecsiptId);
		parmMap.put("destoryCause", destoryCause);
		int result = recsiptMapper.updateDestoryCause(parmMap);
		if(result != 1){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public boolean updateBusinessRecsiptById(Map<String, Object> paramMap) {
		/**
		 * 第一步：
		 * 先根据Id查询受理单中的客户信息是否被修改
		 * 修改了客户的信息，同时修改分拣编码
		 */
		String id= (String) paramMap.get("businessRecsiptId");
		BusinessRecsipt recsipt = recsiptMapper.findBusinessRecsiptIdById(id);
		//获得收件地址和取件地址
		String fetchAddress= (String) paramMap.get("fetchAddress");
		WorkOrder cworkOrder = recsiptMapper.findWorkOrderById(recsipt.getBusinessRecsiptId());
		//判断工单状态是否是不能改单 已取件||已取消||已销单||已收货
		if(cworkOrder.getWstatus().equals("已取件") 
				|| cworkOrder.getWstatus().equals("已取消")
				|| cworkOrder.getWstatus().equals("已收货")){
			return false;
		}else if(recsipt.getFetchAddress().equals(fetchAddress) == false){
			String serveAddress= (String) paramMap.get("serveAddress");
			//通过取件地址和收件地址获得收件城市和寄件城市
			String fetchCity = fetchAddress.substring(fetchAddress.indexOf("市")+1,fetchAddress.indexOf("区"));
			String arrivalCity = serveAddress.substring(serveAddress.indexOf("市")+1,serveAddress.indexOf("区"));
			//将寄件城市和收件城市放入修改的参数map集合中
			paramMap.put("fetchCity", fetchCity);
			paramMap.put("arrivalCity", arrivalCity);
			//先将新的寄件地址和收件地址注入受理实体类
			recsipt.setFetchAddress(fetchAddress);
			recsipt.setServeAddress(serveAddress);
			recsipt.setWeight((BigDecimal)paramMap.get("weight"));
			//再通过计算运费的方法 获得预收费金额
			Double precharge = createMoney(recsipt);
			//更新新的预收费价格，放入参数集合
			paramMap.put("precharge", precharge);
			/**
			 * 地址修改后，同时修改分拣编码，以及更新客户信息
			 */
			//根据手机号码查询客户的信息
			Client client = findClientByPhoneNum((String) paramMap.get("phoneNum"));
			//设置客户地址
			client.setClientAddress(fetchAddress);
			//调用修改客户的方法
			clientMapper.updateClient(client);
			//根据地址获得新的分拣编码
			FixedArea fixedArea = findFetchAddress(fetchAddress);
			//得到分拣编码
			String assignCode = fixedArea.getFixedAreaNum();
			//添加新的分拣编码到Map集合
			paramMap.put("assignCode", assignCode);
			//删除成功之前获得该工单数据
			WorkOrder oldWorkOrder =findWorkOrderById(id);
			//再删除该受理单下的工单并且生成新的工单
			int result = recsiptMapper.deleteWorkOrderByBusinessRecsiptId(id);
			//删除成功，再添加新的工单
			if(result<1){
				recsiptMapper.updateBusinessRecsipt(paramMap);
			}else{
				//删除成功，添加工单详细
				WorkOrderDetail workOrderDetail = new WorkOrderDetail();
				//设置工单详情Id
				workOrderDetail.setWorkOrderDetailId(IDGenderatorUtil.generateId());
				//设置工单详情单号
				workOrderDetail.setWorkOrderDetailNo(FlowOddNumber.AtomicRangeInteger("工单详情"));
				//设置原工单Id
				workOrderDetail.setFormerId(oldWorkOrder.getWorkOrderId());
				//设置工单单号
				workOrderDetail.setFormerNo(oldWorkOrder.getWorkOrderNo());
				//设置销单原因
				workOrderDetail.setCause("修改地址，销的单");
				//地址之后修改新的派送员
				Emp emp = findAreaEmp(fetchAddress);
				//创建工单对象
				WorkOrder workOrder = new WorkOrder();
				//设置工单Id
				workOrder.setWorkOrderId(IDGenderatorUtil.generateId());
				//设置工单单号
				workOrder.setWorkOrderNo(FlowOddNumber.AtomicRangeInteger("工作单"));
				//设置受理单Id
				workOrder.setBusinessRecsiptId(recsipt.getBusinessRecsiptId());
				//设置受理单单号
				workOrder.setBusinessRecsiptNo(recsipt.getBusinessRecsiptNo());
				//设置工单类型
				workOrder.setWorkOrderType("新工单");
				//设置工单状态
				workOrder.setWstatus("已通知");
				//随发送短信的次数自加
				Integer noteNum = 1;
				//设置短信序号
				workOrder.setNoteNum(++noteNum);
				//设置工单生成时间
				workOrder.setWorkOrderTime(new Date());
				//设置追单次数
				workOrder.setTraceNum(0);
				//设置新的工单的取件员
				//设置职员编号
				workOrder.setEmpNum(emp.getEmpNum());
				//设置职员名字
				workOrder.setEmpName(emp.getEmpName());
				//设置职员Id
				workOrder.setEmpId(emp.getEmpId());
				//设置职员所属部门名
				workOrder.setTakeOrgName(emp.getOrgName());
				//设置取件时间
				workOrder.setTakeTime(recsipt.getAppointmentDispatchTime());
				//设置分拣编码
				workOrder.setSortingCode(assignCode);
				//添加新的工单详情
				recsiptMapper.addWorkOrderDetail(workOrderDetail);
				//添加新的工单
				int addWorkOrder = recsiptMapper.addWorkOrder(workOrder);
				if(addWorkOrder>=1){
					//发送短信
					NoteUtil.createToNote(recsipt.getPhoneNum(),
							recsipt.getCustomerName(), "新单", recsipt.getBusinessRecsiptNo(),
							recsipt.getServeAddress(), recsipt.getContacts());
					
					Emp oldEmp = findEmpByEmpId(oldWorkOrder.getEmpId());
					//发送短信给原工单的职员，提醒停止取件
					AcceptanceNote.stopOrderNote(oldEmp.getPhoneNum(), oldEmp.getEmpName(), oldWorkOrder.getWorkOrderNo());
					
					//修改受理单
					int results = recsiptMapper.updateBusinessRecsipt(paramMap);
					if(results != 1){
						return false;
					}else{
						return true;
					}
				}else{
					return false;
				}
				
			}
			//如果客户没有修改地址
		}else{
			String serveAddress= (String) paramMap.get("serveAddress");
			//通过取件地址和收件地址获得收件城市和寄件城市
			String fetchCity = fetchAddress.substring(fetchAddress.indexOf("市")+1,fetchAddress.indexOf("区"));
			String arrivalCity = serveAddress.substring(serveAddress.indexOf("市")+1,serveAddress.indexOf("区"));
			//将寄件城市和收件城市放入修改的参数map集合中
			paramMap.put("fetchCity", fetchCity);
			paramMap.put("arrivalCity", arrivalCity);
			//先将新的寄件地址和收件地址注入受理实体类
			recsipt.setFetchAddress(fetchAddress);
			recsipt.setServeAddress(serveAddress);
			recsipt.setWeight((BigDecimal)paramMap.get("weight"));
			//再通过计算运费的方法 获得预收费金额
			Double precharge = createMoney(recsipt);
			//更新新的预收费价格，放入参数集合
			paramMap.put("precharge", precharge);
			int result = recsiptMapper.updateBusinessRecsipt(paramMap);
			if(result != 1){
				return false;
			}else{
				return true;
			}
		}
		return true;
	}

	@Override
	public String findOrgNameById(String orgId) {
		return recsiptMapper.findOrgNameById(orgId);
	}

	@Override
	public WorkOrder findWorkOrderOne() {
		return recsiptMapper.findWorkOrderOne();
	}

	@Override
	public boolean updatePickStatus(String Wstatus ,String businessRecsiptId) {
		//修改取件状态
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("Wstatus", Wstatus);
		parmMap.put("businessRecsiptId", businessRecsiptId);
		if(recsiptMapper.updatePickStatus(parmMap) < 1){
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public BusinessRecsipt findBusinessRecsiptIdById(String businessRecsiptId) {
		//根据Id查询业务受理单
		return recsiptMapper.findBusinessRecsiptIdById(businessRecsiptId);
	}

	@Override
	public List<String> findPropagandaContent() {
		//查询最近的宣传任务
		return recsiptMapper.findPropagandaContent();
	}

	@Override
	public int countOrderNum(String operatorOrg) {
		//数量
		return recsiptMapper.countOrderNum(empBiz.orgListToString());
	}




}
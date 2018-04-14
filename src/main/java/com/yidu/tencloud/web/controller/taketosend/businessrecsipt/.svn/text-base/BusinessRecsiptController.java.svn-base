package com.yidu.tencloud.web.controller.taketosend.businessrecsipt;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.client.Client;
import com.yidu.tencloud.bean.system.fixedArea.FixedArea;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.BusinessRecsipt;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrder;
import com.yidu.tencloud.bean.taketosend.workOrder.WorkOrderDetail;
import com.yidu.tencloud.biz.system.clientbiz.ClientBiz;
import com.yidu.tencloud.biz.taketosend.businessrecsiptbiz.BusinessRecsiptBiz;
import com.yidu.tencloud.util.FlowOddNumber;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.Num;
/**
 * 业务受理控制器
 * @author 张建勇
 * @date 2017年12月20日 18:03:29
 */
@Controller
@RequestMapping("/recsipt")
public class BusinessRecsiptController {

	@Autowired
	private BusinessRecsiptBiz businessBiz;

	public BusinessRecsiptBiz getBusinessBiz() {
		return businessBiz;
	}

	public void setBusinessBiz(BusinessRecsiptBiz businessBiz) {
		this.businessBiz = businessBiz;
	}

	@Autowired
	private ClientBiz clientBiz;

	public ClientBiz getClientBiz() {
		return clientBiz;
	}

	public void setClientBiz(ClientBiz clientBiz) {
		this.clientBiz = clientBiz;
	}
	
	@RequestMapping(value = "/findClientByPhoneNum.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findClientByPhoneNum(String phoneNum) throws Exception {
		Client client = businessBiz.findClientByPhoneNum(phoneNum);
		if (client == null) {
			return null;
		} else {
			String str = client.getClientAddress();
			String fetchCity = str.substring(str.indexOf("省") + 1, str.indexOf("市"));
			Map<String, Object> resultClientMap = new HashMap<String, Object>();
			resultClientMap.put("client", client);
			resultClientMap.put("fetchCity", fetchCity);
			resultClientMap.put("businessRecsiptNo", FlowOddNumber.AtomicRangeInteger("业务通知单"));
			return resultClientMap;
		}

	}

	@RequestMapping(value = "/findFetchAddress.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findFetchAddress(String fetchAddress) throws Exception {
		FixedArea fixedArea = businessBiz.findFetchAddress(fetchAddress);
		String assignCode = fixedArea.getFixedAreaNum();

		Map<String, Object> resultClientMap = new HashMap<String, Object>();
		resultClientMap.put("assignCode", assignCode);
		return resultClientMap;

	}

	@RequestMapping(value = "/findAllRecsipt.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findAllRecsipt(@RequestBody Map<?, ?> map) throws Exception {

		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");

		Map<String, Object> recsiptMap = new HashMap<String, Object>();
		recsiptMap.put("total", businessBiz.findAllRecsipts().size());
		recsiptMap.put("rows", businessBiz.findAllRecsiptsByPage(offset, limit));
		return recsiptMap;
	}

	@RequestMapping(value = "/addRecsipt.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> addRecsipt(String SendTime, BusinessRecsipt businessRecsipt) throws Exception {
		

		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		if (businessBiz.findClientByPhoneNum(businessRecsipt.getPhoneNum()) == null) {
			Client client = new Client();
			client.setPhoneNum(businessRecsipt.getPhoneNum());
			client.setClientId(IDGenderatorUtil.generateId());
			client.setClientName(businessRecsipt.getCustomerName());
			client.setClientNum(Num.creatNum("来电"));
			client.setClientAddress(businessRecsipt.getFetchAddress());
			client.setClientType("普通客户");
			client.setSex("男");
			client.setNewFrom("来电下单");
			clientBiz.addClient(client);

			businessRecsipt.setDestoryCause("未销单");
			businessRecsipt.setAppointmentDispatchTime(new Date(Timestamp.valueOf(SendTime).getTime()));
			// 后面再加
			businessRecsipt.setOperatorOrg(businessBiz.findOrgNameById(user.getOrgId()));
			businessRecsipt.setUserId(user.getUserId());
			businessRecsipt.setOperator(user.getUserName());
			businessRecsipt.setCustomerNo(Num.creatNum("来电"));
			businessRecsipt.setBusinessRecsiptNo(FlowOddNumber.AtomicRangeInteger("业务通知单"));
			boolean result = businessBiz.addBusinessRecsipt(businessRecsipt);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			if (result) {
				paramMap.put("status", "success");
			} else {
				paramMap.put("status", "failed");
			}
			return paramMap;
		} else {
			businessRecsipt.setDestoryCause("未销单");
			businessRecsipt.setAppointmentDispatchTime(new Date(Timestamp.valueOf(SendTime).getTime()));
			// 后面再加
			businessRecsipt.setBusinessRecsiptNo(FlowOddNumber.AtomicRangeInteger("业务通知单"));	
			businessRecsipt.setOperatorOrg(businessBiz.findOrgNameById(user.getOrgId()));
			businessRecsipt.setUserId(user.getUserId());
			businessRecsipt.setOperator(user.getUserName());
			boolean result = businessBiz.addBusinessRecsipt(businessRecsipt);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			if (result) {
				paramMap.put("status", "success");
			} else {
				paramMap.put("status", "failed");
			}
			return paramMap;
		}

	}

	@RequestMapping(value = "/findRecsiptByConditionVague.action")
	@ResponseBody
	public Map<String, Object> findRecsiptByConditionVague(@RequestBody Map<?, ?> map) throws Exception {
		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");
		String contacts = (String) map.get("Scontacts");
		String phoneNum = (String) map.get("SphoneNum");
		String telephone = (String) map.get("Stelephone");
		String productName = (String) map.get("SproductName");
		String customerName = (String) map.get("ScustomerName");
		String fetchAddress = (String) map.get("SfetchAddress");
		String serveAddress = (String) map.get("SserveAddress");
		List<BusinessRecsipt> businessRecsipts = businessBiz.findRecsiptByConditionVague(phoneNum, contacts, telephone,
				productName, customerName, fetchAddress, serveAddress, offset, limit);
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		businessRecsiptMap.put("total", businessRecsipts.size());
		businessRecsiptMap.put("rows", businessRecsipts);
		return businessRecsiptMap;
	}

	@RequestMapping(value = "/updateWorkOrder.action")
	@ResponseBody
	public Map<String, Object> updateWorkOrder(String businessRecsiptId, String workOrderType) throws Exception {
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		boolean result = businessBiz.updateWorkOrderTypeById(businessRecsiptId, workOrderType, "已通知");
		if (result == true) {
			businessRecsiptMap.put("status", "success");
		} else {
			businessRecsiptMap.put("status", "failed");
		}
		return businessRecsiptMap;
	}

	@RequestMapping(value = "/deleteWorkOrder.action")
	@ResponseBody
	public Map<String, Object> deleteWorkOrder(String businessRecsiptId, String workOrderType, String cause)
			throws Exception {
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		boolean result = businessBiz.deleteWorkOrder(businessRecsiptId, workOrderType);
		if (result == true) {
			// 销单成功 修改业务受理单中的销单原因
			businessBiz.updateDestoryCause(businessRecsiptId, cause);
			// 修改成功，并且往工单详情插入一条工单详情数据
			WorkOrderDetail workOrderDetail = new WorkOrderDetail();
			WorkOrder workOrder = businessBiz.findWorkOrderById(businessRecsiptId);
			workOrderDetail.setFormerId(workOrder.getWorkOrderId());
			workOrderDetail.setFormerNo(workOrder.getWorkOrderNo());
			workOrderDetail.setCause(cause);
			businessBiz.addWorkOrderDetail(workOrderDetail);
			businessRecsiptMap.put("status", "success");
		} else {
			businessRecsiptMap.put("status", "failed");
		}
		return businessRecsiptMap;
	}
	@RequestMapping(value = "/updateBusinessRecsipt.action")
	@ResponseBody
	public Map<String, Object> updateBusinessRecsipt(String businessRecsiptId ,String contacts,String telephone,
			String fetchAddress,String serveAddress,String appointmentDispatchTime,
			String productName,String numberPackages,String weight,String volume,String phoneNum) throws Exception {
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//注入数据
		Map<String, Object> parmMap = new HashMap<String, Object>();
		parmMap.put("businessRecsiptId", businessRecsiptId);
		parmMap.put("contacts", contacts);
		parmMap.put("telephone", telephone);
		parmMap.put("fetchAddress", fetchAddress);
		parmMap.put("serveAddress", serveAddress);
		parmMap.put("appointmentDispatchTime", time.format(new Date(Long.parseLong(appointmentDispatchTime))));
		parmMap.put("productName", productName);
		parmMap.put("numberPackages", numberPackages);
		parmMap.put("weight", new BigDecimal(weight));
		parmMap.put("volume", new BigDecimal(volume));
		parmMap.put("phoneNum", phoneNum);

		boolean result = businessBiz.updateBusinessRecsiptById(parmMap);
		if (result == true) {
			businessRecsiptMap.put("status", "success");
		} else {
			businessRecsiptMap.put("status", "failed");
		}
		return businessRecsiptMap;
	}
	
	
	@RequestMapping(value = "/findWorkOrderOne.action")
	@ResponseBody
	public Map<String, Object> findWorkOrderOne(){
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		WorkOrder workOrder = businessBiz.findWorkOrderOne();
		BusinessRecsipt businessRecsipt = businessBiz.findBusinessRecsiptIdById(workOrder.getBusinessRecsiptId());
		businessRecsiptMap.put("workOrder", workOrder);
		businessRecsiptMap.put("businessRecsipt", businessRecsipt);
		
		return businessRecsiptMap;
	}
	
	
	@RequestMapping(value = "/confirmPick.action")
	@ResponseBody
	public Map<String, Object> confirmPick(String BussnessnoId,String status){
		Map<String, Object> businessRecsiptMap = new HashMap<String, Object>();
		boolean result = businessBiz.updatePickStatus(status, BussnessnoId);
		if (result == true) {
			businessRecsiptMap.put("status", "success");
		} else {
			businessRecsiptMap.put("status", "failed");
		}
		return businessRecsiptMap;
	}
	
	
	
	
	@RequestMapping(value = "/findPropagandaContent.action")
	@ResponseBody
	public List<String> findPropagandaContent(){
		List<String> strings = businessBiz.findPropagandaContent();
		if(strings==null){
			return null;
		}else{
			return strings;
		}
	}
	
	@RequestMapping(value = "/countOrderNum.action")
	@ResponseBody
	public int countOrderNum(){
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		int orderNum = businessBiz.countOrderNum(businessBiz.findOrgNameById(user.getOrgId()));
		System.out.println(orderNum);
		return orderNum;
	}
	
	
}

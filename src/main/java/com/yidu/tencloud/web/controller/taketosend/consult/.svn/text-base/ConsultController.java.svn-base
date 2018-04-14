package com.yidu.tencloud.web.controller.taketosend.consult;

import java.sql.Timestamp;
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

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.bean.taketosend.businessRecsipt.Consult;
import com.yidu.tencloud.biz.taketosend.consultbiz.ConsultBiz;

/**
 * 咨询控制器
 * @author 张建勇
 * @date 2017.12.08
 */

@Controller
@RequestMapping("/consult")
public class ConsultController {
	
	@Autowired
	private ConsultBiz consultBiz;

	public ConsultBiz getConsultBiz() {
		return consultBiz;
	}

	public void setConsultBiz(ConsultBiz consultBiz) {
		this.consultBiz = consultBiz;
	}
	
	@RequestMapping(value = "/addConsult.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> addConsult(String consultTimes,Consult consult)throws Exception{
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		consult.setInitialUnit(user.getUserName());
		consult.setConsultTime(new Date(Timestamp.valueOf(consultTimes).getTime()));
		boolean result = consultBiz.addConsult(consult);
		Map<String, Object> consultMap = new HashMap<String, Object>();
		if (result) {
			consultMap.put("status", "success");
		} else {
			consultMap.put("status", "failed");
		}
		return consultMap;
	}
	
	@RequestMapping(value = "/findBusReConsult.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findBusReConsult(@RequestBody Map<?, ?> map) throws Exception {

		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");

		Map<String, Object> recsiptMap = new HashMap<String, Object>();
		recsiptMap.put("total", consultBiz.findBusReConsult().size());
		recsiptMap.put("rows", consultBiz.findAllConsultByPage(limit, offset, "受理咨询"));
		return recsiptMap;
	}
	
	
	@RequestMapping(value = "/findWorkOrderConsult.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findWorkOrderConsult(@RequestBody Map<?, ?> map) throws Exception {

		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");

		Map<String, Object> recsiptMap = new HashMap<String, Object>();
		recsiptMap.put("total", consultBiz.findWorkOrderConsult().size());
		recsiptMap.put("rows", consultBiz.findAllConsultByPage(limit, offset, "工单咨询"));
		return recsiptMap;
	}
	
	
	@RequestMapping(value="/findBusinessRecsiptNoByClient.action")
	@ResponseBody
	public List<String> findBusinessRecsiptNoByClient(String phoneNum){
		List<String> fileName = consultBiz.findBusinessRecsiptNoByClient(phoneNum);		
		return fileName;
	}
	
	@RequestMapping(value="/findWorkOrderNoByClient.action")
	@ResponseBody
	public List<String> findWorkOrderNoByClient(String phoneNum){
		List<String> fileName = consultBiz.findWorkOrderNoByClient(phoneNum);		
		return fileName;
	}
	
}

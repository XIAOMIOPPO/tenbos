package com.yidu.tencloud.web.controller.transitshipment.anomaly;

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
import com.yidu.tencloud.bean.transitshipment.anomaly.Anomaly;
import com.yidu.tencloud.biz.transitshipment.anomaly.AnomalyBiz;

/**
 * 异常信息处理控制器
 * @author 张建勇
 * @date 2018.01.03
 */
@Controller
@RequestMapping("/anomaly")
public class AnomalyController {
	
	
	@Autowired
	private AnomalyBiz anomalyBiz;

	public AnomalyBiz getAnomalyBiz() {
		return anomalyBiz;
	}

	public void setAnomalyBiz(AnomalyBiz anomalyBiz) {
		this.anomalyBiz = anomalyBiz;
	} 
	
	@RequestMapping(value = "/findAllAnomaly.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findAllAnomaly(@RequestBody Map<?, ?> map) throws Exception {
		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");
		Map<String, Object> anomalyMap = new HashMap<String, Object>();
		anomalyMap.put("total", anomalyBiz.findAllAnomaly().size());
		anomalyMap.put("rows", anomalyBiz.findAllAnomalyByPage(offset, limit));
		return anomalyMap;
	}
	
	@RequestMapping(value = "/addAnomaly.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> addAnomaly(Anomaly anomaly) throws Exception {
		
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("user");
		anomaly.setEntering(user.getUserName());
		anomaly.setEnteringNum(user.getUserId());
		anomaly.setEnteringOrg(user.getOrgId());
		anomaly.setEnteringTime(new Date());
		boolean result = anomalyBiz.addAnomaly(anomaly);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (result) {
			resultMap.put("status", "success");
		} else {
			resultMap.put("status", "failed");
		}
		return resultMap;
	}	
	
	@RequestMapping(value = "/deleteAnomaly.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> deleteAnomalyById(String[] exceptionIds){
		boolean result = false;
		for(String exceptionId : exceptionIds){
			result = anomalyBiz.deleteAnomalyById(exceptionId);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (result==true) {
			resultMap.put("status", "success");
		} else {
			resultMap.put("status", "failed");
		}
		return resultMap;
		
	}
	
	
	@RequestMapping(value="/findAllExceptionNo.action")
	@ResponseBody
	public List<String> findAllExceptionNo(){
		List<String> exceptionNo = anomalyBiz.findAllExceptionNo();		
		return exceptionNo;
	}
	
	@RequestMapping(value="/findAllExceptionType.action")
	@ResponseBody
	public List<String> findAllExceptionType(){
		List<String> exceptionType = anomalyBiz.findAllExceptionType();		
		return exceptionType;
	}
}

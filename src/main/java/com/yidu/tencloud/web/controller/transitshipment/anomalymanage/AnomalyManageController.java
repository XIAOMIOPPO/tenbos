package com.yidu.tencloud.web.controller.transitshipment.anomalymanage;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.transitshipment.anomaly.AnomalyManage;
import com.yidu.tencloud.biz.transitshipment.anomalymanage.AnomalyManageBiz;

/**
 * 异常信息处理控制器
 * @author 张建勇
 * @date 2018.01.03
 */
@Controller
@RequestMapping("/anomalyManage")
public class AnomalyManageController {
	
	
	@Autowired
	private AnomalyManageBiz anomalyManageBiz;

	public AnomalyManageBiz getAnomalyManageBiz() {
		return anomalyManageBiz;
	}

	public void setAnomalyManageBiz(AnomalyManageBiz anomalyManageBiz) {
		this.anomalyManageBiz = anomalyManageBiz;
	}
	
	@RequestMapping(value = "/findAllAnomalyManage.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findAllAnomalyManage(@RequestBody Map<?, ?> map) throws Exception {
		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");
		Map<String, Object> anomalyMap = new HashMap<String, Object>();
		anomalyMap.put("total", anomalyManageBiz.findAllAnomalyManage().size());
		anomalyMap.put("rows", anomalyManageBiz.findAnomalyManageByPage(offset, limit));
		return anomalyMap;
	}
	
	@RequestMapping(value = "/addAnomalyManage.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> addAnomalyManage(String Relaytimes ,AnomalyManage anomalyManage)throws Exception {
		anomalyManage.setActualPortReality(new Date(Timestamp.valueOf(Relaytimes).getTime()));
		boolean result = anomalyManageBiz.addAnomalyManage(anomalyManage);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (result) {
			resultMap.put("status", "success");
		} else {
			resultMap.put("status", "failed");
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/findAnomalyManageByCondition.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findAnomalyManageByCondition(@RequestBody Map<?, ?> map )throws Exception {
		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");
		String coSourcingNo = (String) map.get("coSourcingNo");
		Map<String, Object> anomalyMap = new HashMap<String, Object>();
		anomalyMap.put("total", anomalyManageBiz.findAllAnomalyManage().size());
		anomalyMap.put("rows", anomalyManageBiz.findAnomalyManageByCondition(offset, limit, coSourcingNo));
		return anomalyMap;
	}
	
	@RequestMapping(value = "/updateDisposeMessage.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> updateDisposeMessage(String exceptionManageId ,String result)throws Exception {
		Map<String, Object> anomalyMap = new HashMap<String, Object>();
		boolean results = anomalyManageBiz.updateDisposeMessageById(exceptionManageId,result);
		if (results) {
			anomalyMap.put("status", "success");
		} else {
			anomalyMap.put("status", "failed");
		}
		return anomalyMap;
	}
	
	@RequestMapping(value = "/updateNotarizeMessage.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> updateNotarizeMessage(String exceptionManageId,String affirmFruit)throws Exception {
		Map<String, Object> anomalyMap = new HashMap<String, Object>();
		boolean result = anomalyManageBiz.updateAffirmMessageById(exceptionManageId,affirmFruit);
		if (result) {
			anomalyMap.put("status", "success");
		} else {
			anomalyMap.put("status", "failed");
		}
		return anomalyMap;
	}
}

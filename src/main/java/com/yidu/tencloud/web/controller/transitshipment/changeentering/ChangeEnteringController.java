package com.yidu.tencloud.web.controller.transitshipment.changeentering;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.taketosend.workSheet.WorkSheet;
import com.yidu.tencloud.bean.transitshipment.anomaly.ChangeEntering;
import com.yidu.tencloud.biz.taketosend.worksheetBiz.WorkSheetBiz;
import com.yidu.tencloud.biz.transitshipment.changeentering.ChangeEnteringBiz;
import com.yidu.tencloud.util.ShiroUtil;

/**
 * 到付代收变更信息控制器
 * @author 张建勇
 * @date 2018.01.5
 */
@Controller
@RequestMapping("/changeEntering")
public class ChangeEnteringController {
	
	@Autowired
	private ChangeEnteringBiz enteringBiz;
	
	@Autowired
	private WorkSheetBiz workSheetBiz;
	
	public WorkSheetBiz getWorkSheetBiz() {
		return workSheetBiz;
	}

	public void setWorkSheetBiz(WorkSheetBiz workSheetBiz) {
		this.workSheetBiz = workSheetBiz;
	}

	public ChangeEnteringBiz getEnteringBiz() {
		return enteringBiz;
	}

	public void setEnteringBiz(ChangeEnteringBiz enteringBiz) {
		this.enteringBiz = enteringBiz;
	}
	
	
	@RequestMapping(value = "/findAllChangeEntering.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findAllChangeEntering(@RequestBody Map<?, ?> map)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Integer limit = (Integer) map.get("limit");
		Integer offset = (Integer) map.get("offset");
		resultMap.put("total", enteringBiz.findAllChangeEntering().size());
		resultMap.put("rows", enteringBiz.findChangeEnteringByPage(offset, limit));
		return resultMap;
	}
	
	@RequestMapping(value = "/addChangeEntering.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> addChangeEntering(ChangeEntering changeEntering)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		boolean result = enteringBiz.addChangeEntering(changeEntering);
		if (result) {
			resultMap.put("status", "success");
		} else {
			resultMap.put("status", "failed"); 
		}
		return resultMap;
	}
	
	@RequestMapping(value = "/findWorkSheet.action", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> findWorkSheet(String workSheetNo)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		WorkSheet workSheet = workSheetBiz.findWorkSheet(workSheetNo);
		if(workSheet == null){
			resultMap.put("workSheet", null);
		}else{
			resultMap.put("workSheet", workSheet);
			resultMap.put("enteringUnit", ShiroUtil.getUser().getOrgId());
		}
		return resultMap;
	}
	
}

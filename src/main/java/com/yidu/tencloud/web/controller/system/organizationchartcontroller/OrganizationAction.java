package com.yidu.tencloud.web.controller.system.organizationchartcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.system.organizationchartbiz.impl.OrganizationService;
import com.yidu.tencloud.util.IDGenderatorUtil;

/**
 * 组织结构控制器
 * @author 64429
 *
 */
@Controller
@RequestMapping("/org")
public class OrganizationAction {
	
	@Autowired
	private OrganizationService organizationService;

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	
	@RequestMapping("/allOrg")
	@ResponseBody
	public List<Organization> findAllOrg(){
		return this.organizationService.findAllOrg();
	}
	
	@RequestMapping("/allOrgTypeName")
	@ResponseBody
	public List<Organization> findAllOrgTypeName(){
		return this.organizationService.findAllOrgTypeName();
	}
	
	@RequestMapping("/addOrg")
	@ResponseBody
	public Map<String, Object> addOrg(Organization organization){
		Map<String, Object> status = new HashMap<String, Object>();
		organization.setOrgId(IDGenderatorUtil.generateId());
		if(this.organizationService.addOrg(organization)) {
			status.put("status", 1);
		}else {
			status.put("status", 0);
		}
		return status;
	}
	
	@RequestMapping("/updateOrg")
	@ResponseBody
	public Map<String, Object> updateOrg(Organization organization){
		Map<String, Object> status = new HashMap<String, Object>();
		if(this.organizationService.updateOrg(organization)) {
			status.put("status", 1);
		}else {
			status.put("status", 0);
		}
		return status;
	}
	
}

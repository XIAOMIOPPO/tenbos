package com.yidu.tencloud.biz.system.organizationchartbiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.organizationchart.Organization;
import com.yidu.tencloud.biz.system.organizationchartbiz.OrganizationBiz;
import com.yidu.tencloud.dao.system.organizationchartdao.OrganizationMapper;

/**
 * 组织结构业务逻辑层
 * 
 * @author 64429
 *
 */
@Service
public class OrganizationService implements OrganizationBiz {

	@Autowired
	private OrganizationMapper organizationMapper;

	public OrganizationMapper getOrganizationMapper() {
		return organizationMapper;
	}

	public void setOrganizationMapper(OrganizationMapper organizationMapper) {
		this.organizationMapper = organizationMapper;
	}

	@Override
	public List<Organization> findAllOrg() {
		return this.organizationMapper.findAllOrg();
	}

	@Override
	public List<Organization> findAllOrgTypeName() {
		return this.organizationMapper.findAllOrgTypeName();
	}

	@Override
	public boolean addOrg(Organization organization) {

		if (this.organizationMapper.addOrg(organization) > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updateOrg(Organization organization) {

		if (this.organizationMapper.updateOrg(organization) > 0) {

			return true;
		}

		return false;
	}

}

package com.yidu.tencloud.biz.system.organizationchartbiz;


import java.util.List;

import com.yidu.tencloud.bean.system.organizationchart.Organization;

/**
 * 组织结构业务逻辑层
 * @author 64429
 *
 */
public interface OrganizationBiz {
	
	/**
	 * 查询所有组织结构
	 * @return 组织结构集合
	 */
	public List<Organization> findAllOrg();
	
	/**
	 * 查询所有组织结构类型
	 * @return 组织结构集合
	 */
	public List<Organization> findAllOrgTypeName();
	
	/**
	 * 添加组织结构
	 * @param organization 组织结构
	 * @return 是否添加成功
	 */
	public boolean addOrg(Organization organization);
	
	/**
	 * 修改组织结构
	 * @param paramMap 参数集合
	 * @return 是否修改成功
	 */
	public boolean updateOrg(Organization organization);
	
}

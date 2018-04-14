package com.yidu.tencloud.biz.system.jurisdictionbiz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.biz.system.jurisdictionbiz.RoleService;
import com.yidu.tencloud.dao.system.jurisdiction.RoleMapper;

/**
 * 角色业务实现类
 * @author youngboy
 * @since 2017/12/19
 */
@Service
public class RoleServiceImpl implements RoleService{

	/**
	 * 角色mapper
	 */
	@Autowired
	private RoleMapper roleMapper;
	
	
	/**
	 * 设置角色mapper
	 * @param roleMapper 角色mapper
	 */
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	

	@Override
	public List<Role> findAllRole() {
		//找到所有角色
		List<Role> roles = roleMapper.findAllRole();
		//找到角色类型
		List<AuthOption> orgs = roleMapper.findRoleType();
		//找到orgs的size
		for (int i = 0; i < orgs.size(); i++) {
			//创建角色
			Role role = new Role();
			//设置角色id
			role.setRoleId(orgs.get(i).getFileId());
			//设置角色名
			role.setRoleName(orgs.get(i).getRecordName());
			//角色
			roles.add(role);
		}
		//返回角色集合
		return roles;
	}

	@Override
	public boolean updateRole(Role role) {
		//更新角色
		return roleMapper.updateRole(role)>0?true:false;
	}

	@Override
	public boolean deleteRole(String roleId) {
		//删除角色
		return roleMapper.deleteRole(roleId)>0?true:false;
	}

	@Override
	public boolean addRole(Role role) {
		//添加角色
		return roleMapper.addRole(role)>0?true:false;
	}


	@Override
	public List<AuthOption> findAllRoleType() {
		//找到角色类型
		return roleMapper.findRoleType();
	}


	
}

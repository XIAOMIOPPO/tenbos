package com.yidu.tencloud.biz.system.jurisdictionbiz;

import java.util.List;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.Role;

/**
 * 角色业务接扣
 * @author youngboy
 * @since 2017/12/19
 */
public interface RoleService {
	
	/**
	 * 找到所有角色
	 * @return 角色集合
	 */
	List<Role> findAllRole();
	
	/**
	 * 修改角色
	 * @param role 角色对象
	 * @return 是否修改成功
	 */
	boolean updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId 角色id
	 * @return 是否删除成功
	 */
	boolean deleteRole(String roleId);
	
	/**
	 * 添加角色
	 * @param role 角色对象
	 * @return 是否添加成功
	 */
	boolean addRole(Role role);
	
	/**
	 * 找到所有的角色类型
	 * @return 角色类型集合
	 */
	List<AuthOption> findAllRoleType();
	
}

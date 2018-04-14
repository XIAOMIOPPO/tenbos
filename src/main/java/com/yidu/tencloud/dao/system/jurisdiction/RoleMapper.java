package com.yidu.tencloud.dao.system.jurisdiction;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.jurisdiction.AuthOption;
import com.yidu.tencloud.bean.system.jurisdiction.Role;

/**
 * 角色mapper
 * @author youngboy
 * @since 2017/12/19
 */
public interface RoleMapper {

	/**
	 * 查找所有角色
	 * @return 角色集合
	 */
	List<Role> findAllRole();
	
	/**
	 * 修改角色
	 * @param role 角色对象
	 * @return 影响的行数
	 */
	int updateRole(Role role);
	
	/**
	 * 输出角色
	 * @param roleId 角色id
	 * @return 影响的行数
	 */
	int deleteRole(String roleId);
	
	/**
	 * 添加角色
	 * @param role 角色对象
	 * @return 影响的行数
	 */
	int addRole(Role role);
	
	/**
	 * 模糊查询角色
	 * @param param 查询参数
	 * @return 角色集合
	 */
	List<Role> findRoleByCriteria(Map<String,String> param);
	
	/**
	 * 通过理性id找到角色
	 * @param roleTypeId 角色类型id
	 * @return
	 */
	List<Role> findRoleByTypeId(String roleTypeId);
	
	/**
	 * 找到资源类型
	 * @return 资源类型集合
	 */
	List<AuthOption> findRoleType();
	
	
	
}

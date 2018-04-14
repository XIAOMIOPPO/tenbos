package com.yidu.tencloud.dao.system.jurisdiction;

import java.util.List;

import com.yidu.tencloud.bean.system.jurisdiction.CommBean;
import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;

/**
 * 角色资源mapper
 * @author youngboy
 * @since 2017/12/19
 */
public interface RoleResMapper {

	/**
	 * 添加角色资源
	 * @param beans 通用bean集合
	 * @return 影响的行数
	 */
	int addRoleRes(List<CommBean> beans);
	
	/**
	 * 添加用户角色
	 * @param beans 通用bean集合
	 * @return 影响的行数
	 */
	int addUserRole(List<CommBean> beans);
	
	/**
	 * 输出角色资源
	 * @param id 角色id
	 * @return 影响的行数
	 */
	int deleteRoleRes(String id);
	
	/**
	 * 删除用户角色
	 * @param 用户id
	 * @return 影响的行数
	 */
	int deleteUserRole(String id);
	
	/**
	 * 通过角色id删除已授权的角色
	 * @param 
	 * @return 影响的行数
	 */
	int delRoleByRoleIdInRes(String id);
	
	/**
	 * 通过角色id删除角色
	 * @param 角色id
	 * @return 影响的行数
	 */
	int delRoleByRoleId(String id);
	
	/**
	 * 通过资源id输出资源
	 * @param 资源id
	 * @return 影响的行数
	 */
	int delResByResId(String id);
	
	/**
	 * 通过用户id输出角色id
	 * @param ids 用户id集合 
	 * @return 影响的行数
	 */
	int delRoleByUserId(List<String> ids);
	
	/**
	 * 通过角色id删除资源
	 * @param ids 角色id集合
	 * @return 影响的行数
	 */
	int deleteResByRoleId(List<String> ids);
	
	/**
	 * 通过用户id查找角色
	 * @param userId 用户id
	 * @return 影响的行数
	 */
	List<Role> selectRoleIdByUserId(String userId);
	
	/**
	 * 通过角色id查找资源id
	 * @param 角色id
	 * @return 影响的行数
	 */
	List<URLResource> selectResIdByRoleId(String roleId);
}

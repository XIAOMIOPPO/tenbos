package com.yidu.tencloud.biz.system.jurisdictionbiz;

import java.util.List;

import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;

/**
 * 授权业务层
 * @author youngboy
 * @since 2017/12/19
 */
public interface AuthorizeService {
	
	/**
	 * 添加资源角色 
	 * @param resId 资源id
	 * @param roleId 角色id
	 * @return 是否添加成功
	 */
	boolean addResRole(String[] resId,String[] roleId);
	
	/**
	 * 添加用户角色
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @return 是否添加成功
	 */
	boolean addUserRole(String[] userId,String[] roleId);
	
	/**
	 * 输出资源角色
	 * @param id 资源id
	 * @return 是否删除成功
	 */
	boolean deleteResRole(String id);
	
	/**
	 * 输出用户角色
	 * @param id 用户id
	 * @return 是否删除成功
	 */
	boolean deleteUserRole(String id);
	
	/**
	 * 删除中间表中的角色
	 * @param id 资源id
	 * @return 是否删除成功
	 */
	boolean delRoleByRoleIdInRes(String id);
	
	/**
	 * 通过角色id输出角色
	 * @param id 角色id
	 * @return 是否删除成功
	 */
	boolean delRoleByRoleId(String id);
	
	/**
	 * 通过资源id输出资源
	 * @param id 资源id
	 * @return 是否删除成功
	 */
	boolean delResByResId(String id);
	
	/**
	 * 通过id输出角色
	 * @param id 角色id
	 * @return 是否删除成功
	 */
	boolean delRoleById(String id);
	
	/**
	 * 通过资源id删除资源
	 * @param id 资源id
	 * @return 是否删除成功
	 */
	boolean delResById(String id);
	
	/**
	 * 通过用户id查找角色
	 * @param userId 用户id
	 * @return 角色集合
	 */
	List<Role> findRoleIdByUserId(String userId);
	
	/**
	 * 通过角色id查找资源id
	 * @param roleId 角色id
	 * @return 资源集合
	 */
	List<URLResource> findResIdByRoleId(String roleId);

}

package com.yidu.tencloud.biz.system.userbiz;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yidu.tencloud.bean.system.user.User;
/**
 * 业务逻辑层
 * @author 刘梓轩
 *
 */
public interface UserBiz {
	
	/**
	 * 查询
	 * @return
	 */
	boolean findAllUserName(String userName);
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	boolean updateUser(User user);
	/**
	 * 删除
	 * @param userId
	 * @return
	 */
	boolean deleteUser(String userId);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	boolean addUser(User user);
	/**
	 * 分页
	 * @param ronesUser
	 * @return
	 */
	int countUser(Map<String,Object> ronesUser);
	/**
	 * 模糊查询
	 * @param contMap
	 * @return
	 */
	List<User> listUser(Map<String, Object> contMap);
	/**
	 * 登录
	 * @param map
	 * @return
	 */
	User login(Map<String, String> map);
	
	/**
	 * 根据用户名查找用户
	 * @param userName 用户名
	 * @return 用户对象
	 */
	User findUserByName(String userName);
	
	/**
	 * 通过用户名查找角色
	 * @param userName 用户名
	 * @return 角色集合
	 */
	Set<String> getRoles(String userName);
	
	/**
	 * 通过用户名查找权限
	 * @param userName 用户名
	 * @return 权限集合
	 */
	Map<String,Set<String>> getResources(String userName);
	/**
	 * 查询数据库
	 * @return 查询用户数据
	 */
	List<User> findAllUser();
}

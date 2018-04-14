package com.yidu.tencloud.dao.system.userdao;

import java.util.List;
import java.util.Map;

import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.bean.system.user.User;
/**
 * 控制器层
 * @author 刘梓轩
 *
 */
public interface UserMapper {

	public String findAllUserName(String userName);
	/**
	 * 查询
	 * @return
	 */
	public List<User> findAllUser();
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 删除
	 * @param userId
	 * @return
	 */
	public int deleteUser(String userId);
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * 分页
	 * @param contMap
	 * @return
	 */
	public List<User> conttUser(Map<String, Object> contMap);
	/**
	 * 模糊查询
	 * @param contMap
	 * @return
	 */
	public int ronesUser(Map<String, Object> contMap);
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
	List<Role> findRoleByName(String userName);
	
	/**
	 * 通过用户名查找权限
	 * @param userName 用户名
	 * @return 权限集合
	 */
	List<URLResource> findResourceByName(String userName);
	


	
	
}

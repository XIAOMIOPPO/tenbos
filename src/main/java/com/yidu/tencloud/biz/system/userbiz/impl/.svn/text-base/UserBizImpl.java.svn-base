package com.yidu.tencloud.biz.system.userbiz.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.tencloud.bean.system.jurisdiction.Role;
import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.biz.system.userbiz.UserBiz;
import com.yidu.tencloud.dao.system.userdao.UserMapper;
import com.yidu.tencloud.util.PassUtil;
/**
 * 业务逻辑层
 * @author Administrator
 *
 */
@Service
public class UserBizImpl implements UserBiz{
	@Autowired
	private UserMapper userMapper;
	
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	/**
	 * 查询
	 */
	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}
	/**
	 * 修改
	 */
	@Override
	public boolean updateUser(User user) {
		
		return userMapper.updateUser(user)>0?true:false;
	}
	/**
	 * 删除
	 */
	@Override
	public boolean deleteUser(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setIsUse("0");
		return userMapper.updateUser(user)>0?true:false;
	}
	
	/**
	 * 分页
	 */
	@Override
	public List<User> listUser(Map<String, Object> contMap) {
		return userMapper.conttUser(contMap);
	}
	/**
	 * 模糊查询
	 */
	@Override
	public int countUser(Map<String, Object> contMap) {
		return userMapper.ronesUser(contMap);
	}
	/**
	 * 登录
	 */
	@Override
	public User login(Map<String, String> map) {
		return userMapper.login(map);
	}
	
	
	@Override
	public User findUserByName(String userName) {
		return userMapper.findUserByName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		List<Role> roles = userMapper.findRoleByName(userName);
		Set<String> roleSet = new HashSet<>();
		for (Role role : roles) {
			roleSet.add(role.getRoleCode());
		}
		return roleSet; 
	}

	@Override
	public Map<String,Set<String>> getResources(String userName) {
		List<URLResource> res = userMapper.findResourceByName(userName);
		Map<String,Set<String>> map = new HashMap<String, Set<String>>();
		Set<String> resSet = new HashSet<>();
		for (URLResource resItem : res) {
			resSet.add(resItem.getResourceCode());
		}
		Set<String> urlSet = new HashSet<>();
		for (URLResource resItem : res) {
			String item = resItem.getResourceUrl();
			if(item!=null&&item!="") {
				urlSet.add(item);
			}
		}
		map.put("resSet", resSet);
		map.put("urlSet", urlSet);
		
		return map;
	}

	@Override
	public boolean addUser(User user) {
		String pwd = user.getPwd();
		String md5Pwd = PassUtil.MD5(pwd);
		user.setPwd(md5Pwd);
		return userMapper.addUser(user)>0?true:false;
	}
	@Override
	public boolean findAllUserName(String userName) {
		return true;
	}
	

	
}

package com.yidu.tencloud.web.controller.system.usercontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.biz.system.userbiz.UserBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.MyMD5Util;
/**
 * 控制器层
 * @author 刘梓轩
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	/**
	 * 分页和模糊查询
	 * @param contMap
	 * @return
	 */
	@RequestMapping("/listUser")
	@ResponseBody
	public Map<String, Object> listUser(@RequestBody Map<String,Object> contMap){
		Map<String, Object> ctext = new HashMap<String,Object>();
		//分页
		ctext.put("total", userBiz.countUser(contMap));
		//模糊查询
		ctext.put("rows", userBiz.listUser(contMap));
		return ctext;
	}
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/upduser")
	@ResponseBody
	public Map<String, String> updateUser(User user) {
		Map<String, String> userIt = new HashMap<String, String>();
		if (userBiz.updateUser(user)) {
			userIt.put("status", "success");
		}else{
			userIt.put("status", "failed");
		}
		return userIt;
	}
	/**
	 * 删除
	 * @param userId
	 * @return
	 */
	@RequestMapping("/deluser")
	@ResponseBody
	public Map<String, String> deleteUser(String userId,String isUse) {
		Map<String, String> userIt = new HashMap<String, String>();
		if (userBiz.deleteUser(userId)) {
			userIt.put("status", "success");
		}else{
			userIt.put("status", "failed");
		}
		return userIt;
	}
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	@RequestMapping("/adduser")
	@ResponseBody
	public Map<String, String> addUser(User user) {
		Map<String, String> userIt = new HashMap<String, String>();
		if(userBiz.findAllUserName(user.getUserName()) == false)
			//将name放入结果集
			userIt.put("status", "userName");
		user.setUserId(IDGenderatorUtil.generateId());
		if (userBiz.addUser(user)) {
			userIt.put("status", "success");
		}else{
			userIt.put("status", "failed");
		}
		return userIt;
	}
}

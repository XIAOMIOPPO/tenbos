package com.yidu.tencloud.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.yidu.tencloud.bean.system.user.User;

public class ShiroUtil {
	
	public static final String ADMINID="898E7BD276514001";

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}
	
	public static User getUser() {
		return (User) getSession().getAttribute("user");
	}
	
	
	public static void setAttribute(String key,Object obj) {
		SecurityUtils.getSubject().getSession().setAttribute(key, obj);
	}
	
	
	public static Object getAttribute(String key) {
		return SecurityUtils.getSubject().getSession().getAttribute(key);
	}
	
	
	
	
	
}

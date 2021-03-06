package com.yidu.tencloud.web.controller.system.usercontroller;

import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.tencloud.bean.system.jurisdiction.URLResource;
import com.yidu.tencloud.biz.system.jurisdictionbiz.ResourceService;
/**
 * 控制器层
 * @author 刘梓轩
 *
 */
@Controller
@RequestMapping("/user")
public class UserActionYM {
	
	/**
	 * 缓存的名字
	 */
	private final static String CACHE_NAME = "shiro-kickout-session";
	
	/**
	 * 资源业务对象
	 */
	@Resource ResourceService reservice;
	 
	/**
	 * 缓存管理器
	 */
	@Autowired
	private CacheManager cacheManager;
	
	
	/**
	 * cache队列
	 */
	private Cache<String, Deque<Serializable>> cache;
	 
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}



	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.cache=cacheManager.getCache(CACHE_NAME);
	}



	public Cache<String, Deque<Serializable>> getCache() {
		return cache;
	}



	public void setCache(Cache<String, Deque<Serializable>> cache) {
		this.cache = cache;
	}



	public ResourceService getReservice() {
		return reservice;
	}



	public void setReservice(ResourceService reservice) {
		this.reservice = reservice;
	}



	
	/**
	 * 登陆
	 * @param userName 用户名
	 * @param pwd 密码
	 * @param request 请求对象
	 * @return 成功状态信息
	 */
	 @RequestMapping("/login")
	 @ResponseBody
	 public Map<String,String> findUserByNameAndPwd(String userName,String pwd,HttpServletRequest request) {
		 Map<String,String> map = new HashMap<String,String>();
		 if(validLogin(userName, pwd)) {
			//结果map
			cache=cacheManager.getCache(CACHE_NAME);
		    Deque<Serializable> deque = cache.get(userName);
		    if(deque==null) {
		    	System.err.println("空");
		    	login(userName, pwd, map);
		    }else {
		    	if(deque.size()>0) {
		    		//已登陆
		    		//登陆失败
		    		map.put("status","kickout");
		    		System.err.println("ul:"+deque.size());
		    	}else {
		    		login(userName, pwd, map);
		    	}
		    }
		 }else {
			 map.put("status","error");
			 map.put("error","校验失败");
		 }
		
		return map;	
	}



	/**
	 * 登陆方法
	 * @param userName 用户名
	 * @param pwd 密码
	 * @param map 结果map
	 */
	private void login(String userName, String pwd, Map<String, String> map) {
		//错误信息
		 String error = null;
		 //用户凭证号
		 UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
		 //获取用户主题
		 Subject subject = SecurityUtils.getSubject();
		
		 
			 subject.login(token);
		
		
		if (error==null) {
			//登陆成功
			map.put("status","success");
			//重定向至主页
			map.put("href","jsps/index1.jsp");
		} 
	}



	private boolean validLogin(String userName, String pwd) {
		if(userName==null||userName=="") {
			return false;
		}
		 
		if(pwd==null||pwd=="") {
			return false;
		}
		
		return true;
	}
	 
	 
	 /**
	  * 获取右侧资源菜单
	  * @return 资源菜单树
	  */
	 @RequiresAuthentication
	 @RequestMapping("findres")
	 @ResponseBody
	 public List<URLResource> findRes() {
		 //获取主体
		 Subject subject = SecurityUtils.getSubject();
		 //获取用户名
		 String userName = (String) subject.getPrincipals().getPrimaryPrincipal();
		 //返回资源数据
		 return reservice.findGrantedResourceByUserId(userName);
			
	 }
	
	
	

}

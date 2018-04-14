package com.yidu.tencloud.web.filter.shiro;

import java.io.IOException;
import java.io.Serializable;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class KickoutSessionControlFilter extends AccessControlFilter{
	
	/**
	 * 缓存的名字
	 */
	private final static String CACHE_NAME = "shiro-kickout-session";

	/**
	 * 被踢出后的地址
	 */
    private String kickoutUrl;
    
    /**
     * 踢出之前登陆的还是之后登陆的
     */
    private boolean kickoutAfter = false; // 踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    
    /**
     * 在线人数 默认为1
     */
    private int maxSession = 1;

    
    /**
     * session管理器
     */
    private SessionManager sessionManager;
    
    /**
     * 缓存队列
     */
    private Cache<String, Deque<Serializable>> cache;
    
    
    /**
     * 缓存管理器
     */
    private CacheManager cacheManager;
    
    /**
     * 缓存名
     */
    private String cacheName = CACHE_NAME;

    
    
	

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.cache=cacheManager.getCache(CACHE_NAME);
	}

	public String getKickoutUrl() {
		return kickoutUrl;
	}

	public void setKickoutUrl(String kickoutUrl) {
		this.kickoutUrl = kickoutUrl;
	}

	public boolean isKickoutAfter() {
		return kickoutAfter;
	}

	public void setKickoutAfter(boolean kickoutAfter) {
		this.kickoutAfter = kickoutAfter;
	}

	public int getMaxSession() {
		return maxSession;
	}

	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public Cache<String, Deque<Serializable>> getCache() {
		return cache;
	}

	public void setCache(Cache<String, Deque<Serializable>> cache) {
		this.cache = cache;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	
	
	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            // 如果没有登录，直接进行之后的流程
            return true;
        }

        
        Session session = subject.getSession();
        String username = (String) subject.getPrincipal();
        Serializable sessionId = session.getId();
        // TODO 同步控制
        Deque<Serializable> deque = cache.get(username);
        if (deque == null) {
            deque = new ConcurrentLinkedDeque<Serializable>();
            cache.put(username, deque);
        }
        // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
        	deque.push(sessionId);
        }
        // 如果队列里的sessionId数超出最大会话数，开始踢人
        if (deque.size() > maxSession) {
        	Session kickoutSession = session;
        	kickoutSession.setAttribute("kickout", true);
        }

        // 如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            // 会话被踢出了
            try {
                subject.logout();
            } catch (Exception e) {
            }
            saveRequest(request);
            redirect(request, response, kickoutUrl);
            return false;
        }

        return true;
	}
	
	
	
	/**
	 * 重定向方法
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param kickoutUrl 踢出的url
	 * @throws IOException io异常
	 */
	private void redirect(ServletRequest request, ServletResponse response,String kickoutUrl) throws IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
		if (requestedWith!=null&&!requestedWith.equals("")&&requestedWith.equals("XMLHttpRequest")) {
        	 httpServletResponse.setCharacterEncoding("UTF-8");
             httpServletResponse.setContentType("application/json");
             Map<String,String> map = new HashMap<>();
             map.put("status", "kickout");
             httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(map));
		} else {
			WebUtils.issueRedirect(request, response, kickoutUrl);
		}
	}
	
	

}

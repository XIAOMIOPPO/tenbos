package com.yidu.tencloud.web.filter.shiro;

import java.io.Serializable;
import java.util.Deque;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yidu.tencloud.realm.MyRealm;

public class MyLogoutFilter extends LogoutFilter{
	
	/**
	 * 缓存的名字
	 */
	private final static String CACHE_NAME = "shiro-kickout-session";
	
	private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    /**
     * The default redirect URL to where the user will be redirected after logout.  The value is {@code "/"}, Shiro's
     * representation of the web application's context root.
     */
    public static final String DEFAULT_REDIRECT_URL = "/";
    
    
	/**
	 * shiro数据源
	 */
	private MyRealm realm;
	
	
	/**
     * 缓存队列
     */
    private Cache<String, Deque<Serializable>> cache;
    
    
    /**
     * 缓存管理器
     */
    private CacheManager cacheManager;
	
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}


	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
		this.cache=cacheManager.getCache(CACHE_NAME);
	}


	public MyRealm getRealm() {
		return realm;
	}


	public void setRealm(MyRealm realm) {
		this.realm = realm;
	}


	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        //try/catch added for SHIRO-298:
        try {
        	cleanSessionCache(subject);
        	realm.clearAllCache();
            subject.logout();
        } catch (SessionException ise) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
        issueRedirect(request, response, redirectUrl);
		return false;
	}

	
	
	/**
	 * 清理session缓存
	 * @param subject
	 */
	private void cleanSessionCache(Subject subject) {
		String username = (String) subject.getPrincipal();
        Deque<Serializable> deque = cache.get(username);
        if(deque!=null) {
        	deque.clear();
        }
	}
	
	
	
}

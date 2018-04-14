package com.yidu.tencloud.realm;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yidu.tencloud.bean.system.user.User;
import com.yidu.tencloud.biz.system.userbiz.UserBiz;


public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private UserBiz userBiz;
	

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userBiz.getRoles(username));
		Map<String,Set<String>> resMap = userBiz.getResources(username);
		Set<String> res = new HashSet<String>();
		res.addAll(resMap.get("resSet"));
		//res.addAll(resMap.get("urlSet"));
		authorizationInfo.setStringPermissions(res);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = (String)token.getPrincipal();
        User user = userBiz.findUserByName(username);
        if(user == null) {
            throw new UnknownAccountException();
        }
        if("0".equals(user.getIsUse())) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getUserName(), 
                user.getPwd().toCharArray(), 
                getName()  //realm name
        );
        
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        
        info.setCredentialsSalt(ByteSource.Util.bytes("tenbos"));
        
        return info;
		
		
	}
	
	

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

	
	
	
}

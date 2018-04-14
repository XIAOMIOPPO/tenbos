package com.yidu.tencloud.web.filter.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MyPermissionsAuthorizationFilter extends AuthorizationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        if (requestedWith!=null&&!requestedWith.equals("")&&requestedWith.equals("XMLHttpRequest")) {
        	 httpServletResponse.setCharacterEncoding("UTF-8");
             httpServletResponse.setContentType("application/json");
             Map<String,String> map = new HashMap<>();
             map.put("status", "unauthorized");
             httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(map));
		} else {
			Subject subject = getSubject(request, response);
	        if (subject.getPrincipal() == null) {
	            saveRequestAndRedirectToLogin(request, response);
	        } else {
	            String unauthorizedUrl = getUnauthorizedUrl();
	            if (StringUtils.hasText(unauthorizedUrl)) {
	                WebUtils.issueRedirect(request, response, unauthorizedUrl);
	            } else {
	                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
	            }
	        }

		}
        
        
        return false;
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws IOException {
		Subject subject = getSubject(request, response);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();
		int index = url.indexOf("/",1);
		String surl = url.substring(index);
		if(subject.isPermitted(surl)) {
			return true;
		}
		return false;
	}
	

	
}

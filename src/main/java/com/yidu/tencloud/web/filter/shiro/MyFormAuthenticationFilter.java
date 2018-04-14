package com.yidu.tencloud.web.filter.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
		if (requestedWith!=null&&!requestedWith.equals("")&&requestedWith.equals("XMLHttpRequest")) {
        	 httpServletResponse.setCharacterEncoding("UTF-8");
             httpServletResponse.setContentType("application/json");
             Map<String,String> map = new HashMap<>();
             map.put("status", "unauthenized");
             httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(map));
		} else {
			super.redirectToLogin(request, response);
		}
	}



	
	
}

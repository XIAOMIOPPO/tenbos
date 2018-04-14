package com.yidu.tencloud.web.filter.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyRolesAuthorizationFilter extends RolesAuthorizationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //��ȡ��������
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        //�ж��Ƿ�Ϊ�첽����
        if (requestedWith!=null&&!requestedWith.equals("")&&requestedWith.equals("XMLHttpRequest")) {
        	//���첽����
        	 httpServletResponse.setCharacterEncoding("UTF-8");
             httpServletResponse.setContentType("application/json");
             Map<String,String> map = new HashMap<>();
             map.put("status", "unauthorized");
             httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(map));
             return false;
        }else {
			return super.onAccessDenied(request, response);
		}
	}

	
	
}

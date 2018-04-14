package com.yidu.tencloud.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计页面同时访问人数
 * @author 张建勇
 * @date 2017-11-14
 */
public class SessionCounter implements HttpSessionListener{
	
	//当前在线人数
	private static int ACTIVE_SESSIONS = 0;  
	
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ACTIVE_SESSIONS++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		if(ACTIVE_SESSIONS > 0){
			ACTIVE_SESSIONS --;
		}
	}

	public static int getACTIVE_SESSIONS() {
		return ACTIVE_SESSIONS;
	}  
	
	

}

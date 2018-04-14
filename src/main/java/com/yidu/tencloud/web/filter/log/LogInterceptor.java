package com.yidu.tencloud.web.filter.log;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.tencloud.bean.system.log.Log;
import com.yidu.tencloud.biz.system.logbiz.LogBiz;
import com.yidu.tencloud.util.IDGenderatorUtil;
import com.yidu.tencloud.util.ShiroUtil;

public class LogInterceptor implements HandlerInterceptor{	
	
	/**
	 * 依赖注入日志接口
	 */
	@Autowired
	private LogBiz logBiz;
	
	/**
	 * 获得日志接口
	 * @return 日志接口
	 */
	public LogBiz getLogBiz() {
		return logBiz;
	}

	/**
	 * 设置日志接口
	 * @param logBiz 日志接口
	 */
	public void setLogBiz(LogBiz logBiz) {
		this.logBiz = logBiz;
	}

	/**
	 *  preHandle方法是进行处理器拦截用的
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//继续流程
		return true;
	}

	/**
	 * 该方法将在Controller执行之后，返回视图之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String requestURI = request.getRequestURI();
		if(!requestURI.contains("static")) {
			Log log = new Log();
			log.setLogId(IDGenderatorUtil.generateId());
			String userName = "未知";
			if(ShiroUtil.getUser()==null) {
				userName = request.getParameter("userName");
			}else {
				userName=ShiroUtil.getUser().getUserName();
			}
			log.setUserName(userName);
			log.setVisitDate(new Date());
			log.setVisitResource(requestURI);			
			log.setVisitResult(response.getContentType());
			if(modelAndView!=null) {
				log.setVisitResult(modelAndView.getViewName());
			}
			logBiz.addLog(log);
		}
		
	}

	/**
	 * 在整个请求完成之后或在视图渲染之后进行调用,用于进行一些资源的释放 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
}

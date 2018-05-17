package com.qsj.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	private final String loginSession = "userid";
	/*拦截前处理*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) 
			throws Exception {
		Object mySession = request.getSession().getAttribute(loginSession);
		if(mySession != null) {
			return true;
		}
		response.sendRedirect("iogin");
		return false;
	}
	/*拦截后处理*/
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}
	/*全部完成后处理*/
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {		
	}

	

	

}

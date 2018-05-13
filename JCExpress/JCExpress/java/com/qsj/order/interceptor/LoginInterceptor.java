package com.qsj.order.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.qsj.base.result.ExOsResult;
import com.qsj.pojo.OsCustomer;
import com.qsj.service.TokenService;
import com.qsj.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 拦截权限页面
 * @Package: com.qsj.order.intercepter 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月22日 下午8:36:15 
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Value("${token_name}")
	private String token_name;

	@Autowired
	private TokenService tokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cookieValue = CookieUtils.getCookieValue(request, token_name);
		if (StringUtils.isBlank(cookieValue)) {
			response.sendRedirect("./login.html");
			return false;
		}
		ExOsResult customerToken = tokenService.getCustomerToken(cookieValue);
		if (customerToken.getCode() != 200) {
			response.sendRedirect("./login.html");
			return false;
		}
		OsCustomer customer = (OsCustomer) customerToken.getData();
		request.setAttribute("customer", customer);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}

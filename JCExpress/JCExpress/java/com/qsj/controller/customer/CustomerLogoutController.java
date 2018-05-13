package com.qsj.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsj.base.controller.BaseController;
import com.qsj.base.result.ExOsResult;
import com.qsj.service.TokenService;
import com.qsj.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.customer 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月21日 下午1:58:18 
 */
@Controller
public class CustomerLogoutController extends BaseController {
	@Autowired
	private TokenService tokenService;

	@Value("${token_name}")
	private String token_name;

	/**
	 * @Title: logoutCustomer  
	 * @Description: TODO(用户退出改版 token)  
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/customer/logout/*")
	public String logoutCustomer(HttpServletRequest request, HttpServletResponse response) {
		String cookieValue = CookieUtils.getCookieValue(request, token_name);
		ExOsResult exOsResult = tokenService.deleteCustomerToken(cookieValue);
		if (exOsResult.getCode() == 200) {
			CookieUtils.setCookie(request, response, token_name, "true");
			return redirectTo("/index.html");
		}
		return null;
	}
}

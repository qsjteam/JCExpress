package com.qsj.controller.token;

import com.qsj.base.result.ExOsResult;
import com.qsj.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
@Controller
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@RequestMapping("/customer/token/{token}")
	@ResponseBody
	public Object getCustomerToken(@PathVariable("token") String token) {
		ExOsResult exOsResult = tokenService.getCustomerToken(token);
		System.out.println("Controller::::::::::::"+exOsResult);
		return exOsResult;
	}
}

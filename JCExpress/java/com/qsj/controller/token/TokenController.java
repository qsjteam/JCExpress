package com.qsj.controller.token;

import com.qsj.base.result.ExOsResult;
import com.qsj.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.controller.token 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月21日 上午10:13:45 
 */
@Controller
public class TokenController {

	@Autowired
	private TokenService tokenService;

	@RequestMapping("/customer/token/{token}")
	@ResponseBody
	public Object getCustomerToken(@PathVariable("token") String token) {
		ExOsResult exOsResult = tokenService.getCustomerToken(token);
		return exOsResult;
	}
}

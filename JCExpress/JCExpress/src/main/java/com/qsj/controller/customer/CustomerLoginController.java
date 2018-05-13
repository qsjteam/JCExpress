package com.qsj.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsj.base.result.ExOsResult;
import com.qsj.captcha.sdk.GeetestLib;
import com.qsj.controller.captcha.GeetestConfig;
import com.qsj.service.CustomerService;
import com.qsj.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@RequestMapping("/customerLogin")
@Controller
public class CustomerLoginController {

	@Autowired
	private CustomerService customerService;
	
	@Value("${token_name}")
	private String token_name;

	@RequestMapping
	@ResponseBody
	public Object CustomerLogin(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		// 从session中获取gt-server状态
		int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
		// 从session中获取userid
		String userid = (String) request.getSession().getAttribute("userid");
		int gtResult = 0;
		if (gt_server_status_code == 1) {
			// gt-server正常，向gt-server进行二次验证
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
			System.out.println(gtResult);
		} else {
			// gt-server非正常情况下，进行failback模式验证
			// System.out.println("failback:使用自己的服务器的验证码验证");
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
			System.out.println(gtResult);
		}
		if (gtResult == 1) {
			// 验证成功
			ExOsResult exOsResult = customerService.customerLogin(username, password);
			// 判断是否登录成功
			if (exOsResult.getCode() == 200) {
				String token = exOsResult.getMessage();
				CookieUtils.setCookie(request, response, token_name, token);
				return exOsResult;
			}
			if (exOsResult.getCode() == 400) {
				return exOsResult;
			}
			if (exOsResult.getCode() == 403) {
				request.getSession().setAttribute("email", exOsResult.getMessage());
				return exOsResult;
			}
			return exOsResult;
		} else {
			// 验证失败
			return new ExOsResult("系统错误");
		}
	}

}

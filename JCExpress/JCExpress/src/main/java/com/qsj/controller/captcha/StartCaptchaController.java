package com.qsj.controller.captcha;

import javax.servlet.http.HttpServletRequest;

import com.qsj.captcha.sdk.GeetestLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 前台图片验证码
 * @author qsjteam   
 * @date 2018-5-5
 */
@RequestMapping("/kaptcha/*")
@Controller
public class StartCaptchaController {
	@RequestMapping
	@ResponseBody
	public String startCaptcha(HttpServletRequest request) {

		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), GeetestConfig.getPrivate_key());
		String resStr = "{}";
		// 自定义userid
		String userid = "Ex";
		// 进行验证预处理
		int gtServerStatus = gtSdk.preProcess(userid);
		// 将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		// 将userid设置到session中
		request.getSession().setAttribute("userid", userid);
		resStr = gtSdk.getResponseStr();
		return resStr;
	}
}

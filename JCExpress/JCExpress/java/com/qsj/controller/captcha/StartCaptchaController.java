package com.qsj.controller.captcha;

import javax.servlet.http.HttpServletRequest;

import com.qsj.captcha.sdk.GeetestLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.captcha 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月20日 下午4:35:48 
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

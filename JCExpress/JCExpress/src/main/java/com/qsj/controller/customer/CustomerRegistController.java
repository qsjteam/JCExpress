package com.qsj.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsj.base.result.ExOsResult;
import com.qsj.captcha.sdk.GeetestLib;
import com.qsj.controller.captcha.GeetestConfig;
import com.qsj.pojo.OsCustomer;
import com.qsj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CustomerRegistController {
	
	@Autowired
	private CustomerService customerService;

	/**
	 * @Title: customerRegist  
	 * @Description: TODO(客户注册)  
	 * @param @param customer
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/customerRegist")
	@ResponseBody
	public Object CustomerRegist(HttpServletRequest request, HttpServletResponse response, OsCustomer customer) {
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
		} else {
			// gt-server非正常情况下，进行failback模式验证
			// System.out.println("failback:使用自己的服务器的验证码验证");
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
		}
		if (gtResult == 1) {
			// 验证成功
			ExOsResult exOsResult = customerService.registCustomer(customer);
			// 判断
			if (exOsResult.getCode() == 200) {
				return exOsResult;
			}
			if (exOsResult.getCode() == 400) {
				return exOsResult;
			}
			return exOsResult;
		} else {
			// 验证失败
			return new ExOsResult("系统错误");
		}
	}

	/**
	 * @Title: sendEmail  
	 * @Description: TODO(发送邮件)  
	 * @param @param request
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/sendEmail")
	@ResponseBody
	public Object sendEmail(HttpServletRequest request) {
		String email = (String) request.getSession().getAttribute("email");
		ExOsResult exOsResult = customerService.sendEmail(email);
		return exOsResult;
	}

	/**
	 * @Title: registActive  
	 * @Description: TODO(激活用户)  
	 * @param @param code
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/registActive/{code}")
	public String registActive(@PathVariable("code") String code, Model model) {
		if(customerService.registActive(code)){
			model.addAttribute("message", "验证成功");
		}else{
			model.addAttribute("message", "验证失败！！！");
		}
		return "views/email/activeSuccess";
	}

}

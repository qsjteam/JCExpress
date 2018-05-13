package com.qsj.controller.customer;

import com.qsj.base.result.ExOsResult;
import com.qsj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.customer 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月24日 下午3:57:42 
 */
@Controller
public class CustomerModifyPasswordController {
	@Autowired
	private CustomerService customerService;

	/**
	 * @Title: modifyPassword  
	 * @Description: TODO(跳转修改密码页面)  
	 * @param @param code
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/modifyPassword/{code}")
	public String modifyPassword(@PathVariable("code") String code, Model model) {
		model.addAttribute("code", code);
		return "views/modify/modifyPassword";
	}

	/**
	 * @Title: modifyPassword  
	 * @Description: TODO(修改密码)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public Object modifyPassword(Model model, String password, String code) {
		ExOsResult exOsResult = customerService.modifyPassword(password, code);
		return exOsResult;
	}

	/**
	 * @Title: sendModifyEmail  
	 * @Description: TODO(发送邮件)  
	 * @param @param model
	 * @param @param request
	 * @param @return    设定文件  
	 *@return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/sendModifyEmail")
	@ResponseBody
	public Object sendModifyEmail(String email) {
		ExOsResult exOsResult = customerService.sendModifyEmail(email);
		return exOsResult;
	}

}

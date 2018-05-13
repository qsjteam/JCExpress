package com.qsj.controller.sysUserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/info")
public class sysUserInfoController {
	
	@RequestMapping("/form_avatar")
	public String form_avatar(Model model) {
		System.out.println("------------------->");
		return "views/roles/form_avatar";
	}
	@RequestMapping("/profile")
	public String profile(Model model) {
		return "views/roles/profile";
	}
	@RequestMapping("/contacts")
	public String contacts(Model model) {
		return "views/roles/contacts";
	}
	@RequestMapping("/mailbox")
	public String mailbox(Model model) {
		return "views/roles/mailbox";
	}
}

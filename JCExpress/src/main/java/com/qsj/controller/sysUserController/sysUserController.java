package com.qsj.controller.sysUserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/user")
public class sysUserController {
	
	@RequestMapping("/list/view")
	public String view(Model model) {
		return "views/roles/customerList";
	}
	@RequestMapping("/grade/view")
	public String grade(Model model) {
		return "views/roles/grade";
	}
	@RequestMapping("/record/view")
	public String record(Model model) {
		return "views/roles/record";
	}
	
	
}

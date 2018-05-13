package com.qsj.controller.sysUserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/version")
public class sysVersionController {
	
	@RequestMapping("/druid")
	public String druid(Model model) {
		return "views/roles/druid";
	}
	@RequestMapping("/swagger-ui")
	public String swagger(Model model) {
		return "views/roles/swagger-ui";
	}
	@RequestMapping("/view")
	public String view(Model model) {
		return "views/roles/view";
	}
}

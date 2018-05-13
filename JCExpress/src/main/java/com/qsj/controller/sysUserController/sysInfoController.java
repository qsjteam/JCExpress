package com.qsj.controller.sysUserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/info")
public class sysInfoController {

	@RequestMapping("/punish")
	public String punish(Model model) {
		return "views/roles/punish";
	}
	@RequestMapping("/complaint")
	public String complaint(Model model) {
		return "views/roles/complaint";
	}
}

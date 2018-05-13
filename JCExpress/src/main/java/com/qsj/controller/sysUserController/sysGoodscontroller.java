package com.qsj.controller.sysUserController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/goods")
public class sysGoodscontroller {
	
	@RequestMapping("/query")
	public String query(Model model) {
		return "views/roles/query";
	}
	@RequestMapping("/order")
	public String order(Model model) {
		return "views/roles/order";
	}
}

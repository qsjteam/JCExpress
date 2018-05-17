package com.qsj.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsj.base.result.BaseResult;
import com.qsj.service.ViewService;

@Controller
public class viewController {
	@Autowired
	private ViewService viewservice;
	
	@RequestMapping("/showView")
	@ResponseBody
	public BaseResult showView() {
		BaseResult bb= new BaseResult(null);
		bb=viewservice.showView();
		return bb;
	}
	
}

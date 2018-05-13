package com.qsj.controller.log;

import com.qsj.service.LogService;
import com.qsj.support.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.log.controller 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月27日 上午11:39:14 
 */
@Controller
@RequestMapping("/system/log")
public class LogController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/show")
	public String show(Model model) {
		return "views/log/systemLogList";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object logList(BasePage basePage, @RequestParam(required = false, value = "search") String search) {
		return logService.findAllLogByPage(search, basePage);
	}
}

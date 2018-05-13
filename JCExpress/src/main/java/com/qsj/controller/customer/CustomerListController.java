package com.qsj.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsj.base.controller.BaseController;
import com.qsj.service.CustomerService;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Controller
@RequestMapping("/customer/list")
public class CustomerListController extends BaseController{

	@Autowired
	private CustomerService customerService;

	/**
	 * @Title: userList  
	 * @Description: TODO(跳转到用户列表界面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/customerList")
	public String userList(Model model) {
		return "views/user/customerList";
	}

	/**
	 * @Title: findAllUser  
	 * @Description: TODO(查询所有管理员)  
	 * @param @param basePage
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public Object findAllUser(BasePage basePage, @RequestParam(required = false, value = "search") String search) {
		return  customerService.findAllCustomer(search, basePage);
	}



	
	/**------------------------------------USERLIST END----------------------------------------------------------------**/
}

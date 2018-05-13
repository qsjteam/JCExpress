package com.qsj.controller.driver;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Driver;
import com.qsj.pojo.User;
import com.qsj.service.DriverService;
import com.qsj.support.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.driver 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月10日 下午4:46:07 
 */
@RequestMapping("/driver/list")
@Controller
public class DriverListController {
	@Autowired
	private DriverService driverService;

	/**
	 * @Title: driverList  
	 * @Description: TODO(跳转司机列表页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/driverList")
	public String driverList(Model model) {
		return "views/driver/adminDriverList";
	}

	/**
	 * @Title: driverList  
	 * @Description: TODO(显示司机)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object driverList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return driverService.findAllDriverByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozendriver  
	 * @Description: TODO(冻结启用司机)  
	 * @param @param driverId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{driverId}/frozenDriver", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozendriver(@PathVariable("driverId") Integer driverId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = driverService.FrozenDriver(driverId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deletedriver  
	 * @Description: TODO(删除司机)  
	 * @param @param driverId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{driverId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deletedriver(@PathVariable("driverId") Integer driverId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = driverService.deleteDriver(driverId);
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createdriver  
	 * @Description: TODO(跳转创建司机页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/createDriver")
	public String createdriver(Model model) {
		return "views/driver/adminDriverCreate";
	}

	/**
	 * @Title: createdriver  
	 * @Description: TODO(创建司机)  
	 * @param @param driver
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createdriver(Driver driver) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = driverService.insertDriver(driver);
			return new BaseResult("添加成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createdriver  
	 * @Description: TODO(更新司机)  
	 * @param @param driverId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{driverId}/updateDriver")
	public String updatedriver(@PathVariable("driverId") Integer driverId, Model model) {
		Driver driver = driverService.findDriverById(driverId);
		model.addAttribute("driver", driver);
		return "views/driver/adminDriverUpdate";
	}

	/**
	 * @Title: updatedriver  
	 * @Description: TODO(修改司机)  
	 * @param @param driverId
	 * @param @param driver
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{driverId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updatedriver(@PathVariable("driverId") Integer driverId, Driver driver) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			driver.setId(driverId);
			Integer count = driverService.updateDriver(driver);
			return new BaseResult("修改成功", count);
		}
		return new BaseResult("没有登录");
	}

}

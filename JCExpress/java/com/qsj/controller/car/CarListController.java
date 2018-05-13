package com.qsj.controller.car;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Driver;
import com.qsj.pojo.ExCar;
import com.qsj.pojo.User;
import com.qsj.service.CarService;
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
 * @Package: org.mao.controller.car 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月10日 下午4:46:07 
 */
@RequestMapping("/car/list")
@Controller
public class CarListController {
	@Autowired
	private CarService carService;
	@Autowired
	private DriverService driverService;

	/**
	 * @Title: carList  
	 * @Description: TODO(跳转车辆列表页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/carList")
	public String carList(Model model) {
		return "views/car/ExCarList";
	}

	/**
	 * @Title: carList  
	 * @Description: TODO(显示车辆)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object carList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return carService.findAllCarByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozencar  
	 * @Description: TODO(冻结启用车辆)  
	 * @param @param carId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{carId}/frozenCar", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozencar(@PathVariable("carId") Integer carId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = carService.FrozenCar(carId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deletecar  
	 * @Description: TODO(删除车辆)  
	 * @param @param carId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{carId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deletecar(@PathVariable("carId") Integer carId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = carService.deleteCar(carId);
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createcar  
	 * @Description: TODO(跳转创建车辆页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/createCar")
	public String createcar(Model model) {
		List<Driver> drivers = driverService.findStatusDriver();
		model.addAttribute("drivers", drivers);
		return "views/car/ExCarCreate";
	}

	/**
	 * @Title: createcar  
	 * @Description: TODO(创建车辆)  
	 * @param @param car
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createcar(ExCar car) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = carService.insertCar(car);
			return new BaseResult("添加成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createcar  
	 * @Description: TODO(更新车辆)  
	 * @param @param carId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{carId}/updateCar")
	public String updatecar(@PathVariable("carId") Integer carId, Model model) {
		ExCar car = carService.findCarById(carId);
		model.addAttribute("car", car);
		List<Driver> drivers = driverService.findStatusDriver();
		model.addAttribute("drivers", drivers);
		return "views/car/ExCarUpdate";
	}

	/**
	 * @Title: updatecar  
	 * @Description: TODO(修改车辆)  
	 * @param @param carId
	 * @param @param car
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{carId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updatecar(@PathVariable("carId") Integer carId, ExCar car) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			car.setId(carId);
			Integer count = carService.updateCar(car);
			return new BaseResult("修改成功", count);
		}
		return new BaseResult("没有登录");
	}

}

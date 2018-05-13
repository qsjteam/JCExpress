package com.qsj.controller.staff;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Staff;
import com.qsj.pojo.User;
import com.qsj.service.StaffService;
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
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@RequestMapping("/staff/list")
@Controller
public class StaffListController {
	@Autowired
	private StaffService staffService;

	/**
	 * @Title: staffList  
	 * @Description: TODO(跳转取派员列表页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/staffList")
	public String staffList(Model model) {
		return "views/staff/adminStaffList";
	}

	/**
	 * @Title: staffList  
	 * @Description: TODO(显示取派员)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object staffList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return staffService.findAllStaffByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozenStaff  
	 * @Description: TODO(冻结启用取派员)  
	 * @param @param staffId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{staffId}/frozenStaff", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozenStaff(@PathVariable("staffId") Integer staffId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = staffService.FrozenStaff(staffId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deleteStaff  
	 * @Description: TODO(删除取派员)  
	 * @param @param staffId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{staffId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteStaff(@PathVariable("staffId") Integer staffId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = staffService.deleteStaff(staffId);
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createStaff  
	 * @Description: TODO(跳转创建取派员页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/createStaff")
	public String createStaff(Model model) {
		return "views/staff/adminStaffCreate";
	}

	/**
	 * @Title: createStaff  
	 * @Description: TODO(创建取派员)  
	 * @param @param staff
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createStaff(Staff staff) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = staffService.insertStaff(staff);
			return new BaseResult("添加成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createStaff  
	 * @Description: TODO(更新取派员)  
	 * @param @param staffId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{staffId}/updateStaff")
	public String updateStaff(@PathVariable("staffId") Integer staffId, Model model) {
		Staff staff = staffService.findStaffById(staffId);
		model.addAttribute("staff", staff);
		return "views/staff/adminStaffUpdate";
	}

	/**
	 * @Title: updateStaff  
	 * @Description: TODO(修改取派员)  
	 * @param @param staffId
	 * @param @param staff
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{staffId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateStaff(@PathVariable("staffId") Integer staffId, Staff staff) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			staff.setId(staffId);
			Integer count = staffService.updateStaff(staff);
			return new BaseResult("修改成功", count);
		}
		return new BaseResult("没有登录");
	}

}

package com.qsj.controller.user;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.controller.BaseController;
import com.qsj.base.result.BaseResult;
import com.qsj.exception.ValidateException;
import com.qsj.pojo.Organization;
import com.qsj.pojo.Role;
import com.qsj.pojo.User;
import com.qsj.service.OrganizationService;
import com.qsj.service.RoleService;
import com.qsj.service.UserService;
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
@Controller
@RequestMapping("/user/list")
public class UserListController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganizationService organizationService;

	/**
	 * @Title: userList  
	 * @Description: TODO(跳转到用户列表界面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/userList")
	public String userList(Model model) {
		return "views/user/adminUserList";
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
		return  userService.findAllUser(search, basePage);
	}

	/**
	 * @Title: userLog  
	 * @Description: TODO(跳转到日志页面传递参数)  
	 * @param @param userId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/{userId}/userLog", method = RequestMethod.GET)
	public String userLog(@PathVariable("userId")String userId, Model model) {
		model.addAttribute("userId", userId);
		return "views/user/adminUserLoginLog";
	}

	/**
	 * @Title: userLogs  
	 * @Description: TODO(根据用户id查询用户的登录日志)  
	 * @param @param userId
	 * @param @param basePage
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/{userId}/userLogs")
	@ResponseBody
	public Object userLogs(@PathVariable String userId, BasePage basePage,
			@RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return userService.findUserLoginLogById(Integer.valueOf(userId), search, basePage);
		} else {
			return new BaseResult("没有登录");
		}
	}

	/**
	 * @Title: frozenUser  
	 * @Description: TODO(启用冻结用户)  
	 * @param @param userId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/{userId}/frozenUser")
	@ResponseBody
	public Object frozenUser(@PathVariable("userId") Integer userId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer frozenUser = userService.frozenUser(userId);
			return new BaseResult("请求成功", frozenUser);
		}

		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createUser  
	 * @Description: TODO(跳转创建用户页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/createUser")
	public String createUser(Model model) {
		List<Role> roles = roleService.findAllRolesByStatus("1");
		model.addAttribute("roles", roles);
		List<Organization> organizations = organizationService.findAllOrgByStatus("1");
		model.addAttribute("organizations", organizations);
		return "views/user/adminUserCreate";
	}

	/**
	 * @Title: userMessage  
	 * @Description: TODO(查询用户信息)  
	 * @param @param userId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/{userId}/userMessage")
	public String userMessage(@PathVariable("userId") String userId, Model model) {
		User user = userService.findUserById(Integer.valueOf(userId));
		model.addAttribute("user", user);
		List<Role> roles = roleService.findRoleNameByRoleAndUser(Integer.valueOf(userId));
		model.addAttribute("roles", roles);
		return "views/user/adminUserMessage";
	}

	/**
	 * @Title: createUser  
	 * @Description: TODO(创建用户)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createUser(User user, @RequestParam(required = false, value = "roleId") String[] roleIds) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			try {
				Integer count = userService.createUser(user, roleIds, activeUser.getUser_name());
				return new BaseResult("添加成功", count);
			} catch (ValidateException e) {
				return new BaseResult(e.getMessage());
			}
		}
		return new BaseResult("没有登录");
	}
	/**
	 * @Title: updateUser  
	 * @Description: TODO(跳转更新用户页面)  
	 * @param @param userId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value="/{userId}/updateUser")
	public String updateUser(@PathVariable("userId")String userId, Model model) {
		User user = userService.findUserById(Integer.valueOf(userId));
		model.addAttribute("user", user);
		List<Role> roles = roleService.findAllRolesByStatus("1");
		model.addAttribute("roles", roles);
		List<Role> userRoles = roleService.findRoleNameByRoleAndUser(Integer.valueOf(userId));
		model.addAttribute("userRoles", userRoles);
		List<Organization> organizations = organizationService.findAllOrgByStatus("1");
		model.addAttribute("organizations", organizations);
		return "views/user/adminUserUpdate";
	}

	/**
	 * @Title: updateUser  
	 * @Description: TODO(更新用户)  
	 * @param @param user
	 * @param @param userId
	 * @param @param roleIds
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateUser(User user, @PathVariable("userId") String userId,
			@RequestParam(required = false, value = "roleId") String[] roleIds) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			user.setU_id(Integer.valueOf(userId));
			try {
				Integer count = userService.updateUser(user, roleIds, activeUser.getUser_name());
				return new BaseResult("更新成功", count);
			} catch (ValidateException e) {
				return new BaseResult(e.getMessage());
			}

		}
		return new BaseResult("没有登录");
	}
	/**
	 * @Title: deleteUser  
	 * @Description: TODO(删除用户)  
	 * @param @param userId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteUser(@PathVariable("userId") String userId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = userService.deleteUser(Integer.valueOf(userId));
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}
	/**------------------------------------USERLIST END----------------------------------------------------------------**/
}

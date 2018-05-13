package com.qsj.controller.user;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.controller.BaseController;
import com.qsj.base.result.BaseResult;
import com.qsj.exception.ValidateException;
import com.qsj.pojo.Role;
import com.qsj.pojo.User;
import com.qsj.service.RoleService;
import com.qsj.service.UserService;
import com.qsj.support.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 用户信息
 * @author qsjteam   
 * @date 2018-5-5
 */
@Controller
@RequestMapping("/user/info")
public class UserInfoController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	/**
	 * @Title: showUserInfo  
	 * @Description: TODO(显示个人信息)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/showInfo")
	public String showUserInfo(Model model) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		User UserInfo = userService.findUserById(activeUser.getU_id());
		List<Role> roles = roleService.findRoleNameByRoleAndUser(activeUser.getU_id());
		model.addAttribute("user", UserInfo);
		model.addAttribute("roles", roles);
		return "views/user/adminUserInfo";
	}

	/**
	 * @Title: showUserInfo  
	 * @Description: TODO(显示个人登录日志)  
	 * @param @param basePage
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/showLoginLog")
	@ResponseBody
	public Object showUserInfo(BasePage basePage, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return userService.findUserLoginLogById(activeUser.getU_id(), search, basePage);
		} else {
			return new BaseResult("没有登录");
		}

	}

	/**
	 * @Title: infoEdit  
	 * @Description: TODO(修改用户个人信息)  
	 * @param @param basePage
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/infoEdit")
	@ResponseBody
	public Object infoEdit(User user) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			user.setU_id(activeUser.getU_id());
			user.setUpdate_by(activeUser.getUser_name());
			Integer conut = userService.updateUserInfo(user);
			return new BaseResult("修改成功", conut);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: modifyPassword  
	 * @Description: TODO(修改密码)  
	 * @param @param nowPassword 现在的密码
	 * @param @param newPassword 新密码
	 * @param @param confirmPwd  提交的密码
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public Object modifyPassword(@RequestParam("nowPassword") String nowPassword,
			@RequestParam("newPassword") String newPassword, @RequestParam("confirmPwd") String confirmPwd) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (!newPassword.equals(confirmPwd)) {
			return new BaseResult("两次密码输入不一致");
		}
		if (activeUser != null) {
			try {
				Integer updatePassword = userService.updatePassword(nowPassword, newPassword, activeUser.getU_id());
				return new BaseResult("修改密码成功", updatePassword);
			} catch (ValidateException e) {
				return new BaseResult(e.getMessage());
			}
		}
		return new BaseResult("没有登录");
	}
	/**------------------------------------USERINFO END----------------------------------------------------------------**/
}

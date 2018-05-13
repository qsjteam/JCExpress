package com.qsj.controller.login;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import com.qsj.base.controller.BaseController;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;
import com.qsj.service.LoginService;
import com.qsj.service.MenuService;
import com.qsj.util.ServletUtils;
import com.qsj.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.code.kaptcha.Constants;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.login.controller 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月8日 下午4:39:41 
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private LoginService loginService;

	/**
	 * @Title: getLoginPage  
	 * @Description: TODO(跳转登录页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "views/login/adminLogin";
	}

	/**
	 * @Title: login  
	 * @Description: TODO(请求登录)  
	 * @param @param username
	 * @param @param password
	 * @param @param jcaptchaCode
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestParam("userName") String userName, @RequestParam("Password") String Password,
			@RequestParam("jcaptchaCode") String jcaptchaCode) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();
		String validateCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (jcaptchaCode != null && validateCode != null && !jcaptchaCode.toLowerCase().equals(validateCode)) {
			return new BaseResult("验证码错误", 103);
		}
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, Password);
		token.setRememberMe(false);// 默认不记住密码
		try {
			currentUser.login(token);
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			LoginLog loginLog = new LoginLog(new Date(), ServletUtils.getIpAddr(), user.getU_id(),
					ServletUtils.getUserOperatingSystem(), ServletUtils.getUserBrowser());
			loginService.insertLoginLog(user.getU_id(), loginLog);
			return new BaseResult("登录成功", 200);
		} catch (UnknownAccountException e) {
			return new BaseResult("用户名不存在");
		} catch (DisabledAccountException e) {
			return new BaseResult("您的账户已经被冻结");
		} catch (IncorrectCredentialsException e) {
			return new BaseResult("密码错误", 104);
		} catch (ExcessiveAttemptsException e) {
			return new BaseResult("您错误的次数太多了吧,封你半小时");
		} catch (RuntimeException e) {
			return new BaseResult("运行异常");
		}
	}

	/**
	 * @Title: unauth  
	 * @Description: TODO(没有权限跳转到登录页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/unauth", method = RequestMethod.GET)
	public String unauth() {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			return redirectTo("/login");
		}
		return "unauth";
	}

	/**
	 * @Title: index  
	 * @Description: TODO(跳转到首页)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/")
	public String index(Model model) {
		return redirectTo("/index");
	}

	/**
	 * @Title: menuList  
	 * @Description: TODO(跳转首页)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/index")
	public String menuList(Model model) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		List<MenuVo> menus = menuService.getMenuByUserId(activeUser.getU_id());
		model.addAttribute("menus", menus);
		return "views/main/index";
	}

}

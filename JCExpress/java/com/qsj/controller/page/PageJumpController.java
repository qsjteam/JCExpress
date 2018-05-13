package com.qsj.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.page 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月14日 下午8:48:34 
 */
@Controller
public class PageJumpController {
	/**
	 * @Title: index  
	 * @Description: TODO(跳转首页)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("index")
	public String index() {
		return "common/index";
	}

	/**
	 * @Title: about  
	 * @Description: TODO(跳转关于我们页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("about")
	public String about() {
		return "common/about";
	}

	/**
	 * @Title: contact  
	 * @Description: TODO(跳转联系我们页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("contact")
	public String contact() {
		return "common/contact";
	}

	/**
	 * @Title: zixun  
	 * @Description: TODO(跳转最新咨询页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("zixun")
	public String zixun() {
		return "common/zixun";
	}

	/**
	 * @Title: fuwu  
	 * @Description: TODO(跳转服务内容页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("fuwu")
	public String fuwu() {
		return "common/fuwu";
	}
	/**====================================view====================================================**/

	/**
	 * 
	 * @Title: chadan  
	 * @Description: TODO(跳转查单页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("chadan")
	public String chadan() {
		return "views/order/chadan";
	}

	/**
	 * 
	 * @Title: xiadan  
	 * @Description: TODO(跳转下单页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("xiadan")
	public String xiadan() {
		return "views/order/xiadan";
	}

	/**
	 * @Title: piliang  
	 * @Description: TODO(批量下单)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("piliang")
	public String piliang() {
		return "views/member/memberOrder";
	}

	/**====================================login====regist================================================**/
	/**
	 * @Title: login  
	 * @Description: TODO(跳转登录页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("login")
	public String login() {
		return "views/login/login";
	}

	/**
	 * @Title: regist  
	 * @Description: TODO(跳转注册页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("regist")
	public String regist() {
		return "views/regist/regist";
	}

	/**
	 * @Title: active  
	 * @Description: TODO(激活验证页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("active")
	public String active() {
		return "views/email/active";
	}

	/**
	 * @Title: registSuccess  
	 * @Description: TODO(跳转注册成功页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("registSuccess")
	public String registSuccess() {
		return "views/regist/registSuccess";
	}

	/**
	 * @Title: modify
	 * @Description: TODO(跳转修改密码页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("modify")
	public String modify() {
		return "views/modify/modify";
	}

	/**
	 * @Title: modify
	 * @Description: TODO(跳转修改密码成功页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("modifySuccess")
	public String modifySuccess() {
		return "views/modify/modifySuccess";
	}
}

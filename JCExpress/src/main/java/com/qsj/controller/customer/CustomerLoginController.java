package com.qsj.controller.customer;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsj.base.result.ExOsResult;
import com.qsj.captcha.sdk.GeetestLib;
import com.qsj.controller.captcha.GeetestConfig;
import com.qsj.service.CustomerService;
import com.qsj.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Controller
public class CustomerLoginController {

	@Autowired
	private CustomerService customerService;
	
	@Value("${token_name}")
	private String token_name;

	@RequestMapping(value="/customerLogin", method=RequestMethod.GET)
	@ResponseBody
	protected Object CustomerLogin(HttpServletRequest request, HttpServletResponse response){
			
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(), 
				GeetestConfig.getPrivate_key(), GeetestConfig.isnewfailback());
		String resStr = "{}";
		String userid = (String) request.getSession().getAttribute("userid");
		
		//自定义参数,可选择添加
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("user_id", userid); //网站用户id
		//web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
		param.put("client_type", "web"); 
		param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP
		
		//进行验证预处理
		int gtServerStatus = gtSdk.preProcess(param);
		//将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		//将userid设置到session中
		request.getSession().setAttribute("userid", userid);
		
		resStr = gtSdk.getResponseStr();
		return resStr;
	}
	
	@RequestMapping(value="/customerLogin", method=RequestMethod.POST)
	@ResponseBody
	public Object CustomerLogin(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		System.out.println("username==="+username+"  password==="+password);//TODO log
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(),
				 GeetestConfig.getPrivate_key(), GeetestConfig.isnewfailback());
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		// 从session中获取gt-server状态
		int gt_server_status_code = (Integer)request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
		// 从session中获取userid
		String userid = (String) request.getSession().getAttribute("userid");
		
		//自定义参数,可选择添加
		HashMap<String, String> param = new HashMap<String, String>(); 
		param.put("user_id", userid); //网站用户id
		//web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
		param.put("client_type", "web"); 
		param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP
		
		int gtResult = 0;
		if (gt_server_status_code == 1) {
			// gt-server正常，向gt-server进行二次验证
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
			System.out.println(gtResult);
		} else {
			// gt-server非正常情况下，进行failback模式验证
			// System.out.println("failback:使用自己的服务器的验证码验证");
			gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
			System.out.println(gtResult);
		}
		if (gtResult == 1) {
			// 验证成功
			ExOsResult exOsResult = customerService.customerLogin(username, password);
			// 判断是否登录成功
			if (exOsResult.getCode() == 200) {
				String token = exOsResult.getMessage();
				CookieUtils.setCookie(request, response, token_name, token);
				return exOsResult;
			}
			if (exOsResult.getCode() == 400) {
				return exOsResult;
			}
			if (exOsResult.getCode() == 403) {
				request.getSession().setAttribute("email", exOsResult.getMessage());
				return exOsResult;
			}
			return exOsResult;
		} else {
			// 验证失败
			return new ExOsResult("系统错误");
		}
//		if (gtResult == 1) {
//			// 验证成功
//			// 获取当前用户对象
//			Subject subject = SecurityUtils.getSubject();
//			// 生成令牌(传入用户输入的账号和密码)
//			UsernamePasswordToken token = 
//					new UsernamePasswordToken(username,new MD5().getMD5ofStr(password));
//			try {
//				// 这里会加载自定义的realm
//				// 把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
//				subject.login(token);
//				User user = (User) subject.getPrincipal();// 获取登录成功的用户对象(以前是直接去service里面查)
//				// User activeUser = loginService.findUserByNameAndStatus(loginName);
//				request.getSession().setAttribute("user", user);
//				CookieUtils.setCookie(request, response, token_name, "EXSESSION:"+UUID.randomUUID().toString());
//				return "index";
//			} catch (Exception e) {
//				return new ExOsResult("用户名或密码错误", 400);
//			}
//		} else {
//			// 验证失败
//			return new ExOsResult("系统错误");
//		}
	}

}

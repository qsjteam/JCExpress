package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 登录日志
 * @author qsjteam   
 * @date 2018-5-5
 */
public class LoginLog implements Serializable{
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private int log_id;
	private Date login_time;
	private String user_ip;
	private int user_id;
	private String operating_system;
	private String  browser;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOperating_system() {
		return operating_system;
	}
	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public LoginLog(Date login_time, String user_ip, int user_id, String operating_system, String browser) {
		super();
		this.login_time = login_time;
		this.user_ip = user_ip;
		this.user_id = user_id;
		this.operating_system = operating_system;
		this.browser = browser;
	}
	public LoginLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
 
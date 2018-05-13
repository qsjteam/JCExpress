package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class SysLog implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	private int log_id;
	private int user_id;
	private Date create_time;
	private int spend_time;
	private String method;
	private String user_agent;
	private String user_ip;
	private String opt_content;
	private String url;

	@Override
	public String toString() {
		return "SysLog [log_id=" + log_id + ", user_id=" + user_id + ", create_time=" + create_time + ", spend_time="
				+ spend_time + ", method=" + method + ", user_agent=" + user_agent + ", user_ip=" + user_ip
				+ ", opt_content=" + opt_content + ", url=" + url + "]";
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getSpend_time() {
		return spend_time;
	}

	public void setSpend_time(int spend_time) {
		this.spend_time = spend_time;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getOpt_content() {
		return opt_content;
	}

	public void setOpt_content(String opt_content) {
		this.opt_content = opt_content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

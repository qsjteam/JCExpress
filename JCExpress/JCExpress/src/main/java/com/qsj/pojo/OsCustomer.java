package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 客户实体
 * @author qsjteam   
 * @date 2018-5-5 
 */
public class OsCustomer implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int id;
	/** 用户手机号 **/
	private String customer_telephone;
	/** 用户密码 **/
	private String password;
	/** 昵称 **/
	private String nickname;
	/** 用户邮箱 **/
	private String customer_email;
	/** 创建时间 **/
	private Date create_time;
	/** 激活状态 **/
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_telephone() {
		return customer_telephone;
	}

	public void setCustomer_telephone(String customer_telephone) {
		this.customer_telephone = customer_telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

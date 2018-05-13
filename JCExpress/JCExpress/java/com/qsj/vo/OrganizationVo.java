package com.qsj.vo;

import java.io.Serializable;
import java.util.List;

import com.qsj.pojo.Organization;
import com.qsj.pojo.User;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月25日 下午3:17:46 
 */
public class OrganizationVo extends Organization implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private int number;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}

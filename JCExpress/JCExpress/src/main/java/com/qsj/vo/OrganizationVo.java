package com.qsj.vo;

import java.io.Serializable;
import java.util.List;

import com.qsj.pojo.Organization;
import com.qsj.pojo.User;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class OrganizationVo extends Organization implements Serializable {

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

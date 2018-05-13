package com.qsj.vo;

import java.io.Serializable;
import java.util.List;

import com.qsj.pojo.Role;
import com.qsj.pojo.User;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class UserVo extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String org_name;
	private List<Role> roles;

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}

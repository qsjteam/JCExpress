package com.qsj.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class UserDTO implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private Set<String> roleSigns;
	private Set<String> roleIds;

	public Set<String> getRoleSigns() {
		return roleSigns;
	}

	public void setRoleSigns(Set<String> roleSigns) {
		this.roleSigns = roleSigns;
	}

	public Set<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<String> roleIds) {
		this.roleIds = roleIds;
	}

	public UserDTO(Set<String> roleSigns, Set<String> roleIds) {
		super();
		this.roleSigns = roleSigns;
		this.roleIds = roleIds;
	}
}

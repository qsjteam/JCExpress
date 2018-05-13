package com.qsj.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.dto
 * @author:作者 Mao
 * @date:创建时间 2018年1月13日 下午9:38:38
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

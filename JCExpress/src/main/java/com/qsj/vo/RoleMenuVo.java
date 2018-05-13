package com.qsj.vo;

import java.io.Serializable;

import com.qsj.dto.MenuDTO;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class RoleMenuVo extends MenuDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}

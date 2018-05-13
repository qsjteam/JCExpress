package com.qsj.vo;

import java.io.Serializable;

import com.qsj.dto.MenuDTO;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月24日 下午5:47:19 
 */
public class RoleMenuVo extends MenuDTO implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}

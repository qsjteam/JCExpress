package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.SysFixed;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
public class FixedVo extends SysFixed implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String staffName;
	private String telephone;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}

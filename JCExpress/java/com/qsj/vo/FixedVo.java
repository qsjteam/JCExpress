package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.SysFixed;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月8日 下午3:16:35 
 */
public class FixedVo extends SysFixed implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
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

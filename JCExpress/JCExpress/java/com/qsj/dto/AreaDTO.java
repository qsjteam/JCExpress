package com.qsj.dto;

import java.io.Serializable;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.dto 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月23日 下午6:56:01 
 */
public class AreaDTO implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String address;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

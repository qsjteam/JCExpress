package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.ExCar;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class ExCarVo extends ExCar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String telephone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}

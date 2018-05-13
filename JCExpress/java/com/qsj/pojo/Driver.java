package com.qsj.pojo;

import java.io.Serializable;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.pojo 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午3:48:16 
 */
public class Driver implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int id;
	/** 司机名字 **/
	private String name;
	/** 司机手机号 **/
	private String telephone;
	/** 司机住址 **/
	private String address;
	/** 司机住址 **/
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

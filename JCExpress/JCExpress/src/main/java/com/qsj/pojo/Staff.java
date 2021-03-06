package com.qsj.pojo;

import java.io.Serializable;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 取派员实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class Staff implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private Integer id;
	/** 取派员姓名 **/
	private String name;
	/** 取派员手机 **/
	private String telephone;
	/** 状态 **/
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

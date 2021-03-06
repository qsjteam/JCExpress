package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 角色实体
 * @Package: com.qsj.pojo
 * @author:作者 Mao
 * @date:创建时间 2018年1月13日 下午9:30:53
 */
public class Role implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	private int role_id;
	private String role_name;
	private String role_sign;
	private String status;
	private Date create_time;
	private String create_by;
	private Date update_time;
	private String update_by;
	private String remarks;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_sign() {
		return role_sign;
	}

	public void setRole_sign(String role_sign) {
		this.role_sign = role_sign;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

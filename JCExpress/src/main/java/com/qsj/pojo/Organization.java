package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 组织实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class Organization implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	private int org_id;
	private String org_name;
	private String status;
	private Date create_time;
	private String create_by;
	private Date update_time;
	private String update_by;
	private String remarks;

	@Override
	public String toString() {
		return "Organization [org_id=" + org_id + ", org_name=" + org_name + ", status=" + status + ", create_time="
				+ create_time + ", create_by=" + create_by + ", update_time=" + update_time + ", update_by=" + update_by
				+ ", remarks=" + remarks + "]";
	}

	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
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

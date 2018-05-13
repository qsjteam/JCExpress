package com.qsj.pojo;

import java.io.Serializable;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 定区实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class SysFixed implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int id;
	/** 定区编号 **/
	private String fixed_code;
	/** 取派员id **/
	private Integer staff_id;
	/** 定区名称 **/
	private String fixed_name;
	/** 状态 **/
	private String status;

	@Override
	public String toString() {
		return "SysFixed [id=" + id + ", fixed_code=" + fixed_code + ", staff_id=" + staff_id + ", fixed_name="
				+ fixed_name + ", status=" + status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFixed_code() {
		return fixed_code;
	}

	public void setFixed_code(String fixed_code) {
		this.fixed_code = fixed_code;
	}

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public String getFixed_name() {
		return fixed_name;
	}

	public void setFixed_name(String fixed_name) {
		this.fixed_name = fixed_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

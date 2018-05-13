package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 菜单实体
 * @Package: com.qsj.pojo
 * @author:作者 Mao
 * @date:创建时间 2018年1月4日 下午7:15:16
 */
public class Menu implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	// 菜单id
	private int menu_id;
	// 菜单标志
	private String menu_code;
	// 菜单父id
	private int parent_id;
	// 菜单类型
	private Integer menu_type;
	// 排序
	private int sort;
	// 菜单名字
	private String menu_name;
	// 菜单连接
	private String href;
	// 图标
	private String icon;
	// 状态
	private String status;
	// 权限
	private String permission;
	// 创建时间
	private Date create_time;
	// 创建人
	private String create_by;
	// 更新时间
	private Date update_time;
	// 更新人
	private String update_by;
	// 描述
	private String remarks;

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(Integer menu_type) {
		this.menu_type = menu_type;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getMenu_code() {
		return menu_code;
	}

	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
}

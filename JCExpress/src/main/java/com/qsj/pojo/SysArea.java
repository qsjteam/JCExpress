package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 区域实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class SysArea implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 区域id **/
	private int area_id;
	/** 行政区划代码 **/
	private String area_code;
	/** 父id **/
	private String parent_code;
	/** 地区名称 **/
	private String name;
	/** 层级 **/
	private String layer;
	/** 排序号,1:省级,2:地市,3:区县 **/
	private int order_num;
	/** 显示,1:显示,0:隐藏 **/
	private Integer status;
	/** 备注 **/
	private String remark;
	/** 创建时间 **/
	private Date create_time;
	/** 修改时间 **/
	private Date update_time;

	private Integer size;
	private Boolean isParent;

	@Override
	public String toString() {
		return "SysArea [area_id=" + area_id + ", area_code=" + area_code + ", parent_code=" + parent_code + ", name="
				+ name + ", layer=" + layer + ", order_num=" + order_num + ", status=" + status + ", remark=" + remark
				+ ", create_time=" + create_time + ", update_time=" + update_time + ", size=" + size + ", isParent="
				+ isParent + "]";
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public void checkParent() {
		if (size > 0) {
			this.isParent = true;
		} else {
			this.isParent = false;
		}
	}

}

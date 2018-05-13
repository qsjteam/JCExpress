package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 订单明细
 * @Package: com.qsj.pojo 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 上午11:42:12 
 */
public class ExOrderDetail implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 订单明细id **/
	private String id;
	/** 订单号 **/
	private String order_id;
	/** 订单重量 **/
	private String order_weight;
	/** 订单类型 **/
	private String order_type;
	/** 订单备注 **/
	private String order_remark;
	/** 订单图片 **/
	private String order_img;
	/** 创建时间 **/
	private Date create_time;
	/** 更新时间 **/
	private Date update_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_weight() {
		return order_weight;
	}

	public void setOrder_weight(String order_weight) {
		this.order_weight = order_weight;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public String getOrder_remark() {
		return order_remark;
	}

	public void setOrder_remark(String order_remark) {
		this.order_remark = order_remark;
	}

	public String getOrder_img() {
		return order_img;
	}

	public void setOrder_img(String order_img) {
		this.order_img = order_img;
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
}

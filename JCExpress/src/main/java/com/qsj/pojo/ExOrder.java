package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 订单实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class ExOrder implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 订单号 **/
	private String order_id;
	/** 寄件人姓名 **/
	private String send_name;
	/** 寄件人联系方式 **/
	private String send_telephone;
	/** 寄件人寄出地区 **/
	private String send_area;
	/** 寄件人详细地址 **/
	private String send_address;
	/** 收件人姓名 **/
	private String receive_name;
	/** 收件人联系方式 **/
	private String receive_telephone;
	/** 收件人收取地区 **/
	private String receive_area;
	/** 收件人详细地址 **/
	private String receive_address;
	/** 订单状态 **/
	private String status;
	/** 客户id **/
	private int customer_id;
	/** 更新时间 **/
	private Date update_time;
	/** 创建时间**/
	private Date create_time;

	@Override
	public String toString() {
		return "ExOrder [order_id=" + order_id + ", send_name=" + send_name + ", send_telephone=" + send_telephone
				+ ", send_area=" + send_area + ", send_address=" + send_address + ", receive_name=" + receive_name
				+ ", receive_telephone=" + receive_telephone + ", receive_area=" + receive_area + ", receive_address="
				+ receive_address + ", status=" + status + ", customer_id=" + customer_id + ", update_time="
				+ update_time + ", create_time=" + create_time + "]";
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getSend_telephone() {
		return send_telephone;
	}

	public void setSend_telephone(String send_telephone) {
		this.send_telephone = send_telephone;
	}

	public String getSend_area() {
		return send_area;
	}

	public void setSend_area(String send_area) {
		this.send_area = send_area;
	}

	public String getSend_address() {
		return send_address;
	}

	public void setSend_address(String send_address) {
		this.send_address = send_address;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public String getReceive_telephone() {
		return receive_telephone;
	}

	public void setReceive_telephone(String receive_telephone) {
		this.receive_telephone = receive_telephone;
	}

	public String getReceive_area() {
		return receive_area;
	}

	public void setReceive_area(String receive_area) {
		this.receive_area = receive_area;
	}

	public String getReceive_address() {
		return receive_address;
	}

	public void setReceive_address(String receive_address) {
		this.receive_address = receive_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
}

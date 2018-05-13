package com.qsj.pojo;

import java.io.Serializable;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 分区实体
 * @author qsjteam   
 * @date 2018-5-5
 */
public class SysPartition implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int id;
	/** 分区编号 **/
	private String partition_code;
	/** 关键字 **/
	private String addresskey;
	/** 单双号 **/
	private int single;
	/** 地址 **/
	private String address;
	/** 状态 **/
	private String status;
	/** 省 **/
	private String province;
	/** 市 **/
	private String city;
	/** 区 **/
	private String village;

	@Override
	public String toString() {
		return "SysPartition [id=" + id + ", partition_code=" + partition_code + ", addresskey=" + addresskey
				+ ", single=" + single + ", address=" + address + ", status=" + status + ", province=" + province
				+ ", city=" + city + ", village=" + village + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartition_code() {
		return partition_code;
	}

	public void setPartition_code(String partition_code) {
		this.partition_code = partition_code;
	}
	public String getAddresskey() {
		return addresskey;
	}
	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}
	public int getSingle() {
		return single;
	}
	public void setSingle(int single) {
		this.single = single;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
}

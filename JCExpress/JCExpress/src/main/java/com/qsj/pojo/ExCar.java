package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
public class ExCar implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	private int id;
	/** 车牌号 **/
	private String car_number;
	/** 车类型 **/
	private String car_type;
	/** 车载重 **/
	private String car_load;
	/** 状态 **/
	private String status;
	/** 车型号 **/
	private String car_model;
	/** 司机id **/
	private int driver_id;
	/** 创建时间 **/
	private Date create_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCar_number() {
		return car_number;
	}

	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getCar_load() {
		return car_load;
	}

	public void setCar_load(String car_load) {
		this.car_load = car_load;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

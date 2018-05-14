package com.qsj.pojo;

import java.io.Serializable;
import java.util.Date;

public class Prices implements Serializable {
	
	private static final long serialVersionUID = 4560113397159057916L;
	
	private int id;
	
	private String name;
	
	private int in_province;
	
	private int weight;
	
	private int timer;
	
	private double price;
	
	private String create_by;
	
	private Date create_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIn_province() {
		return in_province;
	}

	public void setIn_province(int in_province) {
		this.in_province = in_province;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "prices [id=" + id + ", name=" + name + ", in_province=" + in_province + ", weight=" + weight
				+ ", timer=" + timer + ", price=" + price + ", create_by=" + create_by + ", create_time=" + create_time
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_by == null) ? 0 : create_by.hashCode());
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + id;
		result = prime * result + in_province;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + timer;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prices other = (Prices) obj;
		if (create_by == null) {
			if (other.create_by != null)
				return false;
		} else if (!create_by.equals(other.create_by))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (id != other.id)
			return false;
		if (in_province != other.in_province)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (timer != other.timer)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
}

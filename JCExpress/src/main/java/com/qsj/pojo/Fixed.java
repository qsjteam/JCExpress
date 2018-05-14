package com.qsj.pojo;

import java.io.Serializable;

public class Fixed  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String fixed_code;
	
	private int staff_id;
	
	private String fixed_name;
	
	private String fixed_adress;
	
	private int status;

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

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getFixed_name() {
		return fixed_name;
	}

	public void setFixed_name(String fixed_name) {
		this.fixed_name = fixed_name;
	}

	public String getFixed_adress() {
		return fixed_adress;
	}

	public void setFixed_adress(String fixed_adress) {
		this.fixed_adress = fixed_adress;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fixed_adress == null) ? 0 : fixed_adress.hashCode());
		result = prime * result + ((fixed_code == null) ? 0 : fixed_code.hashCode());
		result = prime * result + ((fixed_name == null) ? 0 : fixed_name.hashCode());
		result = prime * result + id;
		result = prime * result + staff_id;
		result = prime * result + status;
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
		Fixed other = (Fixed) obj;
		if (fixed_adress == null) {
			if (other.fixed_adress != null)
				return false;
		} else if (!fixed_adress.equals(other.fixed_adress))
			return false;
		if (fixed_code == null) {
			if (other.fixed_code != null)
				return false;
		} else if (!fixed_code.equals(other.fixed_code))
			return false;
		if (fixed_name == null) {
			if (other.fixed_name != null)
				return false;
		} else if (!fixed_name.equals(other.fixed_name))
			return false;
		if (id != other.id)
			return false;
		if (staff_id != other.staff_id)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fixed [id=" + id + ", fixed_code=" + fixed_code + ", staff_id=" + staff_id + ", fixed_name="
				+ fixed_name + ", fixed_adress=" + fixed_adress + ", status=" + status + "]";
	}

	
}

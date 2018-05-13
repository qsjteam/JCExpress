package com.qsj.base.result;

import java.io.Serializable;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class BaseResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private Object data;
	private Integer code;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public BaseResult(String message) {
		super();
		this.message = message;
	}

	public BaseResult(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public BaseResult(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}
	
}

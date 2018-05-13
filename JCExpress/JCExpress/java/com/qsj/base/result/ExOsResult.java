package com.qsj.base.result;

import java.io.Serializable;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 统一返回结果类  
 * @Package: org.mao.base.result 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月18日 下午3:35:25 
 */
public class ExOsResult implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
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

	public ExOsResult(Object data) {
		super();
		this.data = data;
	}

	public ExOsResult(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}

	public ExOsResult(String message, Integer code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ExOsResult(Object data, Integer code) {
		super();
		this.data = data;
		this.code = code;
	}

}

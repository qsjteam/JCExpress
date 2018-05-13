package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.ExOrder;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class ExOrderVo extends ExOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String send_region;
	private String receive_region;

	public String getSend_region() {
		return send_region;
	}

	public void setSend_region(String send_region) {
		this.send_region = send_region;
	}

	public String getReceive_region() {
		return receive_region;
	}

	public void setReceive_region(String receive_region) {
		this.receive_region = receive_region;
	}

}

package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.ExOrder;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 下午2:52:16 
 */
public class ExOrderVo extends ExOrder implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
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

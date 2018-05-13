package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.SysPartition;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月7日 下午7:34:00 
 */
public class PartitionVo extends SysPartition implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}

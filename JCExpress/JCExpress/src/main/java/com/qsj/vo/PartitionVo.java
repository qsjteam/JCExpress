package com.qsj.vo;

import java.io.Serializable;

import com.qsj.pojo.SysPartition;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class PartitionVo extends SysPartition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}

package com.qsj.support.page;

import java.io.Serializable;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 分页 结果拼装实体
 * @Package: com.qsj.support.page 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月16日 下午11:34:09 
 */
public class PageResult implements Serializable{
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private Object rows;
	private Integer total;
	
	public PageResult(Object rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	
	public PageResult() {
		super();
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}
 
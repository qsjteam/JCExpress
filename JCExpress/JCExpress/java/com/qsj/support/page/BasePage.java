package com.qsj.support.page;

import java.io.Serializable;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 分页数据实体
 * @Package: com.qsj.support.page
 * @author:作者 Mao
 * @date:创建时间 2018年1月16日 下午10:00:08
 */
public class BasePage implements Serializable {
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	private static final long serialVersionUID = 1L;
	/** 总记录 */
	private int total;
	/** 总页数 */
	private int totalPage;
	/** 数据库中limit的参数，从第几条开始取 */
	private int offset;
	/** 每页显示的记录数 */
	private int limit;
	/** 当前页 */
	private int current;
	/** 排序字段 */
	private String sort;
	/** ASC,DESC mybatis Order 关键字 */
	private String order;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}

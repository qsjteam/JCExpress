package com.qsj.vo;

import java.io.Serializable;
import java.util.List;

import com.qsj.pojo.Menu;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.vo
 * @author:作者 Mao
 * @date:创建时间 2018年1月4日 下午11:06:59
 */
public class MenuVo extends Menu implements Serializable{
	// @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	private static final long serialVersionUID = 1L;
	private List<Menu> childMenus;

	public List<Menu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}

}

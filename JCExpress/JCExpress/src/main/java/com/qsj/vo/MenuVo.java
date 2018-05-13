package com.qsj.vo;

import java.io.Serializable;
import java.util.List;

import com.qsj.pojo.Menu;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class MenuVo extends Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Menu> childMenus;

	public List<Menu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}

}

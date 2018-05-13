package com.qsj.controller.menu;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Menu;
import com.qsj.pojo.User;
import com.qsj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.menu.controller 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月4日 下午8:24:47 
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	/**
	 * @Title: menuList  
	 * @Description: TODO(跳转显示菜单页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String menuList(Model model) {
		List<Menu> menus = menuService.menuList();
		model.addAttribute("menus", menus);
		return "views/menu/systemMenuList";
	}

	/**
	 * @Title: frozenMenu  
	 * @Description: TODO(启用/隐藏菜单)  
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{menuId}/frozenMenu", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozenMenu(@PathVariable("menuId") String menuId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = menuService.FrozenMenu(Integer.valueOf(menuId));
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createMenu  
	 * @Description: TODO(跳转创建菜单页面)  
	 * @param @param model
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{menuId}/createMenu", method = RequestMethod.GET)
	public String createMenu(Model model, @PathVariable("menuId") String menuId) {
		Menu parentMenu = menuService.findMenuById(Integer.valueOf(menuId));
		model.addAttribute("parentMenu", parentMenu);
		return "views/menu/systemMenuCreate";
	}

	/**
	 * @Title: createMenu  
	 * @Description: TODO(添加菜单)  
	 * @param @param menu
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createMenu(Menu menu) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = menuService.insertMenu(menu, activeUser.getUser_name());
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: icon  
	 * @Description: TODO(跳转到icon页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/icon", method = RequestMethod.GET)
	public String icon(Model model) {
		return "views/menu/systemMenuIcon";
	}

	/**
	 * @Title: deleteMenu  
	 * @Description: TODO(删除菜单)  
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{menuId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteMenu(@PathVariable("menuId") String menuId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = menuService.deleteMenu(Integer.valueOf(menuId));
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateMenu  
	 * @Description: TODO(跳转更新菜单页面)  
	 * @param @param model
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{menuId}/updateMenu", method = RequestMethod.GET)
	public String updateMenu(Model model, @PathVariable("menuId") String menuId) {
		Menu menu = menuService.findMenuById(Integer.valueOf(menuId));
		Menu parentMenu = menuService.findMenuById(menu.getParent_id());
		model.addAttribute("menu", menu);
		model.addAttribute("parentMenu", parentMenu);
		return "views/menu/systemMenuUpdate";
	}

	/**
	 * @Title: updateMenu  
	 * @Description: TODO(更新菜单)  
	 * @param @param menu
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{menuId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateMenu(Menu menu, @PathVariable("menuId") String menuId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			menu.setMenu_id(Integer.valueOf(menuId));
			Integer count = menuService.updateMenu(menu, activeUser.getUser_name());
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}
}

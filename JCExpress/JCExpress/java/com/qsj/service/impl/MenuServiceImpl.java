package com.qsj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qsj.dto.MenuDTO;
import com.qsj.mapper.MenuMapper;
import com.qsj.mapper.RoleMapper;
import com.qsj.pojo.Menu;
import com.qsj.pojo.Role;
import com.qsj.service.MenuService;
import com.qsj.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.menu.service
 * @author:作者 Mao
 * @date:创建时间 2018年1月4日 下午8:17:42
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * (non Javadoc) 
	 * @Title: menuList
	 * @Description:(得到所有菜单)
	 * @return 
	 * @see com.qsj.service.MenuService#menuList()
	 */
	@Override
	public List<Menu> menuList() {
		List<Menu> menus = new ArrayList<Menu>();
		// 得到第一级菜单
		List<Menu> parentMenus = menuMapper.findMenuByType(1);
		// 得到第二季菜单
		List<Menu> childMenus = menuMapper.findMenuByType(2);
		// 查询操作目录
		List<Menu> handleMenus = menuMapper.findMenuByType(0);
		for (Menu parentMenu : parentMenus) {
			menus.add(parentMenu);
			for (Menu childMenu : childMenus) {
				if (parentMenu.getMenu_id() == childMenu.getParent_id()) {
					menus.add(childMenu);
					for (Menu handleMenu : handleMenus) {
						if (childMenu.getMenu_id() == handleMenu.getParent_id()) {
							menus.add(handleMenu);
						}
					}
				}
			}
		}
		return menus;
	}

	/**
	 * @Title: recursionMenu  
	 * @Description: TODO(菜单的处理)  
	 * @param @param menus
	 * @param @param childMenus
	 * @param @param parentMenu    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	private void recursionMenu(List<MenuVo> menus, List<Menu> childMenus, Menu parentMenu) {
		List<Menu> childMenuList = new ArrayList<>();
		for (Menu menu : childMenus) {
			if (parentMenu.getMenu_id() == menu.getParent_id()) {
				childMenuList.add(menu);
			}
		}
		MenuVo parentMenuVo = new MenuVo();
		BeanUtils.copyProperties(parentMenu, parentMenuVo);
		parentMenuVo.setChildMenus(childMenuList);
		menus.add(parentMenuVo);
	}

	/**
	 * (non Javadoc) 
	 * @Title: getMenuByUserId
	 * @Description:(根据用户id获取菜单)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.MenuService#getMenuByUserId(java.lang.Integer)
	 */
	@Override
	public List<MenuVo> getMenuByUserId(Integer userId) {
		List<MenuVo> roleMenus = new ArrayList<MenuVo>();
		List<Role> roles = roleMapper.findRoleNameByRoleAndUser(userId);
		Set<Integer> roleIds = new HashSet<>();
		for (Role role : roles) {
			roleIds.add(role.getRole_id());
		}
		List<Menu> parentMenus = menuMapper.findMenuByRole(1, roleIds);
		List<Menu> childMenus = menuMapper.findMenuByRole(2, roleIds);
		for (Menu parentMenu : parentMenus) {
			recursionMenu(roleMenus, childMenus, parentMenu);
		}
		return roleMenus;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findMenuByStatus
	 * @Description:(根据状态查询菜单)
	 * @param status
	 * @return 
	 * @see com.qsj.service.MenuService#findMenuByStatus(java.lang.String)
	 */
	@Override
	public List<MenuDTO> findMenuByStatus(String status) {
		return menuMapper.findMenuByStatus(status);
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenMenu
	 * @Description:(启用/冻结菜单)
	 * @param status
	 * @param menuId
	 * @return 
	 * @see com.qsj.service.MenuService#FrozenMenu(java.lang.String, java.lang.Ineger)
	 */
	@Override
	public Integer FrozenMenu(Integer menuId) {
		Menu menu = this.findMenuById(menuId);
		if (menu != null && menu.getStatus().equals("0")) {
			return menuMapper.updateFrozenMenu("1", menuId);
		}
		if (menu != null && menu.getStatus().equals("1")) {
			return menuMapper.updateFrozenMenu("0", menuId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertMenu
	 * @Description:(创建菜单)
	 * @param menu
	 * @param createName
	 * @return 
	 * @see com.qsj.service.MenuService#insertMenu(com.qsj.pojo.Menu, java.lang.String)
	 */
	@Override
	public Integer insertMenu(Menu menu, String createName) {
		menu.setCreate_by(createName);
		menu.setCreate_time(new Date());
		menu.setUpdate_by(createName);
		menu.setUpdate_time(new Date());
		return menuMapper.insertMenu(menu);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findMenuById
	 * @Description:(根据菜单id查找菜单)
	 * @param menuId
	 * @return 
	 * @see com.qsj.service.MenuService#findMenuById(java.lang.Integer)
	 */
	@Override
	public Menu findMenuById(Integer menuId) {
		return menuMapper.findMenuById(menuId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteMenu
	 * @Description:(删除菜单)
	 * @param menuId
	 * @return 
	 * @see com.qsj.service.MenuService#deleteMenu(java.lang.Integer)
	 */
	@Override
	public Integer deleteMenu(Integer menuId) {
		Integer count = menuMapper.deleteMenu(menuId);
		menuMapper.deleteMenuRole(menuId);
		return count;
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateMenu
	 * @Description:(更新菜单)
	 * @param menu
	 * @param updateName
	 * @return 
	 * @see com.qsj.service.MenuService#updateMenu(com.qsj.pojo.Menu, java.lang.String)
	 */
	@Override
	public Integer updateMenu(Menu menu, String updateName) {
		menu.setUpdate_by(updateName);
		menu.setUpdate_time(new Date());
		return menuMapper.updateMenu(menu);
	}
}

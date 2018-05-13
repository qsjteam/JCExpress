package com.qsj.service;

import java.util.List;

import com.qsj.dto.MenuDTO;
import com.qsj.pojo.Menu;
import com.qsj.vo.MenuVo;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.menu.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月4日 下午8:17:21 
 */
public interface MenuService {
	List<Menu> menuList();

	List<MenuVo> getMenuByUserId(Integer userId);

	List<MenuDTO> findMenuByStatus(String status);

	Integer FrozenMenu(Integer menuId);

	Integer insertMenu(Menu menu, String createName);

	Menu findMenuById(Integer menuId);

	Integer deleteMenu(Integer menuId);

	Integer updateMenu(Menu menu, String updateName);
}

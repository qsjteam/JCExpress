package com.qsj.service;

import java.util.List;

import com.qsj.dto.MenuDTO;
import com.qsj.pojo.Menu;
import com.qsj.vo.MenuVo;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
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

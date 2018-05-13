package com.qsj.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import com.qsj.dto.MenuDTO;
import com.qsj.pojo.Menu;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.menu.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月4日 下午7:40:25 
 */
public interface MenuMapper {
	/**
	 * @Title: findMenuByType  
	 * @Description: TODO(查询菜单根据类型)  
	 * @param @param menuType
	 * @param @return    设定文件  
	 * @return List<Menu>    返回类型  
	 * @throws
	 */
	List<Menu> findMenuByType(@Param("menuType") Integer menuType);

	/**
	 * @Title: findMenuByRole  
	 * @Description: TODO(查询角色所拥有的菜单根据类型)  
	 * @param @param menuType
	 * @param @param roleIds
	 * @param @return    设定文件  
	 * @return List<Menu>    返回类型  
	 * @throws
	 */
	List<Menu> findMenuByRole(@Param("menuType") Integer menuType, @Param("roleIds") Set<Integer> roleIds);

	/**
	 * @Title: findMenuByStatus  
	 * @Description: TODO(查询菜单根据状态)  
	 * @param @param status
	 * @param @return    设定文件  
	 * @return List<MenuDTO>    返回类型  
	 * @throws
	 */
	List<MenuDTO> findMenuByStatus(@Param("status") String status);

	/**
	 * @Title: deleteRoleMenu  
	 * @Description: TODO(删除角色菜单表中的记录根据角色id)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteRoleMenu(@Param("roleId") Integer roleId);

	/**
	 * @Title: updateFrozenMenu  
	 * @Description: TODO(启用/隐藏菜单)  
	 * @param @param menuType
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenMenu(@Param("status") String status, @Param("menuId") Integer menuId);

	/**
	 * @Title: findMenuById  
	 * @Description: TODO(查询菜单根据id)  
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Menu    返回类型  
	 * @throws
	 */
	Menu findMenuById(@Param("menuId") Integer menuId);

	/**
	 * @Title: insertMenu  
	 * @Description: TODO(添加菜单)  
	 * @param @param menu
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertMenu(@Param("menu") Menu menu);

	/**
	 * @Title: deleteMenu  
	 * @Description: TODO(删除菜单)  
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteMenu(@Param("menuId") Integer menuId);

	/**
	 * @Title: deleteMenuRole  
	 * @Description: TODO(清除RoleMenu表中的冗余数据 )  
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteMenuRole(@Param("menuId") Integer menuId);

	/**
	 * @Title: updateMenu  
	 * @Description: TODO(修改菜单)  
	 * @param @param menu
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateMenu(@Param("menu") Menu menu);
}

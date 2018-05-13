package com.qsj.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.Menu;
import com.qsj.pojo.Role;
import com.qsj.pojo.RoleMenu;
import com.qsj.pojo.UserRole;
import com.qsj.support.page.BasePage;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.role.mapper
 * @author:作者 Mao
 * @date:创建时间 2018年1月13日 下午8:49:31
 */
public interface RoleMapper {
	/**
	 * @Title: findRoleNameByRoleAndUser  
	 * @Description: TODO(根据用户id查找角色列表)  
	 * @param @param userId
	 * @param @return    设定文件  
	 * @return List<Role>    返回类型  
	 * @throws
	 */
	List<Role> findRoleNameByRoleAndUser(@Param("userId") Integer userId);

	/**
	 * 
	 * @Title: findPermissionByRoleId  
	 * @Description: TODO(根据角色id列表查找权限列表)  
	 * @param @param roleIds
	 * @param @return    设定文件  
	 * @return Set<Role>    返回类型  
	 * @throws
	 */
	Set<Menu> findPermissionByRoleId(@Param("userId") Set<String> roleIds);

	/**
	 * 
	 * @Title: findAllRolesByStatus  
	 * @Description: TODO(查询所有可用的角色)  
	 * @param @param status
	 * @param @return    设定文件  
	 * @return List<Role>    返回类型  
	 * @throws
	 */
	List<Role> findAllRolesByStatus(@Param("status") String status);

	/**
	 * 
	 * @Title: insetUserRole  
	 * @Description: TODO(增加用户的角色)  
	 * @param @param userRole
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insetUserRole(@Param("userRoles") List<UserRole> userRoles);

	/**
	 * @Title: deleteUserRole  
	 * @Description: TODO(删除用户拥有的角色)  
	 * @param @param userId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteUserRole(@Param("userId") Integer userId);

	/**
	 * @Title: findAllRoles  
	 * @Description: TODO(查询所有的角色)  
	 * @param @return    设定文件  
	 * @return List<Role>    返回类型  
	 * @throws
	 */
	List<Role> findAllRolesByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: updateFrozenRole  
	 * @Description: TODO(启用冻结角色)  
	 * @param @param status
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenRole(@Param("status") String status, @Param("roleId") Integer roleId);

	/**
	 * @Title: findRoleById  
	 * @Description: TODO(查询角色根据Id)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Role    返回类型  
	 * @throws
	 */
	Role findRoleById(@Param("roleId") Integer roleId);

	/**
	 * @Title: insertRole  
	 * @Description: TODO(添加角色)  
	 * @param @param role
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertRole(Role role);

	/**
	 * @Title: insertRoleMenu  
	 * @Description: TODO(添加角色菜单)  
	 * @param @param roleMenus
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertRoleMenu(@Param("roleMenus") List<RoleMenu> roleMenus);

	/**
	 * @Title: findMenuIdByRoleId  
	 * @Description: TODO(根据角色id查找相应的菜单id)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return List<RoleMenu>    返回类型  
	 * @throws
	 */
	List<RoleMenu> findMenuIdByRoleId(@Param("roleId") Integer roleId);

	/**
	 * @Title: updateRole  
	 * @Description: TODO(更新角色)  
	 * @param @param role
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateRole(@Param("role") Role role);

	/**
	 * @Title: deleteRole  
	 * @Description: TODO(删除角色)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteRole(@Param("roleId") Integer roleId);

	/**
	 * @Title: deleteRoleUser  
	 * @Description: TODO(删除角色在用户角色表中的记录)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteRoleUser(@Param("roleId") Integer roleId);
}

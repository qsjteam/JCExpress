package com.qsj.service;

import java.util.List;
import java.util.Set;

import com.qsj.dto.UserDTO;
import com.qsj.pojo.Role;
import com.qsj.pojo.RoleMenu;
import com.qsj.pojo.UserRole;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.RoleMenuVo;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.role.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月13日 下午8:50:08 
 */
public interface RoleService {
	UserDTO getRolesByUserId(Integer userId);

	Set<String> getPermissions(Set<String> roleIds);

	List<Role> findRoleNameByRoleAndUser(Integer userId);

	List<Role> findAllRolesByStatus(String status);

	Integer insetUserRole(List<UserRole> userRoles);

	PageResult findAllRoles(String search, BasePage page);

	Integer FrozenRole(Integer roleId);

	Role findRoleById(Integer roleId);

	Integer insetRole(Role role, String[] menuIds, String createName);

	List<RoleMenu> findMenuIdByRoleId(Integer roleId);

	List<RoleMenuVo> findCheckMenu(Integer roleId);

	Integer updateRole(Role role, String[] menuIds, String updateName);

	Integer deleteRole(Integer roleId);
}

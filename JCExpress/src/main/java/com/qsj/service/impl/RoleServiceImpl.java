package com.qsj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import com.qsj.dto.MenuDTO;
import com.qsj.dto.UserDTO;
import com.qsj.mapper.MenuMapper;
import com.qsj.mapper.RoleMapper;
import com.qsj.pojo.Menu;
import com.qsj.pojo.Role;
import com.qsj.pojo.RoleMenu;
import com.qsj.pojo.UserRole;
import com.qsj.service.RoleService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.RoleMenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;

	/**
	 * (non Javadoc) 
	 * @Title: getRolesByUserId
	 * @Description:(根据角色id找到角色列表)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.RoleService#getRolesByUserId(java.lang.Integer)
	 */
	@Override
	public UserDTO getRolesByUserId(Integer userId) {
		List<Role> roles = this.findRoleNameByRoleAndUser(userId);
		Set<String> roleSigns = new HashSet<>();
		Set<String> roleIds = new HashSet<>();
		for (Role role : roles) {
			roleSigns.add(role.getRole_sign());
			roleIds.add(String.valueOf(role.getRole_id()));
		}
		return new UserDTO(roleSigns, roleIds);
	}

	/**
	 * (non Javadoc) 
	 * @Title: getPermissions
	 * @Description:(根据角色id列表查找权限列表)
	 * @param roleIds
	 * @return 
	 * @see com.qsj.service.RoleService#getPermissions(java.util.Set)
	 */
	@Override
	public Set<String> getPermissions(Set<String> roleIds) {
		Set<String> Permissions = new HashSet<>();
		Set<Menu> PermissionByRoleId = roleMapper.findPermissionByRoleId(roleIds);
		for (Menu menu : PermissionByRoleId) {
			if (StringUtils.isNotBlank(menu.getPermission())) {
				Permissions.add(menu.getPermission());
			}
		}
		return Permissions;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findRoleNameByRoleAndUser
	 * @Description:(查询角色名字根据用户id)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.RoleService#findRoleNameByRoleAndUser(java.lang.Integer)
	 */
	@Override
	public List<Role> findRoleNameByRoleAndUser(Integer userId) {
		return roleMapper.findRoleNameByRoleAndUser(userId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllRolesByStatus
	 * @Description:(根据状态查询所有角色)
	 * @param status
	 * @return 
	 * @see com.qsj.service.RoleService#findAllRolesByStatus(java.lang.String)
	 */
	@Override
	public List<Role> findAllRolesByStatus(String status) {
		return roleMapper.findAllRolesByStatus(status);
	}

	/**
	 * (non Javadoc) 
	 * @Title: insetUserRole
	 * @Description:(添加用户的角色)
	 * @param userRole
	 * @return 
	 * @see com.qsj.service.RoleService#insetUserRole(com.qsj.pojo.UserRole)
	 */
	@Override
	public Integer insetUserRole(List<UserRole> userRoles) {
		return roleMapper.insetUserRole(userRoles);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllRoles
	 * @Description:(查询所有的角色)
	 * @return 
	 * @see com.qsj.service.RoleService#findAllRoles()
	 */
	@Override
	public PageResult findAllRoles(String search, BasePage page) {
		List<Role> list = roleMapper.findAllRolesByPage(search, page);
		return new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenRole
	 * @Description:(启用冻结角色)
	 * @param status
	 * @param roleId
	 * @return 
	 * @see com.qsj.service.RoleService#FrozenRole(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer FrozenRole(Integer roleId) {
		Role role = this.findRoleById(roleId);
		if (role.getStatus() != null && role.getStatus().equals("0")) {
			return roleMapper.updateFrozenRole("1", roleId);
		}
		if (role.getStatus() != null && role.getStatus().equals("1")) {
			return roleMapper.updateFrozenRole("0", roleId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findRoleById
	 * @Description:(查询角色根据id)
	 * @param roleId
	 * @return 
	 * @see com.qsj.service.RoleService#findRoleById(java.lang.Integer)
	 */
	@Override
	public Role findRoleById(Integer roleId) {
		return roleMapper.findRoleById(roleId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: insetRole
	 * @Description:(创建角色)
	 * @param role
	 * @param menuIds
	 * @param createName
	 * @return 
	 * @see com.qsj.service.RoleService#insetRole(com.qsj.pojo.Role, java.lang.String[], java.lang.String)
	 */
	@Override
	public Integer insetRole(Role role, String[] menuIds, String createName) {
		role.setCreate_by(createName);
		role.setCreate_time(new Date());
		role.setUpdate_by(createName);
		role.setUpdate_time(new Date());
		Integer count = roleMapper.insertRole(role);
		if (menuIds != null && menuIds.length > 0 && !menuIds[0].equals("")) {
			List<RoleMenu> roleMenus = new ArrayList<>();
			for (int i = 0; i < menuIds.length; i++) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setCreate_by(createName);
				roleMenu.setCreate_time(new Date());
				roleMenu.setMenu_id(Integer.valueOf(menuIds[i]));
				roleMenu.setRole_id(role.getRole_id());
				roleMenus.add(roleMenu);
			}
			roleMapper.insertRoleMenu(roleMenus);
		}
		return count;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findMenuIdByRoleId
	 * @Description:(查询角色对应的菜单id)
	 * @param roleId
	 * @return 
	 * @see com.qsj.service.RoleService#findMenuIdByRoleId(java.lang.Integer)
	 */
	@Override
	public List<RoleMenu> findMenuIdByRoleId(Integer roleId) {
		return roleMapper.findMenuIdByRoleId(roleId);
	}

	/**
	 * @Title: findCheckMenu  
	 * @Description: TODO(遍历出选中的角色菜单)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return List<RoleMenuVo>    返回类型  
	 * @throws
	 */
	@Override
	public List<RoleMenuVo> findCheckMenu(Integer roleId) {
		// 所有可见菜单
		List<MenuDTO> menus = menuMapper.findMenuByStatus("1");
		// 用户所拥有的菜单id
		List<RoleMenu> RoleMenus = this.findMenuIdByRoleId(roleId);
		// 菜单vo列表
		List<RoleMenuVo> checkMenus = new ArrayList<>();
		for (MenuDTO menu : menus) {
			RoleMenuVo roleMenuVo = new RoleMenuVo();
			// 把menu对象中的拷贝到vo里
			BeanUtils.copyProperties(menu, roleMenuVo);
			for (RoleMenu roleMenu : RoleMenus) {
				if (roleMenu.getMenu_id() == menu.getMenu_id()) {
					roleMenuVo.setChecked(true);
				}
			}
			checkMenus.add(roleMenuVo);
		}
		return checkMenus;
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateRole
	 * @Description:(更新角色)
	 * @param role
	 * @param menuIds
	 * @param updateName
	 * @return 
	 * @see com.qsj.service.RoleService#updateRole(com.qsj.pojo.Role, java.lang.String[], java.lang.String)
	 */
	@Override
	public Integer updateRole(Role role, String[] menuIds, String updateName) {
		role.setUpdate_by(updateName);
		role.setUpdate_time(new Date());
		Integer count = roleMapper.updateRole(role);
		// 删除RoleMenu表的中记录
		menuMapper.deleteRoleMenu(role.getRole_id());
		// 添加角色菜单
		if (menuIds != null && menuIds.length > 0 && !menuIds[0].equals("")) {
			List<RoleMenu> roleMenus = new ArrayList<>();
			for (int i = 0; i < menuIds.length; i++) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setCreate_by(updateName);
				roleMenu.setCreate_time(new Date());
				roleMenu.setMenu_id(Integer.valueOf(menuIds[i]));
				roleMenu.setRole_id(role.getRole_id());
				roleMenus.add(roleMenu);
			}
			roleMapper.insertRoleMenu(roleMenus);
		}
		return count;
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteRole
	 * @Description:(删除角色)
	 * @param roleId
	 * @return 
	 * @see com.qsj.service.RoleService#deleteRole(java.lang.Integer)
	 */
	@Override
	public Integer deleteRole(Integer roleId) {
		// 删除RoleMenu表的中记录
		menuMapper.deleteRoleMenu(roleId);
		// 删除UserRole表中的记录
		roleMapper.deleteRoleUser(roleId);
		// 删除role
		Integer count = roleMapper.deleteRole(roleId);
		return count;
	}

}

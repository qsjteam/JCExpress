package com.qsj.controller.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.controller.BaseController;
import com.qsj.base.result.BaseResult;
import com.qsj.dto.MenuDTO;
import com.qsj.pojo.Role;
import com.qsj.pojo.User;
import com.qsj.service.MenuService;
import com.qsj.service.RoleService;
import com.qsj.service.UserService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.RoleMenuVo;
import com.qsj.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/role/list")
public class RoleListController extends BaseController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;

	/**
	 * @Title: roleList  
	 * @Description: TODO(跳转角色列表)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("roleList")
	public String roleList(Model model) {
		return "views/role/adminRoleList";
	}

	/**
	 * @Title: allRoles  
	 * @Description: TODO(显示所有的角色)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object allRoles(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return roleService.findAllRoles(search, page);
		}
		return new BaseResult("没有登录");
	}
	/**
	 * @Title: roleUser  
	 * @Description: TODO(跳转角色的用户列表)  
	 * @param @param roleId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}/roleUser")
	public String roleUser(@PathVariable("roleId") String roleId, Model model) {
		model.addAttribute("roleId", roleId);
		return "views/role/adminUserRole";
	}

	/**
	 * @Title: roleUsers  
	 * @Description: TODO(显示角色下的所有用户)  
	 * @param @param roleId
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}/roleUsers")
	@ResponseBody
	public Object roleUsers(@PathVariable("roleId") String roleId, BasePage page,
			@RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			List<UserVo> users = userService.findRoleUsersByPage(Integer.valueOf(roleId), search, page);
			return new PageResult(users, page.getTotal());
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozenRole  
	 * @Description: TODO(冻结/启用角色)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}/frozenRole")
	@ResponseBody
	public Object frozenRole(@PathVariable("roleId") Integer roleId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = roleService.FrozenRole(roleId);
			return new BaseResult("冻结成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createUser  
	 * @Description: TODO(跳转创建角色页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/createRole")
	public String createRole(Model model) {
		List<Map> list = new ArrayList<Map>();
		List<MenuDTO> menus = menuService.findMenuByStatus("1");
		for (MenuDTO menuDTO : menus) {
			Map map = new HashMap();
			map.put("menuId", menuDTO.getMenu_id());
			map.put("menuName", menuDTO.getMenu_name());
			map.put("parentId", menuDTO.getParent_id());
			if (menuDTO.getMenu_type() == 1 || menuDTO.getParent_id() == 0) {
				map.put("open", true);
			}
			list.add(map);
		}
		model.addAttribute("menus", JSONArray.fromObject(list));
		return "views/role/adminRoleCreate";
	}

	/**
	 * @Title: createRole  
	 * @Description: TODO(创建角色)  
	 * @param @param role
	 * @param @param menuId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createRole(Role role, @RequestParam(required = false, value = "menuIds") String menuIds) {
		String[] menuId = menuIds.split(",");
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = roleService.insetRole(role, menuId, activeUser.getUser_name());
			return new BaseResult("创建成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateUser  
	 * @Description: TODO(跳转角色更新页面)  
	 * @param @param roleId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}/updateRole")
	public String updateRole(@PathVariable("roleId") String roleId, Model model) {
		Role role = roleService.findRoleById(Integer.valueOf(roleId));
		model.addAttribute("role", role);
		List<Map> list = new ArrayList<Map>();
		List<RoleMenuVo> checkMenu = roleService.findCheckMenu(Integer.valueOf(roleId));
		for (RoleMenuVo roleMenuVo : checkMenu) {
			Map map = new HashMap();
			map.put("menuId", roleMenuVo.getMenu_id());
			map.put("menuName", roleMenuVo.getMenu_name());
			map.put("parentId", roleMenuVo.getParent_id());
			map.put("checked", roleMenuVo.isChecked());
			if (roleMenuVo.getMenu_type() == 1 || roleMenuVo.getParent_id() == 0) {
				map.put("open", true);
			}
			list.add(map);
		}
		model.addAttribute("menus", JSONArray.fromObject(list));
		return "views/role/adminRoleUpdate";
	}

	/**
	 * @Title: updateRole  
	 * @Description: TODO(更新角色)  
	 * @param @param role
	 * @param @param roleId
	 * @param @param menuIds
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateRole(Role role, @PathVariable("roleId") Integer roleId,
			@RequestParam(required = false, value = "menuIds") String menuIds) {
		String[] menuId = menuIds.split(",");
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			role.setRole_id(Integer.valueOf(roleId));
			Integer count = roleService.updateRole(role, menuId, activeUser.getUser_name());
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateRole  
	 * @Description: TODO(删除角色)  
	 * @param @param roleId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object updateRole(@PathVariable("roleId") Integer roleId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = roleService.deleteRole(roleId);
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}
}

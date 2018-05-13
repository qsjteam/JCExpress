package com.qsj.controller.organization;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.controller.BaseController;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Organization;
import com.qsj.pojo.User;
import com.qsj.service.OrganizationService;
import com.qsj.support.page.BasePage;
import com.qsj.vo.OrganizationVo;
import com.qsj.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Controller
@RequestMapping("/organization/list")
public class OrganizationController extends BaseController {
	@Autowired
	private OrganizationService organizationService;

	/**
	 * @Title: OrganizationList  
	 * @Description: TODO(跳转到组织页面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/organizationList")
	public String OrganizationList(Model model) {
		return "views/organization/adminOrganizationList";
	}

	/**
	 * @Title: allOrganizations  
	 * @Description: TODO(显示所有的组织)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object organizations(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return organizationService.findAllOrgByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: organizationUserList  
	 * @Description: TODO(跳转根据组织查询用户页面)  
	 * @param @param organizationId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}/organizationUserList", method = RequestMethod.GET)
	public String organizationUserList(@PathVariable("organizationId") String organizationId, Model model) {
		model.addAttribute("organizationId", organizationId);
		return "views/organization/adminUserOrganization";
	}

	/**
	 * @Title: organizationUsers  
	 * @Description: TODO(根据组织查询用户)  
	 * @param @param organizationId
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}/organizationUsers", method = RequestMethod.GET)
	@ResponseBody
	public Object organizationUsers(@PathVariable("organizationId") String organizationId, BasePage page,
			@RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return organizationService.findUserByOrgIdByPage(Integer.valueOf(organizationId), search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: organizationDetail  
	 * @Description: TODO(跳转组织详情)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/organizationDetail")
	public String organizationDetail(Model model) {
		List<OrganizationVo> OrganizationVos = organizationService.findOrganizationDetail();
		model.addAttribute("OrganizationVos", OrganizationVos);
		return "views/organization/adminOrganizationDetail";
	}

	/**
	 * @Title: organizationUserDetail  
	 * @Description: TODO(跳转组织下用户的详情)  
	 * @param @param model
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}/organizationUserDetail")
	public String organizationUserDetail(Model model, @PathVariable("organizationId") String organizationId) {
		List<UserVo> UserVos = organizationService.listUserDetail(Integer.valueOf(organizationId));
		model.addAttribute("UserVos", UserVos);
		return "views/organization/adminOrganizationUser";
	}

	/**
	 * @Title: createOrganization  
	 * @Description: TODO(跳转到添加组织界面)  
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/createOrganization")
	public String createOrganization(Model model) {
		return "views/organization/adminOrganizationCreate";
	}

	/**
	 * @Title: createOrganization  
	 * @Description: TODO(添加组织)  
	 * @param @param organization
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createOrganization(Organization organization) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = organizationService.insertOrg(organization, activeUser.getUser_name());
			return new BaseResult("增加成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateOrganization  
	 * @Description: TODO(跳转更新页面)  
	 * @param @param model
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}/updateOrganization")
	public String updateOrganization(Model model, @PathVariable("organizationId") String organizationId) {
		Organization organization = organizationService.findOrganById(Integer.valueOf(organizationId));
		model.addAttribute("organization", organization);
		return "views/organization/adminOrganizationUpdate";
	}

	/**
	 * @Title: updateOrganization  
	 * @Description: TODO(修改组织)  
	 * @param @param organization
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateOrganization(Organization organization, @PathVariable("organizationId") String organizationId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			organization.setOrg_id(Integer.valueOf(organizationId));
			Integer count = organizationService.updateOrg(organization, activeUser.getUser_name());
			return new BaseResult("修改成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deleteOrganization  
	 * @Description: TODO(删除组织)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteOrganization(@PathVariable("organizationId") String organizationId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = organizationService.deleteUserOrg(Integer.valueOf(organizationId));
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozenOrganization  
	 * @Description: TODO(冻结/启用 组织)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{organizationId}/frozenOrganization")
	@ResponseBody
	public Object frozenOrganization(@PathVariable("organizationId") String organizationId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = organizationService.FrozenOrg(Integer.valueOf(organizationId));
			return new BaseResult("冻结成功", count);
		}
		return new BaseResult("没有登录");
	}

}

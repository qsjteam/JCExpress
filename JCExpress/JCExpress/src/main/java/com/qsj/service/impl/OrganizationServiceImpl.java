package com.qsj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qsj.mapper.OrganizationMapper;
import com.qsj.mapper.RoleMapper;
import com.qsj.mapper.UserMapper;
import com.qsj.pojo.Organization;
import com.qsj.pojo.Role;
import com.qsj.pojo.User;
import com.qsj.service.OrganizationService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.OrganizationVo;
import com.qsj.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findOrganById
	 * @Description:(查询组织根据id)
	 * @param organId
	 * @return 
	 * @see com.qsj.service.OrganizationService#findOrganById(java.lang.Integer)
	 */
	@Override
	public Organization findOrganById(Integer organId) {
		return organizationMapper.findOrganById(organId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllOrgByStatus
	 * @Description:(根据状态查询所有的组织)
	 * @param status
	 * @return 
	 * @see com.qsj.service.OrganizationService#findAllOrgByStatus(java.lang.String)
	 */
	@Override
	public List<Organization> findAllOrgByStatus(String status) {
		return organizationMapper.findAllOrgByStatus(status);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllOrgByPage
	 * @Description:(查询所有的组织)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.OrganizationService#findAllOrgByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllOrgByPage(String search, BasePage page) {
		 List<Organization> list = organizationMapper.findAllOrgByPage(search, page);
		return  new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findUserByOrgIdByPage
	 * @Description:(根据组织id查询角色)
	 * @param organizationId
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.OrganizationService#findUserByOrgIdByPage(java.lang.Integer, java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findUserByOrgIdByPage(Integer organizationId, String search, BasePage page) {
		List<UserVo> list = organizationMapper.findUserByOrgIdByPage(organizationId, search, page);
		return  new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findOrganizationDetail
	 * @Description:(查看组织列表)
	 * @return 
	 * @see com.qsj.service.OrganizationService#findOrganizationDetail()
	 */
	@Override
	public List<OrganizationVo> findOrganizationDetail() {
		List<Organization> organizations = organizationMapper.findAllOrg();
		List<OrganizationVo> OrganizationVos = new ArrayList<>();
		for (Organization organization : organizations) {
			List<User> users = userMapper.findUserByOrgId(organization.getOrg_id());
			OrganizationVo OrganizationVo = new OrganizationVo();
			BeanUtils.copyProperties(organization, OrganizationVo);
			OrganizationVo.setUsers(users);
			OrganizationVo.setNumber(users.size());
			OrganizationVos.add(OrganizationVo);
		}
		return OrganizationVos;
	}

	/**
	 * (non Javadoc) 
	 * @Title: listUserDetail
	 * @Description:(查看组织详情)
	 * @param organizationId
	 * @return 
	 * @see com.qsj.service.OrganizationService#listUserDetail(java.lang.Integer)
	 */
	@Override
	public List<UserVo> listUserDetail(Integer organizationId) {
		List<UserVo> userVos = organizationMapper.findUserByOrgId(organizationId);
		for (UserVo userVo : userVos) {
			List<Role> roles = roleMapper.findRoleNameByRoleAndUser(userVo.getU_id());
			userVo.setRoles(roles);
		}
		return userVos;
	}

	/**
	 * @Title: insertOrg  
	 * @Description: TODO(添加组织)  
	 * @param @param organization
	 * @param @param createName
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	@Override
	public Integer insertOrg(Organization organization, String createName) {
		organization.setCreate_by(createName);
		organization.setCreate_time(new Date());
		organization.setUpdate_by(createName);
		organization.setUpdate_time(new Date());
		return organizationMapper.insertOrg(organization);
	}

	/**
	 * @Title: updateOrg  
	 * @Description: TODO(更新组织)  
	 * @param @param organization
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	@Override
	public Integer updateOrg(Organization organization, String updateName) {
		organization.setUpdate_by(updateName);
		organization.setUpdate_time(new Date());
		return organizationMapper.updateOrg(organization);
	}

	/**
	 * @Title: FrozenOrg  
	 * @Description: TODO(冻结 /启用 组织)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	@Override
	public Integer FrozenOrg(Integer organizationId) {
		Organization organization = this.findOrganById(organizationId);
		if (organization.getStatus().equals("0")) {
			return organizationMapper.updateFrozenOrg("1", organizationId);
		}
		if (organization.getStatus().equals("1")) {
			return organizationMapper.updateFrozenOrg("0", organizationId);
		}
		return null;
	}

	/**
	 * @Title: deleteUserOrg  
	 * @Description: TODO(删除组织)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	@Override
	public Integer deleteUserOrg(Integer organizationId) {
		// 清除用户表中残存的组织信息
		organizationMapper.deleteUserOrg(organizationId);
		return organizationMapper.deleteOrg(organizationId);
	}

}

package com.qsj.service;

import java.util.List;

import com.qsj.pojo.Organization;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.OrganizationVo;
import com.qsj.vo.UserVo;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.organization.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月18日 下午2:30:22 
 */
public interface OrganizationService {
	Organization findOrganById(Integer organId);

	List<Organization> findAllOrgByStatus(String status);

	PageResult findAllOrgByPage(String search, BasePage page);

	PageResult findUserByOrgIdByPage(Integer organizationId, String search, BasePage page);

	List<OrganizationVo> findOrganizationDetail();

	List<UserVo> listUserDetail(Integer organizationId);

	Integer insertOrg(Organization organization, String createName);

	Integer updateOrg(Organization organization,String updateName);

	Integer FrozenOrg(Integer organizationId);

	Integer deleteUserOrg(Integer organizationId);
}

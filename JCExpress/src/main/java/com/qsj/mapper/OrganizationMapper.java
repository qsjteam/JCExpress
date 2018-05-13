package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.Organization;
import com.qsj.support.page.BasePage;
import com.qsj.vo.UserVo;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface OrganizationMapper {
	/**
	 * @Title: findOrganById  
	 * @Description: TODO(查询组织根据id)  
	 * @param @param organId
	 * @param @return    设定文件  
	 * @return Organization    返回类型  
	 * @throws
	 */
	Organization findOrganById(@Param("organId") Integer organId);

	/**
	 * @Title: findAllOrgByStatus  
	 * @Description: TODO(根据状态寻找组织)  
	 * @param @param status
	 * @param @return    设定文件  
	 * @return List<Organization>    返回类型  
	 * @throws
	 */
	List<Organization> findAllOrgByStatus(@Param("status") String status);

	/**
	 * @Title: findAllOrgByPage  
	 * @Description: TODO(查询所有组织根据分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<Organization>    返回类型  
	 * @throws
	 */
	List<Organization> findAllOrgByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: findUserByOrgIdByPage  
	 * @Description: TODO(查询组织下的用户根据组织id分页)  
	 * @param @param organizationId
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<UserVo>    返回类型  
	 * @throws
	 */
	List<UserVo> findUserByOrgIdByPage(@Param("organizationId") Integer organizationId, @Param("search") String search,
			@Param("page") BasePage page);

	/**
	 * @Title: findAllOrg  
	 * @Description: TODO(查询所有的组织)  
	 * @param @return    设定文件  
	 * @return List<Organization>    返回类型  
	 * @throws
	 */
	List<Organization> findAllOrg();

	/**
	 * @Title: findUserByOrgId  
	 * @Description: TODO(查询组织下的用户根据组织的id)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return List<UserVo>    返回类型  
	 * @throws
	 */
	List<UserVo> findUserByOrgId(@Param("organizationId") Integer organizationId);

	/**
	 * @Title: insertOrg  
	 * @Description: TODO(添加组织)  
	 * @param @param organization
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrg(@Param("organization") Organization organization);

	/**
	 * @Title: updateOrg  
	 * @Description: TODO(更新组织)  
	 * @param @param organization
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateOrg(@Param("organization") Organization organization);

	/**
	 * @Title: deleteOrg  
	 * @Description: TODO(删除组织)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteOrg(@Param("organizationId") Integer organizationId);

	/**
	 * @Title: updateFrozenOrg  
	 * @Description: TODO(冻结/启用组织)  
	 * @param @param status
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenOrg(@Param("status") String status, @Param("organizationId") Integer organizationId);

	/**
	 * @Title: deleteUserOrg  
	 * @Description: TODO(删除组织后清除关联的用户)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteUserOrg(@Param("organizationId") Integer organizationId);

}

package com.qsj.support.tld;

import com.qsj.pojo.Organization;
import com.qsj.pojo.SysArea;
import com.qsj.service.OrganizationService;
import com.qsj.service.RegionService;
import com.qsj.util.SpringUtils;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.support.tld 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月18日 下午2:39:18 
 */
public class Functions {
	// 定义静态service
	private static OrganizationService organizationService;
	private static RegionService regionService;

	// 通过封装的SpringUtils得到bean
	public static OrganizationService getOrganizationService() {
		if (organizationService == null) {
			organizationService = SpringUtils.getBean(OrganizationService.class);
		}
		return organizationService;
	}

	public static RegionService getRegionService() {
		if (regionService == null) {
			regionService = SpringUtils.getBean(RegionService.class);
		}
		return regionService;
	}

	/**
	 * @Title: organizationName  
	 * @Description: TODO(得到组织名字)  
	 * @param @param organizationId
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	public static String organizationName(Integer organizationId) {
		Organization organization = getOrganizationService().findOrganById(organizationId);
		if (organization == null) {
			return "";
		}
		return organization.getOrg_name();
	}

	/**
	 * @Title: regionName  
	 * @Description: TODO(得到区域名字)  
	 * @param @param areaCode
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	public static String regionName(String areaCode) {
		SysArea sysArea = getRegionService().findReginNameById(areaCode);
		if (sysArea == null) {
			return "国内";
		}
		return sysArea.getName();
	}

}

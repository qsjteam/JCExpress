package com.qsj.service;

import java.util.List;

import com.qsj.pojo.SysArea;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface RegionService {
	List<SysArea> findReginByParentCode(String parentCode);

	PageResult findReginByAreaCodeByPage(String areaCode, BasePage page);

	SysArea findReginNameById(String areaCode);

	Integer insertRegin(SysArea area);

	Integer FrozenRegin(Integer areaId);

	SysArea findReginByAreaId(Integer areaId);

	Integer updateRegin(SysArea area);

	Integer deleteRegin(Integer areaId);

	List<SysArea> findStatusReginByParentCode(String parentCode);
	
	List<SysArea> findAllReginNotIsProvince();
}

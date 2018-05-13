package com.qsj.service;

import java.util.List;

import com.qsj.pojo.SysArea;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.region.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月1日 下午8:18:32 
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

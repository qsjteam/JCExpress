package com.qsj.service.impl;

import java.util.Date;
import java.util.List;

import com.qsj.mapper.RegionMapper;
import com.qsj.pojo.SysArea;
import com.qsj.service.RegionService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
@Service("regionService")
public class RegionServiceImpl implements RegionService {
	@Autowired
	private RegionMapper reginMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findReginByParentCode
	 * @Description:(根据父Id查询区域)
	 * @param parentCode
	 * @return 
	 * @see com.qsj.service.RegionService#findReginByParentCode(java.lang.String)
	 */
	@Override
	public List<SysArea> findReginByParentCode(String parentCode) {
		return reginMapper.findReginByParentCode(parentCode);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findReginByAreaCodeByPage
	 * @Description:(根据行政id查找区域并分页)
	 * @param areaCode
	 * @param page
	 * @return 
	 * @see com.qsj.service.RegionService#findReginByAreaCodeByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findReginByAreaCodeByPage(String areaCode, BasePage page) {
		List<SysArea> list = reginMapper.findReginByAreaCodeByPage(areaCode, page);
		return new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findReginNameById
	 * @Description:(根据区域id查询区域)
	 * @param areaCode
	 * @return 
	 * @see com.qsj.service.RegionService#findReginNameById(java.lang.String)
	 */
	@Override
	public SysArea findReginNameById(String areaCode) {
		return reginMapper.findReginById(areaCode);
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertRegin
	 * @Description:(添加区域)
	 * @param area
	 * @return 
	 * @see com.qsj.service.RegionService#insertRegin(com.qsj.pojo.SysArea)
	 */
	@Override
	public Integer insertRegin(SysArea area) {
		if (area.getParent_code().equals("0")) {
			area.setLayer("1");
		} else {
			SysArea sysArea = reginMapper.findReginById(area.getParent_code());
			if (sysArea.getLayer().equals("1")) {
				area.setLayer("2");
			}
			if (sysArea.getLayer().equals("2")) {
				area.setLayer("3");
			}
		}
		area.setCreate_time(new Date());
		return reginMapper.insertRegin(area);
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenRegin
	 * @Description:(启用/冻结区域)
	 * @param status
	 * @param areaId
	 * @return 
	 * @see com.qsj.service.RegionService#FrozenRegin(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer FrozenRegin(Integer areaId) {
		SysArea sysArea = this.findReginByAreaId(areaId);
		if (sysArea.getStatus() != null && sysArea.getStatus() == 0) {
			return reginMapper.updateFrozenRegin(1, areaId);
		}
		if (sysArea.getStatus() != null && sysArea.getStatus() == 1) {
			return reginMapper.updateFrozenRegin(0, areaId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findReginByAreaId
	 * @Description:(查询区域根据主键)
	 * @param areaId
	 * @return 
	 * @see com.qsj.service.RegionService#findReginByAreaId(java.lang.Integer)
	 */
	@Override
	public SysArea findReginByAreaId(Integer areaId) {
		return reginMapper.findReginByAreaId(areaId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateRegin
	 * @Description:(更新区域)
	 * @param area
	 * @return 
	 * @see com.qsj.service.RegionService#updateRegin(com.qsj.pojo.SysArea)
	 */
	@Override
	public Integer updateRegin(SysArea area) {
		area.setUpdate_time(new Date());
		return reginMapper.updateRegin(area);
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteRegin
	 * @Description:(删除组织)
	 * @param areaId
	 * @return 
	 * @see com.qsj.service.RegionService#deleteRegin(java.lang.Integer)
	 */
	@Override
	public Integer deleteRegin(Integer areaId) {
		return reginMapper.deleteRegin(areaId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findStatusReginByParentCode
	 * @Description:(根据父id查询可用的区域)
	 * @param parentCode
	 * @return 
	 * @see com.qsj.service.RegionService#findStatusReginByParentCode(java.lang.String)
	 */
	@Override
	public List<SysArea> findStatusReginByParentCode(String parentCode) {
		return reginMapper.findStatusReginByParentCode(parentCode);
	}

	/**
	 * @Title: findAllReginNotIsProvince  
	 * @Description: TODO(查询不是省份的区域)  
	 * @param @return    设定文件  
	 * @return List<SysArea>    返回类型  
	 * @throws
	 */
	@Override
	public List<SysArea> findAllReginNotIsProvince() {
		return reginMapper.findAllReginNotIsProvince();
	}

}

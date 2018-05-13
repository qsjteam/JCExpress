package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.SysArea;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface RegionMapper {
	/**
	 * @Title: findReginByParentCode  
	 * @Description: TODO(根据父ID寻找区域)  
	 * @param @param parentCode
	 * @param @return    设定文件  
	 * @return List<SysArea>    返回类型  
	 * @throws
	 */
	List<SysArea> findReginByParentCode(@Param("parentCode") String parentCode);

	/**
	 * @Title: findReginByAreaCodeByPage  
	 * @Description: TODO(查询区域根据 区域id)  
	 * @param @param areaCode
	 * @param @return    设定文件  
	 * @return List<SysArea>    返回类型  
	 * @throws
	 */
	List<SysArea> findReginByAreaCodeByPage(@Param("areaCode") String areaCode, @Param("page") BasePage page);

	/**
	 * @Title: findReginNameById  
	 * @Description: TODO(根据区域id查询区域)  
	 * @param @param areaCode
	 * @param @return    设定文件  
	 * @return SysArea    返回类型  
	 * @throws
	 */
	SysArea findReginById(@Param("areaCode") String areaCode);

	/**
	 * @Title: insertRegin  
	 * @Description: TODO(增加区域)  
	 * @param @param area
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertRegin(@Param("area") SysArea area);

	/**
	 * @Title: updateFrozenRegin  
	 * @Description: TODO(启用/隐藏区域)  
	 * @param @param status
	 * @param @param areaId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenRegin(@Param("status") Integer status, @Param("areaId") Integer areaId);

	/**
	 * @Title: findReginByAreaId  
	 * @Description: TODO(查询区域根据主键)  
	 * @param @param areaId
	 * @param @return    设定文件  
	 * @return SysArea    返回类型  
	 * @throws
	 */
	SysArea findReginByAreaId(@Param("areaId") Integer areaId);

	/**
	 * @Title: updateRegin  
	 * @Description: TODO(更新区域)  
	 * @param @param area
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateRegin(@Param("area") SysArea area);

	/**
	 * @Title: deleteRegin  
	 * @Description: TODO(删除区域)  
	 * @param @param areaId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteRegin(@Param("areaId") Integer areaId);

	/**
	 * @Title: findStatusReginByParentCode  
	 * @Description: TODO(查询可用的区域根据父id)  
	 * @param @param parentCode
	 * @param @return    设定文件  
	 * @return List<SysArea>    返回类型  
	 * @throws
	 */
	List<SysArea> findStatusReginByParentCode(@Param("parentCode") String parentCode);

	/**
	 * @Title: findAllReginNotIsProvince  
	 * @Description: TODO(查询所有不是省份的地区 )  
	 * @param @return    设定文件  
	 * @return List<SysArea>    返回类型  
	 * @throws
	 */
	List<SysArea> findAllReginNotIsProvince();
}

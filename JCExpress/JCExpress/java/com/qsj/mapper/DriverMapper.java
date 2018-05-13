package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.Driver;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午3:58:00 
 */
public interface DriverMapper {
	List<Driver> findAllDriverByPage(@Param("search") String search, @Param("page") BasePage page);

	Driver findDriverById(@Param("driverId") Integer driverId);

	Integer updateFrozenDriver(@Param("status") String status, @Param("driverId") Integer driverId);

	Integer insertDriver(@Param("driver") Driver driver);

	Integer updateDriver(@Param("driver") Driver driver);

	Integer deleteDriver(@Param("driverId") Integer driverId);

	List<Driver> findStatusDriver();
}

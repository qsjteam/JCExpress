package com.qsj.service;

import java.util.List;

import com.qsj.pojo.Driver;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午4:58:50 
 */
public interface DriverService {
	PageResult findAllDriverByPage(String search, BasePage page);

	Driver findDriverById(Integer driverId);

	Integer FrozenDriver(Integer driverId);

	Integer insertDriver(Driver driver);

	Integer updateDriver(Driver driver);

	Integer deleteDriver(Integer driverId);

	List<Driver> findStatusDriver();
}

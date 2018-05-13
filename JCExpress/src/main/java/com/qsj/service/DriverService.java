package com.qsj.service;

import java.util.List;

import com.qsj.pojo.Driver;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
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

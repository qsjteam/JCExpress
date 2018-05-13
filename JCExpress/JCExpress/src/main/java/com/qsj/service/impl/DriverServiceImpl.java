package com.qsj.service.impl;

import java.util.List;

import com.qsj.mapper.DriverMapper;
import com.qsj.pojo.Driver;
import com.qsj.service.DriverService;
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
@Service("driverService")
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverMapper driverMapper;

	@Override
	public PageResult findAllDriverByPage(String search, BasePage page) {
		List<Driver> list = driverMapper.findAllDriverByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	@Override
	public Driver findDriverById(Integer driverId) {
		return driverMapper.findDriverById(driverId);
	}

	@Override
	public Integer FrozenDriver(Integer driverId) {
		Driver driver = this.findDriverById(driverId);
		if (driver != null && driver.getStatus().equals("0")) {
			return driverMapper.updateFrozenDriver("1", driverId);
		}
		if (driver != null && driver.getStatus().equals("1")) {
			return driverMapper.updateFrozenDriver("0", driverId);
		}
		return null;
	}

	@Override
	public Integer insertDriver(Driver driver) {
		return driverMapper.insertDriver(driver);
	}

	@Override
	public Integer updateDriver(Driver driver) {
		return driverMapper.updateDriver(driver);
	}

	@Override
	public Integer deleteDriver(Integer driverId) {
		return driverMapper.deleteDriver(driverId);
	}

	@Override
	public List<Driver> findStatusDriver() {
		return driverMapper.findStatusDriver();
	}

}

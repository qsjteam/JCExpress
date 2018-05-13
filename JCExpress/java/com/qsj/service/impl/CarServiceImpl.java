package com.qsj.service.impl;

import java.util.Date;
import java.util.List;

import com.qsj.mapper.CarMapper;
import com.qsj.pojo.ExCar;
import com.qsj.service.CarService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.ExCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service.impl 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午4:37:08 
 */
@Service("carService")
public class CarServiceImpl implements CarService {
	@Autowired
	private CarMapper carMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findAllCarByPage
	 * @Description:(查询车辆 分页)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.CarService#findAllCarByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllCarByPage(String search, BasePage page) {
		List<ExCarVo> list = carMapper.findAllCarByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findCarById
	 * @Description:(根据id查询车辆)
	 * @param carId
	 * @return 
	 * @see com.qsj.service.CarService#findCarById(java.lang.Integer)
	 */
	@Override
	public ExCar findCarById(Integer carId) {
		return carMapper.findCarById(carId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateFrozenCar
	 * @Description:(启用/冻结车辆)
	 * @param carId
	 * @return 
	 * @see com.qsj.service.CarService#updateFrozenCar(java.lang.Integer)
	 */
	@Override
	public Integer FrozenCar(Integer carId) {
		ExCar exCar = this.findCarById(carId);
		if (exCar != null && exCar.getStatus().equals("0")) {
			return carMapper.updateFrozenCar("1", carId);
		}
		if (exCar != null && exCar.getStatus().equals("1")) {
			return carMapper.updateFrozenCar("0", carId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertCar
	 * @Description:(添加车辆)
	 * @param car
	 * @return 
	 * @see com.qsj.service.CarService#insertCar(com.qsj.pojo.ExCar)
	 */
	@Override
	public Integer insertCar(ExCar car) {
		car.setCreate_time(new Date());
		return carMapper.insertCar(car);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateCar
	 * @Description:(修改车辆)
	 * @param car
	 * @return 
	 * @see com.qsj.service.CarService#updateCar(com.qsj.pojo.ExCar)
	 */
	@Override
	public Integer updateCar(ExCar car) {
		return carMapper.updateCar(car);
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteCar
	 * @Description:(删除车辆)
	 * @param carId
	 * @return 
	 * @see com.qsj.service.CarService#deleteCar(java.lang.Integer)
	 */
	@Override
	public Integer deleteCar(Integer carId) {
		return carMapper.deleteCar(carId);
	}

}

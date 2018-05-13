package com.qsj.service;

import com.qsj.pojo.ExCar;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午4:36:45 
 */
public interface CarService {
	PageResult findAllCarByPage(String search, BasePage page);

	ExCar findCarById(Integer carId);

	Integer FrozenCar(Integer carId);

	Integer insertCar(ExCar car);

	Integer updateCar(ExCar car);

	Integer deleteCar(Integer carId);
}

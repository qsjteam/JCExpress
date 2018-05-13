package com.qsj.service;

import com.qsj.pojo.ExCar;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface CarService {
	PageResult findAllCarByPage(String search, BasePage page);

	ExCar findCarById(Integer carId);

	Integer FrozenCar(Integer carId);

	Integer insertCar(ExCar car);

	Integer updateCar(ExCar car);

	Integer deleteCar(Integer carId);
}

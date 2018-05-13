package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.ExCar;
import com.qsj.support.page.BasePage;
import com.qsj.vo.ExCarVo;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月11日 下午3:56:44 
 */
public interface CarMapper {
	/**
	 * @Title: findAllCarByPage  
	 * @Description: TODO(查询所有的车辆 分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<ExCarVo>    返回类型  
	 * @throws
	 */
	List<ExCarVo> findAllCarByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * 
	 * @Title: findCarById  
	 * @Description: TODO(根据id寻找车辆)  
	 * @param @param carId
	 * @param @return    设定文件  
	 * @return ExCar    返回类型  
	 * @throws
	 */
	ExCar findCarById(@Param("carId") Integer carId);

	/**
	 * @Title: updateFrozenCar  
	 * @Description: TODO(启用/冻结用户)  
	 * @param @param status
	 * @param @param carId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenCar(@Param("status") String status, @Param("carId") Integer carId);

	/**
	 * @Title: insertCar  
	 * @Description: TODO(增加车辆)  
	 * @param @param car
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertCar(@Param("car") ExCar car);

	/**
	 * 
	 * @Title: updateCar  
	 * @Description: TODO(修改车辆)  
	 * @param @param car
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateCar(@Param("car") ExCar car);

	/**
	 * @Title: deleteCar  
	 * @Description: TODO(删除车辆)  
	 * @param @param carId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteCar(@Param("carId") Integer carId);
}

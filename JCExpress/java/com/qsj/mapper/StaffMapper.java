package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.Staff;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月9日 上午11:16:46 
 */
public interface StaffMapper {
	/**
	 * @Title: findStatusStaff  
	 * @Description: TODO(查询所有未冻结的取派员)  
	 * @param @return    设定文件  
	 * @return List<Staff>    返回类型  
	 * @throws
	 */
	List<Staff> findStatusStaff();

	/**
	 * @Title: findAllStaffByPage  
	 * @Description: TODO(查询所有的取派员 分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<Staff>    返回类型  
	 * @throws
	 */
	List<Staff> findAllStaffByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: findStaffById  
	 * @Description: TODO(查询取派员根据id)  
	 * @param @param staffId
	 * @param @return    设定文件  
	 * @return Staff    返回类型  
	 * @throws
	 */
	Staff findStaffById(@Param("staffId") Integer staffId);

	/**
	 * @Title: insertStaff  
	 * @Description: TODO(添加取派员)  
	 * @param @param staff
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertStaff(@Param("staff") Staff staff);

	/**
	 * @Title: updateFrozenStaff  
	 * @Description: TODO(冻结/启用取派员)  
	 * @param @param status
	 * @param @param staffId    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	Integer updateFrozenStaff(@Param("status") String status, @Param("staffId") Integer staffId);

	/**
	 * @Title: updateStaff  
	 * @Description: TODO(更新取派员)  
	 * @param @param staff
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateStaff(@Param("staff") Staff staff);

	/**
	 * @Title: deleteStaff  
	 * @Description: TODO(删除取派员)  
	 * @param @param staffId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteStaff(@Param("staffId") Integer staffId);
}

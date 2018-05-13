package com.qsj.service;

import java.util.List;

import com.qsj.pojo.Staff;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月9日 上午11:22:04 
 */
public interface StaffService {
	List<Staff> findStatusStaff();

	PageResult findAllStaffByPage(String search, BasePage page);

	Staff findStaffById(Integer staffId);

	Integer insertStaff(Staff staff);

	Integer FrozenStaff(Integer staffId);

	Integer updateStaff(Staff staff);

	Integer deleteStaff(Integer staffId);
}

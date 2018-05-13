package com.qsj.service;

import java.util.List;

import com.qsj.pojo.Staff;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
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

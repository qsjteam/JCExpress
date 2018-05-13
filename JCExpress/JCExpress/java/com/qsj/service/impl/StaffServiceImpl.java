package com.qsj.service.impl;

import java.util.List;

import com.qsj.mapper.StaffMapper;
import com.qsj.pojo.Staff;
import com.qsj.service.StaffService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service.impl 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月9日 上午11:22:42 
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffMapper staffMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findStatusStaff
	 * @Description:(查询所有未冻结的取派员)
	 * @return 
	 * @see com.qsj.service.StaffService#findStatusStaff()
	 */
	@Override
	public List<Staff> findStatusStaff() {
		return staffMapper.findStatusStaff();
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllStaffByPage
	 * @Description:(查询所有取派员 分页)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.StaffService#findAllStaffByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllStaffByPage(String search, BasePage page) {
		List<Staff> list = staffMapper.findAllStaffByPage(search, page);
		return new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findStaffById
	 * @Description:(根据id查询取派员)
	 * @param staffId
	 * @return 
	 * @see com.qsj.service.StaffService#findStaffById(java.lang.Integer)
	 */
	@Override
	public Staff findStaffById(Integer staffId) {
		return staffMapper.findStaffById(staffId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertStaff
	 * @Description:(添加取派员
	 * @param staff
	 * @return 
	 * @see com.qsj.service.StaffService#insertStaff(com.qsj.pojo.Staff)
	 */
	@Override
	public Integer insertStaff(Staff staff) {
		return staffMapper.insertStaff(staff);
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenStaff
	 * @Description:(冻结启用取派员)
	 * @param staffId
	 * @return 
	 * @see com.qsj.service.StaffService#FrozenStaff(java.lang.Integer)
	 */
	@Override
	public Integer FrozenStaff(Integer staffId) {
		Staff staff = this.findStaffById(staffId);
		if (staff != null && staff.getStatus().equals("0")) {
			return staffMapper.updateFrozenStaff("1", staffId);
		}
		if (staff != null && staff.getStatus().equals("1")) {
			return staffMapper.updateFrozenStaff("0", staffId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateStaff
	 * @Description:(更新取派员)
	 * @param staff
	 * @return 
	 * @see com.qsj.service.StaffService#updateStaff(com.qsj.pojo.Staff)
	 */
	@Override
	public Integer updateStaff(Staff staff) {
		return staffMapper.updateStaff(staff);
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteStaff
	 * @Description:(删除取派员)
	 * @param staffId
	 * @return 
	 * @see com.qsj.service.StaffService#deleteStaff(java.lang.Integer)
	 */
	@Override
	public Integer deleteStaff(Integer staffId) {
		return staffMapper.deleteStaff(staffId);
	}

}

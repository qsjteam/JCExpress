package com.qsj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qsj.exception.ValidateException;
import com.qsj.mapper.RoleMapper;
import com.qsj.mapper.UserMapper;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;
import com.qsj.pojo.UserRole;
import com.qsj.service.UserService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.util.RandomHeadUtil;
import com.qsj.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.user.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月16日 下午2:53:55 
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findUserById
	 * @Description:(查询用户信息根据用户id)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.UserService#findUserById(java.lang.Integer)
	 */
	@Override
	public User findUserById(Integer userId) {
		return userMapper.findUserById(userId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findUserLoginLogById
	 * @Description:(查询用户登录日志根据用户id)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.UserService#findUserLoginLogById(java.lang.Integer)
	 */
	@Override
	public PageResult findUserLoginLogById(Integer userId, String search, BasePage page) {
		List<LoginLog> list = userMapper.findUserLoginLogByPage(userId, search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateUserInfo
	 * @Description:(更新用户个人信息)
	 * @param user
	 * @return 
	 * @see com.qsj.service.UserService#updateUserInfo(com.qsj.pojo.User)
	 */
	@Override
	public Integer updateUserInfo(User user) {
		Integer updNum = userMapper.updateUserInfo(user);
		if (updNum > 0) {
			return updNum;
		}
		return 0;
	}

	/**
	 * (non Javadoc) 
	 * @Title: updatePassword
	 * @Description:(修改密码)
	 * @param nowPassword
	 * @param newPassword
	 * @param userId
	 * @return 
	 * @see com.qsj.service.UserService#updatePassword(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer updatePassword(String nowPassword, String newPassword, Integer userId) {
		User user = this.findUserById(userId);
		if (user.getPassword() == null || !user.getPassword().equals(nowPassword)) {
			throw new ValidateException("请检查您输入的密码是否正确");
		}
		return userMapper.updatePassword(newPassword, userId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllUser
	 * @Description:(查询所有的用户列表)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.UserService#findAllUser(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllUser(String search, BasePage page) {
		List<UserVo> list = userMapper.findAllUserByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateFrozenUser
	 * @Description:(冻结或者启用用户)
	 * @param status
	 * @param UserId
	 * @return 
	 * @see com.qsj.service.UserService#updateFrozenUser(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer frozenUser(Integer userId) {
		User user = this.findUserById(userId);
		if (user != null && user.getStatus().equals("0")) {
			return userMapper.updateFrozenUser("1", userId);
		}
		if (user != null && user.getStatus().equals("1")) {
			return userMapper.updateFrozenUser("0", userId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: createUser
	 * @Description:(添加用户)
	 * @param user
	 * @return 
	 * @see com.qsj.service.UserService#createUser(com.qsj.pojo.User)
	 */
	@Override
	public Integer createUser(User user, String[] roleIds, String createName) throws ValidateException {
		user.setCreate_by(createName);
		user.setCreate_time(new Date());
		user.setPic_img(RandomHeadUtil.RandomHeadImage());
		user.setUpdate_by(createName);
		if (this.checkName(user.getLogin_name())) {
			throw new ValidateException("该用户名已经被占用");
		}
		Integer insertUser = userMapper.insertUser(user);
		if (roleIds != null && roleIds.length > 0) {
			List<UserRole> userRoles = new ArrayList<>();
			for (int i = 0; i < roleIds.length; i++) {
				UserRole userRole = new UserRole();
				userRole.setCreate_by(createName);
				userRole.setCreate_time(new Date());
				userRole.setRole_id(Integer.valueOf(roleIds[i]));
				userRole.setUser_id(user.getU_id());
				userRoles.add(userRole);
			}
			roleMapper.insetUserRole(userRoles);
		}
		return insertUser;
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateUser
	 * @Description:(更新用户)
	 * @param user
	 * @param roleIds
	 * @param updateName
	 * @return 
	 * @see com.qsj.service.UserService#updateUser(com.qsj.pojo.User, java.lang.String[], java.lang.String)
	 */
	@Override
	public Integer updateUser(User user, String[] roleIds, String updateName) throws ValidateException {
		user.setUpdate_by(updateName);
		Integer count = userMapper.updateUser(user);
		// 删除UserRole表中的用户记录
		roleMapper.deleteUserRole(user.getU_id());
		// 添加角色
		if (roleIds != null && roleIds.length > 0) {
			List<UserRole> userRoles = new ArrayList<>();
			for (int i = 0; i < roleIds.length; i++) {
				UserRole userRole = new UserRole();
				userRole.setCreate_by(updateName);
				userRole.setCreate_time(new Date());
				userRole.setRole_id(Integer.valueOf(roleIds[i]));
				userRole.setUser_id(user.getU_id());
				userRoles.add(userRole);
			}
			roleMapper.insetUserRole(userRoles);
		}
		return count;
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteUser
	 * @Description:(删除用户)
	 * @param userId
	 * @return 
	 * @see com.qsj.service.UserService#deleteUser(java.lang.Integer)
	 */
	@Override
	public Integer deleteUser(Integer userId) {
		// 清除UserRole表中的记录
		roleMapper.deleteUserRole(userId);
		return userMapper.deleteUser(userId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: checkName
	 * @Description:(检查用户名是否重复)
	 * @return 
	 * @see com.qsj.service.UserService#checkName()
	 */
	@Override
	public Boolean checkName(String loginName) {
		Integer count = userMapper.findLoginName(loginName);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findRoleUsersByPage
	 * @Description:(根据角色查询用户)
	 * @param roleId
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.UserService#findRoleUsersByPage(java.lang.Integer, java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public List<UserVo> findRoleUsersByPage(Integer roleId, String search, BasePage page) {
		return userMapper.findRoleUsersByPage(roleId, search, page);
	}

}

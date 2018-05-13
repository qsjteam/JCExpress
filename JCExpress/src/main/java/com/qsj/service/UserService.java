package com.qsj.service;

import java.util.List;

import com.qsj.exception.ValidateException;
import com.qsj.pojo.User;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.UserVo;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface UserService {
	User findUserById(Integer userId);

	PageResult findUserLoginLogById(Integer userId, String search, BasePage page);

	Integer updateUserInfo(User user);

	Integer updatePassword(String nowPassword, String newPassword, Integer userId) throws ValidateException;

	PageResult findAllUser(String search, BasePage page);

	Integer frozenUser(Integer userId);

	Integer createUser(User user, String[] roleIds, String createName) throws ValidateException;

	Integer updateUser(User user, String[] roleIds, String updateName) throws ValidateException;

	Integer deleteUser(Integer userId);

	Boolean checkName(String loginName);

	List<UserVo> findRoleUsersByPage(Integer roleId, String search, BasePage page);
}

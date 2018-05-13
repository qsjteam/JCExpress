package com.qsj.service;

import java.util.List;

import com.qsj.exception.ValidateException;
import com.qsj.pojo.User;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.UserVo;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.user.service
 * @author:作者 Mao
 * @date:创建时间 2018年1月16日 下午2:53:39
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

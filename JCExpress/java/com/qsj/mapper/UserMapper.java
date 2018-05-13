package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;
import com.qsj.support.page.BasePage;
import com.qsj.vo.UserVo;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.user.mapper
 * @author:作者 Mao
 * @date:创建时间 2018年1月16日 下午2:52:57
 */
public interface UserMapper {
	User findUserById(@Param("userId") Integer userId);

	List<LoginLog> findUserLoginLogByPage(@Param("userId") Integer userId, @Param("search") String search,
			@Param("page") BasePage page);

	Integer updateUserInfo(@Param("user") User user);

	Integer updatePassword(@Param("password") String password, @Param("userId") Integer userId);

	List<UserVo> findAllUserByPage(@Param("search") String search, @Param("page") BasePage page);

	List<UserVo> findRoleUsersByPage(@Param("roleId") Integer roleId, @Param("search") String search,
			@Param("page") BasePage page);

	Integer updateFrozenUser(@Param("status") String status, @Param("userId") Integer userId);

	Integer insertUser(User user);

	Integer updateUser(@Param("user") User user);

	Integer deleteUser(@Param("userId") Integer userId);

	Integer findLoginName(@Param("loginName") String loginName);

	List<User> findUserByOrgId(@Param("organizationId") Integer organizationId);
}

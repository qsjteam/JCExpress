package com.qsj.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface LoginMapper {
	User findUserByNameAndStatus(@Param("loginName") String loginName);
	Integer updateTimeAndIpByUserId(@Param("lastLoginTime") Date lastLoginTime,@Param("lastLoginIp") String lastLoginIp,@Param("userId") Integer userId);
	Integer insertLoginLog(LoginLog loginLog);
}

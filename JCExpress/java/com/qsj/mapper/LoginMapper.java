package com.qsj.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;

/**
 * Copyright © 2018 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.login.mapper
 * @author:作者 Mao
 * @date:创建时间 2018年1月8日 上午11:53:15
 */
public interface LoginMapper {
	User findUserByNameAndStatus(@Param("loginName") String loginName);
	Integer updateTimeAndIpByUserId(@Param("lastLoginTime") Date lastLoginTime,@Param("lastLoginIp") String lastLoginIp,@Param("userId") Integer userId);
	Integer insertLoginLog(LoginLog loginLog);
}

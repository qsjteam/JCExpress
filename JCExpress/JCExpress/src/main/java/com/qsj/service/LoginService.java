package com.qsj.service;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface LoginService {
	User findUserByNameAndStatus(@Param("loginName") String loginName);
	Integer insertLoginLog(Integer userId,LoginLog loginLog);
}
 
package com.qsj.service;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.login.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月9日 上午10:08:39 
 */
public interface LoginService {
	User findUserByNameAndStatus(@Param("loginName") String loginName);
	Integer insertLoginLog(Integer userId,LoginLog loginLog);
}
 
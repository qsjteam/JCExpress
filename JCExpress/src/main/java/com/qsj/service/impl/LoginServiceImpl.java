package com.qsj.service.impl;

import com.qsj.mapper.LoginMapper;
import com.qsj.pojo.LoginLog;
import com.qsj.pojo.User;
import com.qsj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginMapper loginMapper;
	/**
	 * 
	 * (non Javadoc) 
	 * @Title: findUserByNameAndStatus
	 * @Description:(用户登录)
	 * @param loginName
	 * @return 
	 * @see com.qsj.service.LoginService#findUserByNameAndStatus(java.lang.String)
	 */
	@Override
	public User findUserByNameAndStatus(String loginName) {
		return loginMapper.findUserByNameAndStatus(loginName);
	}
	/**
	 * 
	 * (non Javadoc) 
	 * @Title: insertLoginLog
	 * @Description:(更新用户最后登录的时间和ip并且记录日志)
	 * @param userId
	 * @param loginLog
	 * @return 
	 * @see com.qsj.service.LoginService#insertLoginLog(java.lang.Integer, com.qsj.pojo.LoginLog)
	 */
	@Override
	public Integer insertLoginLog(Integer userId,LoginLog loginLog) {
		loginMapper.insertLoginLog(loginLog);
		loginMapper.updateTimeAndIpByUserId(loginLog.getLogin_time(),loginLog.getUser_ip(), userId);
		return null;
	}
	
	
}
 
package com.qsj.service.impl;

import java.util.List;

import com.qsj.mapper.LogMapper;
import com.qsj.pojo.SysLog;
import com.qsj.service.LogService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;

	/**
	 * (non Javadoc) 
	 * @Title: insertLog
	 * @Description:(添加日志)
	 * @param log
	 * @return 
	 * @see com.qsj.service.LogService#insertLog(com.qsj.pojo.SysLog)
	 */
	@Override
	public Integer insertLog(SysLog log) {
		return logMapper.insertLog(log);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findAllLogByPage
	 * @Description:(查询日志根据分页)
	 * @param search
	 * @param poage
	 * @return 
	 * @see com.qsj.service.LogService#findAllLogByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllLogByPage(String search, BasePage page) {
		List<SysLog> list = logMapper.findAllLogByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

}

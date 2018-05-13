package com.qsj.service;

import com.qsj.pojo.SysLog;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface LogService {
	Integer insertLog(SysLog log);

	PageResult findAllLogByPage(String search,BasePage page);
}

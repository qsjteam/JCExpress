package com.qsj.service;

import com.qsj.pojo.SysLog;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.log.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月27日 上午11:34:58 
 */
public interface LogService {
	Integer insertLog(SysLog log);

	PageResult findAllLogByPage(String search,BasePage page);
}

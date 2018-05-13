package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.SysLog;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
public interface LogMapper {
	/**
	 * @Title: insertLog  
	 * @Description: TODO(添加日志)  
	 * @param @param log
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertLog(@Param("log") SysLog log);

	/**
	 * @Title: findAllLogByPage  
	 * @Description: TODO(查询日志分页)  
	 * @param @param search
	 * @param @param poage
	 * @param @return    设定文件  
	 * @return List<SysLog>    返回类型  
	 * @throws
	 */
	List<SysLog> findAllLogByPage(@Param("search") String search, @Param("page") BasePage poage);
}

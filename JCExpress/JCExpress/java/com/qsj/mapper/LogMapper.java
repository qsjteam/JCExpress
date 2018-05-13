package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.SysLog;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.log.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年1月27日 上午11:20:28 
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

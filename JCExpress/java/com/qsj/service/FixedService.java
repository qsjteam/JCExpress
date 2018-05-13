package com.qsj.service;

import com.qsj.pojo.SysFixed;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月8日 下午2:52:11 
 */
public interface FixedService {
	PageResult findAllFixedByPage(String search, BasePage page);

	SysFixed findFixedById(Integer fixedId);

	Integer FrozenFixed(Integer fixedId);

	Integer deleteFixed(Integer fixedId);

	PageResult findPartitionIsNullByPage(String search, BasePage page);

	Integer insertFixed(SysFixed sysFixed);

	Integer updateFixed(SysFixed sysFixed);

	PageResult findPartitionByFixedIdByPage(Integer fixedId, String search, BasePage page);

	Integer updateRelaFixed(Integer fixedId,String[] partitionIds);
}

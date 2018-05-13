package com.qsj.service;

import com.qsj.pojo.SysFixed;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
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

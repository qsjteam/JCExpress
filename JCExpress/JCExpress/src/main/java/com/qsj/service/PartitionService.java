package com.qsj.service;

import com.qsj.pojo.SysPartition;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface PartitionService {
	PageResult findAllPartitionByPage(String search, BasePage page);

	Integer insertPartition(SysPartition sysPartition);

	Integer FrozenPartition(Integer partitionId);

	Integer deletePartition(Integer partitionId);

	Integer updatePartition(SysPartition sysPartition);

	SysPartition findPartitionById(Integer partitionId);
}

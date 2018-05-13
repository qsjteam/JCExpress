package com.qsj.service;

import com.qsj.pojo.SysPartition;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.partition.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月6日 下午3:37:27 
 */
public interface PartitionService {
	PageResult findAllPartitionByPage(String search, BasePage page);

	Integer insertPartition(SysPartition sysPartition);

	Integer FrozenPartition(Integer partitionId);

	Integer deletePartition(Integer partitionId);

	Integer updatePartition(SysPartition sysPartition);

	SysPartition findPartitionById(Integer partitionId);
}

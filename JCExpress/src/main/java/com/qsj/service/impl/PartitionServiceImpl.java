package com.qsj.service.impl;

import java.util.List;

import com.qsj.mapper.PartitionMapper;
import com.qsj.pojo.SysPartition;
import com.qsj.service.PartitionService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.PartitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("partitionService")
public class PartitionServiceImpl implements PartitionService {

	@Autowired
	private PartitionMapper partitionMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findAllPartitionByPage
	 * @Description:(查询分区并分页)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.PartitionService#findAllPartitionByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllPartitionByPage(String search, BasePage page) {
		 List<PartitionVo> list = partitionMapper.findAllPartitionByPage(search, page);
		return new PageResult(list,page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertPartition
	 * @Description:(添加分区)
	 * @param sysPartition
	 * @return 
	 * @see com.qsj.service.PartitionService#insertPartition(com.qsj.pojo.SysPartition)
	 */
	@Override
	public Integer insertPartition(SysPartition sysPartition) {
		return partitionMapper.insertPartition(sysPartition);
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenPartition
	 * @Description:(启用冻结分区)
	 * @param partitionId
	 * @return 
	 * @see com.qsj.service.PartitionService#FrozenPartition(java.lang.Integer)
	 */
	@Override
	public Integer FrozenPartition(Integer partitionId) {
		SysPartition sysPartition = this.findPartitionById(partitionId);
		if (sysPartition != null && sysPartition.getStatus().equals("0")) {
			return partitionMapper.updateFrozenPartition("1", partitionId);
		}
		if (sysPartition != null && sysPartition.getStatus().equals("1")) {
			return partitionMapper.updateFrozenPartition("0", partitionId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: deletePartition
	 * @Description:(删除分区)
	 * @param partitionId
	 * @return 
	 * @see com.qsj.service.PartitionService#deletePartition(java.lang.Integer)
	 */
	@Override
	public Integer deletePartition(Integer partitionId) {
		return partitionMapper.deletePartition(partitionId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updatePartition
	 * @Description:(更新分区)
	 * @param sysPartition
	 * @return 
	 * @see com.qsj.service.PartitionService#updatePartition(com.qsj.pojo.SysPartition)
	 */
	@Override
	public Integer updatePartition(SysPartition sysPartition) {
		return partitionMapper.updatePartition(sysPartition);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findPartitionById
	 * @Description:(根据id查找分区)
	 * @param partitionId
	 * @return 
	 * @see com.qsj.service.PartitionService#findPartitionById(java.lang.Integer)
	 */
	@Override
	public SysPartition findPartitionById(Integer partitionId) {
		return partitionMapper.findPartitionById(partitionId);
	}

}

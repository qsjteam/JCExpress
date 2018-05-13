package com.qsj.service.impl;

import java.util.List;

import com.qsj.mapper.FixedMapper;
import com.qsj.pojo.SysFixed;
import com.qsj.pojo.SysPartition;
import com.qsj.service.FixedService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import com.qsj.vo.FixedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@Service("fixedService")
public class FixedServiceImpl implements FixedService {
	@Autowired
	private FixedMapper fixedMapper;

	/**
	 * (non Javadoc) 
	 * @Title: findAllFixedByPage
	 * @Description:(查询定区并分页)
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.FixedService#findAllFixedByPage(java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findAllFixedByPage(String search, BasePage page) {
		List<FixedVo> list = fixedMapper.findAllFixedByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findFixedById
	 * @Description:(查看定区根据id)
	 * @param fixedId
	 * @return 
	 * @see com.qsj.service.FixedService#findFixedById(java.lang.Integer)
	 */
	@Override
	public SysFixed findFixedById(Integer fixedId) {
		return fixedMapper.findFixedById(fixedId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: FrozenFixed
	 * @Description:(冻结/启用定区)
	 * @param fixedId
	 * @return 
	 * @see com.qsj.service.FixedService#FrozenFixed(java.lang.Integer)
	 */
	@Override
	public Integer FrozenFixed(Integer fixedId) {
		SysFixed fixed = this.findFixedById(fixedId);
		if (fixed != null && fixed.getStatus().equals("0")) {
			return fixedMapper.updateFrozenFixed("1", fixedId);
		}
		if (fixed != null && fixed.getStatus().equals("1")) {
			return fixedMapper.updateFrozenFixed("0", fixedId);
		}
		return null;
	}

	/**
	 * (non Javadoc) 
	 * @Title: deleteFixed
	 * @Description:(删除定区)
	 * @param fixedId
	 * @return 
	 * @see com.qsj.service.FixedService#deleteFixed(java.lang.Integer)
	 */
	@Override
	public Integer deleteFixed(Integer fixedId) {
		return fixedMapper.deleteFixed(fixedId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findPartitionIsNullByPage
	 * @Description:(查询没有关联定区的分区 分页)
	 * @return 
	 * @see com.qsj.service.FixedService#findPartitionIsNullByPage()
	 */
	@Override
	public PageResult findPartitionIsNullByPage(String search, BasePage page) {
		List<SysPartition> list = fixedMapper.findPartitionIsNullByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: insertFixed
	 * @Description:(插入定区)
	 * @param sysFixed
	 * @return 
	 * @see com.qsj.service.FixedService#insertFixed(com.qsj.pojo.SysFixed)
	 */
	@Override
	public Integer insertFixed(SysFixed sysFixed) {
		return fixedMapper.insertFixed(sysFixed);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateFixed
	 * @Description:(更新定区)
	 * @param sysFixed
	 * @return 
	 * @see com.qsj.service.FixedService#updateFixed(com.qsj.pojo.SysFixed)
	 */
	@Override
	public Integer updateFixed(SysFixed sysFixed) {
		return fixedMapper.updateFixed(sysFixed);
	}

	/**
	 * (non Javadoc) 
	 * @Title: findPartitionByFixedIdByPage
	 * @Description:(查询已经关联的分区根据定区的id)
	 * @param fixedId
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.FixedService#findPartitionByFixedIdByPage(java.lang.Integer, java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findPartitionByFixedIdByPage(Integer fixedId, String search, BasePage page) {
		List<SysPartition> list = fixedMapper.findPartitionByFixedIdByPage(fixedId, search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateRelaFixed
	 * @Description:(关联分区或者取消分区)
	 * @param fixedId
	 * @param partitionIds
	 * @return 
	 * @see com.qsj.service.FixedService#updateRelaFixed(java.lang.Integer, java.lang.String[])
	 */
	@Override
	public Integer updateRelaFixed(Integer fixedId, String[] partitionIds) {
		if (fixedId == null) {
			return fixedMapper.updateRelaFixed(null, partitionIds);
		} else {
			return fixedMapper.updateRelaFixed(fixedId, partitionIds);
		}
	}

}

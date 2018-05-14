package com.qsj.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qsj.pojo.Fixed;
import com.qsj.pojo.SysFixed;
import com.qsj.pojo.SysPartition;
import com.qsj.support.page.BasePage;
import com.qsj.vo.FixedVo;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */
public interface FixedMapper {
	/**
	 * @Title: findAllFixedByPage  
	 * @Description: TODO(查询所有定区并分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<Fixed>    返回类型  
	 * @throws
	 */
	List<FixedVo> findAllFixedByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: findFixedById  
	 * @Description: TODO(查询定区根据id)  
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Fixed    返回类型  
	 * @throws
	 */
	SysFixed findFixedById(@Param("fixedId") Integer fixedId);

	/**
	 * @Title: updateFrozenFixed  
	 * @Description: TODO(开启冻结定区)  
	 * @param @param status
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenFixed(@Param("status") String status, @Param("fixedId") Integer fixedId);

	/**
	 * @Title: deleteFixed  
	 * @Description: TODO(删除定区)  
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deleteFixed(@Param("fixedId") Integer fixedId);

	/**
	 * @Title: findPartitionIsNullByPage  
	 * @Description: TODO(查询没有关联定区的分区 分页)  
	 * @param @return    设定文件  
	 * @return List<SysPartition>    返回类型  
	 * @throws
	 */
	List<SysPartition> findPartitionIsNullByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: insertFixed  
	 * @Description: TODO(插入定区)  
	 * @param @param sysFixed
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertFixed(@Param("fixed") SysFixed sysFixed);

	/**
	 * @Title: updateFixed  
	 * @Description: TODO(修改定区)  
	 * @param @param sysFixed
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFixed(@Param("fixed") SysFixed sysFixed);

	/**
	 * @Title: findPartitionByFixedIdByPage  
	 * @Description: TODO(查询已关联的分区根据定区id)  
	 * @param @param fixedId
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<SysPartition>    返回类型  
	 * @throws
	 */
	List<SysPartition> findPartitionByFixedIdByPage(@Param("fixedId") Integer fixedId, @Param("search") String search,
			@Param("page") BasePage page);

	/**
	 * @Title: updateRelaFixed  
	 * @Description: TODO(定区关联分区)  
	 * @param @param fixedId
	 * @param @param partitionIds
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateRelaFixed(@Param("fixedId") Integer fixedId, @Param("partitionIds") String[] partitionIds);

	List<Fixed> findFixedByName(String name);
}

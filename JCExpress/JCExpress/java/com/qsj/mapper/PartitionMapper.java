package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.SysPartition;
import com.qsj.support.page.BasePage;
import com.qsj.vo.PartitionVo;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.partition.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月6日 下午3:36:58 
 */
public interface PartitionMapper {
	/**
	 * @Title: findAllPartitionByPage  
	 * @Description: TODO(分页查询分区)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<SysPartition>    返回类型  
	 * @throws
	 */
	List<PartitionVo> findAllPartitionByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: insertPartition  
	 * @Description: TODO(添加分区)  
	 * @param @param sysPartition
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertPartition(@Param("sysPartition") SysPartition sysPartition);

	/**
	 * @Title: updateFrozenPartition  
	 * @Description: TODO(启用冻结分区)  
	 * @param @param status
	 * @param @param partitionId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateFrozenPartition(@Param("status") String status, @Param("partitionId") Integer partitionId);

	/**
	 * @Title: deletePartition  
	 * @Description: TODO(删除分区)  
	 * @param @param partitionId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer deletePartition(@Param("partitionId") Integer partitionId);

	/**
	 * @Title: updatePartition  
	 * @Description: TODO(修改分区)  
	 * @param @param sysPartition
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updatePartition(@Param("sysPartition") SysPartition sysPartition);

	/**
	 * @Title: findPartitionById  
	 * @Description: TODO(根据分区Id查询分区)  
	 * @param @param partitionId
	 * @param @return    设定文件  
	 * @return SysPartition    返回类型  
	 * @throws
	 */
	SysPartition findPartitionById(@Param("partitionId") Integer partitionId);
}

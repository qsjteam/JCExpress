package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.ExOrderRecords;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 上午11:57:41 
 */
public interface OrderRecordsMapper {
	/**
	 * @Title: findOrderRecords  
	 * @Description: TODO(查询订单的历史记录)  
	 * @param @return    设定文件  
	 * @return List<ExOrderRecords>    返回类型  
	 * @throws
	 */
	List<ExOrderRecords> findOrderRecords(@Param("orderId") String orderId);

	/**
	 * @Title: insertOrderRecords  
	 * @Description: TODO(插入订单历史记录)  
	 * @param @param exOrderRecords
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrderRecords(@Param("exOrderRecords") ExOrderRecords exOrderRecords);
}

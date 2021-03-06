package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.ExOrderDetail;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface OrderDetailMapper {
	/**
	 * @Title: findOrderDateil  
	 * @Description: TODO(根据订单id查询订单详细信息)  
	 * @param @param orderId
	 * @param @return    设定文件  
	 * @return ExOrderDetail    返回类型  
	 * @throws
	 */
	ExOrderDetail findOrderDetail(@Param("orderId") String orderId);

	/**
	 * @Title: updateOrderDateil  
	 * @Description: TODO(更新订单详细信息)  
	 * @param @param exOrderDetail
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateOrderDetail(@Param("exOrderDetail") ExOrderDetail exOrderDetail);

	/**
	 * @Title: insertOrderDetail  
	 * @Description: TODO(添加订单明细)  
	 * @param @param exOrderDetail
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrderDetail(@Param("orderDetail") ExOrderDetail exOrderDetail);

	/**
	 * @Title: insertOrderDetails  
	 * @Description: TODO(批量添加订单)  
	 * @param @param orderDetails
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrderDetails(@Param("orderDetails") List<ExOrderDetail> orderDetails);
}

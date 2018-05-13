package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.ExOrder;
import com.qsj.pojo.SysArea;
import com.qsj.support.page.BasePage;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface OrderMapper {
	/**
	 * @Title: findAllOrderByPage  
	 * @Description: TODO(查询所有订单分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<ExOrderVo>    返回类型  
	 * @throws
	 */
	List<ExOrder> findAllOrderByPage(@Param("search") String search, @Param("page") BasePage page);

	/**
	 * @Title: updateOrderStatus  
	 * @Description: TODO(改变订单状态)  
	 * @param @param status 1.已下单 2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @param @param orderId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateOrderStatus(@Param("status") String status, @Param("orderId") String orderId);

	/**
	 * @Title: findStatusOrderByPage  
	 * @Description: TODO(查询订单根据状态 分页)  
	 * @param @param status
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<ExOrderVo>    返回类型  
	 * @throws
	 */
	List<ExOrder> findStatusOrderByPage(@Param("status") String status, @Param("search") String search,
			@Param("page") BasePage page);

	/**
	 * @Title: updateOrder  
	 * @Description: TODO(更新订单信息)  
	 * @param @param exOrder
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer updateOrder(@Param("exOrder") ExOrder exOrder);

	/**
	 * @Title: findOrderById  
	 * @Description: TODO(查询订单根据id)  
	 * @param @param orderId
	 * @param @return    设定文件  
	 * @return ExOrder    返回类型  
	 * @throws
	 */
	ExOrder findOrderById(@Param("orderId") String orderId);

	/**
	 * @Title: insertOrder  
	 * @Description: TODO(添加订单)  
	 * @param @param exOrder
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrder(@Param("order") ExOrder exOrder);

	/**
	 * @Title: findAreaCode  
	 * @Description: TODO(根据地区查询地区码)  
	 * @param @param search
	 * @param @return    设定文件  
	 * @return SysArea    返回类型  
	 * @throws
	 */
	SysArea findAreaCode(@Param("search") String search);

	/**
	 * @Title: insertOrders  
	 * @Description: TODO(批量添加订单)  
	 * @param @param orders
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertOrders(@Param("orders") List<ExOrder> orders);
}

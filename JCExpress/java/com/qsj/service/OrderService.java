package com.qsj.service;

import com.qsj.pojo.ExOrder;
import com.qsj.pojo.ExOrderDetail;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 下午3:07:44 
 */
public interface OrderService {

	PageResult findAllOrderByPage(String search, BasePage page);

	Integer updateOrderStatus(String updateName, String status, String orderId);

	PageResult findStatusOrderByPage(String status, String search, BasePage page);

	ExOrder findOrderById(String orderId);

	Integer updateOrder(String orderId, ExOrder exOrder, ExOrderDetail exOrderDetail);

	String insetOrder(ExOrder exOrder, ExOrderDetail exOrderDetail);
	
	Integer insetOrders(String json,ExOrder orders);
}

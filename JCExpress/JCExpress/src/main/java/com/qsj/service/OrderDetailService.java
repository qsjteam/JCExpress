package com.qsj.service;

import com.qsj.pojo.ExOrderDetail;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface OrderDetailService {

	ExOrderDetail findOrderDetail(String orderId);

	String  orderRecordsTitle(String orderId);

	String  orderRecordsDate(String orderId);
}

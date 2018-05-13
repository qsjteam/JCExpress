package com.qsj.service;

import com.qsj.pojo.ExOrderDetail;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 下午5:20:44 
 */
public interface OrderDetailService {

	ExOrderDetail findOrderDetail(String orderId);

	String  orderRecordsTitle(String orderId);

	String  orderRecordsDate(String orderId);
}

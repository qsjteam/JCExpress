package com.qsj.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.qsj.mapper.OrderDetailMapper;
import com.qsj.mapper.OrderRecordsMapper;
import com.qsj.pojo.ExOrderDetail;
import com.qsj.pojo.ExOrderRecords;
import com.qsj.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service.impl 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月16日 下午5:21:44 
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private OrderRecordsMapper orderRecordsMapper;

	/**
	 * @Title: findOrderDateil  
	 * @Description: TODO(根据订单id查询订单详细信息)  
	 * @param @param orderId
	 * @param @return    设定文件  
	 * @return ExOrderDetail    返回类型  
	 * @throws
	 */
	@Override
	public ExOrderDetail findOrderDetail(String orderId) {
		return orderDetailMapper.findOrderDetail(orderId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: orderRecordsTitle
	 * @Description:(返回操作订单内容)
	 * @param orderId
	 * 参数status  1.已下单 2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @return 
	 * @see com.qsj.service.OrderDetailService#orderRecordsTitle(java.lang.String)
	 */
	@Override
	public String orderRecordsTitle(String orderId) {
		List<String> titles =new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
		{add("未下单");add("等待审核");add("等待派车");add("等待配送");add("等待签收");}};
		List<ExOrderRecords> orderRecords = orderRecordsMapper.findOrderRecords(orderId);
		for (ExOrderRecords orderRecord : orderRecords) {
			if (orderRecord.getStatus().equals("1")) {
				titles.set(0, "已下单");
			}
			if (orderRecord.getStatus().equals("2")) {
				titles.set(1, "审核通过");
			}
			if (orderRecord.getStatus().equals("3")) {
				titles.set(2, "已派车");
			}
			if (orderRecord.getStatus().equals("4")) {
				titles.set(3, "正在配送");
			}
			if (orderRecord.getStatus().equals("5")) {
				titles.set(4,  "已签收");
			}
		}
		StringBuffer sb=new StringBuffer();
		for (String title : titles) {
			sb.append(title);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * (non Javadoc) 
	 * @Title: orderRecordsTitle
	 * @Description:(返回操作订单时间)
	 * @param orderId
	 * 参数status  1.已下单 2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @return 
	 * @see com.qsj.service.OrderDetailService#orderRecordsTitle(java.lang.String)
	 */
	@Override
	public String  orderRecordsDate(String orderId) {
		List<String> dates =new ArrayList<String>(){
			private static final long serialVersionUID = 1L;
		{add("-");add("-");add("-");add("-");add("-");}};
		List<ExOrderRecords> orderRecords = orderRecordsMapper.findOrderRecords(orderId);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		for (ExOrderRecords orderRecord : orderRecords) {
			if (orderRecord.getStatus().equals("1")) {
				dates.set(0,sf.format(orderRecord.getCreate_time())) ;
			}
			if (orderRecord.getStatus().equals("2")) {
				dates.set(1,sf.format(orderRecord.getCreate_time())) ;
			}
			if (orderRecord.getStatus().equals("3")) {
				dates.set(2,sf.format(orderRecord.getCreate_time())) ;
			}
			if (orderRecord.getStatus().equals("4")) {
				dates.set(3,sf.format(orderRecord.getCreate_time())) ;
			}
			if (orderRecord.getStatus().equals("5")) {
				dates.set(4,sf.format(orderRecord.getCreate_time())) ;
			}
		}
		StringBuffer sb=new StringBuffer();
		for (String date : dates) {
			sb.append(date);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}

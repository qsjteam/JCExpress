package com.qsj.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qsj.mapper.OrderDetailMapper;
import com.qsj.mapper.OrderMapper;
import com.qsj.mapper.OrderRecordsMapper;
import com.qsj.pojo.ExOrder;
import com.qsj.pojo.ExOrderDetail;
import com.qsj.pojo.ExOrderRecords;
import com.qsj.service.OrderService;
import com.qsj.support.page.BasePage;
import com.qsj.support.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	private static String orderPrefix = "Ex";
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private OrderRecordsMapper orderRecordsMapper;

	// 订单id明细key
	@Value("${ex_order_detail_id_key}")
	private String ex_order_detail_id_key;

	// 订单历史idkey
	@Value("${ex_order_records_id_key}")
	private String ex_order_records_id_key;

	// 订单号key
	@Value("${ex_order_id_key}")
	private String ex_order_id_key;

	// 订单号初始值
	@Value("${ex_id_key}")
	private String ex_id_key;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * @Title: findAllOrderByPage  
	 * @Description: TODO(查询所有订单分页)  
	 * @param @param search
	 * @param @param page
	 * @param @return    设定文件  
	 * @return List<ExOrderVo>    返回类型  
	 * @throws
	 */
	@Override
	public PageResult findAllOrderByPage(String search, BasePage page) {
		List<ExOrder> list = orderMapper.findAllOrderByPage(search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * @Title: updateOrderStatus  
	 * @Description: TODO(改变订单状态)  
	 * @param @param status 1.已下单 2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @param @param orderId
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	@Override
	public Integer updateOrderStatus(String updateName, String status, String orderId) {
		Integer count = orderMapper.updateOrderStatus(status, orderId);
		ExOrderRecords exOrderRecords = new ExOrderRecords();
		exOrderRecords.setId(redisTemplate.opsForValue().increment(ex_order_records_id_key, 1).toString());
		exOrderRecords.setStatus(status);
		exOrderRecords.setOrder_id(orderId);
		exOrderRecords.setCreate_time(new Date());
		exOrderRecords.setCreate_by(updateName);
		orderRecordsMapper.insertOrderRecords(exOrderRecords);
		return count;
	}

	/**
	 * (non Javadoc) 
	 * @Title: findStatusOrderByPage
	 * @Description:(查询订单根据状态)
	 * @param status
	 * @param search
	 * @param page
	 * @return 
	 * @see com.qsj.service.OrderService#findStatusOrderByPage(java.lang.String, java.lang.String, com.qsj.support.page.BasePage)
	 */
	@Override
	public PageResult findStatusOrderByPage(String status, String search, BasePage page) {
		List<ExOrder> list = orderMapper.findStatusOrderByPage(status, search, page);
		return new PageResult(list, page.getTotal());
	}

	/**
	 * (non Javadoc) 
	 * @Title: findOrderById
	 * @Description:(根据订单号寻找订单)
	 * @param orderId
	 * @return 
	 * @see com.qsj.service.OrderService#findOrderById(java.lang.String)
	 */
	@Override
	public ExOrder findOrderById(String orderId) {
		return orderMapper.findOrderById(orderId);
	}

	/**
	 * (non Javadoc) 
	 * @Title: updateOrder
	 * @Description:(修改订单信息)
	 * @param orderId
	 * @return 
	 * @see com.qsj.service.OrderService#updateOrder(java.lang.String)
	 */
	@Override
	public Integer updateOrder(String orderId, ExOrder exOrder, ExOrderDetail exOrderDetail) {
		if (exOrder != null) {
			exOrder.setOrder_id(orderId);
			exOrder.setUpdate_time(new Date());
		}
		if (exOrderDetail != null) {
			exOrderDetail.setOrder_id(orderId);
			exOrderDetail.setUpdate_time(new Date());
		}
		try {
			// 更新订单内容
			orderMapper.updateOrder(exOrder);
			// 更新订单详细内容
			orderDetailMapper.updateOrderDetail(exOrderDetail);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * (non Javadoc) 
	 * @Title: insetOrder
	 * @Description:(插入订单)
	 * @param exOrder
	 * @param exOrderDetail
	 * @return 
	 * @see com.qsj.service.OrderService#insetOrder(com.qsj.pojo.ExOrder, com.qsj.pojo.ExOrderDetail)
	 */
	@Override
	public String insetOrder(ExOrder exOrder, ExOrderDetail exOrderDetail) {
		try {
			// 补全订单信息
			if (!redisTemplate.hasKey(ex_order_id_key)) {
				redisTemplate.opsForValue().set(ex_order_id_key, ex_id_key);
			}
			Long increment = redisTemplate.opsForValue().increment(ex_order_id_key, 1);
			exOrder.setOrder_id(orderPrefix + increment.toString());
			exOrder.setCreate_time(new Date());
			exOrder.setStatus("1");
			// 补全订单明细
			// ex_order_detail_id_key
			exOrderDetail.setOrder_id(orderPrefix + increment.toString());
			exOrderDetail.setId(redisTemplate.opsForValue().increment(ex_order_detail_id_key, 1).toString());
			exOrderDetail.setCreate_time(new Date());
			// 插入历史记录
			ExOrderRecords exOrderRecords = new ExOrderRecords();
			exOrderRecords.setId(redisTemplate.opsForValue().increment(ex_order_records_id_key, 1).toString());
			exOrderRecords.setStatus("1");
			exOrderRecords.setOrder_id(orderPrefix + increment.toString());
			exOrderRecords.setCreate_time(new Date());
			orderMapper.insertOrder(exOrder);
			orderDetailMapper.insertOrderDetail(exOrderDetail);
			orderRecordsMapper.insertOrderRecords(exOrderRecords);
			return orderPrefix + increment.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer insetOrders(String json, ExOrder orders) {
		try {
			List<ExOrder> orderList = new ArrayList<>();
			List<ExOrderDetail> orderDetailList = new ArrayList<>();
			JSONArray fromObject = JSONArray.fromObject(json);
			for (Object object : fromObject) {
				if (!redisTemplate.hasKey(ex_order_id_key)) {
					redisTemplate.opsForValue().set(ex_order_id_key, ex_id_key);
				}
				Long increment = redisTemplate.opsForValue().increment(ex_order_id_key, 1);
				ExOrderDetail exOrderDetail = new ExOrderDetail();
				ExOrder exOrder = new ExOrder();
				ExOrderRecords exOrderRecords = new ExOrderRecords();
				JSONObject info = JSONObject.fromObject(object);
				// 订单信息
				exOrder.setOrder_id(orderPrefix + increment.toString());
				exOrder.setCustomer_id(orders.getCustomer_id());
				exOrder.setSend_name(orders.getSend_name());
				exOrder.setSend_telephone(orders.getSend_telephone());
				exOrder.setSend_area(orders.getSend_area());
				exOrder.setSend_address(orders.getSend_address());
				exOrder.setStatus("1");
				exOrder.setCreate_time(new Date());
				exOrder.setReceive_name(info.get("*收件人姓名").toString());
				exOrder.setReceive_telephone(info.get("*收件人联系方式").toString());
				exOrder.setReceive_address(info.get("*详细地址").toString());
				exOrder.setReceive_area(
						info.get("*省").toString() + info.get("*市").toString() + info.get("区").toString());
				orderList.add(exOrder);
				// 订单明细
				exOrderDetail.setOrder_id(orderPrefix + increment.toString());
				exOrderDetail.setOrder_remark(info.get("备注").toString());
				exOrderDetail.setOrder_type(info.get("*物品类型").toString());
				exOrderDetail.setOrder_weight(info.get("*物品重量").toString());
				exOrderDetail.setCreate_time(new Date());
				exOrderDetail.setId(redisTemplate.opsForValue().increment(ex_order_detail_id_key, 1).toString());
				orderDetailList.add(exOrderDetail);
				// 添加订单历史
				exOrderRecords.setCreate_time(new Date());
				exOrderRecords.setId(redisTemplate.opsForValue().increment(ex_order_records_id_key, 1).toString());
				exOrderRecords.setOrder_id(orderPrefix + increment.toString());
				exOrderRecords.setStatus("1");
				orderRecordsMapper.insertOrderRecords(exOrderRecords);
			}
			orderMapper.insertOrders(orderList);
			orderDetailMapper.insertOrderDetails(orderDetailList);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

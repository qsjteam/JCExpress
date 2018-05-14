package com.qsj.controller.order;


import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.ExOrder;
import com.qsj.pojo.ExOrderDetail;
import com.qsj.pojo.User;
import com.qsj.service.OrderDetailService;
import com.qsj.service.OrderService;
import com.qsj.support.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
 */

@RequestMapping("/order")
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;

	/**
	 * @Title: orderList  
	 * @Description: TODO(跳转到订单列表页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/list")
	public String orderList(Model model) {
		return "views/order/ExOrderList";
	}

	/**
	 * @Title: orderList  
	 * @Description: TODO(查询订单并分页)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/allOrder")
	@ResponseBody
	public Object orderList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return  orderService.findAllOrderByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: orderDetail  
	 * @Description: TODO(显示订单详细信息)  
	 * @param @param orderId
	 * @param @param status
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/{orderId}/{status}/detail")
	public String orderDetail(@PathVariable("orderId") String orderId, @PathVariable("status") String status,
			Model model) {
		String orderRecordsDate = orderDetailService.orderRecordsDate(orderId);
		String orderRecordsTitle = orderDetailService.orderRecordsTitle(orderId);
		ExOrderDetail orderDetail = orderDetailService.findOrderDetail(orderId);
		model.addAttribute("status", Integer.parseInt(status) - 1);
		model.addAttribute("date", orderRecordsDate);
		model.addAttribute("title", orderRecordsTitle);
		model.addAttribute("orderDetail", orderDetail);
		return "views/order/ExOrderDetail";
	}

	/**
	 * @Title: orderAudit  
	 * @Description: TODO(跳转审核订单)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/audit")
	public String orderAudit(Model model) {
		return "views/order/ExOrderAudit";
	}

	/**
	 * @Title: orderAudit  
	 * @Description: TODO(审核订单列表)  
	 * @param @param page
	 * 1.已下单      2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping("/auditOrder")
	@ResponseBody
	public Object orderAudit(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return orderService.findStatusOrderByPage("1", search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateOrder  
	 * @Description: TODO(跳转修改订单页面)  
	 * @param @param orderId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/{orderId}/updateOrder")
	public String updateOrder(@PathVariable("orderId") String orderId, Model model) {
		ExOrder order = orderService.findOrderById(orderId);
		model.addAttribute("order", order);
		ExOrderDetail orderDetail = orderDetailService.findOrderDetail(orderId);
		model.addAttribute("orderDetail", orderDetail);
		return "views/order/ExOrderUpdate";
	}

	/**
	 * @Title: updateOrder  
	 * @Description: TODO(更新订单)  
	 * @param @param orderId
	 * @param @param exOrder
	 * @param @param exOrderDetail
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/updateOrder/{orderId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateOrder(@PathVariable("orderId") String orderId, ExOrder exOrder, ExOrderDetail exOrderDetail) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = orderService.updateOrder(orderId, exOrder, exOrderDetail);
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: orderAudit  
	 * @Description: TODO(审核订单)  
	 * @param @param orderId
	 * 1.已下单      2.审核通过(等待审核) 3.已派车(等待派车) 4.正在配送 (等待配送)5.已签收 (等待签收)
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{orderId}/adoptOrder", method = RequestMethod.PUT)
	@ResponseBody
	public Object orderAudit(@PathVariable("orderId") String orderId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = orderService.updateOrderStatus(activeUser.getUser_name(), "2", orderId);
			return new BaseResult("审核通过", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createOrder  
	 * @Description: TODO(创建订单/单个/开放接口)  
	 * @param @param exOrder
	 * @param @param exOrderDetail
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	@ResponseBody
	public Object createOrder(ExOrder exOrder, ExOrderDetail exOrderDetail) {
		System.out.println("exOrder========"+exOrder+">>>>>>>>>>>>>>exOrderDetail"+exOrderDetail);
		System.out.println("-----------------------"+orderService);
		String orderId = orderService.insetOrder(exOrder, exOrderDetail);
		System.out.println("hahhahah");
		if (orderId != null) {
			return new BaseResult("预约成功", 1);
		}
		return new BaseResult("创建失败,请联系管理员");
	}

	@RequestMapping(value = "createOrders", method = RequestMethod.POST)
	@ResponseBody
	public Object createOrders(ExOrder exOrder, String receives) {
		Integer count = orderService.insetOrders(receives, exOrder);
		if (count == 1) {
			return new BaseResult("批量预约成功", 1);
		}
		return new BaseResult("创建失败,请联系管理员");
	}
	
	
	@RequestMapping("/selectOrder")
	@ResponseBody
	public BaseResult selectOrder(String id) {
		BaseResult bb;
		if(id.length()==11) {
			bb=orderService.selectOrderByTel(id);
			return bb;
		}else {
			bb=orderService.selectOrderById(id);
			return bb;
		}
	}
}

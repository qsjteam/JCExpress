package com.qsj.controller.fixed;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.Staff;
import com.qsj.pojo.SysFixed;
import com.qsj.pojo.User;
import com.qsj.service.FixedService;
import com.qsj.service.StaffService;
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
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.controller.fixed 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月8日 下午3:25:33 
 */
@RequestMapping("/fixed/list")
@Controller
public class FixedController {
	@Autowired
	private FixedService fixedService;
	@Autowired
	private StaffService staffService;

	/**
	 * @Title: fixedList  
	 * @Description: TODO(跳转定区列表)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/fixedList")
	public String fixedList(Model model) {
		return "views/fixed/fixedList";
	}

	/**
	 * @Title: fixedList  
	 * @Description: TODO(显示定区列表)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object fixedList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return fixedService.findAllFixedByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: fixedList  
	 * @Description: TODO(启用冻结定区)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}/frozenFixed", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozenFixed(@PathVariable("fixedId") Integer fixedId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = fixedService.FrozenFixed(fixedId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deleteFixed  
	 * @Description: TODO(删除定区)  
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteFixed(@PathVariable("fixedId") Integer fixedId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = fixedService.deleteFixed(fixedId);
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createFixed  
	 * @Description: TODO(跳转创建定区页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/createFixed")
	public String createFixed(Model model) {
		List<Staff> staffs = staffService.findStatusStaff();
		model.addAttribute("staffs", staffs);
		return "views/fixed/fixedCreate";
	}

	/**
	 * @Title: createFixed  
	 * @Description: TODO(插入定区)  
	 * @param @param fixed
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createFixed(SysFixed fixed) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = fixedService.insertFixed(fixed);
			return new BaseResult("创建成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateFixed  
	 * @Description: TODO(跳转更新定区页面)  
	 * @param @param fixedId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}/updateFixed")
	public String updateFixed(@PathVariable("fixedId") Integer fixedId, Model model) {
		SysFixed sysFixed = fixedService.findFixedById(fixedId);
		model.addAttribute("sysFixed", sysFixed);
		List<Staff> staffs = staffService.findStatusStaff();
		model.addAttribute("staffs", staffs);
		return "views/fixed/fixedUpdate";
	}

	/**
	 * @Title: updateFixed  
	 * @Description: TODO(更新定区)  
	 * @param @param fixedId
	 * @param @param fixed
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateFixed(@PathVariable("fixedId") Integer fixedId, SysFixed fixed) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			fixed.setId(fixedId);
			Integer count = fixedService.updateFixed(fixed);
			return new BaseResult("创建成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: noRealPartition  
	 * @Description: TODO(跳转没有被关联分区的页面)  
	 * @param @param fixedId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}/noRealPartition")
	public String noRealPartition(@PathVariable("fixedId") Integer fixedId, Model model) {
		model.addAttribute("fixedId", fixedId);
		return "views/fixed/noRealPartition";
	}

	/**
	 * @Title: noRealPartition  
	 * @Description: TODO(查询没有被定区关联的分区)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/noRealPartition")
	@ResponseBody
	public Object noRealPartition(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return  fixedService.findPartitionIsNullByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: noRealPartition  
	 * @Description: TODO(跳转关联分区的页面)  
	 * @param @param fixedId
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}/realPartition")
	public String realPartition(@PathVariable("fixedId") Integer fixedId, Model model) {
		model.addAttribute("fixedId", fixedId);
		return "views/fixed/realPartition";
	}

	/**
	 * @Title: noRealPartition  
	 * @Description: TODO(查询没有被定区关联的分区)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/realPartition/{fixedId}")
	@ResponseBody
	public Object realPartition(@PathVariable("fixedId") Integer fixedId, BasePage page,
			@RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return fixedService.findPartitionByFixedIdByPage(fixedId, search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: realPartition  
	 * @Description: TODO(定区关联分区)  
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{fixedId}/relaFixed", method = RequestMethod.PUT)
	@ResponseBody
	public Object relaFixed(@PathVariable("fixedId") Integer fixedId, String partitionIds) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			String[] ids = partitionIds.split(",");
			Integer count = fixedService.updateRelaFixed(fixedId, ids);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: realPartition  
	 * @Description: TODO(定区取关分区)  
	 * @param @param fixedId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/noRelaFixed", method = RequestMethod.PUT)
	@ResponseBody
	public Object noRelaFixed(String partitionIds) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			String[] ids = partitionIds.split(",");
			Integer count = fixedService.updateRelaFixed(null, ids);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}
}

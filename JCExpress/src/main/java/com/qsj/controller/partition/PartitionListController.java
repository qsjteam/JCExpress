package com.qsj.controller.partition;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.SysArea;
import com.qsj.pojo.SysPartition;
import com.qsj.pojo.User;
import com.qsj.service.PartitionService;
import com.qsj.service.RegionService;
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
@Controller
@RequestMapping("/partition/list")
public class PartitionListController {
	@Autowired
	private PartitionService partitionService;
	@Autowired
	private RegionService regionService;

	/**
	 * @Title: partitionList  
	 * @Description: TODO(跳转分区页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/partitionList")
	public String partitionList(Model model) {
		return "views/partition/partitionList";
	}

	/**
	 * @Title: partitionList  
	 * @Description: TODO(查询根据分区分页)  
	 * @param @param page
	 * @param @param search
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Object partitionList(BasePage page, @RequestParam(required = false, value = "search") String search) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return partitionService.findAllPartitionByPage(search, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: createPartition  
	 * @Description: TODO(跳转增加分区页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/createPartition")
	public String createPartition(Model model) {
		return "views/partition/partitionCreate";
	}

	/**
	 * @Title: createPartition  
	 * @Description: TODO(添加分区)  
	 * @param @param sysPartition
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Object createPartition(SysPartition sysPartition) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = partitionService.insertPartition(sysPartition);
			return new BaseResult("添加成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: regionSelect  
	 * @Description: TODO(三级联动  开放接口)  
	 * @param @param parentCode
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/regionSelect", method = RequestMethod.POST)
	@ResponseBody
	public Object regionSelect(@RequestParam(value = "parentCode", defaultValue = "0") String parentCode) {
			List<SysArea> list = regionService.findStatusReginByParentCode(parentCode);
			return list;
	}

	/**
	 * @Title: createPartition  
	 * @Description: TODO(跳转更新分区页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/{partitionId}/updatePartition")
	public String updatePartition(@PathVariable("partitionId") Integer partitionId, Model model) {
		SysPartition sysPartition = partitionService.findPartitionById(partitionId);
		model.addAttribute("sysPartition", sysPartition);
		return "views/partition/partitionUpdate";
	}

	/**
	 * @Title: updatePartition  
	 * @Description: TODO(更新分区)  
	 * @param @param partitionId
	 * @param @param sysPartition
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{partitionId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updatePartition(@PathVariable("partitionId") Integer partitionId, SysPartition sysPartition) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			sysPartition.setId(partitionId);
			Integer count = partitionService.updatePartition(sysPartition);
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updatePartition  
	 * @Description: TODO(删除分区)  
	 * @param @param partitionId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{partitionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object updatePartition(@PathVariable("partitionId") Integer partitionId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = partitionService.deletePartition(partitionId);
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: frozenPartition  
	 * @Description: TODO(冻结/启用分区)  
	 * @param @param partitionId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{partitionId}/frozenPartition", method = RequestMethod.PUT)
	@ResponseBody
	public Object frozenPartition(@PathVariable("partitionId") Integer partitionId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = partitionService.FrozenPartition(partitionId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

}

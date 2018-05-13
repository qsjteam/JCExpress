package com.qsj.controller.region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import com.qsj.base.result.BaseResult;
import com.qsj.pojo.SysArea;
import com.qsj.pojo.User;
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

import net.sf.json.JSONArray;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: org.mao.region.controller 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月1日 下午8:19:43 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@RequestMapping("/region/list")
@Controller
public class RegionListController {
	@Autowired
	private RegionService regionService;

	/**
	 * @Title: regionList  
	 * @Description: TODO(跳转区域页面)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/regionList")
	public String regionList(Model model) {
		return "views/region/regionList";
	}

	/**
	 * @Title: select  
	 * @Description: TODO(异步tree加载的url)  
	 * @param @param areaCode
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/select", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String select(@RequestParam(value = "areaCode", defaultValue = "0") String areaCode) {
		List<SysArea> areaList = regionService.findReginByParentCode(areaCode);
		List<Map> list = new ArrayList<Map>();
		for (SysArea sysArea : areaList) {
			Map map = new HashMap();
			map.put("areaCode", sysArea.getArea_code());
			map.put("name", sysArea.getName());
			map.put("parentCode", sysArea.getParent_code());
			map.put("layer", sysArea.getLayer());
			if (sysArea.getSize() > 0) {
				map.put("isParent", true);
			}
			list.add(map);
		}
		return JSONArray.fromObject(list).toString();
	}

	/**
	 * @Title: selectList  
	 * @Description: TODO(查询分区列表根据行政id)  
	 * @param @param areaCode
	 * @param @param page
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{areaCode}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object selectList(@PathVariable("areaCode") String areaCode, BasePage page) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			return regionService.findReginByAreaCodeByPage(areaCode, page);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: regionList  
	 * @Description: TODO(添加区域)  
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/{parentCode}/addRegion")
	public String addRegion(@PathVariable("parentCode") String parentCode, Model model) {
		model.addAttribute("parentCode", parentCode);
		return "views/region/regionCreate";
	}

	/**
	 * @Title: addRegion  
	 * @Description: TODO(添加区域)  
	 * @param @param parentCode
	 * @param @param area
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{parentCode}", method = RequestMethod.POST)
	@ResponseBody
	public Object addRegion(@PathVariable("parentCode") String parentCode, SysArea area) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			area.setParent_code(parentCode);
			Integer count = regionService.insertRegin(area);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: FrozenRegin  
	 * @Description: TODO(启用/隐藏区域)  
	 * @param @param areaId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{areaId}/frozenRegin", method = RequestMethod.PUT)
	@ResponseBody
	public Object FrozenRegin(@PathVariable("areaId") Integer areaId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = regionService.FrozenRegin(areaId);
			return new BaseResult("请求成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: updateRegion  
	 * @Description: TODO(跳转更新页面)  
	 * @param @param parentCode
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping("/{areaId}/updateRegion")
	public String updateRegion(@PathVariable("areaId") Integer areaId, Model model) {
		SysArea area = regionService.findReginByAreaId(areaId);
		model.addAttribute("area", area);
		return "views/region/regionUpdate";
	}

	/**
	 * @Title: updateRegion  
	 * @Description: TODO(更新区域)  
	 * @param @param areaId
	 * @param @param area
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{areaId}", method = RequestMethod.PUT)
	@ResponseBody
	public Object updateRegion(@PathVariable("areaId") Integer areaId, SysArea area) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			area.setArea_id(areaId);
			Integer count = regionService.updateRegin(area);
			return new BaseResult("更新成功", count);
		}
		return new BaseResult("没有登录");
	}

	/**
	 * @Title: deleteRegion  
	 * @Description: TODO(删除区域)  
	 * @param @param areaId
	 * @param @return    设定文件  
	 * @return Object    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/{areaId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object deleteRegion(@PathVariable("areaId") Integer areaId) {
		User activeUser = (User) SecurityUtils.getSubject().getPrincipal();
		if (activeUser != null) {
			Integer count = regionService.deleteRegin(areaId);
			return new BaseResult("删除成功", count);
		}
		return new BaseResult("没有登录");
	}

	/*@RequestMapping(value = "all")
	@ResponseBody
	public Object regionJson(Model model) {
		Map json = new HashMap<>();
		List<AreaDTO> listProvince = new ArrayList<>();
		List<SysArea> allProvince = regionService.findStatusReginByParentCode("0");
		for (SysArea sysArea : allProvince) {
			// 所有省份set到listProvince
			AreaDTO areaDTO = new AreaDTO();
			areaDTO.setAddress(sysArea.getName());
			areaDTO.setCode(Integer.parseInt(sysArea.getArea_code()));
			listProvince.add(areaDTO);
		}
		json.put(86, listProvince);
		List<SysArea> areas = regionService.findAllReginNotIsProvince();
		for (SysArea area : areas) {
			Map map = new HashMap<>();
			List<SysArea> cent = regionService.findStatusReginByParentCode(area.getArea_code());
			if (cent != null&&cent.size()>0) {
				for (SysArea sysArea : cent) {
					map.put(Integer.parseInt(sysArea.getArea_code()), sysArea.getName());
				}
				json.put(Integer.parseInt(area.getArea_code()), map);
			}
		}
		return json;
	}*/
}

package com.qsj.controller.yunfei;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsj.base.result.BaseResult;
import com.qsj.pojo.User;
import com.qsj.service.YunfeiService;

@Controller
public class yunFeiController {
	@Autowired
	private YunfeiService yunfeiService;
	
	@RequestMapping("/yunfei")
	@ResponseBody
	public BaseResult yunfei(String name1,String name2,Integer weight,Integer timer) {
		
		BaseResult bb= new BaseResult(null);
		int in_province;
		int leght=name2.length();
		String subStr=name1.substring(0,leght);
		if(subStr.equals(name2)) {
			 in_province=0;
		}else {
			 in_province=1;
		}
		bb=yunfeiService.yunfei(in_province, weight, timer);
		return bb;
		
		
		
		
	}
}

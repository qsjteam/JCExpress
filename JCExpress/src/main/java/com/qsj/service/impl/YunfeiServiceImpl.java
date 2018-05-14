package com.qsj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsj.base.result.BaseResult;
import com.qsj.mapper.YunfeiMapper;
import com.qsj.service.YunfeiService;

@Service("yunfeiService")
public class YunfeiServiceImpl implements YunfeiService {
	@Autowired
	private YunfeiMapper yunfeimapper;
	
	@Override
	public BaseResult yunfei(Integer in_province, Integer weight, Integer timer) {
		BaseResult bb=new BaseResult(null);
		bb.setData(yunfeimapper.yunfei(in_province, weight, timer));
		return bb;
	}

}

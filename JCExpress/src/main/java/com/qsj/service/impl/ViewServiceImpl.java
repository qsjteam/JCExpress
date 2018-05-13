package com.qsj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsj.base.result.BaseResult;
import com.qsj.mapper.ViewMapper;
import com.qsj.service.ViewService;
@Service("viewService")
public class ViewServiceImpl implements ViewService {
	@Autowired
	ViewMapper viewmapper;
	@Override
	public BaseResult showView() {
		BaseResult bb=new BaseResult(null);
		bb.setData(viewmapper.showView());
		return bb;
	}

}

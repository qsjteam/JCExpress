package com.qsj.service;

import com.qsj.base.result.ExOsResult;
import com.qsj.pojo.OsCustomer;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月20日 下午9:47:44 
 */
public interface CustomerService {
	ExOsResult customerLogin(String customerCode, String password);

	ExOsResult registCustomer(OsCustomer customer);

	ExOsResult sendEmail(String email);

	Integer activeCustomer(String email);

	ExOsResult modifyPassword(String password,String code);
	
	ExOsResult sendModifyEmail(String email);
	
	boolean registActive(String code);
	
}

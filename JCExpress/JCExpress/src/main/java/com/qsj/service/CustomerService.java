package com.qsj.service;

import com.qsj.base.result.ExOsResult;
import com.qsj.pojo.OsCustomer;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5 
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

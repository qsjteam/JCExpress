package com.qsj.service;

import com.qsj.base.result.ExOsResult;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public interface TokenService {
	ExOsResult getCustomerToken(String token);
	
	ExOsResult deleteCustomerToken(String token);
}

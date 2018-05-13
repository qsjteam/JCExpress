package com.qsj.service;

import com.qsj.base.result.ExOsResult;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.service 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月21日 上午10:16:39 
 */
public interface TokenService {
	ExOsResult getCustomerToken(String token);
	
	ExOsResult deleteCustomerToken(String token);
}

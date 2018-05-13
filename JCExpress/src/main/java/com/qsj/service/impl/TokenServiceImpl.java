package com.qsj.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import com.qsj.base.result.ExOsResult;
import com.qsj.pojo.OsCustomer;
import com.qsj.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

/**   
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
	@Autowired
	private RedisTemplate redisTemplate;

	private String sessionKeyPrefix = "EXSESSION:";

	/**
	 * (non Javadoc) 
	 * @Title: getCustomerToken
	 * @Description:(更新token)
	 * @param token
	 * @return 
	 * @see com.qsj.service.TokenService#getCustomerToken(java.lang.String)
	 */
	@Override
	public ExOsResult getCustomerToken(String token) {
		String customerJson = (String) redisTemplate.opsForValue().get(sessionKeyPrefix + token);
		if (StringUtils.isBlank(customerJson)) {
			return new ExOsResult("您的身份已经过期", 403);
		}
		// 更新过期时间
		redisTemplate.expire(sessionKeyPrefix + token, 30, TimeUnit.MINUTES);
		// 转化对象
		JSONObject json = JSONObject.fromObject(customerJson);
		OsCustomer osCustomer = (OsCustomer) JSONObject.toBean(json, OsCustomer.class);
		return new ExOsResult(osCustomer, 200);
	}

	@Override
	public ExOsResult deleteCustomerToken(String token) {
		redisTemplate.delete(sessionKeyPrefix + token);
		if (redisTemplate.hasKey(sessionKeyPrefix + token)) {
			return new ExOsResult("系统出错", 404);
		}
		return new ExOsResult("退出成功", 200);
	}

}

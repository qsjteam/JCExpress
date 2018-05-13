package com.qsj.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import com.qsj.base.result.ExOsResult;
import com.qsj.mapper.CustomerMapper;
import com.qsj.pojo.OsCustomer;
import com.qsj.service.CustomerService;
import com.qsj.util.MD5;
import com.qsj.util.MailUtil;
import com.qsj.util.ModifyPasswordMailUtil;
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
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	// token的前缀
	private String sessionKeyPrefix = "EXSESSION:";
	// 注册key前缀
	private String registKeyPrefix = "REGIST:";
	// 发送邮件key前缀
	private String emailKeyPrefix = "SRNDEMAIL:";
	// 修改密码key
	private String modifyPasswordKeyPrefix = "MODIFYPASSWORD:";

	/**
	 * (non Javadoc)
	 * 
	 * @Title: customerLogin
	 * @Description:(用户登录 生成token)
	 * @param customerCode
	 * @param password
	 * @return
	 * @see com.qsj.service.CustomerService#customerLogin(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public ExOsResult customerLogin(String customerCode, String password) {
		List<OsCustomer> osCustomer = customerMapper.findCustomerByEmailOrTelephone(customerCode);
		if (osCustomer == null || osCustomer.size() == 0) {
			return new ExOsResult("用户名或密码错误", 400);
		}
		OsCustomer customer = osCustomer.get(0);
		// 未激活
		if (customer.getState().equals("0")) {
			return new ExOsResult(customer.getCustomer_email(), 403);
		}
		MD5 md5 = new MD5();
		if (!customer.getPassword().equals(md5.getMD5ofStr(password))) {
			return new ExOsResult("用户名或密码错误", 400);
		}
		String token = UUID.randomUUID().toString();
		customer.setPassword(null);
		redisTemplate.opsForValue().set(sessionKeyPrefix + token, JSONObject.fromObject(customer).toString(), 30,
				TimeUnit.MINUTES);
		return new ExOsResult(token, 200);
	}

	/**
	 * (non Javadoc)
	 * 
	 * @Title: registCustomer
	 * @Description:(注册用户)
	 * @param customer
	 * @return
	 * @see com.qsj.service.CustomerService#registCustomer(com.qsj.pojo.OsCustomer)
	 */
	@Override
	public ExOsResult registCustomer(OsCustomer customer) {
		// 判断邮箱是否被注册
		Integer hasEmail = customerMapper.findeHasEmail(customer.getCustomer_email());
		if (hasEmail > 1) {
			return new ExOsResult("该邮箱已经被注册", 400);
		}
		String password = customer.getPassword();
		MD5 md5 = new MD5();
		// 补全信息
		customer.setPassword(md5.getMD5ofStr(password));
		customer.setCreate_time(new Date());
		customer.setState("0");
		Integer count = customerMapper.insertCustomer(customer);
		String code = UUID.randomUUID().toString();
		if (count == 1) {
			// 注册code 存入redis
			redisTemplate.opsForValue().set(registKeyPrefix + code, customer.getCustomer_email(), 2, TimeUnit.DAYS);
			// 启用一个线程发送邮件
			new Thread(new MailUtil(customer.getCustomer_email(), code)).start();
			// 限制重复发送
			if (!redisTemplate.hasKey(emailKeyPrefix + customer.getCustomer_email())) {
				redisTemplate.opsForValue().set(emailKeyPrefix + customer.getCustomer_email(), "1", 5,
						TimeUnit.MINUTES);
			}
			return new ExOsResult("邮件发送成功", 200);
		} else {
			return new ExOsResult("邮件发送失败,请与管理员联系", 400);
		}
	}

	/**
	 * (non Javadoc)
	 * 
	 * @Title: sendEmail
	 * @Description:(重新发送邮件)
	 * @param email
	 * @return
	 * @see com.qsj.service.CustomerService#sendEmail(java.lang.String)
	 */
	@Override
	public ExOsResult sendEmail(String email) {
		if (StringUtils.isBlank(email)) {
			return new ExOsResult("邮件发送失败,请与管理员联系", 400);
		}
		String code = UUID.randomUUID().toString();
		// 判断五分钟内是不是已经发送过邮件
		if (!redisTemplate.hasKey(emailKeyPrefix + email)) {
			// 不存在就发送
			redisTemplate.opsForValue().set(emailKeyPrefix + email, "1", 5, TimeUnit.MINUTES);
			redisTemplate.opsForValue().set(registKeyPrefix + code, email, 2, TimeUnit.DAYS);
			new Thread(new MailUtil(email, code)).start();
			return new ExOsResult("邮件发送成功", 200);
		}
		return new ExOsResult("五分钟内只能发送一封邮件！！", 400);
	}

	/**
	 * (non Javadoc)
	 * 
	 * @Title: activeCustomer
	 * @Description:(激活用户)
	 * @param email
	 * @return
	 * @see com.qsj.service.CustomerService#activeCustomer(java.lang.String)
	 */
	@Override
	public Integer activeCustomer(String email) {
		return customerMapper.activeCustomer(email);
	}

	/**
	 * (non Javadoc)
	 * 
	 * @Title: modifyPassword
	 * @Description:(修改密码)
	 * @param password
	 * @param email
	 * @return
	 * @see com.qsj.service.CustomerService#modifyPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public ExOsResult modifyPassword(String password, String code) {
		if (!redisTemplate.hasKey(modifyPasswordKeyPrefix + code)) {
			return new ExOsResult("修改密码失败！！！", 400);
		} else {
			String email = (String) redisTemplate.opsForValue().get(modifyPasswordKeyPrefix + code);
			MD5 md5 = new MD5();
			Integer count = customerMapper.modifyPassword(md5.getMD5ofStr(password), email);
			if (count == 1) {
				return new ExOsResult("修改密码成功！！！", 200);
			}
		}
		return new ExOsResult("系统错误,请联系管理员", 400);
	}

	/**
	 * (non Javadoc)
	 * 
	 * @Title: sendModifyEmail
	 * @Description:(发送修改密码邮件)
	 * @param email
	 * @return
	 * @see com.qsj.service.CustomerService#sendModifyEmail(java.lang.String)
	 */
	@Override
	public ExOsResult sendModifyEmail(String email) {
		if (StringUtils.isBlank(email)) {
			return new ExOsResult("邮件发送失败,请与管理员联系", 400);
		}
		String code = UUID.randomUUID().toString();
		if (!redisTemplate.hasKey(emailKeyPrefix + email)) {
			// 不存在就发送
			redisTemplate.opsForValue().set(emailKeyPrefix + email, "1", 5, TimeUnit.MINUTES);
			redisTemplate.opsForValue().set(modifyPasswordKeyPrefix + code, email, 30, TimeUnit.MINUTES);
			new Thread(new ModifyPasswordMailUtil(email, code)).start();
			return new ExOsResult("邮件发送成功", 200);
		}
		return new ExOsResult("五分钟内只能发送一封邮件！！", 400);
	}

	/**
	 * 注册验证
	 */
	@Override
	public boolean registActive(String code) {
		// 判断code是否在redis里存在
		if (!redisTemplate.hasKey(registKeyPrefix + code)) {
			return false;
		} else {
			String email = (String) redisTemplate.opsForValue().get(registKeyPrefix + code);
			// 激活用户
			Integer count = customerMapper.activeCustomer(email);
			if (count == 1) {
				return true;
			}
		}
		return false;
	}
}

package com.qsj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qsj.pojo.OsCustomer;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.mapper 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月20日 下午9:41:19 
 */
public interface CustomerMapper {
	/**
	 * @Title: findCustomerByEmailOrTelephone  
	 * @Description: TODO(根据邮箱或者手机号寻找用户)  
	 * @param @param customerCode
	 * @param @return    设定文件  
	 * @return OsCustomer    返回类型  
	 * @throws
	 */
	List<OsCustomer> findCustomerByEmailOrTelephone(@Param("customerCode") String customerCode);

	/**
	 * @Title: insertCustomer  
	 * @Description: TODO(添加客户)  
	 * @param @param customer
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer insertCustomer(@Param("customer") OsCustomer customer);

	/**
	 * @Title: findeHasEmail  
	 * @Description: TODO(判断邮箱是否存在)  
	 * @param @param email    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	Integer findeHasEmail(@Param("email") String email);

	/**
	 * @Title: activeCustomer  
	 * @Description: TODO(激活用户)  
	 * @param @param email
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer activeCustomer(@Param("email") String email);

	/**
	 * @Title: modifyPassword  
	 * @Description: TODO(修改密码)  
	 * @param @param password
	 * @param @param email
	 * @param @return    设定文件  
	 * @return Integer    返回类型  
	 * @throws
	 */
	Integer modifyPassword(@Param("password") String password, @Param("email") String email);
}

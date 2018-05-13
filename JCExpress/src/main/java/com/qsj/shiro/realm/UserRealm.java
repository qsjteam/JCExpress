package com.qsj.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.qsj.pojo.OsCustomer;
import com.qsj.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright © 2018  The so-called success is to make extraordinary persistence in the ordinary.
 * 
 * @author qsjteam   
 * @date 2018-5-5
 */
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private CustomerService customerService;

	// doGetAuthorizationInfo 是权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		OsCustomer osCustomer = (OsCustomer) principals.getPrimaryPrincipal();
		if (osCustomer != null) {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			return authorizationInfo;
		}
		return null;
	}

	// doGetAuthorizationInfo 是身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		OsCustomer osCustomer = customerService.checkCustomer(username);
		if (osCustomer == null) {
			throw new UnknownAccountException();
		}
		if (!osCustomer.getState().equals("1")) {
			throw new DisabledAccountException();// 被冻结了
		} else {
			return new SimpleAuthenticationInfo(osCustomer, osCustomer.getPassword(), getName());
		}
	}
}

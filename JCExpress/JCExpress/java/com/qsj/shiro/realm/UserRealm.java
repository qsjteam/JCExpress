package com.qsj.shiro.realm;

import java.util.Set;

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
import com.qsj.dto.UserDTO;
import com.qsj.pojo.User;
import com.qsj.service.LoginService;
import com.qsj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright © 2017 Sometimes perseverance does win out.
 * 
 * @Package: com.qsj.realm
 * @author:作者 Mao
 * @date:创建时间 2017年12月19日 下午4:02:57
 */
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RoleService roleService;

	// doGetAuthorizationInfo 是权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User activeUser = (User) principals.getPrimaryPrincipal();
		if (activeUser != null) {
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			// 获取角色列表
			UserDTO userDto = roleService.getRolesByUserId(activeUser.getU_id());
			// 赋予角色
			authorizationInfo.setRoles(userDto.getRoleSigns());
			// 获取权限列表
			Set<String> permissions = roleService.getPermissions(userDto.getRoleIds());
			// 赋予权限
			authorizationInfo.setStringPermissions(permissions);
			return authorizationInfo;
		}
		return null;
	}

	// doGetAuthorizationInfo 是身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String loginName = token.getUsername();
		User activeUser = loginService.findUserByNameAndStatus(loginName);
		if (activeUser == null) {
			throw new UnknownAccountException();
		}
		if (activeUser.getStatus().equals("0")) {
			throw new DisabledAccountException();// 被冻结了
		} else {
			return new SimpleAuthenticationInfo(activeUser, activeUser.getPassword(), getName());
		}
	}
}

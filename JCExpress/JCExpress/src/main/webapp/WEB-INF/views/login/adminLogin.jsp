<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>JC Express</title>
	<link rel="shortcut icon" href="${maosta}/exp/images/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${maosta}/exp/css/login.css" />
	<script> var t1 = new Date().getTime(); baselocation='${pageContext.request.contextPath}';</script>
</head>
<body>
<!-- <form action="" method="post"> -->
<dl class="admin_login">
  <dt> <strong>锦程物流管理系统</strong> <em>Management System</em> </dt>
  <dd class="user_icon">
    <input type="text" name="userName"  placeholder="账号" class="login_txtbx"/>
  </dd>
  <dd class="pwd_icon">
    <input type="password" name="Password" placeholder="密码" class="login_txtbx"/>
  </dd>
  <dd class="val_icon">
    <div class="checkcode">
      <input type="text" id="J_codetext" name="jcaptchaCode" placeholder="验证码" maxlength="4" class="login_txtbx">
      <img class="J_codeimg" src="${mao}/kaptcha/getKaptchaImage.jpg" id="kaptchaImage" /> </div>
    <input type="button" value="点击,换一张" class="ver_btn"  onclick="$(this).prev().find('img').click()">
  </dd>
  <dd>
    <input type="button" value="立即登陆" class="submit_btn"/>
  </dd>
  <dd>
    <p>©2018 JC Express, Inc. Licensed under qsj license.</p>
    <p><span id="showsectime"></span></p>
  </dd>
</dl>
<!-- </form> -->
<script src="${maosta}/common/jquery/jquery-3.2.0.min.js"></script> 
<script src="${maosta}/common/layer/layer.js"></script> 
<script src="${maosta}/common/particleground/js/jquery.particleground.min.js"></script> 
<script src="${maosta}/exp/js/login.js"></script>
</body>
</html>
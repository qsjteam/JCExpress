<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Regist | JC Express</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="${maosta}/assets/images/favicon.png">
  <link rel="stylesheet" href="${maosta}/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="${maosta}/assets/css/style.css">
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>锦程快递</h1>
    <p>JC Express<br/>安全放心便捷</p>
  </div>
  <hr />
</div>
<div class="am-g am-g-fixed">
  <div class="am-u-lg-2 am-u-md-4">
	<label for=""></label>
  </div>
    <div class="am-u-lg-4 am-u-md-5">
	<ul class="am-avg-sm-1 am-avg-md-1 am-avg-lg-1 am-thumbnails m-service-list">
		  <li>
			<i class="am-icon-home am-icon-fw"></i>
			积分奖励，电子运单专享特权</li>
		  <li>
			<i class="am-icon-book am-icon-fw"></i>
			快件路由订阅、快件信息管理、批量下单</li>
		  <li>
		    <i class="am-icon-pencil am-icon-fw"></i>
			收寄件积分奖励、积分抵运费</li>
		  <li>
		    <i class="am-icon-pencil am-icon-fw"></i>
			生日特权、会员专享特色惠购</li>
	</ul>
  </div>
  <div class="am-u-lg-4 am-u-md-6 ">
    <h3>锦程快递会员登录</h3>
    <hr>
    <form method="post" id="login_form" class="am-form">
      <label for="email">帐号:</label>
      <input type="email" name="username"  value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password"  value="">
      <br>
      <div class="am-cf am-margin-bottom" id="embed-captcha"></div>
      <p id="wait" style="display: block;">正在加载验证码......</p>
	  <p id="notice" style="display: none;">请先拖动验证码到相应位置</p>
      <div class="am-cf">
        <input type="button" id="login" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <a id="login" href="${mao}/modify" class="am-btn am-btn-default am-btn-sm am-fr">忘记密码 ^_^? </a>
      </div>
	  <br>
	  <a href="${mao}/regist">没有账号蛮?注册点哈这儿</a>
    </form>
    <hr>
 </div>

</div>
<div class="am-g am-g-fixed am-text-align">
 <hr>
 <div class="am-u-lg-5 am-u-md-12 am-u-sm-centered ">
<p>©2017 JC Express, Inc. Licensed under QJS license.</p>
</div>
</div>
<script src="${maosta}/assets/js/jquery.min.js"></script>
<script src="${maosta}/assets/js/amazeui.min.js"></script>
<script src="${maosta}/captcha/geetest.js"></script>
<script src="${maosta}/expWebSite/js/login.js"></script>
</body>
</html>

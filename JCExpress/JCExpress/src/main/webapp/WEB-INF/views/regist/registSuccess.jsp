<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>Login | JC Express</title>
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
  <div class="am-u-lg-3 am-u-md-5">
	<label for=""></label>
  </div>
  <div class="am-u-lg-4 am-u-md-6 ">
    <h3>锦程快递会员注册</h3>
    <hr>
    	<p>注册成功,请前往邮箱进行验证！！</p>
      <div class="am-cf">
      	<a type="button"  href="${mao}/login"  class="am-btn am-btn-primary am-btn-sm am-fl">登录</a>
      	<a  href="${mao}/modify" class="am-btn am-btn-default am-btn-sm am-fr">忘记密码 ^_^? </a>
      </div>
	  <br>
	  <a href="${mao}/regist">没有账号哦?注册点击这里</a>
    <hr>
 </div>
  <div class="am-u-lg-4 am-u-md-5">
	<ul class="am-avg-sm-1 am-avg-md-1 am-avg-lg-1 am-thumbnails m-service-list">
            <li>
              <div class="am-u-lg-2 am-u-md-12 m-service-list-icon am-hide-md-down">
                <i class="am-icon-code"></i>
              </div>
              <div class="am-u-lg-10 am-u-md-12 am-u-sm-12">
                <h3>积分奖励</h3>
                      <p>
						积分奖励，电子运单专享特权
                      </p>
              </div>
            </li>
            <li>
              <div class="am-u-lg-2 am-u-md-12 m-service-list-icon am-hide-md-down">
                <i class="am-icon-desktop"></i>
              </div>
              <div class="am-u-lg-10 am-u-md-12 am-u-sm-12">
              <h3>快件路由</h3>
              <p>
				    快件路由订阅、快件信息管理、批量下单
              </p>
              </div>
            </li>
			  <li>
            <div class="am-u-lg-2 am-u-md-12 m-service-list-icon am-hide-md-down">
              <i class="am-icon-bar-chart"></i>
            </div>
            <div class="am-u-lg-10 am-u-md-12 am-u-sm-12">
             <h3>收寄件积分</h3>
				 <p>
					 收寄件积分奖励、积分抵运费
				 </p>
            </div>
            </li>
            <li>
            <div class="am-u-lg-2 am-u-md-12 m-service-list-icon am-hide-md-down">
              <i class="am-icon-video-camera"></i>
            </div>
            <div class="am-u-lg-10 am-u-md-12 am-u-sm-12">
            <h3>生日特权</h3>
				  <p>
					 生日特权、会员专享特色惠购
				  </p>
            </div>
            </li>
	</ul>
  </div>
</div>
<div class="am-g am-g-fixed am-text-align">
 <hr>
 <div class="am-u-lg-5 am-u-md-12 am-u-sm-centered ">
<p>©2018 JC Express, Inc. Licensed under qsj license.</p>
</div>
</div>
<script src="${maosta}/assets/js/jquery.min.js"></script>
<script src="${maosta}/assets/js/amazeui.min.js"></script>
<script src="${maosta}/captcha/geetest.js"></script>
<script src="${maosta}/expWebSite/js/regist.js"></script>
</body>
</html>

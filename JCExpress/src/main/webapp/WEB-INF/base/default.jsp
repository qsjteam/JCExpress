<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title><sitemesh:write property='title' />qsj</title>
	<link rel="shortcut icon" href="${maosta}/exp/images/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${maosta}/common/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${maosta}/common/font-awesome/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${maosta}/exp/css/animate.css" />
	<link rel="stylesheet" href="${maosta}/exp/css/style.css" />
	<script> var t1 = new Date().getTime(); baselocation='${mao}';</script>
	<sitemesh:write property='head' />
  </head>
  <body class="fixed-sidebar full-height-layout gray-bg">
  	<sitemesh:write property='body' />
  	<!-- 全局js -->
	<script src="${maosta}/common/jquery/jquery-3.2.0.min.js"></script>
	<script src="${maosta}/common/bootstrap/js/bootstrap.min.js"></script>
	<script src="${maosta}/common/metismenu/metisMenu.min.js"></script>
	<script src="${maosta}/common/slimscroll/jquery.slimscroll.min.js"></script>
	<!-- layer弹出框js -->
    <script src="${maosta}/common/layer/layer.js"></script>
    <!-- iCheck --> 
  	<script src="${maosta}/common/icheck/icheck.min.js"></script> 
  	<!-- bootstrapvalidator-master前端验证框架 --> 
  	<script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
	<!-- 自定义js -->
	<script src="${maosta}/exp/js/hplus.js"></script>
	<script src="${maosta}/exp/js/contabs.js"></script>
	<script src="${maosta}/exp/js/content.js"></script>
	<sitemesh:write property='myfooter' />
  </body>
</html>

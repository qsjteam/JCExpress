<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改司机</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
         <h5>修改司机<small><b>用户个人信息时应当遵循合法、正当、必要的原则，明示目的、方式和范围，并经用户同意<big>♂</big></b></small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${mao}/driver/list/${driver.id}" data-method="put">
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">司机姓名：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" value="${driver.name}" name="name">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">司机手机号：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${driver.telephone}" name="telephone">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">司机住址：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${driver.address}" name="address">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">是否启用：</label>
              <div class="col-sm-5">
                <label class="radio-inline">
                  <input type="radio" name="status" value="1" ${driver.status eq '1' ? 'checked="checked"':''}>
               			  启用</label>
                <label class="radio-inline">
                  <input type="radio" name="status" value="0" ${driver.status eq '0' ? 'checked="checked"':''}>
                		  冻结</label>
                <label class="radio-inline status-tip">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <div class="col-sm-12 text-center">
                <button class="btn btn-primary" type="submit">提交</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<myfooter> 
	<script src="${maosta}/common/jquery/jquery-3.2.0.min.js"></script> 
  <!-- iCheck --> 
  <script src="${maosta}/common/icheck/icheck.min.js"></script> 
  <!-- bootstrapvalidator前端验证框架 --> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/adminDriver.js"></script> 
</myfooter>
</body>
</html>

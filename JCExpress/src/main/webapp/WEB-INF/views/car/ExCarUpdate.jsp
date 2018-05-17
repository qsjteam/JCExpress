<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改车辆</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
         <h5>修改车辆<small><b>用户个人信息时应当遵循合法、正当、必要的原则，明示目的、方式和范围，并经用户同意<big>♂</big></b></small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${mao}/car/list/${car.id}" data-method="put">
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">车牌号：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" value="${car.car_number}" name="car_number">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">车辆类型：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${car.car_type}" name="car_type">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">车辆型号：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${car.car_model}" name="car_model">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">车辆载重：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${car.car_load}" name="car_load">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">选择司机：</label>
              <div class="col-sm-7">
               <select  class="combobox form-control" name="driver_id">
				 <option value="">--请选择司机--</option>
                  <c:forEach items="${drivers}" var="driver">
                    <option value="${driver.id}" ${car.driver_id eq driver.id ?'selected="selected"':''}>${driver.name}</option>
                  </c:forEach>
				</select>
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">是否启用：</label>
              <div class="col-sm-5">
                <label class="radio-inline">
                  <input type="radio" name="status" value="1" ${car.status eq '1' ? 'checked="checked"':''}>
               			  启用</label>
                <label class="radio-inline">
                  <input type="radio" name="status" value="0" ${car.status eq '0' ? 'checked="checked"':''}>
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
    <script src="${maosta}/common/bootstrap/js/bootstrap.min.js"></script> 
    <script src="${maosta}/common/layer/layer.js"></script> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/exCar.js"></script> 
</myfooter>
</body>
</html>

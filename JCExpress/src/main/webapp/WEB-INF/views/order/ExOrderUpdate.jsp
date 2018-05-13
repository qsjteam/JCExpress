<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改订单</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
         <h5>修改订单<small><b>只能在审核期间才可以更改！客户申请更改必须严谨<big>♂</big></b></small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${mao}/order/updateOrder/${order.order_id}" data-method="put">
            <p>寄件人信息</p>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">收件人姓名：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" value="${order.send_name}" name="send_name">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">联系方式：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${order.send_telephone}" name="send_telephone">
              </div>
            </div>
          	<div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">寄出区域：</label>
           	 <div class="col-sm-7">
           	 	 <input type="text"  class="form-control" value="${order.send_area}" name="send_area">
           	 </div>
           	</div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">寄出详细地址：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${order.send_address}" name="send_address">
              </div>
            </div>
            <p>收件人信息</p>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">收件人姓名：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" value="${order.receive_name}" name="receive_name">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">联系方式：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${order.receive_telephone}" name="receive_telephone">
              </div>
            </div>
          	<div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">收取区域：</label>
             <div class="col-sm-7">
              <input type="text"  class="form-control" value="${order.receive_area}" name="receive_area">
           	 </div>
           	</div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">寄出详细地址：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${order.receive_address}" name="receive_address">
              </div>
            </div>
            <p>订单详细信息</p>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">订单重量：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${orderDetail.order_weight}" name="order_weight">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">订单类型：</label>
              <div class="col-sm-7">
                <input type="text"  class="form-control" value="${orderDetail.order_type}" name="order_type">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">备注：</label>
              <div class="col-sm-7">
                <textarea class="form-control" rows="2" name="remarks" placeholder="请输入消息...">${orderDetail.order_remark}</textarea>
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
  <script src="${maosta}/exp/js/exOrderAudit.js"></script> 
</myfooter>
</body>
</html>

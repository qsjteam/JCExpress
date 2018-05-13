<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>订单性情</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
<link rel="stylesheet" href="${maosta}/common/step/css/jquery.step.css"/>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>订单详细信息</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
       	  <div class="ibox-content">
                <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">订单流程</a>
                        </li>
                        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">详细信息</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane active">
                            <div class="panel-body">
                                <div id="step" style="width:800px"></div>
                            </div>
                        </div>
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                                <form id="form" class="form-horizontal">
					             <div class="form-group m-t">
					              <label class="col-sm-2 col-xs-offset-1 control-label">订单号：</label>
					              <div class="col-sm-7">
					                	<label class="col-xs-offset-1 control-label">${orderDetail.order_id}</label>
					              </div>
					            </div>
					            <div class="hr-line-dashed"></div>
					            <div class="form-group m-t">
					              <label class="col-sm-2 col-xs-offset-1 control-label">物品类型：</label>
					              <div class="col-sm-7">
					               		<label class="col-xs-offset-1 control-label">${orderDetail.order_type}</label>
					              </div>
					            </div>
					            <div class="hr-line-dashed"></div>
					            <div class="form-group m-t">
					              <label class="col-sm-2 col-xs-offset-1 control-label">备注：</label>
					              <div class="col-sm-7">
					                    <label class="col-xs-offset-1 control-label">${orderDetail.order_remark}</label>
					              </div>
					            </div>
					            <div class="hr-line-dashed"></div>
					            <div class="form-group m-t">
					              <label class="col-sm-2 col-xs-offset-1 control-label">产物品图片：</label>
					              <div class="col-sm-7">
					              		<img alt="image" src="${maoimg}/${orderDetail.order_img}" alt="加载中..." style="width: 350px; height: 350px;" />
					              </div>
					            </div>
					          </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </div>
      </div>
    </div>
  </div>
</div>
<myfooter> 
  <!-- iCheck --> 
  <script src="${maosta}/common/icheck/icheck.min.js"></script> 
  <!-- bootstrapvalidator前端验证框架 --> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- jquery  step插件 -->
  <script src="${maosta}/common/step/js/jquery.step.min.js"></script> 
  <!-- 自定义js -->
  <script>
   var $date="${date}";
   var $title="${title}";
   var $status="${status}";
   var orderDate= $date.split(",");
   var orderTitle= $title.split(",");
   var $step = $("#step");
	$step.step({
		index: parseInt($status),
		time: 500,
		title:orderTitle,
		date:orderDate
	});
  </script>
</myfooter>
</body>
</html>

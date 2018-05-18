<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>会员列表 </title>
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>会员列表</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <div id="toolbar" class="btn-group m-t-sm">
                  </div>
                  <table id="table"
                         data-toggle="table"
                         data-height="600"
                         data-search="true"
                         data-show-refresh="true"
                         data-show-toggle="true"
                         data-show-export="true"
                         data-show-pagination-switch="true"
                         data-show-columns="true"
                         data-url="${mao}/customer/list/"
                         data-pagination="true"
                         data-page-size="20"
                         data-page-list="[20, 50, 100, 200]"
                         data-side-pagination="server"
                         data-striped="true"
                         data-pagination="true"
                         data-sort-order="desc"
                         data-toolbar="#toolbar">
                    <thead>
                      <tr>
                        <th data-field="id" data-formatter="nameFormatter" data-halign="center" data-align="center" data-sortable="true">ID</th>
                        <th data-field="customer_telephone" data-halign="center" data-align="center" data-sortable="true">手机</th>
                        <th data-field="nickname" data-halign="center" data-align="center" data-sortable="true">昵称</th>
                        <th data-field="customer_email" data-halign="center" data-align="center" data-sortable="true">邮箱</th>
                        <th data-field="create_time" data-formatter="registerTimeFormatter" data-halign="center" data-align="center" data-sortable="true">注册时间</th>
                        <th data-field="state" data-formatter="stateFormatter" data-halign="center" data-align="center">状态</th>
                        <th data-formatter="actionFormatter" data-events="actionEvents" data-halign="center" data-align="center">操作</th>
                      </tr>
                    </thead>
                  </table>
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
  <script src="${maosta}/common/jquery/jquery-3.2.0.min.js"></script> 
  <!-- Bootstrap table --> 
  <script src="${maosta}/common/bootstrap/js/bootstrap.min.js"></script> 
  <script src="${maosta}/common/bootstrap-table/bootstrap-table.min.js"></script> 
  <script src="${maosta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script> 
  <script src="${maosta}/common/bootstrap-table/tableExport.js"></script> 
  <script src="${maosta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script> 
  <script src="${maosta}/common/layer/layer.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/customerList.js"></script> 
  <script src="${maosta}/exp/js/content.js"></script> 
</myfooter>
</body>
</html>
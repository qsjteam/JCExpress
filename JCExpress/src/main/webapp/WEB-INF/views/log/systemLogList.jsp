<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>管理员列表 </title>
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>日志列表</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <table id="table">
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
  <script src="${maosta}/common/bootstrap-table/bootstrap-table.min.js"></script> 
  <script src="${maosta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script> 
  <script src="${maosta}/common/bootstrap-table/tableExport.js"></script> 
  <script src="${maosta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script> 
  <!-- 自定义js --> 
  <script>
var baselocation = "/JCExpress";
var $table = $('#table');
$(function() {
	$table.bootstrapTable({
		url: baselocation + '/system/log/',
		height: '650',
		striped: true,
		search: true,
		showRefresh: true,
		showColumns: true,
		minimumCountColumns: 2,
		clickToSelect: true,
		detailView: true,
		detailFormatter: 'detailFormatter',
		pagination: true,
		paginationLoop: false,
		sidePagination: 'server',
		pageSize: '20',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		searchOnEnterKey: true,
		idField: 'log_id',
		maintainSelected: true,
		sortName: 'log_id',
		sortOrder: 'desc',
		toolbar: '#toolbar',
		columns: [
			{field: 'log_id', title: '编号', sortable: true, align: 'center', halign: 'center'},
			{field: 'user_id', title: '操作用户', align: 'center', halign: 'center'},
            {field: 'create_time', title: '操作时间', formatter: "timeFormatter", halign: 'center'},
			{field: 'spend_time', title: '耗时', align: 'center', sortable: true, halign: 'center'},
			{field: 'url', title: '请求路径', halign: 'center'},
			{field: 'method', title: '请求类型', align: 'center', halign: 'center'},
			{field: 'user_agent', title: '用户标识', halign: 'center'},
			{field: 'user_ip', title: 'IP地址', align: 'center', halign: 'center'}
		]
	});
});
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
function timeFormatter(value) {
	return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
}
  </script> 
</myfooter>
</body>
</html>
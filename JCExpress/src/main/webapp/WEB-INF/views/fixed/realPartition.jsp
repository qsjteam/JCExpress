<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>已关联分区 </title>
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>已关联分区</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                	<div id="toolbar" class="btn-group">
                     <button type="button" class="btn btn-default"  title="取消关连" onclick="noRela_fixed()"> <i class="glyphicon glyphicon-remove">取消关连</i> </button>
              		</div>
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
  <script src="${maosta}/exp/js/systemFixedCheck.js"></script> 
  <script>
var fixedId = '${fixedId}';
var $table = $('#table');
$(function() {
	$table.bootstrapTable({
		url: baselocation + '/fixed/list/realPartition/'+fixedId,
		height: '550',
		striped: true,
		search: true,
		showRefresh: true,
		showColumns: true,
		clickToSelect: true,
		pagination: true,
		sidePagination: 'server',
		pageSize: '20',
		silentSort: false,
		smartDisplay: false,
		escape: true,
		searchOnEnterKey: true,
		maintainSelected: true,
		sortOrder: 'desc',
		toolbar: '#toolbar',
		columns: [
			{checkbox : true},
			{field: 'addresskey', title: '关键字', align: 'center', halign: 'center'},
			{field: 'address', title: '地址', align: 'center', halign: 'center'}
		]
	});
});
  </script> 
</myfooter>
</body>
</html>
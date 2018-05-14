<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>区域列表 </title>
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
<link rel="stylesheet" href="${maosta}/common/ztree/css/metroStyle/metroStyle.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
  <div class="col-md-2 no-padding">
    <div class="panel panel-default">
		<div class="ibox-title">
          <h5>区域列表</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a></div>
        </div>
		<div class="ibox-content" id="treePanel" style="overflow: auto;">
			<ul id="areaTree" class="ztree"></ul>
		</div>
	</div>
  </div>
  <div class="col-md-10 no-padding">
		 <div class="ibox-title">
          <h5>区域列表</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a></div>
        </div>
         <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
              		<div id="toolbar" class="btn-group">
                     <button type="button" class="btn btn-default"  title="创建区域" onclick=" add_region();"> <i class="glyphicon glyphicon-plus"></i> </button>
              		</div>
                  <table id="table" data-toolbar="#toolbar">
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
  <!-- ztree --> 
  <script src="${maosta}/common/ztree/js/jquery.ztree.all.min.js"></script> 
  
  <script src="${maosta}/common/layer/layer.js"></script> 
  <script src="${maosta}/common/particleground/js/jquery.particleground.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/systemRegionList.js"></script> 
</myfooter>
</body>
</html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>修改定区</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
         <h5>修改定区<small><b>用户个人信息时应当遵循合法、正当、必要的原则，明示目的、方式和范围，并经用户同意<big>♂</big></b></small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${mao}/fixed/list/${sysFixed.id}" data-method="put">
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">定区编号：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" value="${sysFixed.fixed_code }" class="form-control" name="fixed_code">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">定区名称：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" value="${sysFixed.fixed_name }" class="form-control" name="fixed_name">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">负责派送员：</label>
              <div class="col-sm-7">
                <select  class="combobox form-control" name="staff_id">
				 <option value="">--请选择取派员--</option>
                  <c:forEach items="${staffs}" var="staff">
                    <option value="${staff.id}" ${sysFixed.staff_id eq staff.id ?'selected="selected"':''}>${staff.name}</option>
                  </c:forEach>
				</select>
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">是否启用：</label>
              <div class="col-sm-9">
                <label class="radio-inline">
                  <input type="radio" name="status" value="1" ${sysFixed.status eq '1' ? 'checked="checked"':''}>
               			  启用</label>
                <label class="radio-inline">
                  <input type="radio" name="status" value="0" ${sysFixed.status eq '0' ? 'checked="checked"':''}>
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
  <!-- Bootstrap table --> 
      <script src="${maosta}/common/bootstrap/js/bootstrap.min.js"></script> 
<script src="${maosta}/common/layer/layer.js"></script> 
  <script src="${maosta}/common/bootstrap-table/bootstrap-table.min.js"></script> 
  <script src="${maosta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script> 
  <script src="${maosta}/common/bootstrap-table/tableExport.js"></script> 
  <script src="${maosta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script> 
  <!-- iCheck --> 
  <script src="${maosta}/common/icheck/icheck.min.js"></script> 
  <!-- bootstrapvalidator前端验证框架 --> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- ztree --> 
  <script src="${maosta}/common/ztree/js/jquery.ztree.all.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/systemFixed.js"></script> 
</myfooter>
</body>
</html>

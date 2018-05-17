<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>更新角色</title>
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
<link rel="stylesheet" href="${maosta}/common/ztree/css/metroStyle/metroStyle.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>更新角色<small> 角色信息时应当遵循合法、正当、必要的原则，明示目的、方式和范围。</small></h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <form id="form" class="form-horizontal" action="${mao}/role/list/${role.role_id}" data-method="put">
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1  control-label">角色名称：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" name="role_name" value="${role.role_name}">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group m-t">
              <label class="col-sm-2 col-xs-offset-1 control-label">角色标志：</label>
              <div class="col-sm-7">
                <input type="text" maxlength="10" class="form-control" name="role_sign" value="${role.role_sign}">
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">是否可用：</label>
              <div class="col-sm-9">
                <label class="radio-inline">
                  <input type="radio" name="status" value="1" ${role.status eq '1' ? 'checked="checked"':''}>
                  		开启</label>
                <label class="radio-inline">
                  <input type="radio" name="status" value="0" ${role.status eq '0' ? 'checked="checked"':''}>
               		          冻结</label>
                <label class="radio-inline status-tip"><strong>提示：</strong> 状态</label>
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">角色授权：</label>
              <div class="col-sm-9">
                <div id="ztree" class="ztree"></div>
              </div>
            </div>
            <div class="hr-line-dashed"></div>
            <div class="form-group">
              <label class="col-sm-2 col-xs-offset-1 control-label">角色备注：</label>
              <div class="col-sm-7">
                <textarea class="form-control" rows="2" name="remarks" placeholder="请输入消息...">${role.remarks}</textarea>
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
	<script src="${maosta}/common/bootstrap/js/bootstrap.min.js"></script> 
<script src="${maosta}/common/layer/layer.js"></script> 
  <!-- iCheck --> 
  <script src="${maosta}/common/icheck/icheck.min.js"></script> 
  <!-- bootstrapvalidator前端验证框架 --> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- ztree --> 
  <script src="${maosta}/common/ztree/js/jquery.ztree.all.min.js"></script> 
  <!-- 自定义js --> 
  <script type="text/javascript">
  		var treedata = '${menus}';
  </script> 
  <script src="${maosta}/exp/js/adminRole.js"></script> 
</myfooter>
</body>
</html>

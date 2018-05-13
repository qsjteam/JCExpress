<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>个人信息 </title>
<link rel="stylesheet" href="${maosta}/common/bootstrap-table/bootstrap-table.min.css" />
<link rel="stylesheet" href="${maosta}/common/icheck/flat/green.css" />
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-5">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>管理员信息</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content form-horizontal">
          <form id="form">
            <div class="form-group">
              <label class="col-sm-3 control-label">用户名：</label>
              <div class="col-sm-6">
                <input name="login_name" type="text" class="form-control form-disabled" disabled="disabled" value="${user.login_name}">
              </div>
                <div class="col-sm-3">
                  <button type="button" class="btn btn-warning pull-right" onclick="change_Password();">修改密码</button>
                </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">姓名：</label>
              <div class="col-sm-6">
                <input name="user_name" type="text" class="form-control form-disabled" disabled="disabled" value="${user.user_name}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">性别：</label>
              <div class="col-sm-6">
                <input id="sex"  type="text" class="form-control" disabled="disabled" value="<c:if test="${user.sex==1 }">男</c:if><c:if test="${user.sex==2 }">女</c:if><c:if test="${user.sex==0 }">保密</c:if>">
                <label class="radio-inline add-radio" style="display: none;">
                  <input type="radio"  name="sex" value="1" ${user.sex eq '1'?'checked="checked"':''}>
                  男</label>
                <label class="radio-inline add-radio" style="display: none;">
                  <input type="radio" name="sex" value="2" ${user.sex eq '2'?'checked="checked"':''}>
                  女</label>
                <label class="radio-inline add-radio" style="display: none;">
                  <input type="radio" name="sex" value="0" ${user.sex eq '0'?'checked="checked"':''}>
                  保密</label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">年龄：</label>
              <div class="col-sm-6">
                <input name="age" type="text" class="form-control form-disabled" disabled="disabled" value="${user.age}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">移动电话：</label>
              <div class="col-sm-6">
                <input name="telephone" type="text" class="form-control form-disabled" disabled="disabled" value="${user.telephone}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label ">电子邮箱：</label>
              <div class="col-sm-6 stm-inp">
                <input name="email" type="text" class="form-control form-disabled" disabled="disabled" value="${user.email}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">权限：</label>
              <div class="col-sm-6">
                <input type="text" class="form-control disabled-form-control" disabled="disabled" value="<c:forEach items="${roles}" var="role">${role.role_name}&nbsp;&nbsp;</c:forEach>">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">所属组织：</label>
              <div class="col-sm-6">
                <input type="text" class="form-control disabled-form-control" disabled="disabled" value="${fulin:organizationName(user.organization_id)}">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">注册时间：</label>
              <div class="col-sm-6">
                <input type="text" class="form-control disabled-form-control" disabled="disabled" value="<fmt:formatDate value="${user.create_time}" pattern="yyyy/MM/dd HH:mm" />">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">最后登录时间：</label>
              <div class="col-sm-6">
                <input type="text" class="form-control disabled-form-control" disabled="disabled" value="<fmt:formatDate value="${user.last_login_time}" pattern="yyyy/MM/dd HH:mm" />">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">最后登录IP：</label>
              <div class="col-sm-6">
                <input type="text" class="form-control disabled-form-control" disabled="disabled" value="${user.last_login_ip}">
              </div>
            </div>                        
            <div class="form-group">
              <div class="col-sm-8 col-sm-offset-3">
                  <button type="button" class="btn btn-primary pull-left m-r-md" onclick="modify();">修改信息</button>
                <button type="button" class="btn btn-success" onclick="save_info();" style="display: none;">保存修改</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div class="col-sm-7">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>管理员登陆记录</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="example-wrap">
                <div class="example">
                  <table id="table"
                       data-toggle="table"
                       data-height="600"
                       data-search="true"
                       data-show-refresh="true"
                       data-show-toggle="true"
                       data-show-export="true"
                       data-url="${mao}/user/info/showLoginLog"
                       data-pagination="true"
                       data-page-size="20"
                       data-page-list="[20, 50, 100, 200]"
                       data-side-pagination="server"
                       data-striped="true"
                       data-pagination="true"
                       data-sort-name="login_time"
                       data-sort-order="desc">
                    <thead>
                      <tr>
                        <th data-field="login_time" data-formatter="loginTimeFormatter" data-halign="center" data-align="center" data-sortable="true">登录时间</th>
                        <th data-field="user_ip" data-halign="center" data-align="center" data-sortable="true">登录IP</th>
                        <th data-field="operating_system" data-halign="center" data-align="center" data-sortable="true">操作系统</th>
                        <th data-field="browser" data-halign="center" data-align="center" data-sortable="true">游览器</th>
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
<div class="ibox-content form-horizontal" id="change_Pass" style="display: none;">
  <div class="form-group">
    <label class="col-sm-4 control-label">原密码：</label>
    <div class="col-sm-6">
      <input name="nowPassword" type="password" class="form-control" >
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-4 control-label">新密码：</label>
    <div class="col-sm-6">
      <input name="newPassword" type="password" class="form-control" >
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-4 control-label">确认密码：</label>
    <div class="col-sm-6">
      <input name="confirmPwd" type="password" class="form-control">
    </div>
  </div>
</div>
<myfooter> 
  <!-- bootstrapvalidator-master前端验证框架 --> 
  <script src="${maosta}/common/bootstrapvalidator/js/bootstrapValidator.min.js"></script> 
  <!-- Bootstrap table --> 
  <script src="${maosta}/common/bootstrap-table/bootstrap-table.min.js"></script> 
  <script src="${maosta}/common/bootstrap-table/extensions/export/bootstrap-table-export.js"></script> 
  <script src="${maosta}/common/bootstrap-table/tableExport.js"></script> 
  <script src="${maosta}/common/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script> 
  <!-- iCheck --> 
  <script src="${maosta}/common/icheck/icheck.min.js"></script> 
  <!-- 自定义js --> 
  <script src="${maosta}/exp/js/adminUserInfo.js"></script> 
</myfooter>
</body>
</html>

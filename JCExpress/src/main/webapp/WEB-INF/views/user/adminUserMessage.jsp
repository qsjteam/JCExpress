<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>%>
<!DOCTYPE HTML>
<html>
<head>
<title>个人资料</title>
</head>

<body class="gray-bg">
<div class="middle-box text-center lockscreen animated fadeInDown">
  <div>
    <div class="m-b-md"> <img src="${maosta}/${user.pic_img}" alt="头像加载中..." class="img-circle circle-border" style="width: 59px; height: 59px;"> </div>
    <h3>${user.login_name}</h3>
    <div class="hr-line-dashed"></div>
    <div class="member_content">
      <ul>
        <li>
          <label class="label_name">姓名：</label>
          <span class="name">${user.user_name}</span></li>
        <li>
          <label class="label_name">年龄：</label>
          <span class="name">${user.age}</span></li>
        <li>
          <label class="label_name">性别：</label>
          <span class="name">${user.sex eq '0'?'保密':''}${user.sex eq '1'?'男':''}${user.sex eq '2'?'女':''}</span></li>
        <li>
          <label class="label_name">手机：</label>
          <span class="name">${user.telephone}</span></li>
        <li>
          <label class="label_name">邮箱：</label>
          <span class="name">${user.email}</span></li>
        <li>
          <label class="label_name">注册时间：</label>
          <span class="name">
          <fmt:formatDate value="${user.create_time}" pattern="yyyy/MM/dd HH:mm" />
          </span></li>
        <li>
          <label class="label_name">创建者：</label>
          <span class="name">${user.create_by}</span></li>
        <li>
          <label class="label_name">更新者：</label>
          <span class="name">${user.update_by}</span></li>
        <li>
          <label class="label_name">权限：</label>
          <span class="name">
          <c:forEach items="${roles}" var="role">${role.role_name}&nbsp;&nbsp;</c:forEach>
          </span></li>
        <li>
          <label class="label_name">所属组织：</label>
          <span class="name">${fulin:organizationName(user.organization_id)}</span></li>
      </ul>
    </div>
  </div>
</div>
</body>
</html>
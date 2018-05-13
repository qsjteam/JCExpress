<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>组织管理</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
<button type="button" class="btn btn-default"  title="返回" onclick="javascript:window.location.href='${mao}/organization/list/organizationDetail'"> <i class="glyphicon glyphicon-arrow-left"></i> </button>
  <div class="row">
    <c:forEach items="${UserVos}" var="userVo">
      <div class="col-sm-4">
        <div class="contact-box">
          <div class="col-sm-4">
            <div class="text-center"> <img src="${maosta}/${userVo.pic_img}" alt="头像加载中..." class="img-circle m-t-xs img-responsive">
              <div class="m-t-xs font-bold">${userVo.user_name }</div>
            </div>
          </div>
          <div class="col-sm-8">
            <h3><strong>${userVo.user_name }</strong></h3>
            <p><i class="fa fa-map-marker"></i>
              <c:forEach items="${userVo.roles}" var="role">${role.role_name}&nbsp;&nbsp;</c:forEach>
            </p>
            <address>
            <strong>${userVo.sex eq '0'?'保密':''}${userVo.sex eq '1'?'男':''}${userVo.sex eq '2'?'女':''}&nbsp; ${userVo.age }</strong><br>
            E-mail:${userVo.email }<br>
            <abbr title="Phone">Tel:</abbr> ${userVo.telephone }<br>
            	上次登录时间:
            <fmt:formatDate value="${userVo.last_login_time}" pattern="yyyy/MM/dd HH:mm" />
            <br>
            </address>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<myfooter> 
  <script type="text/javascript">
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
     </script> 
</myfooter>
</body>
</html>
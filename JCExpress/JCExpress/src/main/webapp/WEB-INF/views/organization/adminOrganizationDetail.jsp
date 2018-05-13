<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>组织管理</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
<button type="button" class="btn btn-default"  title="返回" onclick="javascript:window.location.href='${mao}/organization/list/organizationList'"> <i class="glyphicon glyphicon-arrow-left"></i> </button>
  <div class="row">
    <c:forEach items="${OrganizationVos}" var="OrganizationVo">
      <div class="col-sm-4">
        <div class="ibox">
          <div class="ibox-title">
            <c:if test="${OrganizationVo.status eq '0' }"> <span class="label label-danger pull-right">冻结</span></c:if>
            <h5>编号-${OrganizationVo.org_id } - ${OrganizationVo.org_name }</h5>
          </div>
          <div class="ibox-content">
            <div class="team-members"> <a href="${mao}/organization/list/${OrganizationVo.org_id}/organizationUserDetail">
              <c:forEach items="${OrganizationVo.users }" var="user"><img src="${maosta}/${user.pic_img}" alt="头像加载中..." class="img-circle"> </c:forEach>
              </a></div>
            <h4>组织简介</h4>
            <p> ${OrganizationVo.remarks} </p>
            <div class="row  m-t-sm">
              <div class="col-sm-4">
                <div class="font-bold">组织人数</div>
                <i class="fa fa-user-times text-navy"></i>&nbsp;&nbsp;&nbsp;&nbsp;${OrganizationVo.number} </div>
              <div class="col-sm-4 col-md-offset-4 text-right">
                <div class="font-bold">成立时间</div>
                <i class="fa fa-calendar-times-o text-navy"></i>&nbsp;&nbsp;
                <fmt:formatDate value="${OrganizationVo.create_time}" pattern="yyyy/MM/dd HH:mm" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@taglib prefix="fulin" uri="http://mao.com/fulin/tags/fulin"%> --%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String projectPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	String staticPath = projectPath + "/static";
%>
<%--项目路径 --%>
<c:set var="basePath" value="<%=projectPath%>"></c:set>
<c:set var="mao" value="${pageContext.request.contextPath}"/>
<%--静态资源路径 --%>
<c:set var="maosta" value="${pageContext.request.contextPath}/static"/>
<%--图片路径 --%>
<c:set var="maoimg" value="http://192.168.80.101"/>




<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>菜单管理 </title>
<link rel="stylesheet" href="${maosta}/common/treeTable/themes/vsStyle/treeTable.min.css" />
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>菜单列表</h5>
          <div class="ibox-tools"> <a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a class="close-link"><i class="fa fa-times"></i></a> </div>
        </div>
        <div class="ibox-content">
          <div class="row row-lg">
            <div class="col-sm-12">
              <div class="btn-group m-t-sm">
                  <button type="button" class="btn btn-default"  title="创建菜单" onclick="layer_show('创建菜单','${mao}/system/menu/1/createMenu','900','700')"> 创建菜单  <i class="glyphicon glyphicon-plus"></i> </button>
                <button type="button" class="btn btn-default"  title="刷新列表" onclick="javascript:window.location.reload()"> 刷新列表  <i class="glyphicon glyphicon-refresh"></i> </button>
              </div>
              <table id="treeTable" class="table table-bordered table-striped">
                <thead>
                  <tr>
                    <th>菜单名称</th>
                    <th>权限代码</th>
                    <th>链接地址</th>
                    <th class="text-center">排序</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">权限标识</th>
                    <th class="text-center">操作</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${menus}" var="menu">
                    <tr id="${menu.menu_id}" pId="${menu.parent_id ne '1' ? menu.parent_id:'0'}">
                      <td class="${menu.parent_id eq '1'?'menu_name':''}"><i class="fa fa-${not empty menu.icon ? menu.icon:' hide'} m-l-xs m-r-xs"></i>${menu.menu_name}</td>
                      <td>${menu.menu_code}</td>
                      <td>${menu.href}</td>
                      <td class="text-center">${menu.sort}</td>
                      <td class="td-status text-center"><span class="label ${menu.status eq '1'?'label-primary':'label-danger'}">${menu.status eq '1'?'显示':'隐藏'}</span></td>
                      <td class="text-center">${menu.permission}</td>
                      <td class="td-manage text-center">
                          <c:if test="${menu.status eq 1}">
                          <a class="like text-info" href="javascript:void(0)" onClick="status_stop(this,'${menu.menu_id}')" title="隐藏">
                          <i class="glyphicon glyphicon-pause"></i>
                          </a>
                          </c:if>
                          <c:if test="${menu.status eq 0}">
                          <a class="like text-info" href="javascript:void(0)" onClick="status_start(this,'${menu.menu_id}')" title="显示">
                          <i class="glyphicon glyphicon-play"></i>
                          </a>
                          </c:if>
                        <a class="edit m-l-sm text-warning" href="javascript:void(0)" onclick="layer_show('编辑菜单','${mao}/system/menu/${menu.menu_id}/updateMenu','900','700')" title="编辑"> <i class="glyphicon glyphicon-edit"></i> </a>
                        <a class="remove m-l-sm text-danger" href="javascript:void(0)" onclick="menu_delete(this,'${menu.menu_id}')" title="删除"> <i class="glyphicon glyphicon-remove"></i> </a>
                         <c:if test="${menu.menu_type != 0}"> 
                         <a class="remove m-l-sm text-primary" href="javascript:void(0)" onclick="layer_show('创建菜单','${mao}/system/menu/${menu.menu_id}/createMenu','900','700')" title="添加下级菜单"> 
                         <i class="glyphicon glyphicon-sort-by-attributes-alt"></i> 
                         </a>
                         </c:if>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<myfooter> 
	<script src="${maosta}/common/jquery/jquery-3.2.0.min.js"></script> 
  <script src="${maosta}/common/treeTable/jquery.treeTable.min.js"></script> 
  <script src="${maosta}/exp/js/systemMenuList.js"></script> 
  <script src="${maosta}/hplus/js/plugins/layer/layer.min.js"></script>
</myfooter>
</body>
</html>
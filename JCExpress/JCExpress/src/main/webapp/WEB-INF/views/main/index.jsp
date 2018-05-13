<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>锦程</title>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    	<link rel="shortcut icon" href="${maosta}/exp/images/favicon.ico" type="image/x-icon" />
    <link href="${maosta}/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${maosta}/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${maosta}/hplus/css/animate.min.css" rel="stylesheet">
    <link href="${maosta}/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div style="margin-left: 30px" class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="${maosta}/<shiro:principal  property='pic_img'/>" alt="头像加载中..." style="width: 64px; height: 64px;" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span style="margin-left:12px"  class="block m-t-xs">
                                 <strong class="font-bold"><shiro:principal  property="login_name"/></strong>
                               </span>
                                <span style="margin-left:12px"  class="text-muted text-xs block"><shiro:principal  property="user_name"/><b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                                </li>
                                <li><a class="J_menuItem" href="profile.html">个人资料</a>
                                </li>
                                <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                                </li>
                                <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="${mao}/logout">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">A+
                        </div>
                    </li>
                    <!-- 菜单开始 -->
                    <!-- menu.childMenus.size() -->
                    <c:forEach items="${menus}" var="menu">
			          <c:choose>
			            <c:when test="${menu.childMenus != null && fn:length(menu.childMenus)>0}">
			              <li> <a href="${menu.href}"> <i class="fa fa-${menu.icon}"></i> <span class="nav-label">${menu.menu_name}</span> <span class="fa arrow"></span> </a>
			                <ul class="nav nav-second-level">
			                  <c:forEach items="${menu.childMenus}" var="childMenu">
			                    <li> <a class="J_menuItem" href="${mao}${childMenu.href}"><i class="fa fa-${childMenu.icon}"></i>${childMenu.menu_name}</a> </li>
			                  </c:forEach>
			                </ul>
			              </li>
			            </c:when>
			            <c:otherwise>
			              <li> <a class="J_menuItem" href="${pageContext.request.contextPath }${menu.href}"> <i class="fa fa-${menu.icon}"></i> <span class="nav-label">${menu.menu_name}</span> </a> </li>
			            </c:otherwise>
			          </c:choose>
			        </c:forEach>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="http://www.zi-han.net/theme/hplus/search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="m-t-xs">
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index_v1.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="${mao}/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="www.baidu.com" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; ©2018 JC Express, Inc. Licensed under qsj license. 
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                    <li class=""><a data-toggle="tab" href="#tab-2">
                     		   通知
                    </a>
                    </li>
                    <li><a data-toggle="tab" href="#tab-3">
                       			 项目进度
                    </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>
                        		固定宽度
                 			   </span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             		默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                           		 蓝色主题
                        </a>
                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                         		  黄色/紫色主题
                        </a>
                    </span>
                            </div>
                        </div>
                    </div>
                    <div id="tab-2" class="tab-pane">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
                            <small><i class="fa fa-tim"></i>您当前没有通知</small>
                        </div>
                        <div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                    	好烦的bug啊啊啊啊啊啊
                                        <br>
                                        <small class="text-muted">今天 0:00</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                       <!--  <img alt="image" class="img-circle message-avatar" src="img/a2.jpg"> -->
                                    </div>
                                    <div class="media-body">
                                        	啊啊啊啊啊啊啊啊还有9999999个bug
                                        <br>
                                        <small class="text-muted">昨天 25:00</small>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div id="tab-3" class="tab-pane">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-cube"></i> 最新任务</h3>
                            <small><i class="fa fa-tim"></i> 您当前有99999个任务，0个已完成</small>
                        </div>

                        <ul class="sidebar-list">
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">999999小时以后</div>
                                    <h4>项目开发</h4> 赶紧完成；

                                    <div class="small">已完成： 0%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 0%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">项目截止： 明天</div>
                                </a>
                            </li>
                        </ul>

                    </div>
                </div>

            </div>
        </div>
        <!--右侧边栏结束-->
    </div>
    <script src="${maosta}/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="${maosta}/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${maosta}/hplus/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${maosta}/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${maosta}/hplus/js/plugins/layer/layer.min.js"></script>
    <script src="${maosta}/hplus/js/hplus.min.js?v=4.1.0"></script>
    <script type="text/javascript" src="${maosta}/hplus/js/contabs.min.js"></script>
    <script src="${maosta}/hplus/js/plugins/pace/pace.min.js"></script>
</body>
</html>

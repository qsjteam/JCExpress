<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html class="no-js" lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>服务内容-关于锦程-锦程速递</title>
	<style type="text/css">
		th{
			border: 1px solid black;
			text-align: center;
			line-height: center;
		}
		td{
			border: 1px solid black;
			text-align: center;
			line-height: center;
		}
		
	</style>
		<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp"/>
	<link rel="alternate icon" type="image/png" href="${maosta}/assets/images/favicon.png">
	<link rel="stylesheet" href="${maosta}/assets/css/amazeui.min.css">
	<link rel="stylesheet" href="${maosta}/assets/css/style.css">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js"></script>
	<![endif]-->
</head>
<!--[if lt IE 9]>
<div class="am-modal am-modal-no-btn am-modal-active" tabindex="-1" id="doc-modal-1" style="display: block; width: 400px; margin-left: -200px; margin-top: -112px;">
<div class="am-modal-dialog">
<div class="am-modal-hd">365 安全卫士提醒</div>
<div class="am-modal-bd">你的浏览器太古董了，还不换一个你就奥特曼了
    <a href="http://browsehappy.com/" target="_blank" class="am-btn am-btn-danger am-btn-sm am-radius" rel="nofollow">速速点击换一个</a>
    </div>
</div>
</div>
<![endif]-->
<body>
<header class="m-hd">
   <section data-am-sticky class="am-show-md-up">
    <div class="am-container">
		<!--<ul class="am-fr m-about">
                <li><a href="/about/" class="am-btn am-btn-danger am-btn-sm am-radius" rel="nofollow">关于我们</a></li>
                <li><a href="/contact/" class="am-btn am-btn-danger am-btn-sm am-radius" rel="nofollow">联系我们</a></li>
            </ul> -->
        <nav>
         <ul class="m-nav am-nav am-nav-pills am-fr">
            <li><a href="${mao}/index" rel="nofollow">网站首页</a></li>
            <li><a href="${mao}/fuwu" rel="nofollow">服务内容</a></li>
            <li><a href="${mao}/zixun" rel="nofollow">最新动态</a></li>
			<li><a href="${mao}/piliang" rel="nofollow">会员专区</a></li>
            <li><a href="${mao}/about" rel="nofollow">关于我们</a></li>
            <li><a href="${mao}/contact" rel="nofollow">联系我们</a></li>
			<li><a href="${mao}/login"  id="login" class="am-btn am-btn-primary" rel="nofollow">登录</a></li>
         	<li><a href="${mao}/regist"  id="regist" class="am-btn am-btn-success" rel="nofollow">注册</a></li>
          </ul>
        </nav>
    </section>

    </div>
   <nav data-am-widget="header" class="am-header am-show-sm-only">
      <div class="am-header-left am-header-nav">
        <a href="${mao}/index" rel="nofollow">
          <i class="am-header-icon am-icon-home"></i> 首页
        </a>
      </div>
      <h1 class="am-header-title">
        <a href="${mao}/index" rel="nofollow">拉德速递</a>
      </h1>
      <div class="am-header-right am-header-nav">
        <a href="#right-link" class="" data-am-offcanvas="{target: '#r-nav'}">
          <i class="am-header-icon am-icon-bars"></i> 菜单
        </a>
      </div>
    </nav> 

    <!-- 侧边栏内容 -->
    <div id="r-nav" class="am-offcanvas">
      <div class="am-offcanvas-bar am-offcanvas-bar-flip">
        <nav class="am-offcanvas-content">
            <a href="/" rel="nofollow"><span class="logo"></span></a>
            <p><i class="am-icon-home"></i> <a href="${mao}/index" rel="nofollow">网站首页</a></p>
            <p><i class="am-icon-cogs"></i> <a href="${mao}/fuwu" rel="nofollow">服务内容</a></p>
            <p><i class="am-icon-credit-card"></i> <a href="${mao}/zixun" rel="nofollow">最新动态</a></p>
            <p><i class="am-icon-user"></i> <a href="${mao}/about" rel="nofollow">关于我们</a></p>
            <p><i class="am-icon-qq"></i> <a href="${mao}/contact" rel="nofollow">联系我们</a></p>
        </nav>
      </div>
    </div>
</header>
<div class="m-header-banner m-list-header" style="background: url(${maosta}/assets/images/service-bg.jpg) 50% 0 no-repeat fixed;">
    <section class="am-container">
        <hgroup data-am-scrollspy="{animation:'slide-bottom', delay: 317}">
            <h2>服务内容</h2>
            <p>我们期待与您的携手，与您合作驱动企业价值增长，我们与伙伴共同成长。</p>
        </hgroup>
    </section>
</div>
<nav class="m-cat-nav">
    <ul class="am-container">
                <li ><a href="${mao}/about"><i class="icon-chevron-right"></i>关于拉德</a></li>
                <li ><a href="${mao}/fuwu"><i class="icon-chevron-right"></i>服务内容</a></li>
                <li ><a href="${mao}/xiadan"><i class="icon-chevron-right"></i>在线下单</a></li>
                <li class="am-active"><a href="#"><i class="icon-chevron-right"></i>在线查单</a></li>
            </ul>
</nav>
<section class="am-container m-service-page">
    <div class="m-service-container">
     <h2>在线查单</h2>
	 <div class="am-g am-g-xfixed am-text-center">
		<div class="am-u-md-3">
			<label for="" class=""></label>
		</div>
		<div class="am-u-md-6" >
		<form action="" class="am-form" data-am-validator>
		<div data-am-widget="tabs"class="am-tabs am-tabs-d2">
		  <ul class="am-tabs-nav am-cf">
			  <li class="am-active"><a href="[data-tab-panel-0]">按订单号</a></li>
			  <li class=""><a href="[data-tab-panel-1]">按手机号</a></li>
			  <li class=""><a href="[data-tab-panel-2]">网点查询</a></li>
		  </ul>
		  <div class="am-tabs-bd">
			  <div data-tab-panel-0 class="am-tab-panel am-active">
			    <div class="am-form-group">
					<div class="am-u-md">
					<input name="Num" type="text" id="Num" placeholder="输入正确的单号"
						pattern="^\d{20}$" required />
					</div>
					<div class="am-u-md am-margin-top-lg">
						<div class="am-u-md" >
							<button class="am-btn am-btn-secondary" type="button"
								id="NumButton" onclick="chadan()">查询</button>
						</div>
					</div>
				</div>
			  </div>
			  <div data-tab-panel-1 class="am-tab-panel ">
				<div class="am-form-group">
					<div class="am-u-md">
						<input name="Tel" type="text" id="Tel" placeholder="输入正确的手机号"
							pattern="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d{8}$"
							required />
					</div>
					<div class="am-u-md am-margin-top-lg">
						<div class="am-u-md" >
							<button class="am-btn am-btn-secondary" type="button"
								id="NumButton" onclick="chadanTel()">查询</button>
						</div>
					</div>
				</div>
			  </div>
			  <div data-tab-panel-2 class="am-tab-panel ">
				<div class="am-form-group">
				  <label for="doc-select-1">省市区</label>
				  <div class="am-g" id="doc-select-1">
				  <div class="am-u-md-4 am-margin-0 am-padding-0" >
				  <select  class="am-fl"  id="receiveProvince" name="receive_province">
					<option value="option1">-省-</option>
				  </select>
				  </div>
				  <div class="am-u-md-4 am-margin-0 am-padding-0">
				  <select  class="am-fl" id="receiveCity"  name="receive_city">
					<option value="option1">-市-</option>
				  </select>
				  </div>
				  <div class="am-u-md-4 am-margin-0 am-padding-0">
				  <select  class="am-fl" id="receiveVillage" name="receive_village">
					<option value="option1">-区-</option>
				  </select>
				  </div>
				  </div>
				</div>
				<div class="am-u-md am-margin-top-lg">
						<div class="am-u-md" >
							<button class="am-btn am-btn-secondary" type="button"
								id="NumButton" onclick="wangdian()">查询</button>
						</div>
					</div>
				</div>
		  </div>
		</div>
		</form>
		</div>
	</div>
    <div style="text-align: center;">
		  	<table style="height: 30px; border: 1px solid black ;" >
		  		<tbody id="tbody"></tbody>
		  	</table>
	</div>
    </div>
</section>
<footer class="m-footer">

<div class="am-container">
	<section class="am-g m-footer-container">
		<section class="am-u-sm-12 am-u-md-12 am-u-lg-6">
			<h2>关于我们</h2>
			<p>锦程速递成立于2018年，专注高端网站建设、视觉设计、平面设计、广告拍摄、产品摄影、营销策划和品牌网络推广为一体的创新高端公司，拥有超过8年行业经验的资深团队及设计、开发、摄影、营销、开发经验，强悍创新的视觉执行力<a href="/about" rel="nofollow">更多</a></p>
		</section>
		<section class="am-u-sm-12 am-u-md-6 am-u-lg-3">
            	<h2>最新资讯</h2>
			<ul>
								<li><time class="am-fr">90次阅读</time><a href="/post/151">台山社保局</a></li>
								<li><time class="am-fr">67次阅读</time><a href="/post/150">江门市外海小学</a></li>
								<li><time class="am-fr">72次阅读</time><a href="/post/148">恩城三小</a></li>
							</ul>
		</section>
		<section class="am-u-sm-12 am-u-md-6 am-u-lg-3 subnav">
			<h2>其他</h2>
			<a href="" rel="nofollow">网站欣赏</a> <a href="/sitemap">网站地图</a> <a href="" rel="nofollow">合作流程</a> <a href="" rel="nofollow">帮助中心</a> <a href="/contact" rel="nofollow">联系我们</a>
		</section>
	</section>
	</div>
<div class="m-footer-bottom">
  <div class="am-container">
  <div class="am-g">
    <span class="m-u-sm-12 am-u-md-9 am-u-lg-10">©2018 JC Express, Inc. Licensed under qsj license. <a href="http://www.miitbeian.gov.cn/" rel="external nofollow">川ICP备xxxxxx号-1</a>
</span>
    <span class="m-u-sm-12 am-u-md-3 am-u-lg-2 ico am-text-right am-hide-sm-only a">
      <a href="" data-am-popover="{content: '88888888', trigger: 'hover focus'}" rel="nofollow"><i class="am-icon-qq"></i></a>
      <a href="" data-am-popover="{content: '138-0000-0000', trigger: 'hover focus'}" rel="nofollow"><i class="am-icon-phone-square"></i></a>
      <a href="" data-am-popover="{content: '138-0000-0000', trigger: 'hover focus'}" rel="nofollow"><i class="am-icon-weixin"></i></a>
      <a href="" data-am-popover="{content: '11111@qq.com', trigger: 'hover focus'}" rel="nofollow"><i class="am-icon-envelope"></i></a>
    </span>
  </div>
  </div>
</div>
</footer>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${maosta}/assets/js/polyfill/rem.min.js"></script>
<script src="${maosta}/assets/js/polyfill/respond.min.js"></script>
<script src="${maosta}/assets/js/amazeui.legacy.js"></script>
<![endif]-->
<script src="${maosta}/assets/js/jquery.min.js"></script>

<script src="${maosta}/webuploader/webuploader.js"></script>
<script src="${maosta}/expWebSite/js/exCreateOrder.js"></script>
<script src="${maosta}/expWebSite/js/exOrderSelect.js"></script>
 <script src="${maosta}/assets/js/echo.min.js"></script>
 <script>
  echo.init({
    offset: 100,
    throttle: 250,
    unload: false,
    callback: function (element, op) {
      console.log(element, 'has been', op + 'ed')
    }
  });
  // 图片赖加载
  </script>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${maosta}/assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src='${maosta}/assets/js/jquery.qrcode.min.js'></script>
<script src="${maosta}/expWebSite/js/jquery.cookie.js"></script>
<script src="${maosta}/expWebSite/js/customerToken.js"></script>


<script type="text/javascript">
	function chadan() {
		var mytt=$("#Num").val();

		console.log(mytt);
		$("#Tel").text('');
		$.ajax({
			type : "post",
			url : "/JCExpress/order/selectOrder",//发送的后台地址
			data : {'id':mytt},
			dataType:"json",
			success : function(obj) {
				$("#tbody").empty();
				
				var list = obj.data;
				if(list){
					var tr = $("<tr><td name='order_id'>"
							+ '单号'
							+ "</td><td name='send_name'>"
							+ '寄件人'
							+ "</td><td name='send_telephone'>"
							+ '寄件人电话'
							+ "</td><td name='send_area'>"
							+ '原寄地区'
							+ "</td><td name='send_address'>"
							+ '原寄件人地址'
							+ "</td><td name='receive_name'>"
							+ '收货人名字'
							+ "</td><td name='receive_telephone'>"
							+ '收货人电话'
							+ "</td><td name='receive_area'>"
							+'收货人区域'
							+"</td><td name='receive_address'>"
							+'收货人地址'
							+"</td><td name='update_time'>"
							+'修改时间'
							+"</td><td name='create_time'>"
							+ '创建时间'
							+"</td><td name='status'>"
							+'现状'
							+"</td><td name='customer_id'>"
							+'customer_id'
							+"</td></tr>");
					$("#tbody").append(tr);
					$.each(list,function(index,value){
						// 在table 中生成tr 
						var tr = $("<tr><td name='order_id'>"
								+ value.order_id
								+ "</td><td name='send_name'>"
								+ value.send_name
								+ "</td><td name='send_telephone'>"
								+ value.send_telephone
								+ "</td><td name='send_area'>"
								+ value.send_area
								+ "</td><td name='send_address'>"
								+ value.send_address
								+ "</td><td name='receive_name'>"
								+ value.receive_name
								+ "</td><td name='receive_telephone'>"
								+ value.receive_telephone
								+ "</td><td name='receive_area'>"
								+value.receive_area
								+"</td><td name='receive_address'>"
								+value.receive_address
								+"</td><td name='update_time'>"
								+(new Date(value.update_time)).Format("yyyy-MM-dd")
								+"</td><td name='create_time'>"
								+ (new Date(value.create_time)).Format("yyyy-MM-dd")
								+"</td><td name='status'>"
								+value.status
								+"</td><td name='customer_id'>"
								+value.customer_id
								+"</td></tr>");
							$("#tbody").append(tr);
						})
				}else{
					$("#tbody").css("margin","auto");
					$("#tbody").append("<tr><td>"+obj.message+"</td></tr>")
				}
			}
		})
		

	}
	
	function chadanTel(){
		var tel=$("#Tel").val();
		$("#Num").text('');
		$.ajax({
			type : "post",
			url : "/JCExpress/order/selectOrderB",//发送的后台地址
			data : {'id':tel},
			dataType:"json",
			success : function(obj) {
				$("#tbody").empty();
				
				var list = obj.data;
				if(list){
					var tr = $("<tr><td name='order_id'>"
							+ '单号'
							+ "</td><td name='send_name'>"
							+ '寄件人'
							+ "</td><td name='send_telephone'>"
							+ '寄件人电话'
							+ "</td><td name='send_area'>"
							+ '原寄地区'
							+ "</td><td name='send_address'>"
							+ '原寄件人地址'
							+ "</td><td name='receive_name'>"
							+ '收货人名字'
							+ "</td><td name='receive_telephone'>"
							+ '收货人电话'
							+ "</td><td name='receive_area'>"
							+'收货人区域'
							+"</td><td name='receive_address'>"
							+'收货人地址'
							+"</td><td name='update_time'>"
							+'修改时间'
							+"</td><td name='create_time'>"
							+ '创建时间'
							+"</td><td name='status'>"
							+'现状'
							+"</td><td name='customer_id'>"
							+'customer_id'
							+"</td></tr>");
					$("#tbody").append(tr);
					$.each(list,function(index,value){
						// 在table 中生成tr 
						var tr = $("<tr><td name='order_id'>"
								+ value.order_id
								+ "</td><td name='send_name'>"
								+ value.send_name
								+ "</td><td name='send_telephone'>"
								+ value.send_telephone
								+ "</td><td name='send_area'>"
								+ value.send_area
								+ "</td><td name='send_address'>"
								+ value.send_address
								+ "</td><td name='receive_name'>"
								+ value.receive_name
								+ "</td><td name='receive_telephone'>"
								+ value.receive_telephone
								+ "</td><td name='receive_area'>"
								+value.receive_area
								+"</td><td name='receive_address'>"
								+value.receive_address
								+"</td><td name='update_time'>"
								+(new Date(value.update_time)).Format("yyyy-MM-dd")
								+"</td><td name='create_time'>"
								+ (new Date(value.create_time)).Format("yyyy-MM-dd")
								+"</td><td name='status'>"
								+value.status
								+"</td><td name='customer_id'>"
								+value.customer_id
								+"</td></tr>");
							$("#tbody").append(tr);
						})
				}else{
					$("#tbody").css("margin","auto");
					$("#tbody").append("<tr><td>"+obj.message+"</td></tr>")
				}
			}
		})
		
	}
	
	Date.prototype.Format = function(fmt)     
	{   
 	//author:wangweizhen  
	  var o = {     
	    "M+" : this.getMonth()+1,                 //月份     
	    "d+" : this.getDate(),                    //日  
	    "h+" : this.getHours(),                   //小时     
	    "m+" : this.getMinutes(),                 //分     
	    "s+" : this.getSeconds(),                 //秒     
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度     
	    "S"  : this.getMilliseconds()             //毫秒     
	  };     
	  if(/(y+)/.test(fmt))     
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
	  for(var k in o)     
	    if(new RegExp("("+ k +")").test(fmt))     
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
	  return fmt;     
	};
</script>
<script type="text/javascript">
	function wangdian() {
		console.log("-----------------------11")
		var myare=$("#receiveVillage option:selected").text();
		$.ajax({
			type : "post",
			url : "/JCExpress/fixed/list/findFixed",//发送的后台地址
			data : {'name':myare},
			dataType:"json",
			success : function(obj) {
				console.log(obj);
				$("#tbody").empty();
				var list = obj.data;
				if(list){
					var tr = $("<tr><td name='id'>"
							+ 'id'
							+ "</td><td name='fixed_code'>"
							+ '网点编号'
							+ "</td><td name='staff_id'>"
							+ '备注id'
							+ "</td><td name='fixed_name'>"
							+ '网点名'
							+ "</td><td name='fixed_adress'>"
							+ '网点地址'
							+ "</td><td name='status'>"
							+ '状态'
							+"</td></tr>");
					$("#tbody").append(tr);
					$.each(list,function(index,value){
						// 在table 中生成tr 
						var tr = $("<tr><td name='id'>"
								+ value.id
								+ "</td><td name='fixed_code'>"
								+ value.fixed_code
								+ "</td><td name='staff_id'>"
								+ value.staff_id
								+ "</td><td name='fixed_name'>"
								+ value.fixed_name
								+ "</td><td name='fixed_adress'>"
								+ value.fixed_adress
								+ "</td><td name='status'>"
								+ value.status
								+"</td></tr>");
							$("#tbody").append(tr);
						})
				}
			}
		})
	}
</script>

</body>
</html>
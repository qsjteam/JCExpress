<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/base/base.jsp"%>
<!DOCTYPE HTML>
<html class="no-js" lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>锦程快递</title>
	<style type="text/css">
	.mytable {  
    table-layout: fixed;  
    width: 98% ;  
    margin: 0px;  
}  
	.mytable tr td {  
	    text-overflow: ellipsis; /* for IE */  
	    -moz-text-overflow: ellipsis; /* for Firefox,mozilla */  
	    overflow: hidden;  
	    white-space: nowrap;  
	    text-align: left;
	    color: white;
	    height: 30px;
	}
	.mytable tr {
		height: 30px;
	}
	
	
	</style>
		<meta name="description" content="锦程" />
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
<style>
.myoverflow{width:100%;
     word-break:keep-all;/* 不换行 */
     white-space:nowrap;/* 不换行 */
     overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
     text-overflow:ellipsis;/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/}
</style>
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
			<div id="view" style="height: 30px; " >
   				<table class="mytable" id="mytable" style="width: 60%;margin:auto"  
   					onmouseout="this.int=window.setInterval('scroll2()',1000)" 
   					onmouseover="window.clearInterval(this.int)" >
    			 	<tbody id="tbody"  >
    			 		
    			 	</tbody>
    			</table>
</div>
        </nav>
    </section>
	
    </div>
    <nav data-am-widget="header" class="am-header am-show-sm-only">
      <div class="am-header-left am-header-nav">
        <a href="/" rel="nofollow">
          <i class="am-header-icon am-icon-home"></i> 首页
        </a>
      </div>
      <h1 class="am-header-title">
        <a href="/" rel="nofollow">锦程网络</a>
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
            <p><i class="am-icon-home"></i> <a href="/" rel="nofollow">网站首页</a></p>
            <p><i class="am-icon-desktop"></i> <a href="/anli" rel="nofollow">案例展示</a></p>
            <p><i class="am-icon-cogs"></i> <a href="/fuwu" rel="nofollow">服务内容</a></p>
            <p><i class="am-icon-credit-card"></i> <a href="/zixun" rel="nofollow">最新动态</a></p>
            <p><i class="am-icon-user"></i> <a href="/about" rel="nofollow">关于我们</a></p>
            <p><i class="am-icon-qq"></i> <a href="/contact" rel="nofollow">联系我们</a></p>
        </nav>
      </div>
    </div>
</header>

<div data-am-widget="slider" class="am-slider am-slider-i2" data-am-flexslider="{controlNav:false}">
    <ul class="am-slides">
        <li class="am-slider-images" style="background-image: url(${maosta}/assets/images/banner1.jpg)">
            <div class="am-container am-slider-desc">
                <div class="am-slider-content">
                    <h2 class="am-slider-title am-animation-slide-left" data-am-scrollspy="{animation: 'slide-left', delay: 100}">创新企业定制服务</h2>
                    <p data-am-scrollspy="{animation:'slide-right', delay: 600}" class="am-animation-slide-right">来自锦程网络永不畏惧的创新力量</p>
                    <a href="${mao}/fuwu" class="am-btn-xs am-btn am-btn-danger am-radius am-animation-slide-bottom am-animation-delay-1" rel="nofollow" data-am-scrollspy="{animation:'slide-bottom', delay: 100}">READ MORE</a>
                </div>
            </div>
        </li>
    </ul>
</div>

<div class="m-services m-home-box">
    <section class="am-container">
        <hgroup class="am-animation-slide-bottom am-animation-delay-1" data-am-scrollspy="{animation:'slide-bottom', delay: 100}">
            <h2>我们的服务</h2>
            <p>全力为江门恩平中小企业提供网页设计、网站建设、淘宝/天猫/京东等店铺详情装修设计、产品摄影、广告拍摄、营销策划、平面设计、品牌推广等高端订制服务。</p>
        </hgroup>
        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-6 am-thumbnails">
            <li class="am-animation-slide-top" data-am-scrollspy="{animation:'slide-top', delay: 0}">
                <h2>网页设计</h2>
                <p>为客户提供专业化、品牌化的PC手机网站设计、助您在网络领域超越同行者。</p>
            </li>
            <li class="am-animation-slide-top" data-am-scrollspy="{animation:'slide-top', delay: 0}">
                <h2>平面设计</h2>
                <p>专业的服务团队为您量身定制，优秀的设计方案及后期制作，为您解决一切后顾之忧。</p>
            </li>
          <li class="am-animation-slide-top am-animation-delay-1" data-am-scrollspy="{animation:'slide-top', delay: 100}">
                <h2>营销策划</h2>
                <p>运用专业营销理论思想与实战经验，帮助企业以更经济更快速的方式打开市场。</p>
            </li>
            <li class="am-animation-slide-top am-animation-delay-1" data-am-scrollspy="{animation:'slide-top', delay: 100}">
                <h2>广告拍摄</h2>
                <p>致力于本土电子行业产品拍摄、企业宣传拍摄、商业摄影等专业拍摄服务。</p>
            </li>
            <li class="am-animation-slide-top am-animation-delay-2" data-am-scrollspy="{animation:'slide-top', delay: 200}">
                <h2>电商设计</h2>
                <p>专注高端电商定制服务，打造顶级视觉传达设计服务，完美提升品牌形象。</p>
            </li>
            <li class="am-animation-slide-top am-animation-delay-2" data-am-scrollspy="{animation:'slide-top', delay: 200}">
                <h2>品牌策划</h2>
                <p>从定位到设计一系列的系统的视觉形象策划设计方案，为你排忧解难。</p>
            </li>
        </ul>
    </section>

</div>
<section class="am-container m-home-box m-partner">
    <hgroup data-am-scrollspy="{animation:'slide-bottom', delay: 100}">
        <h2>协助伙伴</h2>
        <p>用最具影响力品牌协助，并全力协助新兴品牌，我们以设计助力众多品牌走向行业领先地位，鼎力相助每一个梦想。</p>
    </hgroup>
    <ul class="am-avg-lg-8 am-avg-md-8 am-avg-sm-2  am-thumbnails" data-am-scrollspy="{animation:'slide-bottom', delay: 100}">
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 44}">
            <img src="${maosta}/assets/images/tencent.png" alt="腾讯" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 45}">
            <img src="${maosta}/assets/images/dianxin.png" alt="中国电信" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 399}">
            <img src="${maosta}/assets/images/aliyun.png" alt="阿里云" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 286}">
            <img src="${maosta}/assets/images/canon.png" alt="佳能" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 114}">
            <img src="${maosta}/assets/images/baidu.png" alt="百度" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 72}">
            <img src="${maosta}/assets/images/microsoft.png" alt="微软" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 190}">
            <img src="${maosta}/assets/images/apple.png" alt="苹果" class="am-img-responsive"></li>
        <li data-am-scrollspy="{animation:'slide-bottom', delay: 99}">
            <img src="${maosta}/assets/images/adobe.png" alt="adobe" class="am-img-responsive"></li>
    </ul>
</section>
<div class="m-home-box m-contact">
    <section class="am-container">
        <hgroup data-am-scrollspy="{animation:'slide-bottom', delay: 100}">
            <h2>联系我们</h2>
            <p>你可以通过以下方式和我们取得联系。</p>
        </hgroup>
        <ul class="am-avg-lg-4 am-avg-md-4 am-avg-sm-2 am-thumbnails">
            <li data-am-scrollspy="{animation:'slide-bottom', delay: 2}"> <i class="am-icon-qq"></i> 88888888
            </li>
            <li data-am-scrollspy="{animation:'slide-bottom', delay: 41}"> <i class="am-icon-phone-square"></i> 138-0000-0000
            </li>
            <li data-am-scrollspy="{animation:'slide-bottom', delay: 51}">
                <i class="am-icon-weixin"></i> 138-0000-0000
            </li>
            <li data-am-scrollspy="{animation:'slide-bottom', delay: 211}" >
                <i class="am-icon-envelope"></i> 1111@qq.com
            </li>
        </ul>
    </section>
</div>
<footer class="m-footer">

<div class="am-container">
    <section class="am-g m-footer-container">
        <section class="am-u-sm-12 am-u-md-12 am-u-lg-6">
            <h2>关于我们</h2>
            <p>拉德网络成立于2010年，专注高端网站建设、视觉设计、平面设计、广告拍摄、产品摄影、营销策划和品牌网络推广为一体的创新高端公司，拥有超过8年行业经验的资深团队及设计、开发、摄影、营销、开发经验，强悍创新的视觉执行力<a href="/about.html" rel="nofollow">更多</a></p>
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
            <a href="" rel="nofollow">网站欣赏</a> <a href="/sitemap.html">网站地图</a> <a href="" rel="nofollow">合作流程</a> <a href="" rel="nofollow">帮助中心</a> <a href="/contact.html" rel="nofollow">联系我们</a>
        </section>
    </section>
	</div>
<div class="m-footer-bottom">
	<div class="am-container">
	<div class="am-g">
		<span class="m-u-sm-12 am-u-md-9 am-u-lg-10">Copyright @ 2010 - 2015 www.imj2.com. All Rights Reserved 免费下载使用请保留作者网站版权信息 <a href="http://www.miitbeian.gov.cn/" rel="external nofollow">粤ICP备xxxxxx号-1</a> <a href="http://www.imj2.com/">江门网站设计</a>
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
<script src="${maosta}/assets/js/jquery.min.js"></script>
<script src="${maosta}/assets/js/amazeui.min.js"></script>
<script src="${maosta}/expWebSite/js/jquery.cookie.js"></script>
<script src="${maosta}/expWebSite/js/customerToken.js"></script>
<!--<![endif]-->
<script src='${maosta}/assets/js/jquery.qrcode.min.js'></script>
<script type="text/javascript">
$(function(){
	var str = "http://www.imj2.com";
		$("#code").qrcode({
			render: "table",
			width: 100,
			height:100,
			text: str
		});
})
// 二维码生成
//返回顶部
function imj2(){
	this.init();
}
imj2.prototype = {
	constructor: imj2,
	init: function(){
		this._initBackTop();
	},
	_initBackTop: function(){
		var $backTop = this.$backTop = $('<div class="m-top-cbbfixed">'+
						'<a class="m-top-weixin m-top-cbbtn"">'+
							'<span class="m-top-weixin-icon"></span><div></div>'+
						'</a>'+
						'<a class="m-top-go m-top-cbbtn">'+
							'<span class="m-top-goicon"></span>'+
						'</a>'+
					'</div>');
		$('body').append($backTop);

		$backTop.click(function(){
			$("html, body").animate({
				scrollTop: 0
			}, 120);
		});

		var timmer = null;
		$(window).bind("scroll",function() {
            var d = $(document).scrollTop(),
            e = $(window).height();
            0 < d ? $backTop.css("bottom", "10px") : $backTop.css("bottom", "-90px");
			clearTimeout(timmer);
			timmer = setTimeout(function() {
                clearTimeout(timmer)
            },100);
	   });
	}

}
var imj2 = new imj2();
//end返回顶部
</script>
<script type="text/javascript">
$(function () {
		$.ajax({
			type : "post",
			url : "/JCExpress/showView",//发送的后台地址
			dataType:"json",
			success : function(obj) {
				var list = obj.data;
				// 获取form的值
				/* var l="<marquee direction='up' scrollamount='3' loop='infinite'>"
				var j="</marquee>" */
				/* $("#tbody").append(l); */
				$.each(list,function(index,value){
					// 在table 中生成tr 
					var tr = $("<tr><td name='title'>"
						+ value.title
						+ "</td><td name='content' id='mycontent' onclick='show(this)'>"
						+ value.content
						+ "</td><td name='create_time'>"
						+ (new Date(value.create_time)).Format("yyyy-MM-dd")+"</td><td>查看详情</td></tr>");
					$("#tbody").append(tr);
					
				})
				/* $("#tbody").append(j); */
			}
		})
	}
)
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
function show(obj) {
	alert($(obj).html());
	
}
</script>
<script type="text/javascript">
function scroll2(){
	            var table = document.getElementById("mytable").getElementsByTagName("tbody")[0];
	            var row = table.lastChild;
	            table.removeChild(row);   
	            table.insertBefore(row,table.firstChild);
	        }
</script>

</body>
</html>
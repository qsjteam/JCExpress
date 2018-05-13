var baselocation = "/JCExpress";
var handlerEmbed = function(captchaObj) {
	$("#login").click(function(e) {
		var validate = captchaObj.getValidate();
		if (!validate) {
			$("#notice").show();
			setTimeout(function() {
				$("#notice").hide();
			}, 2000);
			e.preventDefault();
		} else {
			$.ajax({
				// 几个参数需要注意一下
				type : "POST",// 方法类型
				url : baselocation + "/customerLogin",// url
				data : $('#login_form').serialize(),
				success : function(result) {
					//console.log(result);// 打印服务端返回的数据(调试用)
					if (result.code == 200) {
						window.location.href=baselocation + "/index";
					}else if (result.code == 400) {
						alert(result.message);
						location.reload();
					}else if (result.code == 403) {
						window.location.href=baselocation + "/active";
					}
				},
				error : function() {
					alert("系统繁忙，请稍后再试...");
				}
			});
		}
	});
	// 将验证码加到id为captcha的元素里
	captchaObj.appendTo("#embed-captcha");
	captchaObj.onReady(function() {
		$("#wait").hide();
	});
	// 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
};
$.ajax({
	// 获取id，challenge，success（是否启用failback）
	url : baselocation + "/kaptchah/json",
	type : "get",
	dataType : "json",
	success : function(data) {
		// 使用initGeetest接口
		// 参数1：配置参数
		// 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
		initGeetest({
			gt : data.gt,
			challenge : data.challenge,
			product : "float", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
			offline : !data.success
		// 表示用户后台检测极验服务器是否宕机，一般不需要关注
		}, handlerEmbed);
	}
});
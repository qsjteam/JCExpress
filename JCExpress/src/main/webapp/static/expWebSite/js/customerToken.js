var baselocation = "/JCExpress";
$(function() {
	checkLogin();
});

function checkLogin() {
	var ticket = $.cookie("Ladd");
	if (ticket == "true") {
		return;
	}
	$.ajax({
		// 几个参数需要注意一下
		type : "GET",// 方法类型
		url : baselocation + "/customer/token/" + ticket ,// url
		data : $('#login_form').serialize(),
		success : function(result) {
			console.log(result);// 打印服务端返回的数据(调试用)
			if (result.code == 200) {
				var username = result.data.nickname;
				$("#login").text("欢迎:" + username);
				$("#login").attr("class", "");
				$("#regist").attr("id", "logout");
				$("#logout").text("退出");
				$("#logout").attr("href", baselocation + "/customer/logout/");
			}
			if (result.code == 403) {
			}
		},
		error : function() {
			alert("异常！");
		}
	});

}
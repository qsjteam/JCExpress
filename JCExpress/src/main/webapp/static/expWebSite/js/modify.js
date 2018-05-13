var baselocation = "/JCExpress";
function snedMail() {
	$.ajax({
		// 几个参数需要注意一下
		type : "post",// 方法类型
		url : baselocation + "/sendModifyEmail",// url
		data : {
			"email" : $("#email").val()
		},
		success : function(result) {
			console.log(result);// 打印服务端返回的数据(调试用)
			if (result.code == 200) {
				$("#p").empty();
				$("#p").text(result.message);
			}
			if (result.code == 400) {
				$("#p").empty();
				$("#p").text(result.message);
			}
		},
		error : function() {
			alert("异常！");
		}
	});

}

function modify() {
	var password = $("#password").val();
	var tpassword = $("#tpassword").val();
	if (password != tpassword) {
		$("#p").empty();
		$("#p").text("两次密码输入不一致");
		return;
	}
	$.ajax({
		// 几个参数需要注意一下
		type : "post",// 方法类型
		url : baselocation + "/modifyPassword",// url
		data : {
			"password" : $("#password").val(),
			"code":$("#code").val()
		},
		success : function(result) {
			console.log(result);// 打印服务端返回的数据(调试用)
			if (result.code == 200) {
				window.location.href=baselocation + "/modifySuccess";
			}
			if (result.code == 400) {
				$("#p").empty();
				$("#p").text(result.message);
			}
		},
		error : function() {
			alert("异常！");
		}
	});

}
var baselocation = "/JCExpress";
function snedMail() {
	$.ajax({
		// 几个参数需要注意一下
		type : "post",// 方法类型
		url : baselocation +"/sendEmail",// url
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
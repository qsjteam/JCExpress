var baselocation = "/JCExpress";
//图片上传
var $ = jQuery;
var $list = $('#fileList');
var ratio = window.devicePixelRatio || 1;
// 缩略图大小
var thumbnailWidth = 100 * ratio;
var thumbnailHeight = 100 * ratio;
// 初始化Web Uploader
var uploader = WebUploader.create({
	// 选完文件后，是否自动上传。
	auto : false,
	// swf文件路径
	swf : baselocation + '/sattic/webuploader/Uploader.swf',
	// 文件接收服务端。
	server : baselocation + '/upLoad',
	// 选择文件的按钮。可选。
	// 内部根据当前运行是创建，可能是input元素，也可能是flash.
	pick : {
		id : '#filePicker',
		multiple : false,
		label : '点击选择图片'
	},
	// 只允许选择图片文件。
	accept : {
		title : 'Images',
		extensions : 'gif,jpg,jpeg,bmp,png',
		mimeTypes : 'image/*'
	}
});
// 当有文件添加进来的时候
uploader
		.on('fileQueued',
				function(file) {
					$list.empty();
					var $li = $('<div id="' + file.id
							+ '" class="file-item thumbnail">' + '<img>'
							+ '<div class="info">' + file.name + '</div>'
							+ '</div>'), $img = $li.find('img');
					// $list为容器jQuery实例
					$list.append($li);
					// 创建缩略图
					// 如果为非图片文件，可以不用调用此方法。
					// thumbnailWidth x thumbnailHeight 为 100 x 100
					uploader.makeThumb(file, function(error, src) {
						if (error) {
							$img.replaceWith('<span>不能预览</span>');
							return;
						}
						$img.attr('src', src);
					}, thumbnailWidth, thumbnailHeight);
				});
// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on('uploadSuccess', function(file, str) {
	// $( '#'+file.id ).addClass('upload-state-done');
	var uploaderId = 'rt_' + file.source.ruid;// 获取当前节点id
	var $this = $("#" + uploaderId).parent();// 获取当前节点父类节点 a标签
	var par = $this.parent();// 获取当前节点祖父节点 div
	par.find("img:first").attr("src", str.path);// 获取祖父节点下第一个img标签，并赋值
	// par.find("a:first").find("div:first").find("div:last").find("input:first").attr("value",str.pathPic);
	form();
});

uploader.on('uploadAccept', function(file, response) {
	if (response.flag) {
		$("#order_img").val(response.servicePath);
		return true;
	}
	// 通过return false来告诉组件，此文件上传有错。
	return false;
});
// 文件上传失败，显示上传出错。
uploader.on('uploadError', function(file, str) {
	var $li = $('#' + file.id), $error = $li.find('div.error');
	// 避免重复创建
	if (!$error.length) {
		$error = $('<div class="error"></div>').appendTo($li);
	}
	$error.text('上传失败');
});
// 点击上传
function up() {
	console.log("<_______________________>")
	uploader.upload();
	from();
}
function from() {
	console.log("--------------------->");
	var send=$("#sendProvince").find("option:selected").text()+
	$("#sendCity").find("option:selected").text()+$("#sendVillage").find("option:selected").text();
	var receive=$("#receiveProvince").find("option:selected").text()+
	$("#receiveCity").find("option:selected").text()+$("#receiveVillage").find("option:selected").text();
	var params='';
	params+=$("#createOrder").serialize();
	params+="&send_area="+send+"&receive_area="+receive;
	$.ajax({
		// 几个参数需要注意一下
		type : "POST",// 方法类型
		dataType : "json",// 预期服务器返回的数据类型
		url : Backstagelocation + "/order/createOrder",// url
		data : params,
		success : function(result) {
			console.log(result);// 打印服务端返回的数据(调试用)
			if (result.data == 1) {
				console.log("MMP");
				AMUI.dialog.alert({
					title : '预约成功',
					content : '请耐心等待取派员取件',
					onConfirm : function() {
						console.log('close');
						window.location.reload();
					}
				})
			} else {
				console.log("HHHHHHHHHHMMMMP");
				AMUI.dialog.alert({
					title : '预约失败',
					content : result.message,
					onConfirm : function() {
						console.log('close');
						window.location.reload();
					}
				});
			};
		},
		error : function() {
			alert("异常！");
		}
	});
}

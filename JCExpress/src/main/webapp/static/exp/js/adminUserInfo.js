/**
 * 多选按钮插件
 */
$(document).ready(function() {
	$('input').iCheck({
		checkboxClass : 'icheckbox_flat-green',
		radioClass : 'iradio_flat-green'
	});
});

/**
 * 对登录时间进行格式转换
 */
function loginTimeFormatter(value) {
	return Format(new Date(value),"yyyy-MM-dd HH:mm:ss");
}

/**
 * 表单验证
 */
$(function() {
	$('#form').bootstrapValidator({
		container : 'tooltip',
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			'userName' : {
				message : '用户名验证失败',
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					}
				}
			},
			'realName' : {
				message : '真实姓名验证失败',
				validators : {
					notEmpty : {
						message : '真实姓名不能为空'
					}
				}
			},
			'telephone' : {
				validators : {
					notEmpty : {
						message : '移动电话不能为空'
					},
					regexp : {
						regexp : /^1[3|4|5|7|8]\d{9}$/,
						message : '手机号码格式不正确'
					}
				}
			},
			'email' : {
				validators : {
					notEmpty : {
						message : '电子邮箱不能为空'
					},
					regexp : {
						regexp : /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
						message : '电子邮箱格式不正确'
					}
				}
			},
			'sex' : {
				validators : {
					notEmpty : {
						message : '年龄不能为空'
					},
					regexp : {
						regexp : /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
						message : '年龄格式不正确'
					}
				}
			}
		}
	})
})

/**
 * 修改信息,按钮点击事件
 */
function modify() {
	$('.form-disabled').attr("disabled", false);
	$('#sex').hide();
	$('.add-radio').show();
	$('.form-group').find('.btn-success').css({
		'display' : 'block'
	});
}

/**
 * 保存信息,按钮点击事件
 */
function save_info() {
	var params =$('#form').serialize();
	$.ajax({
		data : params,
		type : "post",
		url : baselocation + '/user/info/infoEdit',
		success : function(result) {
			if (result.code == 1) {
				$('.form-disabled').attr("disabled", true);
				$('#sex').show();
				$('.add-radio').hide();
				$('.form-group').find('.btn-success').css({
					'display' : 'none'
				});
				window.location.reload();
			} else {
				layer.alert(result.message, {
					title : '提示框',
					icon : 0,
				});
			}
		}
	})
}

/**
 * 修改密码
 */
function change_Password() {
	layer.open({
		type : 1,
		title : '修改密码',
		skin : 'layui-layer-rim', //加上边框
		area : [ '420px', '295px' ], //宽高
		content : $('#change_Pass'),
		btn : [ '确认修改' ],
		yes : function(index, layero) {
			if ($("input[name='nowPassword']").val() == "") {
				layer.alert('原密码不能为空!', {
					title : '提示框',
					icon : 0,
				});
				return false;
			}
			if ($("input[name='newPassword']").val() == "") {
				layer.alert('新密码不能为空!', {
					title : '提示框',
					icon : 0,
				});
				return false;
			}
			if ($("input[name='confirmPwd']").val() == "") {
				layer.alert('确认新密码不能为空!', {
					title : '提示框',
					icon : 0,
				});
				return false;
			}
			if ($("input[name='confirmPwd']").val() != $("input[name='newPassword']").val()) {
				layer.alert('密码不一致!', {
					title : '提示框',
					icon : 0,
				});
				return false;
			}
			var params =
			{
               "newPassword":$("input[name='newPassword']").val(),
               "confirmPwd":$("input[name='confirmPwd']").val(),
               "nowPassword":$("input[name='nowPassword']").val(),
			};
			$.ajax({
				data : params,
				type : "post",
				url : baselocation + '/user/info/modifyPassword',
				success : function(result) {
					if (result.code == 1) {
						layer.alert("密码修改成功!", {
							title : '提示框',
							icon : 1,
						});
						layer.close(index);
						$("input[name='confirmPwd']").val("");
						$("input[name='newPassword']").val("");
						$("input[name='nowPassword']").val("");
						window.location.reload();
					} else {
						layer.alert(result.message, {
							title : '提示框',
							icon : 0,
						});
					}
				}
			})
		}
	});
}

var baselocation = "/JCExpress";
function Format(now,mask)
{
    var d = now;
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };
 
    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
    {
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};


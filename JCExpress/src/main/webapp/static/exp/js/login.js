var baselocation = "/JCExpress";
$(function() {
	//粒子背景特效
	$('body').particleground({
		dotColor : '#5cbdaa',
		lineColor : '#5cbdaa'
	});
	//网站计时器
	showsectime();
	//初始化验证码
	$('#kaptchaImage').click(getKaptchaImage);
	//获取验证码图片
	$('#kaptchaImage').trigger("click"); 
	//初始化通知事项
	notifys();
})

/**
 * 网站计时器
 */
function NewDate(str) {
	str = str.split('-');
	var date = new Date();
	date.setUTCFullYear(str[0], str[1] - 1, str[2]);
	date.setUTCHours(0, 0, 0, 0);
	return date;
}
function showsectime() {
	var birthDay = NewDate("2018-05-06");
	var today = new Date();
	var timeold = today.getTime() - birthDay.getTime();

	var sectimeold = timeold / 1000
	var secondsold = Math.floor(sectimeold);
	var msPerDay = 24 * 60 * 60 * 1000;

	var e_daysold = timeold / msPerDay;
	var daysold = Math.floor(e_daysold);
	var e_hrsold = (daysold - e_daysold) * -24;
	var hrsold = Math.floor(e_hrsold);
	var e_minsold = (hrsold - e_hrsold) * -60;
	var minsold = Math.floor((hrsold - e_hrsold) * -60);

	var seconds = Math.floor((minsold - e_minsold) * -60).toString();
	document.getElementById("showsectime").innerHTML = "网站运行：" + daysold + "天" + hrsold + "小时" + minsold + "分" + seconds + "秒";
	setTimeout(showsectime, 1000);
}

/**
 * 用户登录
 */
$(function() {
	$('.submit_btn').click(function() {
		var username = $("input[name='userName']").val();
		if (username.length <= 0) {
			$("input[name='userName']").attr("placeholder", "请输入帐号");
			return false;
		}
		var password = $("input[name='Password']").val();
		if (password.length <= 0) {
			$("input[name='Password']").attr("placeholder", "请输入密码");
			return false;
		}
		var jcaptchaCode = $("input[name='jcaptchaCode']").val();
		if (jcaptchaCode.length <= 0) {
			$("input[name='jcaptchaCode']").attr("placeholder", "输入验证码");
			return false;
		}
		$.ajax({
			url : baselocation + '/loginh',
			type : 'post',
			dataType : 'json',
			data : {
				"userName" : username,
				"Password" : password,
				"jcaptchaCode" : jcaptchaCode
			},
			success : function(result) {
				console.info(result);
				if (result.data == 200) {
					window.location.href = baselocation + '/indexh';
				} else if (result.data == 103) {
					$("input[name='jcaptchaCode']").val("");
					$("input[name='jcaptchaCode']").attr("placeholder", result.message);
					$(".ver_btn").trigger("click");
				} else if (result.data == 104) {
					$("input[name='password']").val("");
					$("input[name='password']").attr("placeholder", result.message);
					$(".ver_btn").trigger("click");
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		});
	})
});
/**
 * 回车登录实现
 */
$(document).keyup(function(event) {
	if (event.keyCode == 13) {
		$(".submit_btn").trigger("click");
	}
});
/**
 * 验证码更改
 */
function getKaptchaImage() {
	$(this).attr('src', baselocation + '/kaptcha/json?' + Math.floor(Math.random() * 100));
}


function notifys(){
	$.ajax({
		url : baselocation + '/showView',
		type : 'get',
		dataType : 'json',
		success : function(result){
			var list = result.data;
			$.each(list,function(index,value){
				// 在table 中生成tr 
				var tr = $("<div><a>"
					+ value.title
					+ "</a>&nbsp&nbsp&nbsp<a style='width:100px;' css='myoverflow' >"
					+ value.content
					+ "</a>&nbsp&nbsp&nbsp<a>"
					+ Format(new Date(value.create_time),"yyyy-MM-dd")+"</a></div>");
				$('#notice').append(tr);
				
			})
			
		}
	})
}

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


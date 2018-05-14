$(function() {
	// 默认绑定省
	sendProviceBind();
	// 绑定事件
	$("#sendProvince").change(function() {
		sendCityBind();
	})
	$("#sendCity").change(function() {
		sendVillageBind();
	})
	receiveProviceBind();
	// 绑定事件
	$("#receiveProvince").change(function() {
		receiveCityBind();
	})
	$("#receiveCity").change(function() {
		receiveVillageBind();
	})
})
function Bind(str) {
	alert($("#sendProvince").html());
	$("#sendProvince").val(str);

}
function sendProviceBind() {
	// 清空下拉数据
	
	//$(".Province").html("");
	//var str = "<option>--省--</option>";
	var str = "";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : "0"
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendProvince").append(str);
		},
		error : function() {
			alert("Error");
		}
	});

}
function sendCityBind() {
	var provice = $("#sendProvince").val();
	// 判断省份这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#sendCity").html("");
	$("#sendVillage").html("");
	var Village = "<option>--区--</option>";
	$("#sendVillage").append(Village);
	var str = "<option>--市--</option>";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provice
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendCity").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
function sendVillageBind() {
	var provice = $("#sendCity").val();
	// 判断市这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#sendVillage").html("");
	var str = "<option>--区--</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provice
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendVillage").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}

function receiveProviceBind() {
	// 清空下拉数据
	//$(".Province").html("");
	//var str = "<option>--省--</option>";
	var str = "";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : "0"
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveProvince").append(str);
		},
		error : function() {
			alert("Error");
		}
	});

}
function receiveCityBind() {
	var provice = $("#receiveProvince").val();
	// 判断省份这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#receiveCity").html("");
	$("#receiveVillage").html("");
	var Village = "<option>--区--</option>";
	$("#receiveVillage").append(Village);
	var str = "<option>--市--</option>";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provice
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveCity").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
function receiveVillageBind() {
	var provice = $("#receiveCity").val();
	// 判断市这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#receiveVillage").html("");
	var str = "<option>--区--</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provice
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
						+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveVillage").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}

$(function() {
	// 默认绑定省
	sendProviceBinds();
	// 绑定事件
	$("#sendProvinces").change(function() {
		sendCityBinds();
	})
	$("#sendCitys").change(function() {
		sendVillageBinds();
	})
	receiveProviceBinds();
	// 绑定事件
	$("#receiveProvinces").change(function() {
		receiveCityBinds();
	})
	$("#receiveCitys").change(function() {
		receiveVillageBinds();
	})
})
function Binds(str) {
	alert($("#sendProvinces").html());
	$("#sendProvinces").val(str);
	
}
function sendProviceBinds() {
	// 清空下拉数据
	
	//$(".Province").html("");
	//var str = "<option>--省--</option>";
	var str = "";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : "0"
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendProvinces").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
	
}
function sendCityBinds() {
	console.log("MMMMMMMMMMMMMMMMMMMPPPPPPPP");
	var provices = $("#sendProvinces").val();
	// 判断省份这个下拉框选中的值是否为空
	if (provices == "") {
		return;
	}
	$("#sendCitys").html("");
	$("#sendVillages").html("");
	var Villages = "<option>--区--</option>";
	$("#sendVillages").append(Village);
	var str = "<option>--市--</option>";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provices
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendCitys").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
function sendVillageBinds() {
	var provices = $("#sendCitys").val();
	// 判断市这个下拉框选中的值是否为空
	if (provices == "") {
		return;
	}
	$("#sendVillages").html("");
	var str = "<option>--区--</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provices
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#sendVillages").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}

function receiveProviceBinds() {
	console.log("hhhhhhhhp");
	// 清空下拉数据
	//$(".Province").html("");
	//var str = "<option>--省--</option>";
	var str = "";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : "0"
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveProvinces").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
	
}
function receiveCityBinds() {
	console.log("mmmmmmmmp");
	var provices = $("#receiveProvinces").val();
	// 判断省份这个下拉框选中的值是否为空
	if (provices == "") {
		return;
	}
	$("#receiveCitys").html("");
	$("#receiveVillages").html("");
	var Villages = "<option>--区--</option>";
	$("#receiveVillages").append(Villages);
	var str = "<option>--市--</option>";
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provices
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveCitys").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
function receiveVillageBinds() {
	var provices = $("#receiveCitys").val();
	// 判断市这个下拉框选中的值是否为空
	if (provices == "") {
		return;
	}
	$("#receiveVillages").html("");
	var str = "<option>--区--</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "post",
		url :Backstagelocation+ "/partition/list/regionSelect",
		data : {
			"parentCode" : provices
		},
		dataType : "json",
		async : false,
		success : function(data) {
			// 从服务器获取数据进行绑定
			$.each(data, function(i, item) {
				str += "<option value=" + item.area_code + ">" + item.name
				+ "</option>";
			})
			// 将数据添加到省份这个下拉框里面
			$("#receiveVillages").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
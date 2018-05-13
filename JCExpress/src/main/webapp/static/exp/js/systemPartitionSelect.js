$(function() {
	// 默认绑定省
	ProviceBind();
	// 绑定事件
	$("#Province").change(function() {
		CityBind();
	})
	$("#City").change(function() {
		VillageBind();
	})
})
function Bind(str) {
	alert($("#Province").html());
	$("#Province").val(str);

}
function ProviceBind() {
	// 清空下拉数据
	//$("#Province").html("");
	//var str = "<option>--省--</option>";
	var str = "";
	$.ajax({
		type : "post",
		url :baselocation+ "/partition/list/regionSelect",
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
			$("#Province").append(str);
		},
		error : function() {
			alert("Error");
		}
	});

}
function CityBind() {
	var provice = $("#Province").val();
	// 判断省份这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#City").html("");
	$("#Village").html("");
	var Village = "<option>--区--</option>";
	$("#Village").append(Village);
	var str = "<option>--市--</option>";
	$.ajax({
		type : "post",
		url :baselocation+ "/partition/list/regionSelect",
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
			$("#City").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
}
function VillageBind() {
	var provice = $("#City").val();
	// 判断市这个下拉框选中的值是否为空
	if (provice == "") {
		return;
	}
	$("#Village").html("");
	var str = "<option>--区--</option>";
	// 将市的ID拿到数据库进行查询，查询出他的下级进行绑定
	$.ajax({
		type : "post",
		url :baselocation+ "/partition/list/regionSelect",
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
			$("#Village").append(str);
		},
		error : function() {
			alert("Error");
		}
	});
	// $.post("/Home/GetAddress", { parentiD: provice, MyColums: "Village" },
	// function (data) {
	// $.each(data.Data, function (i, item) {
	// str += "<option value=" + item.Id + ">" + item.MyTexts + "</option>";
	// })
	// $("#Village").append(str);
	// })
}
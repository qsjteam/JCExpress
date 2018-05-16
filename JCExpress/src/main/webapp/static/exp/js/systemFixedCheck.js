
var baselocation = "/JCExpress";
function getIds(json)
{
	var ids = [];
	for (var i = 0; i < json.length; i++) {
		ids.push(json[i].id);
	}
	return ids.join(",");
}

function rela_fixed() {
	layer.confirm('确认要关联这些定区吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var getSelectRows = $("#table").bootstrapTable('getSelections', function(row) {
			return row;
		});
		var partitionIds=getIds(getSelectRows);
		if(partitionIds=="")
		{
			layer.alert("好歹选择个东西啊", {
				icon : 2
			});
			return;
		}
		$.ajax({
			type : 'put',
			data:{
				"partitionIds":partitionIds
			},
			url : baselocation + '/fixed/list/'+ fixedId+'/relaFixed',
			success : function(result) {
				if (result.code > 0) {
					parent.layer.msg("关联定区成功!", {
						shade : 0.3,
						time : 1500
					}, function() {
						window.location.reload();
					});
				} else {
					layer.msg(result.message, {
						icon : 2,
						time : 1000
					});
				}
			}
		})
	});
}


function noRela_fixed(){
	layer.confirm('确认要取消这些定区吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var getSelectRows = $("#table").bootstrapTable('getSelections', function(row) {
			return row;
		});
		var partitionIds=getIds(getSelectRows);
		if(partitionIds=="")
		{
			layer.alert("好歹选择个东西啊", {
				icon : 2
			});
			return;
		}
		$.ajax({
			type : 'put',
			data:{
				'partitionIds':partitionIds
			},
			url : baselocation + '/fixed/list/noRelaFixed',
			success : function(result) {
				if (result.code > 0) {
					parent.layer.msg("取关定区成功!", {
						shade : 0.3,
						time : 1500
					}, function() {
						window.location.reload();
					});
				} else {
					layer.msg(result.message, {
						icon : 2,
						time : 1000
					});
				}
			}
		})
	});
}

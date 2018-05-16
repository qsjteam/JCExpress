/**
 * 进行格式转换
 */
var baselocation = "/JCExpress";
function timeFormatter(value) {
	return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
}
function actionFormatter(value, row, index) {
		return [
			'<a class="ok m-r-m text-success" href="javascript:void(0)" title="通过">',
			'<i class="glyphicon glyphicon-ok"></i>通过',
			'</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
			'<a class="edit m-r-m text-info" href="javascript:void(0)" title="修改信息">',
			'<i class="glyphicon glyphicon-pencil"></i>修改信息',
			'</a>',
		].join('');
}

window.actionEvents = {
	'click .edit' : function(e, value, row, index) {
		layer_show(row.order_id, baselocation + '/order/'+row.order_id+ '/updateOrder', 900, 650)
	},
	'click .ok' : function(e, value, row, index) {
		order_Audit(index,row.order_id);
	},
};


function order_Audit(index, value) {
	layer.confirm('确认要审核该订单吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			type : 'put',
			dataType : 'json',
			url : baselocation + '/order/'+ value+'/adoptOrder',
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('hideRow', {
						index : index
					});
					layer.msg('该订单审核成功!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}
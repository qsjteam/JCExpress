/**
 * 进行格式转换
 */
var baselocation = "/JCExpress";
function statusFormatter(value) {
	if (value == 1) {
		return '<span class="label label-primary">已下单</span>'
	} 
	if (value == 2) {
		return '<span class="label label-primary">审核通过</span>'
	}
	if (value == 3) {
		return '<span class="label label-primary">正在派送</span>'
	}
	if (value == 4) {
		return '<span class="label label-primary">正在配送</span>'
	}
	if (value == 5) {
		return '<span class="label label-primary">已签收</span>'
	}
}
function timeFormatter(value) {
	return new Date(value).Format("yyyy-MM-dd HH:mm:ss");
}
function actionFormatter(value, row, index) {
		return [
			'<a class="detail m-r-m text-info" href="javascript:void(0)" title="查看详情">',
			'<i class="glyphicon glyphicon-book"></i>查看详情',
			'</a>',
		].join('');
}

window.actionEvents = {
	'click .detail' : function(e, value, row, index) {
		layer_show(row.order_id, baselocation + '/order/'+row.order_id+'/'+row.status
				+ '/detail', 1100, 650)
	},
};

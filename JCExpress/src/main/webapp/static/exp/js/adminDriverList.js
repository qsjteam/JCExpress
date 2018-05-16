/**
 * 进行格式转换
 */
var baselocation = "/JCExperss";
function statusFormatter(value) {
	if (value == 1) {
		return '<span class="label label-primary">正常</span>'
	} else if (value == 0) {
		return '<span class="label label-danger">冻结</span>'
	}
}
function actionFormatter(value, row, index) {
	if (row.status == 1) {
		return [
			'<a class="freeze m-r-sm text-info" href="javascript:void(0)" title="冻结">冻结',
			'<i class="glyphicon glyphicon-pause"></i>',
			'</a>',
			'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">编辑',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">删除',
			'<i class="glyphicon glyphicon-remove"></i>',
			'</a>',
		].join('');
	} else {
		return [
			'<a class="normal m-r-sm text-info" href="javascript:void(0)" title="启用">启用',
			'<i class="glyphicon glyphicon-play"></i>',
			'</a>',
			'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">编辑',
			'<i class="glyphicon glyphicon-edit"></i>',
			'</a>',
			'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">删除',
			'<i class="glyphicon glyphicon-remove"></i>',
			'</a>',
		].join('');
	}
}

window.actionEvents = {
	'click .freeze' : function(e, value, row, index) {
		status_stop(index, row.id);
	},
	'click .normal' : function(e, value, row, index) {
		status_start(index, row.id);
	},
	'click .edit' : function(e, value, row, index) {
		layer_show(row.name, baselocation + '/driver/list/'+row.id+'/updateDriver', 800, 520)
	},
	'click .remove' : function(e, value, row, index) {
		admin_delete(index, row.id);
	},
};

/*
 * 修改司机
 */
function layer_show(name, url, row, index){
	layer.confirm('', {}, function() {
		window.location.replace(url);
	});
}

/**
 * 冻结司机
 */
function status_stop(index, value) {
	layer.confirm('确认要冻结该司机吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/driver/list/'+ value+'/frozenDriver',
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('updateRow', {
						index : index,
						row : {
							status : 0,
						}
					});
					layer.msg('该司机冻结成功!', {
						icon : 5,
						time : 1000
					});
					window.location.reload();
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}

/**
 * 启用司机
 */
function status_start(index, value) {
	layer.confirm('确认要启用该司机吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/driver/list/'+ value+'/frozenDriver',
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('updateRow', {
						index : index,
						row : {
							status : 1,
						}
					});
					layer.msg('该司机启用成功!', {
						icon : 6,
						time : 1000
					});
					window.location.reload();
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}

/**
 * 删除司机
 */
function admin_delete(index, value) {
	layer.confirm('确认要删除该司机吗？', {
		btn : [ '确定', '取消' ] //按钮
	}, function() {
		$.ajax({
			type : 'delete',
			dataType : 'json',
			url : baselocation + '/driver/list/' + value,
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('hideRow', {
						index : index
					});
					layer.msg('该司机删除成功!', {
						icon : 1,
						time : 1000
					});
					window.location.reload();
				} else {
					layer.alert(result.message, {
						icon : 2
					});
				}
			}
		})
	});
}
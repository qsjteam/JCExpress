/**
 * 进行格式转换
 */
var baselocation = "/JCExpress/";
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
				'<a class="freeze m-r-sm text-info" href="javascript:void(0)" title="冻结">',
				'<i class="glyphicon glyphicon-pause"></i>冻结',
				'</a>',
				'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">',
				'<i class="glyphicon glyphicon-edit"></i>编辑',
				'</a>',
				'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">',
				'<i class="glyphicon glyphicon-remove"></i>删除', '</a>', ]
				.join('');
	} else {
		return [
				'<a class="normal m-r-sm text-info" href="javascript:void(0)" title="启用">',
				'<i class="glyphicon glyphicon-play"></i>启用',
				'</a>',
				'<a class="edit m-r-sm text-warning" href="javascript:void(0)" title="编辑">',
				'<i class="glyphicon glyphicon-edit"></i>编辑',
				'</a>',
				'<a class="remove m-r-sm text-danger" href="javascript:void(0)" title="删除">',
				'<i class="glyphicon glyphicon-remove"></i>删除', '</a>', ]
				.join('');
	}
}
function relaFormatter(value, row, index) {
	return [
			'<a class="norela m-r-m text-info" href="javascript:void(0)" title="关联分区">',
			'<i class="glyphicon glyphicon-plus-sign">关联分区</i>',
			'</a>',
			'<a class="rela m-r-m text-danger" href="javascript:void(0)" title="取关分区">',
			'<i class="glyphicon glyphicon-minus-sign">取关分区</i>', '</a>', ]
			.join('&nbsp;&nbsp;');
}

window.actionEvents = {
	'click .freeze' : function(e, value, row, index) {
		status_stop(index, row.id);
	},
	'click .normal' : function(e, value, row, index) {
		status_start(index, row.id);
	},
	'click .edit' : function(e, value, row, index) {
		layer_show(row.fixed_code, baselocation + '/fixed/list/' + row.id
				+ '/updateFixed', 800, 600)
	},
	'click .remove' : function(e, value, row, index) {
		fixed_delete(index, row.id);
	},
	'click .rela' : function(e, value, row, index) {
		layer_show(row.fixed_code, baselocation + '/fixed/list/' + row.id
				+ '/realPartition', 800, 600)
	},
	'click .norela' : function(e, value, row, index) {
		layer_show(row.fixed_code, baselocation + '/fixed/list/' + row.id
				+ '/noRealPartition', 800, 600)
	}
};

/**
 * 隐藏定区
 */
function status_stop(obj, value) {
	layer.confirm('确认要隐藏该定区吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/fixed/list/' + value + '/frozenFixed',
			success : function(result) {
				if (result.code == 1) {
					layer.msg('该定区隐藏成功!', {
						icon : 5,
						time : 1000
					}, function() {
						$('#table').bootstrapTable('refresh');
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

/**
 * 显示定区
 */
function status_start(index, value) {
	layer.confirm('确认要显示该定区吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		$.ajax({
			dataType : 'json',
			type : 'put',
			url : baselocation + '/fixed/list/' + value + '/frozenFixed',
			success : function(result) {
				if (result.code == 1) {
					layer.msg('该定区显示成功!', {
						icon : 6,
						time : 1000
					}, function() {
						$('#table').bootstrapTable('refresh');
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

/**
 * 删除定区
 */
function fixed_delete(index, value) {
	layer.confirm('确认要删除该定区吗？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		$.ajax({
			type : 'delete',
			dataType : 'json',
			url : baselocation + '/fixed/list/' + value,
			success : function(result) {
				if (result.code == 1) {
					$('#table').bootstrapTable('hideRow', {
						index : index
					});
					layer.msg('该定区删除成功!', {
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

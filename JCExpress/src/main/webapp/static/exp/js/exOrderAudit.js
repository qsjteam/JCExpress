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
			'send_name' : {
				message : '寄件人姓名验证失败',
				validators : {
					notEmpty : {
						message : '寄件人姓名称不能为空'
					}
				}
			},
			'send_telephone' : {
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
			'send_address' : {
				message : '详细地址验证失败',
				validators : {
					notEmpty : {
						message : '详细地址不能为空'
					}
				}
			},	
			'receive_name' : {
				message : '寄件人姓名验证失败',
				validators : {
					notEmpty : {
						message : '寄件人姓名称不能为空'
					}
				}
			},
			'receive_telephone' : {
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
			'receive_address' : {
				message : '详细地址验证失败',
				validators : {
					notEmpty : {
						message : '详细地址不能为空'
					}
				}
			},	
		}
	})
		.on('success.form.bv', function(e) {
			// Prevent form submission
			e.preventDefault();
			// Get the form instance
			var $form = $(e.target);
			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');
			var method = $('#form').attr('data-method');
			// Use Ajax to submit form data
			if (method == 'put') {
				$.ajax({
					data : $form.serialize(),
					dataType : 'json',
					type : 'post',
					url : $form.attr('action'),
					success : function(result) {
						if (result.code == 1) {
							parent.layer.msg("更新订单成功!", {
								shade : 0.3,
								time : 1500
							}, function() {
								window.parent.location.reload(); // 刷新父页面
							});
						} else {
							layer.msg(result.message, {
								icon : 2,
								time : 1000
							});
						}
					}
				})
			} else if (method == 'post') {
				$.ajax({
					data : $form.serialize(),
					dataType : 'json',
					type : 'post',
					url : $form.attr('action'),
					success : function(result) {
						if (result.code == 1) {
							parent.layer.msg("创建订单成功!", {
								shade : 0.3,
								time : 1500
							}, function() {
								window.parent.location.reload(); // 刷新父页面
							});
						} else {
							layer.msg(result.message, {
								icon : 2,
								time : 1000
							});
						}
					}
				})
			}
		});
})

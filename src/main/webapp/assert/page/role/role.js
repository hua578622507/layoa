layui.use([ 'layer', 'table', 'form' ], function() {
	// 通过一个变量将加载的模块取出来
	var layer = layui.layer;
	var form = layui.form;
	var table = layui.table;
	// layui内置jQuery
	var $ = layui.$;
	// 自定义角色名字唯一性校验
	form.verify({
		checkRoleName : function(value, item) {// value:表单的值，item：表单的DOM对象
			console.log(value);
			var msg;
			$.ajax({
				type : 'get',
				async : false,// 把异步请求关闭
				url : 'role/chenckname',
				data : {
					'roleName' : value
				},
				success : function(result) {
					if (result == 0) {
						msg = '此名称已被别人使用';
					}
				}
			});
			return msg;
		}
	});

	// 绑定form表单的提交按钮
	form.on('submit(formDemo)', function() {
		// 表单取值
		var data = form.val('form_role');
		var rowId = data.rowId;
		// console.log(data);
		if (rowId == '') {
			$.ajax({
				type : 'post',
				url : 'role',
				data : data,
				success : function(result) {
					if (result) {
						layer.msg("提交成功了")
						layer.close(layer.index);
						// 将按钮自带的动作屏蔽掉
						// 重新加载表格数据
						table.reload('demo');
						return false;
					}
				}
			});
		} else {
			$.ajax({
				type : 'put',
				url : 'role',
				data : data,
				success : function(result) {
					layer.msg('提交成功');
					// 关闭弹出层
					layer.close(layer.index);
					// 将按钮自带的提交动作屏蔽
					// 重新加载表格数据
					table.reload('demo');
					return false;
				}
			})
		}

	});
});
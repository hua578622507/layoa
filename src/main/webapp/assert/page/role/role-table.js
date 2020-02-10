layui.use([ 'table', 'layer', 'form' ], function() {
	var table = layui.table;
	var form = layui.form;
	var layer = layui.layer;
	var $ = layui.$;
	// 通过render方法渲染table数据
	table.render({
		elem : '#demo'// 要绑定的页面元素
		,
		url : 'role'// 数据接口
		,
		where : $('#form_search').serialize()// 额外的参数#目前引入搜索表单的数据
		,
		page : true// 开启分页
		,
		cols : [ [ // 表头
		{
			field : 'rowId',
			title : 'ID',
			width : 80,
			sort : true,
			fixed : 'left'
		}, {
			field : 'roleCode',
			title : '角色帐号',
			width : 200
		}, {
			field : 'roleName',
			title : '角色名字',
			width : 200
		}, {
			field : 'roleKind',
			title : '角色类型',
			width : 200,
			sort : true,
			templet : '#titleTpl'
		}, {
			field : 'roleInfo',
			title : '角色简介',
			width : 177
		}, {
			field : '',
			title : '操作',
			width : 177,
			templet : '#toolbarDemo'
		} ] ]
	});

	// 对table立面的按钮进行绑定
	// 注：tool 是工具条事件名，table_user 是 table 原始容器的属性 lay-filter="对应的值"
	table.on('tool(table_user)', function(obj) {
		var data = obj.data;// 获取当前行的数据
		var layEvent = obj.event;// 获得lay-event对应的值，（也可以是表头的event参数对应的值）
		var rowId = data.rowId;// 通过data将要修改的数据的主键取出
		switch (layEvent) {
		case 'delete':
			layer.confirm('你确定要删除吗？？？', function() {
				$.ajax({
					type : 'delete',
					url : 'role/' + rowId,
					success : function(result) {
						if (result) {
							layer.msg("删除成功", {
								icon : 6
							});
							// 关闭弹出层
							layer.closeAll();// 疯狂模式，关闭
							// 重新加载表格数据
							table.reload('demo');
						}
					}
				});
			});
			break;
		case 'update':
			// 打开修改的表单
			openLayerRole(rowId);
			break;
		}
	});

	// 绑定新增按钮
	$('.layui-btn-add').on('click', function() {
		// 打开新增的表单
		openLayerRole();
	});

	// 打开新增或修改表单
	function openLayerRole(rowId) {
		// 弹出层的标题
		var titleVal = rowId == null ? '角色新增' : '角色修改';
		$.ajax({
			url : 'role/goadd',
			success : function(htmlData) {
				// 通过layer.open方法打开弹出层
				layer.open({
					// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
					type : 1,
					title : titleVal,
					area : '800px',//
					content : htmlData,//
					success : function() {// 弹出层打开以后
						if (rowId) {
							// 用ajax的方式根据rowId查询要修改的对象的数据
							$.ajax({
								type : 'get',
								url : 'role/' + rowId,
								success : function(role) {
									// 给表单赋值
									form.val('form_role', role);
									// data('old)=<input data-old=''>
									$('#roleName').data('old', role.roleName);
									// 重新渲染form表单
									form.render(null, 'form_role');
								}
							});
						} else {// 进新增动作
							// 重新渲染form表单
							form.render(null, 'form_role');
						}
					}
				});
			}
		});
	}
	// 绑定搜索事件
	form.on('submit(btn_search)', function(data) {
		// 将参数传到后台
		table.reload('demo', {
			page : {// 重新从第一页开始
				curr : 1
			},
			where : $('#form_search').serialize()
		}, 'data');// 额外的参数#重新配置查询额外的数据
		return false;
	});
});
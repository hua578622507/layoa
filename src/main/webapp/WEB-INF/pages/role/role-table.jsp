<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layui-table</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="assert\layui\css\layui.css">
</head>
<body class="body">
	<!-- layui定义的模板数据 开始 -->
	<!-- 修改 删除按钮 -->
	<!--此处必须有lay-event 才能通过table.on完成事件的绑定  -->
	<script type="text/html" id="toolbarDemo">
 <button class="layui-btn  layui-btn-sm" lay-event="update">修改</button>
  {{#  if(d.roleKind==1){ }}
    <button type="butten" class="layui-btn layui-btn-sm layui-btn-disabled" >删除</button>
  {{#  } else { }}
    <button type="butten" class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
  {{#  } }}
</script>

	<script type="text/html" id="titleTpl">
  {{#  if(d.roleKind==1){ }}
    <span class="layui-badge layui-bg-green">超级角色</span>
  {{#  } else { }}
    <span class="layui-badge layui-bg-gray">普通角色</span>
  {{#  } }}
</script>
	<!-- layui定义的模板数据 结束 -->
	<div class="layui-form-item">
		<div class="layui-input-inline">
			<input placeholder="请输入角色名称" autocomplete="off" class="layui-input"
				id="select_roleName" >
		</div>
		<button class="layui-btn " id="btn_search">搜索</button>
		<button class="layui-btn " id="btn_add"
			style="position: absolute; right: 10px;">新增</button>
	</div>
	<table class="layui-hide" id="demo" lay-filter="table_user"></table>
</body>
<script type="text/javascript" src="assert\layui\layui.js"></script>
<script type="text/javascript">
	layui.use([ 'table', 'layer', 'form' ], function() {
		var table = layui.table;
		var form = layui.form;
		var layer = layui.layer;
		var $ = layui.$;
		//通过render方法渲染table数据
		table.render({
			elem : '#demo'//要绑定的页面元素
			,
			url : 'role'//数据接口
			,
			where : {}//额外的参数
			,
			page : true//开启分页
			,
			cols : [ [ //表头
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

		//对table立面的按钮进行绑定
		//注：tool 是工具条事件名，table_user 是 table 原始容器的属性 lay-filter="对应的值"
		table.on('tool(table_user)', function(obj) {
			var data = obj.data;//获取当前行的数据
			var layEvent = obj.event;//获得lay-event对应的值，（也可以是表头的event参数对应的值）
			var rowId = data.rowId;//通过data将要修改的数据的主键取出
			switch (layEvent) {
			case 'delete':
				layer.confirm('你确定要删除吗？？？', function(index) {
					$.ajax({
						type : 'delete',
						url : 'role/' + rowId,
						success : function(result) {
							if (result) {
								layer.msg("删除成功", {
									icon : 6
								});
								//重新加载表格数据
								table.reload('demo');
							}
						}
					});
					//向服务端发送删除指令
					layer.close(index);
					return false;
				});
				break;
			case 'update':
				//layer.msg('编辑');
				$.ajax({
					url : 'role/' + rowId,
					success : function(htmlData) {
						//console.log(htmlData);
						layer.open({
							//layer提供了5种层类型。可传入的值有：
							//0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
							type : 1,
							title : '修改',
							area : '800px',//设置宽度
							content : htmlData,//引用的弹出层的页面层的方式加载修改界面表单
							success : function() {
								$('#roleCode').val(data.roleCode);
								$('#roleName').val(data.roleName);
								$("input[id=roleKind][value=0]").attr(
										"checked",
										data.roleKind == 0 ? true : false);
								$("input[id=roleKind][value=1]").attr(
										"checked",
										data.roleKind == 1 ? true : false);
								$('#roleInfo').val(data.roleInfo);
								$('#rowId').val(data.rowId);
								form.render(null, 'form_role');
							}
						});
					}
				});
				break;
			}
		});

		//绑定新增按钮
		$('#btn_add').on('click', function() {
			$.ajax({
				url : 'role/goadd',
				success : function(htmlData) {
					layer.open({
						type : 1,
						title : '新增',
						area : '800px',//
						content : htmlData,//
						success : function() {
							form.render(null, 'form_role');
						}
					});
				}
			});
			return false;
		});
		//绑定搜索事件
		$('#btn_search').on('click', function() {
			var roleName = $('#select_roleName').val();
			//将参数传到后台
			table.reload('demo', {
				where : {
					'roleName' : roleName
				},
				page : {
					curr : 1
				}
			//重新从第一页开始
			});
		});
	});
</script>
</html>
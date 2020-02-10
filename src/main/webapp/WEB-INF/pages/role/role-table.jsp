<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layui-table</title>
<jsp:include page="/base.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!--引用layui的css样式表  -->
<link rel="stylesheet" href="assert\layui\css\layui.css">
<!--引入自定义样式表  -->
<link rel="stylesheet" href="assert\page\css\custom.css">
</head>
<body style="background-color: #F2F2F2;">
	<!-- layui定义的模板数据 开始 -->
	<!-- 修改 删除按钮 开始 -->
	<!--此处必须有lay-event 才能通过table.on完成事件的绑定  -->
	<script type="text/html" id="toolbarDemo">
 <button class="layui-btn  layui-btn-sm" lay-event="update">修改</button>
  {{#  if(d.roleKind==1){ }}
    <button type="butten" class="layui-btn layui-btn-sm layui-btn-disabled" >删除</button>
  {{#  } else { }}
    <button type="butten" class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
  {{#  } }}
</script>
	<!-- 修改 删除按钮 结束 -->
	<script type="text/html" id="titleTpl">
  {{#  if(d.roleKind==1){ }}
    <span class="layui-badge layui-bg-green">超级角色</span>
  {{#  } else { }}
    <span class="layui-badge layui-bg-gray">普通角色</span>
  {{#  } }}
</script>
	<!-- layui定义的模板数据 结束 -->
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">
					角色管理
						<!--新增按钮 开始  -->
						<button type="button" class="layui-btn layui-btn-sm layui-btn-add" >
						<i class="layui-icon layui-icon-addition"></i>新增</button>
						<!--新增按钮 结束  -->
					</div>
					<div class="layui-card-body">
						<!--搜索表单 开始  -->
						<form class="layui-form" id="form_search">
							<div class="layui-search-form">
								<div class="layui-inline">
									<select name="roleKind">
										<option value="">请选择角色类型</option>
										<option value="1">超级角色</option>
										<option value="0">普通角色</option>
									</select>
								</div>
								<div class="layui-inline">
									<input name="roleName" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
								</div>
								<div class="layui-inline">
									<button class="layui-btn layui-btn-primary layui-btn-sm " lay-submit lay-filter="btn_search">
										<i class="layui-icon layui-icon-search"></i>
									</button>
									<button type="reset" class="layui-btn layui-btn-primary layui-btn-sm">
										<i class="layui-icon layui-icon-refresh"></i>
									</button>
								</div>
							</div>
						</form>
						<!--表格 开始  -->
						<table id="demo" lay-filter="table_user"></table>
						<!--表格 结束  -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--搜索表单 结束  -->

</body>
<!--引入 layui的 开发脚本  -->
<script type="text/javascript" src="assert\layui\layui.js"></script>
<!--引入自定义的js脚本-->
<script type="text/javascript" src="assert\page\role\role-table.js"></script>
</html>
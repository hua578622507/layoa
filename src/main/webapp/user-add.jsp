<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户新增</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="assert\layui\css\layui.css">
</head>
<body>
	<form class="layui-form" lay-filter="form_user">
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input name="stuName" required lay-verify="required|checkstuname"
					placeholder="请输入学生名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-inline">
				<input name="stuAge" required lay-verify="required|number"
					placeholder="请输入年龄" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">生日</label>
			<div class="layui-input-inline">
				<input name="stuBirthday" id="stuBirthday" lay-verify="required"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<input type="radio" name="stuSex" value="1" title="男"> <input
					type="radio" name="stuSex" value="0" title="女" checked>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">爱好</label>
			<div class="layui-input-block">
				<input type="checkbox" name="stuLikes" value="写作" title="写作"> 
				<input type="checkbox" name="stuLikes" value="阅读" title="阅读" > 
				<input type="checkbox" name="stuLikes" value="发呆" title="发呆">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript" src="assert\layui\layui.js"></script>
<script type="text/javascript">
	layui.use([ 'layer', 'form', 'laydate' ], function() {
		//通过一个变量将加载的模块取出来
		var layer = layui.layer;
		var form = layui.form;
		var laydate = layui.laydate;
		//layui内置jQuery
		var $ = layui.$;
		//渲染日历
		laydate.render({
			elem : '#stuBirthday'//指定元素
		});
		//表单的自定义校验
		form.verify({
			checkstuname:function(value,item){//value:表单的值，item：表单的DOM对象
			console.log(value);
			var msg;
			$.ajax({
				type:'get',
				async:false,//为了让layui可以做唯一性校验，需要将ajax的异步提交关闭
				url:'student/checkname',
				data:{"stuName":value},
				success:function(result){
					//判定此名称已被人使用
					if(result==0){
						msg='此名称已被人使用';
					}
				}
			});
				return msg;
			}
		});
		
		
		//绑定提交
		form.on('submit(formDemo)', function(data) {
			//form.val('filter',object);表单赋值，取值
			//var data = form.val('form_user');
			//通过使用jQuery的表单序列化
			var formData = $(data.form).serialize();
			console.log(formData);
			//使用ajax的方式提交到后台
			$.ajax({
				type : 'post',
				url : 'student',
				data : formData,
				success : function(result) {
					if (result) {
						layer.msg("提交成功了");
					}
				}
			});

			//layer.msg(JSON.stringify(data.field));

			//将按钮自带的动作屏蔽掉
			return false;
		});
	});
</script>
</html>
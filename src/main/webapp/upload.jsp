<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layui文件上传</title>
<link rel="stylesheet" href="assert\layui\css\layui.css">
</head>
<body>
	<button type="button" class="layui-btn" id="test1">
		<i class="layui-icon">&#xe67c;</i>上传图片
	</button>
	<!--此处隐藏域应该保存上传文件成功后的返回的文件路径  -->
	<input type="hidden" name="stuImg" id="stuImg" />
</body>
<script type="text/javascript" src="assert\layui\layui.js"></script>
<script type="text/javascript">
	layui.use([ 'upload' ], function() {
		var upload = layui.upload;
		var $= layui.$;
		upload.render({
			elem : '#test1' //绑定元素
			,
			url : 'upload/' //上传接口
			,
			//field:'uploadFile/'//设定文件域的字段名
			//,
			done : function(res) {
				//上传完毕回调
				console.log(res.data);
				//将上传成功返回的文件路径付给表单中隐藏域
				$('#stuImg').val(res.data);
			},
			error : function() {
				//请求异常回调
			}
		});
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_role" >
	<div class="layui-form-item">
		<label class="layui-form-label">角色编号</label>
		<div class="layui-input-inline">
			<input name="roleCode"  id ="roleCode" required lay-verify="required"
				placeholder="请输入角色编号" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色姓名</label>
		<div class="layui-input-inline">
			<input name="roleName" id="roleName" required lay-verify="required|checkRoleName"
				placeholder="请输入角色名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色类型</label>
		<div class="layui-input-block">
			<input type="radio" name="roleKind" id="roleKind" value="1" title="超级角色"> 
			<input type="radio" name="roleKind" id="roleKind" value="0" title="普通角色" >
		</div>
	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">角色简介</label>
		<div class="layui-input-block">
			<textarea name="roleInfo" id="roleInfo" placeholder="请输入角色简介"
				class="layui-textarea"></textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
	<input type="hidden" id="rowId" name="rowId" />
</form>
<script type="text/javascript" src="assert\page\role\role.js"></script>

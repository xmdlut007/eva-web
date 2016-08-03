<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>测试</title>
</head>
<body>
	<form class="well form-horizontal" action="/app/upload" method="POST"
		enctype="multipart/form-data">
		<fieldset>
			<legend>编辑媒体源</legend>
			<div class="control-group">
				<label class="control-label">新媒体ICON</label>
				<div class="controls">
					<input type="file" name="phoneIcon" id="phoneIcon"
						value="${media.phoneIcon}" />
					<p class="help-block">图片格式要求：168×168、192*192均可</p>
				</div>
			</div>

			<%-- 		<div class="control-group">
				<label class="control-label">媒体名称</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="mediaName"
						name="mediaName" required value="${media.name}" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">一句话描述</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="description"
						name="description" required value="${media.description}" />
					<p class="help-block">填写20字以内的描述</p>
				</div>
			</div> --%>

			<div class="form-actions">
				<a class="btn btn-primary"
					href="audit/subscription/subscription?type=${type}">返回</a> <input
					type="submit" class="btn btn-primary" value="确定" />
			</div>
		</fieldset>
	</form>
	<form class="well form-horizontal" action="/app/upload1" method="POST"
		enctype="multipart/form-data">
		<fieldset>
			<legend>编辑媒体源</legend>
			<div class="control-group">
				<label class="control-label">新媒体ICON</label>
				<div class="controls">
					<input type="file" name="phoneIcon" id="phoneIcon"
						value="${media.phoneIcon}" />
					<p class="help-block">图片格式要求：168×168、192*192均可</p>
				</div>
			</div>
			<div class="form-actions">
				<a class="btn btn-primary"
					href="audit/subscription/subscription?type=${type}">返回</a> <input
					type="submit" class="btn btn-primary" value="确定" />
			</div>
		</fieldset>
	</form>
	<form class="well form-horizontal" action="/app/upload2" method="POST"
		enctype="multipart/form-data">
		<fieldset>
			<legend>编辑媒体源</legend>
			<div class="control-group">
				<label class="control-label">新媒体ICON</label>
				<div class="controls">
					<input type="file" name="phoneIcon" id="phoneIcon"
						value="${media.phoneIcon}" />
					<p class="help-block">图片格式要求：168×168、192*192均可</p>
				</div>
			</div>
			<div class="form-actions">
				<a class="btn btn-primary"
					href="audit/subscription/subscription?type=${type}">返回</a> <input
					type="submit" class="btn btn-primary" value="确定" />
			</div>
		</fieldset>
	</form>
</body>
</html>

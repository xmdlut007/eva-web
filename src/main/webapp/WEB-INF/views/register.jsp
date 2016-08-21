<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/assets/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="/assets/js/bootstrap.js"></script>
 -->
 <link rel="stylesheet" href="/assets/css/bootstrap.min.css">



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User From</title>
</head>
<body>
	<div class="container">
		<div id="signup">
			<h1>新用户注册</h1>
			<form method="POST" action="/auth/register" role="form"
				id="signup-request-form">
				<input type="hidden" name="_xsrf"
					value="2|5ad121f1|abc42d1eb11c60e943191cdf7354581e|1471524062" />
				<fieldset class="form-group">
					<label><label for="userName">昵称</label></label> <input
						class="form-control" type="text" name="userName" />

				</fieldset>
				<fieldset class="form-group">
					<label><label for="password">密码</label></label> <input
						class="form-control" type="password" name="password" />

				</fieldset>
				<div class="form-group">
					<label>邮件</label> <input class="form-control" type="text"
						name="email" /> <input type="text" name="identifier_id"
						id="identifier_id" hidden />
				</div>
				<div class="form-group">
					<label><button
							class="btn btn-info btn-sm form-control-static"
							id="fetch-identifier-code">获取验证码</button></label> <span
						style="color: red;" id="send-email-success"></span> <input
						class="form-control" type="text" name="identifier_code"
						placeholder="输入验证码" />

				</div>

				<div style="color: red;" id="js-validate-error"></div>
				<button class="btn btn-large btn-primary btn-block"
					id="signup-request-bt">注册</button>
			</form>
			<div class="option-switch">
				<a style="padding-right: 20px" href="/auth/forget_password">忘记密码</a>
				<a href="/auth/signin">登录</a>
			</div>
		</div>
	</div>
</body>
<script src="/assets/js/signup.js"></script>
</html>
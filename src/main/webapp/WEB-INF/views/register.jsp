<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User From</title>
</head>
<body>
	<form action="/auth/register" method="post">
		<fieldset>
			<legend>创建用户</legend>
			<p>
				<label>姓名：</label> <input type="text" id="userName" name="userName"
					tabindex="1">
			</p>
			</p>
			<p>
				<label>密码：</label> <input type="text" id="password" name="password"
					tabindex="2">
			</p>
			<p>
				<label>邮箱：</label> <input type="text" id="email" name="email"
					tabindex="3">
		<p>
				<label>验证码：</label> <input type="text" id="code" name="code"
					tabindex="4">
			</p>
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4" value="取消"> <input
					id="submit" type="submit" tabindex="5" value="创建">
			</p>
		</fieldset>
	</form>
</body>
</html>
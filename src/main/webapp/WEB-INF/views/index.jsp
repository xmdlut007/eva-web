<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User From</title>
</head>

<body>
   欢迎来到eva 社区 ~
   ${hasSign}
   <ul class="nav navbar-nav pull-xs-right">
      <li class="nav-item signin">
          <a class="nav-link" href="/auth/signin">登录</a>
      </li>
      <li class="nav-item signin">
          <a class="nav-link" href="/auth/signup">注册</a>
      </li>
    </ul>
</body>
</html>
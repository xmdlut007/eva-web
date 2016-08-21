<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet">
<script src="/assets/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User From</title>
</head>
<body>
<div class="container">

      <form class="form-signin" action="/auth/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="userName" class="form-control" >
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js" type="text/javascript"></script> 
 -->
<div class="span2">
	欢迎来到eva 社区 ~
	<div id="divMsg">Hello World!</div>
	<input id="btnShow" type="button" value="显示" /> <input id="btnHide"
		type="button" value="隐藏" /><br /> <input id="btnChange"
		type="button" value="修改内容为 Hello World, too!" />
	<script type="text/javascript">
		$("#btnShow").bind("click", function(event) {
			$("#divMsg").show();
		});
		$("#btnHide").bind("click", function(event) {
			$("#divMsg").hide();
		});
		$("#btnChange").bind("click", function(event) {
			$("#divMsg").html("Hello World, too!");
		});
	</script>
	<ul class="nav navbar-nav pull-xs-right">
		<li class="nav-item signin"><a class="nav-link"
			href="/auth/signin">登录</a></li>
		<li class="nav-item signin"><a class="nav-link"
			href="/auth/signup">注册</a></li>
	</ul>
</div>
function validateEmail(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
// 检查signup注册对话框格式
function check_form() {
	$("#js-validate-error").text(""); //

	var v = "";
	var $signup = $("#signup");
	console.log("1212124")

	v = $signup.find("input[name=userName]").val()
	console.log(v)
	if (v.length < 2) {
		return "用户名不能小于2个字符";
	}
	v = $signup.find("input[name=password]").val()
	if (v.length < 8) {
		return "密码不能小于8个字符";
	}

	v = $signup.find("input[name=email]").val()
	if (!validateEmail(v)) {
		return "邮件地址格式错误";
	}

	return ""
};
function bind_fetch_identifier() {
	var $signup = $("#signup");

	$("#fetch-identifier-code").click(function(event) {
		event.preventDefault();
		err = check_form();
		if (err.length != 0) {
			$("#js-validate-error").text(err)
			return

		}
		var xsrf = $signup.find("input[name=_xsrf]").val();
		var data = {
			type : 'email',
			data : $signup.find("input[name=email]").val(),
		}
		$.ajax({
			method : 'POST',
			url : '/auth/register',
			async : true,
			headers : {
				'X-Xsrftoken' : xsrf
			},
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				$("#send-email-success").text("邮件发送成功！");
				// $("#send-email-success").delay(3200).fadeOut(300);
				$("#identifier_id")[0].value = data.id;
			},
			error : function(e) {
				$("#send-email-success").text(e.responseJSON.error);
			}
		});
	});
};
function signup() {
	var $signup = $("#signup")

	$("#signup-request-bt").click(
			function() {
				// event.preventDefault();
				err = check_form();
				if (err.length != 0) {
					$("#js-validate-error").text(err)
					return

				}
				var xsrf = $signup.find("input[name=_xsrf]").val();
				var data = {
					nickname : $signup.find("input[name=userName]").val(),
					password : $signup.find("input[name=password]").val(),
					email : $signup.find("input[name=email]").val(),
					identifier_id : $signup.find("input[name=identifier_id]")
							.val(),
					identifier_code : $signup.find(
							"input[name=identifier_code]").val(),
				}
				$.ajax({
					url : "/api/auth/signup",
					method : "POST",
					async : true,
					headers : {
						'X-Xsrftoken' : xsrf
					},
					data : JSON.stringify(data),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(data) {
						if (data.status == 'success') {
							window.location = "/auth/signin"
						}
					},
					error : function(e) {
						$("#js-validate-error").text(e.responseJSON.error)
					}
				});
			});
}
$(document).ready(function() {
	bind_fetch_identifier();
	signup();
});
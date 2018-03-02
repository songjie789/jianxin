<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;修改密码
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入账号：<input type="text" class="input3" id="name"/> 
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入密码：<input type="password" class="input3"
						 id="password" />
				</div>
				<div class="bbD">
					再次确认密码：<input type="password" class="input3" 
						id="password2" />
				</div>
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="checkpwd1()">提交</button>
						<a class="btn_ok btn_no" href="#">取消</a>
					</p>
				</div>
			</div>

			<!-- 修改密码页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
		function checkpwd1(){
			var name = $("#name").val();
			var password = $("#password").val();
			var password2 = $("#password2").val();
			if(name=="" || name==null){
				alert("账号不能为空");
				return false;
			}
			if(password==""||password==null){
				alert("密码不能为空");
				return false;
			}
			if(password!=password2){
				alert("两次输入账号不一致");
				return false;
			}
			 RSAUtils.setMaxDigits(200);
			var key = new RSAUtils.getKeyPair("${public_exponent}", "",
					"${Modulus}"); 
			 var encrypedPwd = RSAUtils.encryptedString(key, password); 
			 alert(encryedPwd);
			$.post("registrationAdmin", {
				password : encrypedPwd,
				name : name,
			}, function(data) {
				if (data.isok == 1) {
					alert(data.message);
					$("#register").modal("hide");
				} else {
					$("#errormessage").html(data.message);
				}
			})
		}
</script>
</html>
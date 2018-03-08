<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- 引入外部js判断添加用户事件 -->
<script type="text/javascript" src="jsp_js/changepwsa_js.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">公共管理</a>&nbsp;-</span>&nbsp;添加用户
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入账号：<input type="text" class="input3" id="username"/> 
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入密码：<input type="password" class="input3" id="password" />
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确认密码：<input type="password" class="input3" id="password2" />
				</div>
				
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号：&nbsp;&nbsp;&nbsp;<input type="text" class="input3" id="phone" />
				</div>
				
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="name" class="input3" 
						id="name" />
				</div>
				
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="checkpwd1()">提交</button>
						<a class="btn_ok btn_no"  id = "quxiao" href="#">取消</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<style> 
span{
	color: #000;
	font-size: 20px;
	font-face: 微软雅黑;
	position: absolute;
	top: 25px;
	left: 1650px;
}
</style>


<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL" >
			<img class="headLogo" src="img/logLOGOa.JPG" width="200px" height="80px" />
			<span>欢迎：${admin }</span>
		</div>
		<div class="headR" >
			<a href="index" rel="external">【退出】</a>
		</div>
	</div>
</body>
</html>
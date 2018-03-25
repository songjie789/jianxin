<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>

<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/jquery.paginate.css" />
<link rel="stylesheet" href="css/jquery.yhhDataTable.css" />

<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.paginate.js" ></script>
<script type="text/javascript" src="js/jquery.yhhDataTable.js" ></script>
<script type="text/javascript" src="js/index.js" ></script>
<script type="text/javascript" src="jsp_js/power.js" ></script>
</head>
<body style="padding-bottom:3px;">
<div style="width:1200px;margin:20px;top:-20px;" id="MainForm">
	
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>编号</th>
			<th>管理员账号</th>
			<th>管理员姓名</th>
			<th>管理员手机号</th>
			<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.user}" var="user">
			<tr>
			<td>${number}</td>
			<td>${user.username }</td>
			<td>${user.name }</td>
			<td>${user.phone }</td>
			<td>权限管理&nbsp;&nbsp;&nbsp;&nbsp;
				<a  href="#" onclick="Updatemima(${user.id})">密码初始化</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${user.supera=='正常' }">
				<a id="a" href="#" onclick="Updatejinyong(${user.id})">禁用</a></c:if>
				<c:if test="${user.supera=='禁用' }">
				<a id="a" href="#" onclick="Updatejinyong(${user.id})">还原</a></c:if>
			</td>
			</tr>
		<c:set var="number" value="${number+1}"></c:set>
		</c:forEach>
		</tbody>
	</table>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
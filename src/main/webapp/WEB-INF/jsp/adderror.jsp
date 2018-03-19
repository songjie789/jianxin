<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>

<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/jquery.paginate.css" />
<link rel="stylesheet" href="css/jquery.yhhDataTable.css" />
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/carcontent.css"/>
<link rel="stylesheet" type="text/css" href="css/css.css" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.paginate.js" ></script>
<script type="text/javascript" src="js/jquery.yhhDataTable.js" ></script>
<script type="text/javascript" src="js/index.js" ></script>
<script type="text/javascript" src="jsp_js/pilot_js.js"></script>
<script type="text/javascript" src="jsp_js/carcontent_js.js"></script>

</head>
<body style="padding-bottom:0px;">
	<!-- 头部 -->
	<div class="pageTop">
		<div class="page">
			<img src="img/coin02.png" /><span><a href="pilot">首页</a>&nbsp;-&nbsp;
			<a href="pilot">操作日志</a>&nbsp;-</span>&nbsp;异常信息
		</div>
	</div>		
	
	
	 <!-- 分页  -->			
<div style="width:1650px;margin:20px;top:0px;" id="MainForm">
	<button class="button white" onclick="add_driver()">添加信息</button>
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>异常编号</th>
			<th>登录站好</th>
			<th>异常信息</th>
			<th>操作时间</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.error}" var="error">
			<tr>
			<td>${error.id }</td>
			<td>${error.username }</td>
			<td>${error.error_message }</td>
			<td>${error.time }</td>
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
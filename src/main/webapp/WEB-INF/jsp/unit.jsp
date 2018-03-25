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

</head>
<body style="padding-bottom:3px;">
<div style="width:1200px;margin:20px;top:-20px;" id="MainForm">
	
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>编号</th>
			<th>公司名称</th>
			<th>公司地址</th>
			<th>公司负责人</th>
			<th>负责人电话</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.unit}" var="unit">
			<tr>
			<td>${unit.id}</td>
			<td>${unit.unit_name }</td>
			<td>${unit.unit_address }</td>
			<td>${unit.unit_contact }</td>
			<td>${unit.unit_phone }</td>
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
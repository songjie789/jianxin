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

</head>
<body style="padding-bottom:0px;">
<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="carcontent">首页</a>&nbsp;-&nbsp;<a
					href="carcontent">驾驶员管理</a>&nbsp;-</span>&nbsp;驾驶员信息
			</div>
			</div>		
  			
<div style="width:1650px;margin:20px;top:0px;" id="MainForm">
	<button class="button white" id = "add">添加信息</button>
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>编号</th>
			<th>驾驶员编号</th>
			<th>驾驶员姓名</th>
			<th>驾驶员性别</th>
			<th>车辆编号</th>
			<th>驾驶证编号</th>
			<th>操作</th>
			
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.js}" var="js">
			<tr>
			<td>${number}</td>
			<td>${js.id }</td>
			<td>${js.name }</td>
			<td>${js.age }</td>
			<td>${js.shenfezheng_id }</td>
			<td>${js.jiashiyuan_name }</td>
			<td>详情&nbsp;&nbsp;&nbsp;&nbsp;修改
			&nbsp;&nbsp;&nbsp;&nbsp;删除</td>
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
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车辆维修</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	<script type="text/javascript" src="jsp_js/carrepair_js.js"></script>
	
  </head>
  	<body style="padding-bottom:3px;">
	<!-- 头部导航标签 -->
	<div class="pageTop">
		<div class="page">
			<img src="img/coin02.png" /><span><a href="car_repair">首页</a>&nbsp;-&nbsp;
			<a href="car_repair">车辆维修</a>&nbsp;-</span>&nbsp;车辆维修
		</div>
	</div>
	
	
	<!--条件搜索  -->
	<div style="width:1200px;margin:20px; background-color:#d7d7d7; id="MainForm">
		<b>车牌号:</b><input style="height: 30px;width: 100px" id ="search_car_number"/>&nbsp;&nbsp;
		<b>部件:</b><select id = "search_car_driver"style="height: 30px; ">
		<option value="0" size="20px"> 请选择部件 </option>
			<c:forEach items="${requestScope.bj}" var="bj">
				<option value="${bj.id}">${bj.part_name}</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		
		<button class="button white"  id="search">搜索</button>
		<a href="addpart">
		<button class="button white">新增部件</button></a>
	</div>
	
	<!-- 分页 -->
	<div style="width:100%;margin:20px;" id="MainForm">
		<table  id="testtable2" cellpadding="10px" cellspacing="50px">
			<thead>
				<tr>
					<th>ID</th>
					<th>车牌号</th>
					<th>维修地点</th>
					<th>更换部件</th>
					<th>部件单价</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="number" value="1"></c:set>
				<c:forEach items="${requestScope.wx}" var="wx">
					<tr>
						<td>${wx.id}</td>
						<td>${wx.car_number }</td>
						<td>${wx.repair_address }</td>
						<td>${wx.repair_part }</td>
						<td>${wx.unit_price }</td>
						<td>编辑|删除</td>
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

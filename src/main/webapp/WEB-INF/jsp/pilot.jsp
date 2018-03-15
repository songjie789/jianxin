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
			<a href="pilot">驾驶员管理</a>&nbsp;-</span>&nbsp;驾驶员信息
		</div>
	</div>		
	
	
	 <!-- 分页  -->			
<div style="width:1650px;margin:20px;top:0px;" id="MainForm">
	<button class="button white" onclick="add_driver()">添加信息</button>
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>驾驶员编号</th>
			<th>驾驶员姓名</th>
			<th>驾驶员所属车辆</th>
			<th>住址</th>
			<th>联系方式</th>
			<th>操作</th>
			
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.js}" var="js">
			<tr>
			<td>${js.id }</td>
			<td>${js.driver_name }</td>
			<td>${js.driver_car_number }</td>
			<td>${js.driver_address }</td>
			<td>${js.driver_phone }</td>
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


<!-- 添加驾驶员信息 默认隐藏,点击添加按钮才显示 -->
  		<br/><br/><br/><br/><br/>
  		<!-- 添加车辆信息 -->
  		<div>
  			<center>
  			<table cellspacing="20px">
  				<tr>
  					<td>驾驶员姓名:</td>
  					<td><input id="driver_name"style="height: 30px;width: 200px"/></td>
  				</tr>
  				
  				<tr>
  					<td>驾驶员所属车辆:</td>
 					<td>
  						<select id = "driver_number" name="district" style="width: 205px">
							<option value="0">请选择车辆</option>
							<c:forEach var="car_number" items="${car_number_ok}" >
							<option value=${car_number}>${car_number.car_number}</option>
							</c:forEach>
						</select>
  					</td>
  				</tr>
  				
  				<tr>
  					<td>住址:</td>
  					<td><input id="driver_address"style="height: 30px;width: 200px" maxlength="17"/></td>
  				</tr>
  				<tr>
  					<td>联系方式:</td>
  					<td><input id="driver_phone"style="height: 30px;width: 200px"/></td>
  				</tr>
  			</table>
  			<button class="button white"   onclick="add_driver()">添加</button>
  			<button class="button white">取消</button>
  			</center>
  		</div>
</body>
</html>
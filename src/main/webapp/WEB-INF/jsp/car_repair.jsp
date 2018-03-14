<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>车辆维修</title>
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/jquery.paginate.css" />
<link rel="stylesheet" href="css/jquery.yhhDataTable.css" />
<link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
<link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/carcontent.css"/>

<script type="text/javascript" src="js/jquery.paginate.js" ></script>
<script type="text/javascript" src="js/jquery.yhhDataTable.js" ></script>
<script type="text/javascript" src="js/index.js" ></script>
<!--引入车辆维修信息页面的js事件  -->
<script type="text/javascript" src="jsp_js/car_repair_js.js" ></script>
</head>
	<body  style="padding-bottom:0px;">
	<!-- 头部 -->
	<div class="pageTop">
				<div class="page">
					<img src="img/coin02.png" /><span><a href="car_repair">首页</a>&nbsp;-&nbsp;<a
						href="car_repair">车辆维修</a>&nbsp;-</span>&nbsp;车辆维修信息
				</div>
	</div>	
	<div class="head"  id = "head">

  			车牌号:<input style="height: 30px;width: 100px" id ="car_number"/>
  			车辆所属驾驶员:<select id = "car_driver" style="height: 30px; ">
				<option value="0" size="20px">请选择所属驾驶员</option>
  				<c:forEach items="${js}" var="js">
  						<option value="${js.id}" size="20px">${js.driver_name}</option>
				</c:forEach>
			</select>
	  			<button class="button white"  onclick="search()">搜索</button>
  			<button class="button white"  onclick = "add_part()">新增部件</button>
  		</div>	
	
	
	 <!-- 分页  -->			
<div>
	<table width="100%" height="100%" id="testtable2" cellpadding="10px" cellspacing="50px">
		<thead><tr>
			<th>车牌号</th>
			<th>车辆所属驾驶员</th>
			<th>维修地点</th>
			<th>维修部件</th>
			<th>部件单价</th>
			<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="number" value="1"></c:set>
		<c:forEach items="${requestScope.wx}" var="wx">
			<tr>
			<td>${wx.id }</td>
			<td>${wx.car_number }</td>
			<td>${wx.repair_address }</td>
			<td>${wx.repair_part }</td>
			<td>${wx.unit_price }</td>
			<td><a href="#">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">删除</a></td>
			</tr>
		<c:set var="number" value="${number+1}"></c:set>
		</c:forEach>
		</tbody>
	</table>
</div>
<div style="text-align:center;">
</div>

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
					部件名称 ：<input type="text"  class="input3"  id="repair_name"/> 
				</div>
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" id="repair_add">提交</button>
						<button class="btn_ok btn_no" id="repair_cancel">取消</button>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
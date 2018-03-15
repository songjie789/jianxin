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
    
    <title>添加车辆信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="jsp_js/addcarcontent_js.js"></script>
  </head>
  <body >
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="addcarcontent">首页</a>&nbsp;-&nbsp;<a
					href="carcontent">车辆信息</a>&nbsp;-</span>&nbsp;添加车辆信息
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					车辆名称：<input type="text" class="input3" id="car_name"/> 
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					车辆长度：<input type="text" class="input3" id="car_length" />
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					车架号:&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="car_vin" maxlength="17"/>
				</div>
				
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					车牌号:&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="car_number" />
				</div>
				
				<div class="bbD">
				车辆所属驾驶员:&nbsp;&nbsp;
					<select id ="car_driver" style="height: 40px; width: 200px;" >
						<option value="0">请选择驾驶员</option>
						<c:forEach items="${js}" var="js">
							<option value="${js.id}">${js.driver_name }</option>
						</c:forEach>
					</select>
				</div>
					
				<div class="bbD">
				车辆所属单位:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<select id="car_unit" style="height: 40px; width: 200px;">
						<option value="1"> 请  选  择  所  属  单位 </option>
						<c:forEach items="${car_unit}" var="car_unit">
							<option value="${car_unit.id}">${car_unit.unit_name}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="addcar()">添加</button>
						<button class="btn_ok btn_no" onclick="quxiao()">取消</button>
					</p>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>

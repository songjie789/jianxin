<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加车辆维修</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- 引入外部js判断添加用户事件 -->
<script type="text/javascript" src="jsp_js/addcarrepair_js.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">车辆维修</a>&nbsp;-</span>&nbsp;添加车辆维修
			</div>
		</div>
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
		
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					维修地点：&nbsp;
					<input type="text" class="input3" id="repair_address" />
				</div>
				
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					维修部件：&nbsp;
					<select id ="repair_part" style="width: 245px;height: 40px">
					<option value="1">请选择更换的部件</option>
						<c:forEach items="${part}" var="part">
							<option value="${part.id }">${part.part_name }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					部件单价：
					<input type="text" class="input3" id="unit_price" />(元)
				</div>
				
					<div class="bbD">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					车牌号：&nbsp;&nbsp;&nbsp;&nbsp;
					<select id = "car_number" style="width: 245px;height: 40px">
					<option value = "0" >请选择车辆</option>
						<c:forEach items="${car}" var="car">
							<option value="${car.car_id}">${car.car_number}</option>
						</c:forEach>
					</select>
				</div>
				
				
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="add_repair()">提交</button>
						<a class="btn_ok btn_no"  href="car_repair">取消</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
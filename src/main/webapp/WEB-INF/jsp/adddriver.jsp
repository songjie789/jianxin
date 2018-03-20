<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加驾驶员</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="jsp_js/add_driver_js.js"></script>

</head>
<body style="padding-bottom:0px;">
	<!-- 头部 -->
	<div class="pageTop">
		<div class="page">
			<img src="img/coin02.png" /><span><a href="indexa">首页</a>&nbsp;-&nbsp;
			<a href="pilot">驾驶员管理</a>&nbsp;-</span>&nbsp;添加驾驶员信息
		</div>
	</div>	
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					驾驶员姓名：<input type="text" class="input3" id="name"/> 
				</div>
				<div class="bbD">
					住址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="address"/> 
				</div>
				<div class="bbD">
					联系方式：&nbsp;&nbsp;
					<input type="text" class="input3"id="phone" />
				</div>
				<div class="bbD">	
					所属车辆	：&nbsp;&nbsp;&nbsp;
						<select id = "car_number" style="width: 245px; height: 40px" >
							<option value="0">请选择车辆</option>
							<c:forEach items="${js}" var="js">
							<option value="${js.car_number }">${js.car_number}</option>
							</c:forEach>
						</select>
				</div>
				<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="add_driver()">提交</button>
						<a class="btn_ok btn_no" href="main" id="quxiaosj">取消</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
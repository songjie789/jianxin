<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加单位</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="jsp_js/addunit_js.js"></script>
</head>
<body style="padding-bottom:0px;">
	<!-- 头部 -->
	<div class="pageTop">
		<div class="page">
			<img src="img/coin02.png" /><span><a href="indexa">首页</a>&nbsp;-&nbsp;
			<a href="#">单位管理</a>&nbsp;-</span>&nbsp;添加单位信息
		</div>
	</div>	
		<div class="page ">
			<!-- 修改密码页面样式 -->
			<div class="bacen">
				<div class="bbD">
					单位名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="unit_name"/> 
					</br></br></br>
					单位地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="unit_address"/> 
					</br></br></br>
					单位负责人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" class="input3" id="unit_contact"/>
					</br></br></br>
					单位负责人电话：<input type="text" class="input3" id="unit_phone">
					</br></br></br>
					<div class="bbD">
					<p class="bbDP">
						<button class="btn_ok btn_yes" onclick="addunitaa()">添加</button>
						<a class="btn_ok btn_no" onclick="quxiao()">取消</a>
					</p>
				</div>
			</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
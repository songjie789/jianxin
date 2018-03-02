<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
<head></head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<a href="main.html" target="main"><div class="line">
					<img src="img/coin01.png" />&nbsp;&nbsp;首页
				</div></a>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="img/coin03.png" /><img class="icon2"
						src="img/coin04.png" /> 网站管理<img class="icon3"
						src="img/coin19.png" /><img class="icon4"
						src="img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="onemenu"
						target="main">添加一级菜单</a><img class="icon5" src="img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="img/coin111.png" /><img class="coin22"
						src="img/coin222.png" /><a class="cks" href="twomenu"
						target="main">添加二级菜单</a><img class="icon5" src="img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				
				<c:forEach items="${requestScope.first }" var="first">
				<dl class="system_log" onclick="display()">
					<dt >						
						<img class="icon1" src="img/coin07.png"  />
						<img class="icon2"src="img/coin08.png" /> ${first.name }<img class="icon3"src="img/coin19.png" />
						<img class="icon4"src="img/coin20.png" />
					</dt>
				
					<c:forEach items="${requestScope.second }" var="second">
					<c:if test="${first.id==second.firset_menu_id}">
					<dd>
						<img class="coin11" src="img/coin111.png" />
						<img class="coin22"src="img/coin222.png" />
						<a class="cks" href="${second.address } "target="main">${second.name }</a>
						<img class="icon5" src="img/coin21.png" />
					</dd>
					</c:if>
					</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>
</body>

</html>
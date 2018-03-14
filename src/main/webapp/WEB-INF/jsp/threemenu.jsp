<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>一级菜单</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">网站管理</a>&nbsp;-</span>&nbsp;新增三级菜单
			</div>
		</div>
		<div class="page ">
			<!-- 添加三级菜单 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>三级菜单</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						菜单名称：<input type="text" class="input3" id="name" placeholder="请输入三级菜单名称"/>
					</div>
					<div class="bbD">
						连接地址：<input type="text" class="input3" id="address" placeholder="请输入连接地址">
					</div>
					<div class="bbD">
						一级菜单：<select id='news_type' class="input3">
							<option value="-1">请选择三级菜单</option>
						<c:forEach items="${requestScope.first }" var="first">
							<option value="${first.id }">${first.name }</option>
						</c:forEach>
							</select>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" onclick="addonefirst()">提交</button>
							<a class="btn_ok btn_no" href="#">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 会员注册页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
function addonefirst() {
	var name = $("#name").val();
	var id = $("#news_type").val();
	var address = $("#address").val();
		
	if(name == null||name == ""){
		alert("菜单名称不能为空");
		return false;
	}
	if(address == null||address ==""){
		alert("请选择连接地址");
		return false;
	}
	if(id==-1){
		alert("请选择二级菜单");
		return false;
	}
	
	 $.post("addthreemenu", 
	 {name : name,address : address, id : id},
	  function(data) {
		if (data.ok == 1) {
			alert("新增失败");
		} else {
			alert("新增成功");
		} 
	}) 
	
}
</script>
</html>
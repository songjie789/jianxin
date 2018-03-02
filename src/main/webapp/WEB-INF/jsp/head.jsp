<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
</head>

<style> 
span{
	color: #000;
	font-size: 18px;
	font-face: 微软雅黑;
	position: absolute;
	top: 8px;
	left: 1010px;
}
</style>
<script type="text/javascript"></script>
  <style type="text/css">
    p{
    color: #000;
	font-size: 18px;
	font-face: 微软雅黑;
	position: absolute;
	top: 50px;
	left: 1010px;
    }
  </style>


<body>
	<!-- 头部 -->
	<div class="head"  >
		<div class="headL" >
			<img class="headLogo" src="img/logLOGOa.JPG" width="200px" height="80px" />
			<span>欢迎：${admin}</span> <p id= "clock">.</p>
			<a href="login" id="tuichu">退出</a>
		</div>
	</div>
</body>

<script language="javascript"> 

/*清除登陆标记并退出账号到首页  */
function realSysTime(clock){ 
var now=new Date(); //创建Date对象 
var year=now.getFullYear(); //获取年份 
var month=now.getMonth(); //获取月份 
var date=now.getDate(); //获取日期 
var day=now.getDay(); //获取星期 
var hour=now.getHours(); //获取小时 
var minu=now.getMinutes(); //获取分钟 
var sec=now.getSeconds(); //获取秒钟 
month=month+1; 
var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
var week=arr_week[day]; //获取中文的星期 
var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间 
clock.innerHTML=time; //显示系统时间 
} 
window.onload=function(){ 
window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间 
} 
</script> 
</html>
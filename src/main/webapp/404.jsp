<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="main">
		<center>
			<div>
				<img src="img/main-bg.jpg" width="900px" height="450px"/>
			</div>
		</center>
		<!-- header -->
		<div id="header">
			<center>
			<h1>唉呀!</h1>  
            <h1>你正在寻找的页面无法找到。<a style="color:#ff6600;" href="login">可能在这里！</a></h1>  
            <a class="link" href="login" onclick="history.go(-1)"><span id="sec"></span> 秒后返回首页</a>  
            <br /><br /><br /> 
			</center>
		</div>
		<!-- footer -->
		<div id="footer">
      </div>
	</div>			
</body>
    <script type="text/JavaScript">  
 var secs = 5; //倒计时的秒数   
for(var i=secs;i>=0;i--)   
 {   
	window.setTimeout("doUpdate(" + i + ")", (secs-i) * 1000);   
 }   
function doUpdate(num)   
 {   
	document.getElementById("sec").innerHTML = num ;   
	if (num == 0){window.location='login'}  //window.location='要跳转的页面'
 }  
</script> 
</html>
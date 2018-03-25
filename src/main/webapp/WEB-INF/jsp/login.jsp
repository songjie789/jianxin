<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow"/>
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />
<style>
body{width:100%;height:100%;overflow:hidden;background:url(img/pc_loginBg.jpg) no-repeat;background-size:cover;position:absolute;}
</style>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/page.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
	  $('body').particleground({
	    dotColor:'green',
	    lineColor:'#c9ec6e'
	  });
	  $('.intro').css({
	    'margin-top': -($('.intro').height() /2)
	  });
	  $(".loginform input[type='button']").click(function(){

		  location.href="index";
		  });
	});
</script>
<style>
button{
	width: 100%;
	height: 45px;
	background-color: #999999;
	border: none;
	color: white;
	font-size: 18px;
}
</style>
</head>
<body>
<form action="index" method="post">
  <section class="loginform">
   <h1>后台管理系统</h1>
   <ul>
    <li> 
    <c:if test="${zhuang ==null }">
   	 <p>${zhuan }</p>
   	 </c:if>
   	 <p>${zhuang }</p>
     <label>账号：</label>
     <input type="text" name="username"  id = "username"class="textBox" placeholder="管理员账号"/>
    </li>
    <li>
     <label>密码：</label>
     <input type="password" name="password" id = "password"class="textBox" placeholder="登陆密码"/>
    </li>
    <li>
     <button>登录</button>
    </li>
   </ul>
  </section>
  </form>
</body>
<script type="text/javascript">
	
</script>
</html>
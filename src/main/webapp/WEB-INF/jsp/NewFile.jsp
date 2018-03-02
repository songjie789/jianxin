<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<style> 
	div
	{
		width:100px;
		height:100px;
		background:red;
		animation:myfirst 1s;
		-moz-animation:myfirst 1s; /* Firefox */
		-webkit-animation:myfirst 1s; /* Safari and Chrome */
		-o-animation:myfirst 1s; /* Opera */
	}

	@keyframes myfirst
	{
		from {background:red;}
		to {background:yellow;}
	}

	@-moz-keyframes myfirst /* Firefox */
	{
		from {background:red;}
		to {background:yellow;}
	}

	@-webkit-keyframes myfirst /* Safari and Chrome */
	{
		from {background:red;}
		to {background:yellow;}
	}

	@-o-keyframes myfirst /* Opera */
	{
		from {background:red;}
		to {background:yellow;}
	}
</style>
<body>
<div>1<div>2</div>
<div>3</div>
<div></div></div>

<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
</body>
</html>
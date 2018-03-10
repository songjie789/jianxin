<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>建鑫物流-车辆维修</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/carcontent.css"/>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
	<link rel="stylesheet" href="/layui/css/layui.css" media="all">  <!--引入layui框架css  -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="/layui/layui.js"></script><!-- 引入layui框架js -->
	<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.paginate.js" ></script>
<script type="text/javascript" src="js/jquery.yhhDataTable.js" ></script>
<script type="text/javascript" src="js/index.js" ></script>
<script type="text/javascript" src="js/jquery.easyui.min.js" ></script>

</head>
<body style="padding-bottom:3px;">
<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="autorepair">首页</a>&nbsp;-&nbsp;<a
					href="autorepair">车辆维修</a>&nbsp;-</span>&nbsp;车辆信息
			</div>
			</div>
	<input id="dd"  class="easyui-datebox" required="required"></input>
  </body>
  <script type="text/javascript">
	$('#dd').datebox({    
    required:true   
});  
  </script>
</html>

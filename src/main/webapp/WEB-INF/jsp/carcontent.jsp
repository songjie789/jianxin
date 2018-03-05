<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>车辆信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/carcontent.css"/>
	<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  <body >
  			<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="carcontent">首页</a>&nbsp;-&nbsp;<a
					href="carcontent">车辆管理</a>&nbsp;-</span>&nbsp;车辆信息
			</div>
			</div>
  		<div class="head"  id = "head">
  			车辆编号:<input style="height: 30px;width: 100px"/> &nbsp;&nbsp;
  			
  			车辆名称:<input style="height: 30px;width: 100px"/>&nbsp;&nbsp;
  			
  			车牌号:<input style="height: 30px;width: 100px"/>&nbsp;&nbsp;
  			
  			车辆所属驾驶员:<select style="height: 30px; ">
  			<option value="1" size="20px">请选择所属驾驶员</option>
  				<option value="1" size="20px">宋杰</option>
  				<option value="2">宋杰1</option>
  				<option value="3">宋杰2</option>
  			</select>&nbsp;&nbsp;
  			
  			车辆所属单位:<select style="height: 30px; ">
  			<option value="1" size="20px">请选择所属单位</option>
  				<option value="1" size="20px">顺丰</option>
  				<option value="2">百世</option>
  				<option value="3">圆通</option>
  			</select>
  			<button class="button white" id="search" >搜索</button>
  			<button class="button white" id = "add">添加信息</button>
  		</div>
  		
  		
  		
  		
  		<!-- 分页 -->
  		<div id= "fenye"style="width:1100px;margin:1px;top:10px;" id="MainForm">
<br/>
	<table width="100%" height="100%" >
		<thead><tr>
			<th>编号</th>
			<th>车辆名称</th>
			<th>车辆长度</th>
			<th>车架号</th>
			<th>车牌号</th>
			<th>车辆所属驾驶员</th>
			<th>车辆所属单位</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.selectCar}" var="second">
			<tr id = "tr">
			<td>${second.car_id }</td>
			<td>${second.car_name }</td>
			<td>${second.car_length }</td>
			<td>${second.car_vin }</td>
			<td>${second.car_number}</td>
			<td>${second.car_driver}</td>
			<td>${second.car_unit}</td>
			<td><button class="button white" onclick = "update(this.id)" id = ${second.car_id }>修改</button></td>
			<td><button class="button white"  onclick= "deletes(this.id)" id = ${second.car_id }>删除</button></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div style="text-align:center;">
</div>
  		
  		<!-- 添加车辆信息 默认隐藏,点击添加按钮才显示 -->
  		<br/><br/><br/><br/><br/>
  		<!-- 添加车辆信息 -->
  		<div class="addcar" id="add1">
  			<center>
  			<table cellspacing="20px">
  				<tr>
  					<td>车辆名称:</td>
  					<td><input class="inputa"  id = "carname" style="height: 30px;width: 200px"/></td>
  				</tr>
  				
  				<tr>
  					<td>车辆名称长度:</td>
  					<td><input class="inputa"  id="carlength" style="height: 30px;width: 200px"/></td>
  				</tr>
  				
  				<tr>
  					<td>车辆名称VIN:</td>
  					<td><input class="inputa"  id="carvin" style="height: 30px;width: 200px"/></td>
  				</tr>
  				<tr>
  					<td>车牌号:</td>
  					<td><input class="inputa"  id="carnumber"style="height: 30px;width: 200px"/></td>
  				</tr>
  				
  				<tr>
  					<td>车辆所属驾驶员:</td>
  					<td>
  						<select id = "cardriver" class = "inputb" style="height: 30px; ">
				  			<option  value="1" >请选择所属驾驶员</option>
			  				<option value="2" >宋杰</option>
			  				<option value="3">宋杰1</option>
			  				<option value="4">宋杰2</option>
  				  		</select>
  					</td>
  				</tr>
  				
  				<tr>
  					<td>车辆所属单位:</td>
  					<td>
  						<select id="unit" class = "inputb"style="height: 30px; ">
				  			<option value="1" >请选择所属单位</option>
			  				<option id="sf"   value="2" >顺丰</option>
			  				<option id ="bs"  value="3">百世</option>
			  				<option id="yt"   value="4">圆通</option>
			  				<option id="yz"   value="5">邮政</option>
			  				<option id="zy"   value="6">则一</option>
			  				<option id="st"   value="7">申通</option>
  				  		</select>
  					</td>
  				</tr>
  			</table>
  			<button class="button white"  id = "add" onclick="addto()">添加</button>
  			<button class="button white"  id="quxiao">取消</button>
  			</center>
  		</div>
  		
  		
  		
  		
  		
  		<!-- 修改车辆信息页面  默认隐藏 -->
  		<div class="addcar" id="xiugai">
  			<center>
  			<table cellspacing="20px">
  				<tr>
  					<td>车辆名称:</td>
  					<td><input id = "update_name" style="height: 30px;width: 200px"disabled="true"　readOnly="true" /></td>
  				</tr>
  				
  				<tr>
  					<td>车辆长度:</td>
  					<td><input   id="update_length" style="height: 30px;width: 200px"disabled="true"　readOnly="true"/></td>
  				</tr>
  				
  				<tr>
  					<td>车辆VIN:</td>
  					<td><input  id="update_vin" style="height: 30px;width: 200px" disabled="true"　readOnly="true"/></td>
  				</tr>
  				<tr>
  					<td>车牌号:</td>
  					<td><input  id="update_number"style="height: 30px;width: 200px"/></td>
  				</tr>
  				
  				<tr>
  					<td>车辆所属驾驶员:</td>
  					<td>
  						<select id = "update_driver"style="height: 30px; ">
				  			<option  value="1" >请选择所属驾驶员</option>
			  				<option value="2" >宋杰</option>
			  				<option value="3">宋杰1</option>
			  				<option value="4">宋杰2</option>
  				  		</select>
  					</td>
  				</tr>
  				
  				<tr>
  					<td>车辆所属单位:</td>
  					<td>
  						<select id="update_unit" style="height: 30px; ">
				  			<option value="1" >请选择所属单位</option>
			  				<option id="sf"   value="2" >顺丰</option>
			  				<option id ="bs"  value="3">百世</option>
			  				<option id="yt"   value="4">圆通</option>
			  				<option id="yz"   value="5">邮政</option>
			  				<option id="zy"   value="6">则一</option>
			  				<option id="st"   value="7">申通</option>
  				  		</select>
  					</td>
  				</tr>
  			</table>
  			<button class="button white"  onclick="update_addto()">修改</button>
  			<button class="button white"  id="quxiao">取消修改</button>
  			</center>
  		</div>
  </body>
  <script type="text/javascript">
   
   
   
   //修改一条车辆信息
   function update(car_id){
   		var carid = car_id.substring(0,10);
   		$("#xiugai").show(); //展示修改div
   		$("#head").hide();  //隐藏头部div
   		$("#fenye").hide();  //隐藏分页内容div
   		alert("进入查询修改post"+carid);
   		$.post("select_car",
   		{
   			car_id:carid,
   		},
   		function(data){
   			alert(data);
   			$("#update_name").val(data);
   			function update_addto(){
   				alert("修改成功");
   			} 
   		});
   }
   
   //修改车辆信息进行提交
  
   		
   
   
   //删除一条车辆信息
   function deletes(car_iddel){
   	var car_iddel = car_iddel.substring(0,10);
   	$.post("car_delectxinxi",{
   		car_iddel : car_iddel
   	},function(data){
   		if(data>0){
   			alert("删除成功");
   			window.location.href=window.location.href;   // 刷新当前页面
   		}else{
   			alert("删除失败");
   			window.location.href=window.location.href;   // 刷新当前页面
   		}
   	});
   }
  	

	//搜索查询
  	$(document).ready(function(){
  		$("#search").click(function(){
  			alert("搜索按钮");
  		});
  	});
  	
  	//点击添加信息按钮隐藏头部以及分页div展示添加页面
	  	$(document).ready(function(){
	  		$("#add").click(function(){
	  			$("#head").hide();
	  			$("#fenye").hide();
	  			$("#add1").show();
	  		});
	  	});
	  	
	  	
	  	//在添加信息页面点击取消 展示头部 分页div 隐藏添加信息页面
	  		$(document).ready(function(){
	  		$("#quxiao").click(function(){
	  			$("#head").show();
	  			$("#fenye").show();
	  			$("#add1").hide();
	  			window.location.href=window.location.href;   // 刷新页面
	  		});
	  	});
  	
  	
  	//添加车辆信息
  		function addto(){
  		var carname= $("#carname").val();
  		var carlength =$("#carlength").val();
  		var carvin = $("#carvin").val();
  		var carnumber = $("#carnumber").val();
  		//获取驾驶员的下拉列表值
  		 var  cardriver=document.getElementById("cardriver");
  		 var cardriver_text=$("#cardriver option:selected");
  		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
  		 //获取所属单位的下拉列表框
  		 var  unit=document.getElementById("unit");
  		 var unit_text=$("#unit option:selected");
  		 var units= unit_text.text();  //获取车辆所属单位的text值
  		   		 if(carname==null||carname==""){
  		   		 	alert("车辆名称不能为空");
  		   		 	return false;
  		   		 }
  		   		 if(carlength==null||carlength==""){
  		   		 	alert("车辆长度不能为空");
  		   		 	return false;
  		   		 }
  		   		  if(carvin==null||carvin==""){
  		   		 	alert("车架号VIN不能为空");
  		   		 	return false;
  		   		 }
  		   		  if(carvin.length!=17){
  		   		 	alert("车架号输入错误,车架号为17位数");
  		   		 	return false;
  		   		 }
  		   		  if(carnumber==null||carnumber==""){
  		   		 	alert("车牌号不能为空");
  		   		 	return false;
  		   		 }
  		   		   if(carnumber==null||carnumber==""){
  		   		 	alert("车牌号不能为空");
  		   		 	return false;
  		   		 }
  			$.post("addcar", {
  			carname :carname,  
  			carlength:carlength, 
  			carvin:carvin,   
  			carnumber:carnumber,
  			cardrivers : cardrivers,  
  			unit:units
  			},function(data){
  				if(data>0){
  					alert("添加成功");
  					 $(".inputa").val("");   //把class值为inputa的输入框清空
  					 $(".inputb").val("1"); //把class值为inputb的下拉列表框的value值改为1
  					 
  				}else{
  					alert("添加失败");
  				}
  			});
  		}
  </script>
</html>

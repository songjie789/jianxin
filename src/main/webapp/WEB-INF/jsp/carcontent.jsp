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
	<!-- 引入车辆信息表处理的js事件的js文件 -->
	<script type="text/javascript" src="jsp_js/carcontent_js.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js" ></script>

  </head>
  <body >
  			<div class="pageTop">
			<div class="page">
				<img src="img/coin02.png" /><span><a href="carcontent">首页</a>&nbsp;-&nbsp;<a
					href="carcontent">车辆管理</a>&nbsp;-</span>&nbsp;车辆信息
			</div>
			</div>
			
			<!--条件搜索  -->
  		<div class="head"  id = "head">
  			车辆编号:<input style="height: 30px;width: 100px" id = "search_car_id"/> &nbsp;&nbsp;
  			
  			车辆名称:<input style="height: 30px;width: 100px" id = "search_car_name"/>&nbsp;&nbsp;
  			
  			车牌号:<input style="height: 30px;width: 100px" id ="search_car_number"/>&nbsp;&nbsp;
  			
  			车辆所属驾驶员:<select id = "search_car_driver"style="height: 30px; ">
  			<option value="1" size="20px">请选择所属驾驶员</option>
  				<option value="1" size="20px">宋杰</option>
  				<option value="2">宋杰1</option>
  				<option value="3">宋杰2</option>
  			</select>&nbsp;&nbsp;
  			
  			车辆所属单位:<select id = "search_car_unit" style="height: 30px; ">
  			<option value="1" size="20px">请选择所属单位</option>
  				<option value="1" size="20px">顺丰</option>
  				<option value="2">百世</option>
  				<option value="3">圆通</option>
  			</select>
  			<button class="button white"  id="search">搜索</button>
  			<button class="button white" id = "add">添加信息</button>
  		</div>
  		
  		
  		
  		
  		<!-- 分页 -->
  		<div id= "fenye"style="width:1100px;margin:1px;top:10px;" id="MainForm">
<br/>
	<table width="100%" height="100%" id="dg" data-options="
			31 rownumbers:true,
			32 singleSelect:true,
			33 autoRowHeight:false,
			34 pagination:true,
			35 resizeHandle:'right'">
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
			<tr>
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
  					<td><input class="inputa"  id="carlength" style="height: 30px;width: 200px" /></td>
  				</tr>
  				
  				<tr>
  					<td>车辆名称VIN:</td>
  					<td><input class="inputa"  id="carvin" style="height: 30px;width: 200px" maxlength="17"/><span id= "vin_span"></span></td>
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
  			<button class="button white"  onclick="quxiao()">取消修改</button>
  			</center>
  		</div>
  </body>
</html>

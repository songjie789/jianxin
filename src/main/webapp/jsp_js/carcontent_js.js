/*!
 * 
 *
 * 车辆信息页面
 * 添加车辆
 * 修改车辆信息
 * 删除车辆信息
 * 
 */

/*jshint browser: true, strict: true, undef: true */

     //修改一条车辆信息
   function update(car_id){
	   var ids=$('#tbList tr td:first-child').map(function(){return $(this).text()}).get().join(',')
	   alert(ids);
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


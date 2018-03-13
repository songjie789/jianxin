/*
 * 车辆信息页面
 * 添加车辆
 * 修改车辆信息
 * 删除车辆信息
 * 条件查询
 * 
 */

     //修改一条车辆信息
		function update(car_id){
   		var carid = car_id.substring(0,10);
   		$("#xiugai").show(); //展示修改div
   		$("#head").hide();  //隐藏头部div
   		$("#fenye").hide();  //隐藏分页内容div
   		$.post(
   				"select_car",
   				{car_id:carid},
   				function(data){
   					var obj = JSON.parse(data);  //json数组
   					var carname = obj[0].car_name;
   					var carlength = obj[0].car_length;
   					var carvin = obj[0].car_vin;
   					var carnumber = obj[0].car_number;
   					var carunit = obj[0].car_unit;
   					$("#update_name").val(carname);
   					$("#update_length").val(carlength);
   					$("#update_vin").val(carvin);
   					$("#update_number").val(carnumber);
   				}
   		);
   }
		
		
		
		 //修改车辆信息
		   function update_addto(){
				var car_numbers = $("#update_number").val();//获取车牌号
				//获取驾驶员的下拉列表值
		  		 var  cardriver=document.getElementById("update_driver");
		  		 var cardriver_text=$("#update_driver option:selected");
		  		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
		  		 //获取所属单位的下拉列表框
		  		 var  unit=document.getElementById("update_unit");
		  		 var unit_text=$("#update_unit option:selected");
		  		 var units= unit_text.text();  //获取车辆所属单位的text值
		  		 var vin = $("#update_vin").val();
		  		
		 		$.post("modify",
						{
		 					car_vins :vin,
							car_numbers:car_numbers,
							car_units:units,
							car_drivers:cardrivers
							},
						function(data){
							if(data>0){
								alert("修改成功");
								window.location.href=window.location.href;   // 刷新当前页面
							}else{
								alert("修改失败");
							}
							
						});
			}
		   
		   //取消修改
		   function quxiao(){
			   window.location.href=window.location.href;   // 刷新当前页面(相当于直接舒心到车辆信息页面)
		   }
		   
   
   
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
   
  
  	

   	//顶部条件查询
  	$(document).ready(function(){
  		$("#search").click(function(){
  			var car_id = $("#search_car_id").val(); //获取车辆ID
  			var car_name = $("#search_car_name").val(); //获取车辆名称
  			var car_number = $("#search_car_number").val();//获取车牌号
  	  		//获取驾驶员的下拉列表值
  	  		 var  cardriver=document.getElementById("search_car_driver");
  	  		 var cardriver_text=$("#search_car_driver option:selected");
  	  		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
  	  		 //获取所属单位的下拉列表框
  	  		 var  unit=document.getElementById("search_car_unit");
  	  		 var unit_text=$("#search_car_unit option:selected");
  	  		 var units= unit_text.text();  //获取车辆所属单位的text值
  	  		 alert("车辆编号 : "+car_id+"-----车辆名称 : "+car_name+"------车牌号 : "+car_number+"------车辆所属驾驶员 : "+cardrivers+"------车辆所属单位 :  : "+units);
  	  		 $.post("search",
  	  				 {
  	  			 	car_id:car_id,
  	  			 	car_name:car_name,
  	  			 	car_number : car_number,
  	  			 	car_drivers :cardrivers,
  	  			 	unit:units
  	  				 },
  	  				 function(data){
  	  					 alert(data);
  	  				 });
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
  	
	  		
	  		
	  		//查询车牌号是否存在在进行添加车辆 input失去焦点的时候进行ajax
	  		$(document).ready(function(){
		  		  $("#carnumber").blur(function(){
		  			  	var carnumber = $("#carnumber").val();
		  		   		$.post("select_carnumber",{car_number : carnumber},
		  		   		function(data){
		  		   			if(data==1){
		  		   				alert("车牌号已存在请重新输入");
		  		   			}
		  		   		});						
		  		  });
		  		});
	  		
	  		
	  		
	  		//查询VIN是否存在在进行添加车辆 input失去焦点的时候进行ajax
	  		$(document).ready(function(){
	  		  $("#carvin").blur(function(){
	  			  	var vin = $("#carvin").val();
	  		   		$.post("select_vin",{vins : vin},
	  		   		function(data){
	  		   			if(data==1){
	  		   				alert("VIN已存在请重新输入");
	  		   			}
	  		   		});						
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

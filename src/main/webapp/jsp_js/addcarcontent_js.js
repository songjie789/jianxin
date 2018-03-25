//查询车牌号是否存在在进行添加车辆 input失去焦点的时候进行ajax
	  		$(document).ready(function(){
		  		  $("#car_number").blur(function(){
		  			  	var car_number = $("#car_number").val();
		  		   		$.post("select_carnumber",{car_number : car_number},
		  		   		function(data){
		  		   			if(data==1){
		  		   				alert("车牌号已存在请重新输入");
		  		   			}
		  		   		});						
		  		  });
		  		});
	  		
	  		
	  		
	  		//查询VIN是否存在在进行添加车辆 input失去焦点的时候进行ajax
	  		$(document).ready(function(){
	  		  $("#car_vin").blur(function(){
	  			  	var vin = $("#car_vin").val();
	  		   		$.post("select_vin",{vins : car_vin},
	  		   		function(data){
	  		   			if(data==1){
	  		   				alert("VIN已存在请重新输入");
	  		   			}
	  		   		});						
	  		  });
	  		});
	  		
	  		
	  		
  	//添加车辆信息
  		function addcar(){
  		var carname= $("#car_name").val();
  		var carlength =$("#car_length").val();
  		var carvin = $("#car_vin").val();
  		var carnumber = $("#car_number").val();
  		//获取驾驶员的下拉列表值
  		 var  cardriver=document.getElementById("car_driver");
  		 var cardriver_text=$("#car_driver option:selected");
  		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
  		 var  car_driver_val = 	$("#car_driver option:selected").val();
  		 var  car_unit_val = 	$("#car_unit option:selected").val();
  		 //获取所属单位的下拉列表框
  		 var  unit=document.getElementById("car_unit"); 
  		 var unit_text=$("#car_unit option:selected");	
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
  		   		  if(!/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂]{1}$/.test(carnumber)){
  		   			  alert("车牌号格式错误,正确格式鲁QV23B5");
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
  					window.location.href=window.location.href;
  				}else{
  					alert("添加失败");
  				}
  			});
  		}
  		
  		 //取消修改
		   function quxiao(){
			   window.location.href=window.location.href;   // 刷新当前页面(相当于直接到车辆信息页面)
		   }

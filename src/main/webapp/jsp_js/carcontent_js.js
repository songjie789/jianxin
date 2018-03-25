/*
 * 车辆信息页面
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
				var carnumber	 = $("#update_number").val();//获取车牌号
				//获取驾驶员的下拉列表值
		  		 var  cardriver=document.getElementById("update_driver");
		  		 var cardriver_text=$("#update_driver option:selected");
		  		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
		  		 //获取所属单位的下拉列表框
		  		 var  unit=document.getElementById("update_unit");
		  		 var unit_text=$("#update_unit option:selected");
		  		 var units= unit_text.text();  //获取车辆所属单位的text值
		  		 var vin = $("#update_vin").val();
		  		 var  car_driver_val = 	$("#update_driver option:selected").val();
		  		 var  car_unit_val = 	$("#update_unit option:selected").val();
		  		  if(!/^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂]{1}$/.test(carnumber)){
  		   			  alert("车牌号格式错误,正确格式鲁QV23B5");
  		   			  return false;
  		   		  }
		  		if(car_driver_val==0){
		   			   alert("请选择驾驶员");
		   			   return false;
		   		   }
		   		   if(car_unit_val==0){
		   			   alert("请选择所属单位");
		   			   return false;
		   		   }
		 		$.post("modify",
						{
		 					car_vins :vin,
							car_numbers:carnumber,
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
   function search(){
	   alert("搜索按钮");
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
	  		 alert("搜索按钮");
	  		 $.post("Comprehensive_Search",
	  				 {
	  			 	car_id:car_id,
	  			 	car_name:car_name,
	  			 	car_number : car_number,
	  			 	car_drivers :cardrivers,
	  			 	car_unit:units
	  				 },
	  				 function(data){
	  					 window.location.href="select_car";
	  				 });
   }
  		

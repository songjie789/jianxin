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
  	  		 $.post("Comprehensive_Search",
  	  				 {
  	  			 	car_id:car_id,
  	  			 	car_name:car_name,
  	  			 	car_number : car_number,
  	  			 	car_drivers :cardrivers,
  	  			 	car_unit:units
  	  				 },
  	  				 function(data){
  	  					 alert(data);
  	  				 });
  			});
  	});

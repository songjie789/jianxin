function add_driver(){
	var driver_name = $("#name").val();
	var driver_address = $("#address").val();
	var driver_phone = $("#phone").val();
	//获取车牌号的下拉列表值
		 var  car_number=document.getElementById("car_number");
		 var car_number_text=$("#car_number option:selected");
		 var car_number_val=$("#car_number option:selected").val();
		 var driver_car_number = car_number_text.text(); //获取驾驶员所属车辆的text值
		 if(driver_name==null || driver_name==""){
			 alert("驾驶员姓名不能为空");
			 return false;
		 }
		 
		 if(driver_address==null || driver_address==""){
			 alert("住址不能为空");
			 return false;
		 }
	    if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(driver_phone))&&phone.length!=11){     //正则表达式判断手机号格式和长度
        	 alert("请输入正确的11位手机号");
             return false;  
         } 
	    if(car_number_val==0){
	    	 alert("请选择车辆");
             return false;  
	    }
	    $.post("add_drivers",
	    	{driver_name:driver_name,
	    	driver_car_number:driver_car_number,
	    	driver_address:driver_address,
	    	driver_phone:driver_phone},
	    	function(data){
  				if(data>0){
  					alert("添加成功");
  					window.location.href=window.location.href;
  				}else{
  					alert("添加失败");
  				}
  			});
}

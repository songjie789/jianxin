function add_driver(){
	var name = $("#name").val();
	var address = $("#address").val();
	var phone = $("#phone").val();
	//获取车牌号的下拉列表值
		 var  car_number=document.getElementById("car_number");
		 var car_number_text=$("#car_number option:selected");
		 var car_number_val=$("#car_number option:selected").val();
		 var car_numbers = car_number_text.text(); //获取驾驶员所属车辆的text值
		 
		 alert(name+address+phone+car_numbers);
		 if(name==null || name==""){
			 alert("驾驶员姓名不能为空");
			 return false;
		 }
		 
		 if(address==null || address==""){
			 alert("住址不能为空");
			 return false;
		 }
	    if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))&&phone.length!=11){     //正则表达式判断手机号格式和长度
        	 alert("请输入正确的11位手机号");
             return false;  
         } 
	    if(car_number_val==0){
	    	 alert("请选择车辆");
             return false;  
	    }
	    $.post("add_driver_kjsd9jiot53", {
	    	driver_names:name,
	    	driver_car_number:car_numbers,
	    	driver_address:address,
	    	driver_phone:phone,
	    	},function(data){
  				if(data>0){
  					alert("添加成功");
  					window.location.href=window.location.href;
  				}else{
  					alert("添加失败");
  				}
  			});
	    
	    
	   
}

/**/
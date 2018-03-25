function add_repair(){
	  //获取车牌号的下拉列表值
	 var  car_number=document.getElementById("car_number");
	 var car_number_text=$("#car_number option:selected");
	 var car_numbers = car_number_text.text(); //获取车牌号的下拉列表值
	 var  car_numbers_val = 	$("#car_number option:selected").val();//获取车牌号的val值
	 
	var repair_address = $("#repair_address").val();
	
	  //获取部件的下拉列表值
	 var  repair_part=document.getElementById("repair_part");
	 var repair_part_text=$("#repair_part option:selected");
	 var repair_parts = repair_part_text.text(); //获取部件的下拉列表值
	 var  repair_part_val = 	$("#repair_part option:selected").val();//获取部件的val

	 var unit_price = $("#unit_price").val();
	 if(repair_address==null || repair_address==""){
			alert("维修地址不能为空");
			return false;
		}
	 
		if(repair_part_val==1){
			alert("请选择部件");
			return false;
		}
		
		if(unit_price==null || unit_price==""){
			alert("部件价格不能玩为空");
			return false;
		}
	 
	if(car_numbers_val==0){
		alert("请选择维修车辆");
		return false;
	}

	
	$.post("addrepair",
			{
				car_number:car_numbers,
				repair_address:repair_address,
				repair_part:repair_parts,
				unit_price:unit_price
			},
			function(data){
				if(data>0){
					alert("添加成功")
					window.location.href=window.location.href;
				}else{
					alert("添加失败");
				}
			});
}



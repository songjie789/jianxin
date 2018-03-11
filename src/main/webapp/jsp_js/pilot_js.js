/*
 * 
 * 添加驾驶员信息
 * 修改驾驶员信息
 * 删除驾驶员信息
 * 
 */



//添加驾驶员信息
function add_driver(){
	var driver_name = $("#driver_name").val();
	//获取驾驶员的下拉列表值
	 var  driver_number =document.getElementById("driver_number");
	 var driver_number_text=$("#driver_number option:selected");
	 var driver_car_number = driver_number_text.text(); //获取车牌号
	var driver_address = $("#driver_address").val();
	var driver_phone = $("#driver_phone").val();
	alert(driver_car_number+driver_name+driver_address+driver_phone);
	$.post("add_driver",
			{
		driver_names:driver_name,
		driver_car_numbers:driver_car_number,
		driver_addresss:driver_address,
		driver_phones:driver_phone
			},
			function(data){
				if(data==1){
					alert("添加成功")
				}else{
					alert("添加失败");
				}
				
			});
}
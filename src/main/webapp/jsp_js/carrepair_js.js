
//车辆维修 条件查询
function search(){
	//获取车牌号
	var car_number = $("#car_number").val();
		//获取驾驶员的下拉列表值
		 var  cardriver=document.getElementById("car_driver");
		 var cardriver_text=$("#car_driver option:selected");
		 var cardrivers = cardriver_text.text(); //获取车辆所属驾驶员的text值
		 alert(cardrivers+car_number);
}

//添加部件
function addcar(){
	var part_names = $("#part_name").val();
	if(part_names == null || part_names==""){
		alert("请填写部件名称！");
		return false;
	}
	$.post("addadd",
			{
		part_name:part_names
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


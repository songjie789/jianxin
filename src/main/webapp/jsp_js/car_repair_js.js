
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
$(document).ready(function(){
		$("#repair_add").click(function(){
			var part_names = $("#repair_name").val();
			$.post("add_repair",
					{part_name : part_names},
					function(data){
						if(data==1){
							alert("添加成功");
						}else{
							alert("添加失败");
						}
					});
		});
});

function addunitaa(){
	var unit_name = $("#unit_name").val();
	var unit_address = $("#unit_address").val();
	var unit_contact = $("#unit_contact").val();
	var unit_phone = $("#unit_phone").val();
	if(unit_name==null || unit_name==""){
		alert("单位名称不能为空");
		return false;
	}
	if(unit_address==null || unit_address==""){
		alert("单位地址不能为空");
		return false;
	}
	if(unit_contact==null || unit_contact==""){
		alert("单位负责人不能为空");
		return false;
	}
    if(!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(unit_phone))&&unit_phone.length!=11){     //正则表达式判断手机号格式和长度
   	 alert("请输入正确的11位手机号");
        return false;  
    } 
	$.post("addunits",
			{
			unit_name:unit_name,
			unit_address:unit_address,
			unit_contact:unit_contact,
			unit_phone:unit_phone
			},
			function(data){
				if(data>0){
					alert("插入成功");
					window.location.href=window.location.href;
				}else{
					alert("插入失败");
				}
			});
}

//取消按钮
function quxiao(){
	window.location.href=window.location.href;
}
/*!
 * 
 *修改用户密码js事件
 * 
 */

$(document).ready(function(){
		  $("#quxiao").click(function(){
		   		window.location.href=window.location.href;   // 清空输入框
					window.location.reload; 							
		  });
		});
		function checkpwd1(){
			var username = $("#username").val();   //获取账号
			var password = $("#password").val();  //获取密码
			var password2 = $("#password2").val(); //获取重复密码
			var phone = $("#phone").val(); //获取手机号
			var name = $("#name").val(); //获取姓名
			if(username.length==0 || username==null){
				alert("账号不能为空");
				return false;
			}
			if(password==""||password==null){
				alert("密码不能为空");
				return false;
			}
			if(password!=password2){
				alert("两次密码输入不一致");
				return false;
			}
          if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))&&phone.length!=11){     //正则表达式判断手机号格式和长度
         	 alert("请输入正确的11位手机号")
              return false;  
          } 
			$.post("AddUsers", {
				username : username,
				password : password,
				phone : phone,
				name : name
			}, 
			function(data) {
				if (data == 1) {
					alert("添加成功");
					window.location.href=window.location.href;   //添加完成之后进行局部刷新 清空输入框
					window.location.reload; 								//添加完成之后进行局部刷新 清空输入框
				} else if(data == 0) {
					alert("添加失败");
					window.location.href=window.location.href;   //添加完成之后进行局部刷新 清空输入框
					window.location.reload; 								//添加完成之后进行局部刷新 清空输入框
				}else if(data == 2){
					alert("用户信息已存在请重新填写账号或密码")
				}else{
					alert("未知错误 请联系网络管理员!!!")
				}
			});
		}
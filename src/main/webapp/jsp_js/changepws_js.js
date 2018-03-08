/*!
 * 
 *添加用户js事件
 * 
 */

//点击取消按钮清空input框
		$(document).ready(function(){
		  $("#quxiao").click(function(){
		   		window.location.href=window.location.href;   // 清空输入框
				window.location.reload; 							
		  });
		});
		function checkpwd1(){
			var username = $("#username").val();
			var password = $("#password").val();
			var password2 = $("#password2").val();
			var phone = $("#phone").val();
			if(username=="" || username==null){
				alert("账号不能为空");
				return false;
			}
			if(username.length>10){
				alert("账号长度不能超出10位");
				return false;
			}
		   if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))&&phone.length!=11){     //正则表达式判断手机号格式和长度
        	 alert("请输入正确的11位手机号")
             return false;  
           } 
			if(password==""||password==null){
				alert("密码不能为空");
				return false;
			}
			if(password.length>16){
				alert("密码不能超过16位");
				return false;
			}
			if(password!=password2){
				alert("两次输入密码不一致");
				return false;
			}
			$.post("registrationAdmin", {
				username : username,
				password : password,
				phone : phone
			}, function(data) {
				if(data==1){
					alert("修改成功");
					window.location.href=window.location.href;   //添加完成之后进行局部刷新 清空输入框
					window.location.reload; 								//添加完成之后进行局部刷新 清空输入框
					}else if(data==2){
						alert("账号和手机号不存在请重新输入");
					}else if (data == 0){
						alert("修改失败");
					}else{
						alert("未知错误 请联系网络管理员!!!");
					}
			});
		}
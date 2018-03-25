	//还原管理员密码
	function Updatemima(id) {
		$.post("mima", 
				 {id : id},
				  function(data) {
					if (data == 1) {
						alert("密码还原成功");
						parent.location.reload();
					} else {
						alert("密码还原失败");
					} 
				})
	}
	//修改管理员状态
	function Updatejinyong(id) {
		$.post("UpdateZhuangTai", 
				 {id : id},
				  function(data) {
					if (data == 1) {
						alert("修改管理员状态成功");
						parent.location.reload();
					} else {
						alert("修改管理员状态失败");
					} 
		})
	}
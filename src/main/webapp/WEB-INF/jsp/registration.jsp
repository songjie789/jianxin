<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-2.2.0.min.js"></script>
<title>注册</title>
<script type="text/javascript">
function toAddAdmin() {
	/* var name = $("#name").val();
	var password = $("#password").val();
	alert(password);
	/* if (name == null || name == "") {
		alert(name);
	} else {
		
	}
	if (password == null || password == "") {
		
		return false;
	} else {
		$("#loginnamemessage1").html("");
	}
	
	RSAUtils.setMaxDigits(200);
	alert(name);
	var key = new RSAUtils.getKeyPair("${public_exponent}", "",
			"${Modulus}"); 
	var encrypedPwd = RSAUtils.encryptedString(key, password); encrypedPwd 
	$.post("registrationAdmin", {name : name,password : encrypedPwd}
	, function(data) {
		alert(name);
		if (data.isok == 1) {
			alert(data.message);
			$("#register").modal("hide");
		} else {
			$("#errormessage").html(data.message);
		}
	}) */
}
	function c(){
		
	 	var b=document.getElementsByName("product");
	 	for (var i=0;i<b.length;i++)
	 		b[i].checked=document.getElementById("all").checked;
	 }
	
	function bouth(){  
        //判断至少写了一项  
        var checkedNum = $("input[name='product']:checked").length;  
        if(checkedNum==0){  
            alert("请至少选择一项!");  
            return false;  
        }  
        if(confirm("确定删除所选项目?")){  
        var checkedList = new Array();  
        $("input[name='product']:checked").each(function(){  
            checkedList.push($(this).val());  
        });  
        $.ajax({  
            type:"POST",  
            url:"del",  
            data:{"delitems":checkedList.toString()},  
            datatype:"html",  
            success:function(data){  
                $("[name='checkbox2']:checkbox").attr("checked",false);  
                location.reload();//页面刷新  
            },  
            error:function(data){  
                art.dialog.tips('删除失败!');  
            }  
        });  
        
        }  
}  
</script>
</head>
<body>
<!-- <form action="" method="post">
<input type="text" placeholder="输入注册名" id="name"  value="Admin" ><br>
<input type="password" placeholder="输入密码" id="password" value="admin"><br>
<input type="password" placeholder="确认密码" name="password1"><br>
<p id="loginnamemessage2"></p>
<button onclick="toAddAdmin()"> 注册</button>
</form> -->
  <table border="0" cellspacing="0" cellpadding="0" class="bg">
  <tr>
    <td style="height:40px;">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr style="font-weight:bold;">
    <td><input id="all" type="checkbox" value="全选" onclick="c()" />全选</td>
    <td>商品图片</td>
  </tr>
  <c:set var="number" value="1"></c:set>
  <c:forEach items="${requestScope.second }" var="Batch" >
  	<tr>
    <td><input name="product" type="checkbox" value="${Batch.id }" /></td>
    <td>${Batch.name }<td>
    <td>${Batch.firset_menu_id }</td>
  	</tr>
  	<c:set var="number" value="${number+1 }"></c:set>
  	</c:forEach>
</table>
<button onclick="bouth()">全部删除</button>

<form method="POST" action="" name="myform"> 
<button  name="B1" >按钮</button>
</form>
</body>

</html>
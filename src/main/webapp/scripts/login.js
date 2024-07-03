function loginAction(){
			//清空提示信息
			$("#count_span").html("");
			$("#password_span").html("");
			//获取请求参数
			var name=$("#count").val().trim();
			var password=$("#password").val().trim();
			var ok=true; //所有参数均有效
			//格式的校验
			if(name==""){
				$("#count_span").html("用户名不能为空");
				ok=false;
			}
			if(password==""){
				$("#password_span").html("密码不能为空");
				ok=false;
			}
			//发送ajax请求
			if(ok){
				$.ajax({
					url:path+"/user/login.do",
					type:"post",
					data:{"name":name,"password":password},
					dataType:"json",
					success:function(result){
						if(result.state==0){ //0代表成功
							//将用户信息写入Cookie
							var user = result.data;
							
							addCookie("userId",user.id,2);
							//跳转到主页
							window.location.href="edit.html";
							
						}else if(result.state==2){
							$("#count_span").html(result.message);
						}else if(result.state==3){
							$("#password_span").html(result.message);
						}
					
				
					},
					error:function(){
						alert("登录失败");
					}
				});
			}
		}


function registAction(){
	
	
	//清除提示信息
	$("#warning_1 span").html("");
	$("#warning_2 span").html("");
	$("#warning_3 span").html("");
	var name = $("#regist_username").val().trim();
	var nick = $("#nickname").val().trim();
	var password = $("#regist_password").val().trim();
	var final_password=$("#final_password").val().trim();

	var ok=true;
	if(name==""){
		ok=false;
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();  //div被隐藏了，因此span也被隐藏了
		
	}
	//验证密码长度
	if(password=="" || password.length<6){
		$("#warning_2 span").html("密码长度太短");
		$("#warning_2").show();
		ok=false;
	}
	//验证密码和确认密码
	else if(password!=final_password){
		$("#warning_3 span").html("密码不一致哦");
		$("#warning_3").show();
		ok=false;
	}
	if(ok){
		$.ajax({	
			"url":path+"/user/regist.do",
			"type":"post",
			"dataType":"json",
			"data":{"name":name,"nick":nick,"password":password},
			"success":function(result){
				//console.log(1);
				if(result.state==2){
					//alert("用户名被占用");
					$("#warning_1 span").html(result.message);
					$("#warning_1").show();
				}
				if(result.state==0){
					alert("注册成功，返回登录界面");
					$("#back").click();
					//user = result.data;
					$("#count").val(result.data.name);
					$("#password").focus();  //光标停在密码框
					
					//清除之前注册的信息.离开之前打扫卫生
					$("#regist_username").val("");
					$("#nickname").val("");
					$("#regist_password").val("");
					$("#final_password").val("");
				}
				
			},
			"error":function(){
				alert("系统繁忙，稍后再试");
				console.log(path);
				console.log(window.location.pathname);
			}
		 });
		
	}
	

 }











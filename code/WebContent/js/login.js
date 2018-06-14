		var username="";
		var pwd="";
		function clickbutton(){
			username="";
			pwd="";
			username=document.getElementById("username").value;
			if(username==""){
				document.getElementById("error").innerHTML="用户名不能为空";
				return false;
			}
			pwd=document.getElementById("password").value;
			if(pwd==""){
				document.getElementById("error").innerHTML="密码不能为空";
				return false;
			}
			$.ajax({
			url:"http://localhost:8080/LabManager/login",
			data: {
				username: username,
				password: pwd
			},
			type:"POST",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					window.location.href = "manager.html";
				}
				else if(xhr.status == 221){
					document.getElementById("error").innerHTML="您输入的用户名或密码有错";
					loginform.username.focus();
					return false;
				}else{
					console.log(xhr.status);
				}
			},
			error: function () {
				console.log(error);
			}
		});
		}
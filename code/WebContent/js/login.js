		var username="";
		var pwd="";
//		var code=urlToobj().code;
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
		
//		function urlToobj(){
//			var obj={};
//			var url=location.href;
//			var arr1=url.split('?');
//			if (arr1.length > 1) {
//				var arr2=arr1[1].split('&');
//				var arr3;
//				for (let i=0; i<arr2.length; i++) {
//					arr3=arr2[i].split('=');
//					obj[arr3[0]]=arr3[1];
//				}
//				return obj;
//			}
//			return {code: 0};
//		}
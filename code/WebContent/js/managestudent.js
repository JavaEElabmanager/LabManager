	var table=document.getElementById("student");
	var studentid="";
	var studentname="";
	var keywords="";
	window.onload=allstudent();
	function addstu(){
		studentid="";
		studentname="";
		studentid=document.getElementById("studentid").value;
		if(studentid==""){
				document.getElementById("error").innerHTML="学生学号不能为空";
				return false;
			}
		studentname=document.getElementById("studentname").value;
		if(studentname==""){
				document.getElementById("error").innerHTML="学生姓名不能为空";
				return false;
			}
		$.ajax({
			url:"http://localhost:8080/LabManager/addStudent",
			data: {
				studentId: studentid,
				studentName: studentname
			},
			type:"GET",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					location.reload();
				}
				else{
					window.location.href="#addStudent";
					document.getElementById("error").innerHTML=xhr.status;
					console.log(xhr.status);
					return false;
				}
			},
			error: function () {
				console.log(error);
			}
		});
	}
	function searchstu(){
		keywords="";
		keywords=document.getElementById("keywords").value;
		if(keywords==''){
			location.reload();
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/searchStudentById",
			data: {
				studentId: keywords
			},
			type:"GET",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					table.innerHTML="";
					var obj=JSON.parse(xhr.responseText);
					console.log(obj);
					var tr=document.createElement("tr");
					tr.innerHTML="<td>"+obj.studentId+"</td><td>"+obj.studentName+"</td><td><span>修改</span>&nbsp<span onclick='delstudent("+obj.studentId+","+obj.studentName+")'>删除</span></td>";
					table.appendChild(tr);
				}
				else{
					console.log(xhr.status);
					return false;
				}
			},
			error: function () {
				console.log(error);
			}
		});
	}
	function allstudent(){
		$.ajax({
			url:"http://localhost:8080/LabManager/allStudents",
			type:"GET",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					console.log(xhr.responseText);
					var arr=eval(xhr.responseText);
					console.log(arr);
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.studentId+"</td><td>"+obj.studentName+"</td><td><span>修改</span>&nbsp<span onclick='delstudent("+obj.studentId+","+obj.studentName+")'>删除</span></td>";
						table.appendChild(tr);
					}
				}
				else{
					console.log(xhr.status);
				}
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
	function delstudent(id,name){
		$.ajax({
			url:"http://localhost:8080/LabManager/deleteStudent",
			data: {
				studentId: id,
				studentName: name
			},
			type:"GET",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					console.log(xhr.responseText);
					location.reload();
				}
				else{
					console.log(xhr.status);
				}
			},
			error: function (error) {
				console.log(error);
			}
		});
	}
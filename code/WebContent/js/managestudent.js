	var table=document.getElementById("student");
	var studentid="";
	var studentname="";
	var keywords="";
	window.onload=allstudent();
	function addstu(){
		studentid="";
		studentname="";
		studentid=document.getElementById("studentid").value;
		if(checknull(studentid)){
				document.getElementById("error").innerHTML="学生学号不能为空";
				return false;
			}
		if(!checknumber(studentid)){
			document.getElementById("error").innerHTML="学生学号必须为数字";
			return false;
		}
		studentname=document.getElementById("studentname").value;
		if(checknull(studentname)){
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
		if(checknull(keywords)||!checknumber(keywords)){
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
					tr.innerHTML="<td>"+obj.studentId+"</td><td>"+obj.studentName+"</td><td><span data-toggle='modal' data-target='#updateStudent' onclick='updatebutton("+obj.studentId+",	&apos;"+obj.studentName+"&apos;)'>修改</span>&nbsp<span onclick='delstudent("+obj.studentId+")'>删除</span></td>";
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
						tr.innerHTML="<td>"+obj.studentId+"</td><td>"+obj.studentName+"</td><td><span data-toggle='modal' data-target='#updateStudent' onclick='updatebutton("+obj.studentId+",	&apos;"+obj.studentName+"&apos;)'>修改</span>&nbsp<span onclick='delstudent("+obj.studentId+")'>删除</span></td>";
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
	function delstudent(id){
		$.ajax({
			url:"http://localhost:8080/LabManager/deleteStudent",
			data: {
				studentId: id
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
	function updatebutton(id, name){
		$("#studentid2").val(id);
		$("#studentname2").val(name);
	}
	function updatestu(id,name){
		studentid=document.getElementById("studentid2").value;
		if(checknull(studentid)){
				document.getElementById("error2").innerHTML="学生学号不能为空";
				return false;
			}
		if(!checknumber(studentname)){
			document.getElementById("error2").innerHTML="学生学号必须为数字";
			return false;
		}
		studentname=document.getElementById("studentname2").value;
		if(checknull(studentname)){
				document.getElementById("error2").innerHTML="学生姓名不能为空";
				return false;
			}
		$.ajax({
			url:"http://localhost:8080/LabManager/updateStudent",
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
					window.location.href="#updateStudent";
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

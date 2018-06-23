	var table=document.getElementById("lab");
	var labid="";
	var labname="";
	var labposition="";
	var keywords="";
	window.onload=alllab();
	function addlab(){
		labname="";
		labposition="";
		labname=document.getElementById("labname").value;
		if(checknull(labname)){
				document.getElementById("error").innerHTML="实验室名称不能为空";
				return false;
		}
		labposition=document.getElementById("labposition").value;
		if(checknull(labposition)){
				document.getElementById("error").innerHTML="实验室位置不能为空";
				return false;
			}
		$.ajax({
			url:"http://localhost:8080/LabManager/addLab",
			data: {
				labName: labname,
				labPosition: labposition
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
				else if(xhr.status == 221) {
					document.getElementById("error").innerHTML="实验室名称已存在";
					return false;
				}
				else if(xhr.status == 222) {
					document.getElementById("error").innerHTML="实验室位置已存在"
					return false;
				}
				else{
					window.location.href="#addLab";
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
	function searchlab(){
		keywords="";
		keywords=document.getElementById("keywords").value;
		console.log(keywords)
		if(checknull(keywords)){
			location.reload();
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/searchLabByname",
			data: {
				labName: keywords
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
					var arr=eval(xhr.responseText);
					console.log(arr);
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.labId+"</td><td>"+obj.labName+"</td><td>"+obj.labPosition+"</td><td><span onclick='sendlabid("+obj.labId+")'>查看</span>&nbsp<span data-toggle='modal' data-target='#updateLab' onclick='updatebutton("+obj.labId+",&apos;"+obj.labName+"&apos;,&apos;"+obj.labPosition+"&apos;)'>修改</span>&nbsp<span onclick='dellab("+obj.labId+")'>删除</span></td>";
						table.appendChild(tr);
					}
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
	function alllab(){
		$.ajax({
			url:"http://localhost:8080/LabManager/allLab",
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
						tr.innerHTML="<td>"+obj.labId+"</td><td>"+obj.labName+"</td><td>"+obj.labPosition+"</td><td><span onclick='sendlabid("+obj.labId+")'>查看</span>&nbsp<span data-toggle='modal' data-target='#updateLab' onclick='updatebutton("+obj.labId+",&apos;"+obj.labName+"&apos;,&apos;"+obj.labPosition+"&apos;)'>修改</span>&nbsp<span onclick='dellab("+obj.labId+")'>删除</span></td>";
						table.appendChild(tr);
					}
				}
				else if(xhr.status == 230) {
					window.location.href = 'index.html';
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
	function dellab(id){
		$.ajax({
			url:"http://localhost:8080/LabManager/deleteLab",
			data: {
				labId: id
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
				else if(xhr.status == 231){
					alert("该实验室还有计算机");
					return false;
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
	function updatebutton(id,name,position){
		labid=id;
		$("#labposition2").val(position);
		$("#labname2").val(name);
	}
	function updatelab(id,name,position){
		labname=document.getElementById("labname2").value;
		if(checknull(labname)){
				document.getElementById("error2").innerHTML="实验室姓名不能为空";
				return false;
			}
		labposition=document.getElementById("labposition2").value;
		if(checknull(labposition)){
			document.getElementById("error2").innerHTML="实验室位置不能为空";
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/updateLab",
			data: {
				labId: labid,
				labName: labname,
				labPosition: labposition
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
				else if (xhr.status == 223) {
					document.getElementById("error2").innerHTML="实验室名称或位置重复";
					return false;
				}
				else{
					window.location.href="#updateLab";
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
function sendlabid(id){
	url="managecomputer.html?labid="+id;
	window.location.href=url;
}

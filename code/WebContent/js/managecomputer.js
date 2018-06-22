	var table=document.getElementById("computer");
	var computerid="";
	var computerposition="";
	var computerip="";
	var labid=urlToobj().labid;
	var labid2="";
	var isusing=false;
	var keywords="";
	document.getElementById("title").innerHTML="<a>"+labid+"号实验室计算机</a>";
	window.onload=allcomputer();
	function addcomputer(){
		computerposition="";
		computerip="";
		computerposition=document.getElementById("computerposition").value;
		if(checknull(computerposition)){
				document.getElementById("error").innerHTML="计算机机号不能为空";
				return false;
		}
		if(!checknumber(computerposition)){
			document.getElementById("error").innerHTML="计算机机号必须为数字";
			return false;
		}
		computerip=document.getElementById("computerip").value;
		if(checknull(computerip)){
				document.getElementById("error").innerHTML="计算机ip不能为空";
				return false;
			}
		if(!checkip(computerip)){
			document.getElementById("error").innerHTML="请输入正确ip";
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/addComputer",
			data: {
				labId: labid,
				computerPosition: computerposition,
				computerIp: computerip
			},
			type:"GET",
			dataType:"text",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success:function(data, status, xhr){
				console.log(data);
				console.log(status);
				console.log(xhr.status);
				if(xhr.status == 200) {
					var url="managecomputer.html?labid="+labid;
					window.location.href=url;
				}
				else if(xhr.status == 221) {
					document.getElementById("error").innerHTML="该计算机机号已存在";
					return false;
				}
				else if(xhr.status == 222) {
					document.getElementById("error").innerHTML="该计算机ip已存在";
					return false;
				}
				else{
					window.location.href="#addComputer";
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
	function searchcomputer(){
		keywords="";
		keywords=document.getElementById("keywords").value;
		if(checknull(keywords)||!checknumber(keywords)){
			var url="managecomputer.html?labid="+labid;
			window.location.href=url;
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/searchComputerByid",
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
					var obj=JSON.parse(xhr.responseText);
					console.log(obj);
					var tr=document.createElement("tr");
					tr.innerHTML="<td>"+obj.computerId+"</td><td>"+obj.computerPosition+"</td><td>"+obj.computerIp+"</td><td>"+obj.isUsing+"</td><td><span data-toggle='modal' data-target='#updateComputer' onclick='updatebutton("+obj.computerId+","+obj.computerPosition+",&apos;"+obj.computerIp+"&apos;)'>修改</span>&nbsp<span onclick='delcomputer("+obj.computerId+")'>删除</span></td>";
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
	function allcomputer(){
		$.ajax({
			url:"http://localhost:8080/LabManager/loadComputersByLabId",
			data: {
				labId: labid
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
					var arr=eval(xhr.responseText);
					console.log(arr);
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.computerId+"</td><td>"+obj.computerPosition+"</td><td>"+obj.computerIp+"</td><td>"+obj.isUsing+"</td><td><span data-toggle='modal' data-target='#updateComputer' onclick='updatebutton("+obj.computerId+","+obj.computerPosition+",&apos;"+obj.computerIp+"&apos;)'>修改</span>&nbsp<span onclick='delcomputer("+obj.computerId+")'>删除</span></td>";
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
	function delcomputer(id){
		$.ajax({
			url:"http://localhost:8080/LabManager/deleteComputer",
			data: {
				computerId: id
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
					var url="managecomputer.html?labid="+labid;
					window.location.href=url;
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
	function updatebutton(id,position,ip){
		computerid=id;
		$("#labid2").val(labid);
		$("#computerposition2").val(position);
		$("#computerip2").val(ip);
	}
	function updatecomputer(){
		labid2=document.getElementById("labid2").value;
		if(checknull(labid)){
				document.getElementById("error2").innerHTML="实验室编号不能为空";
				return false;
			}
		if(!checknumber(labid)){
				document.getElementById("error2").innerHTML="实验室编号必须为数字";
				return false;
			}
		computerposition=document.getElementById("computerposition2").value;
		if(checknull(computerposition)){
				document.getElementById("error2").innerHTML="计算机机号不能为空";
				return false;
			}
		if(!checknumber(computerposition)){
				document.getElementById("error2").innerHTML="计算机机号必须为数字";
				return false;
			}
		computerip=document.getElementById("computerip2").value;
		if(checknull(computerip)){
			document.getElementById("error2").innerHTML="计算机ip不能为空";
			return false;
		}
		if(!checkip(computerip)){
			document.getElementById("error2").innerHTML="请输入正确ip";
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/updateComputer",
			data: {
				labId: labid2,
				computerId: computerid,
				computerPosition: computerposition,
				computerIp: computerip
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
					var url="managecomputer.html?labid="+labid;
					window.location.href=url;
				}
				else if (xhr.status == 222) {
					document.getElementById("error2").innerHTML="计算机ip已存在";
					return false;
				}
				else if (xhr.status == 225) {
					document.getElementById("error2").innerHTML="不可修改正在使用的计算机";
					return false;
				}
				else if (xhr.status == 226) {
					document.getElementById("error2").innerHTML="计算机位置已存在";
					return false;
				}
				else{
					window.location.href="#updateComputer";
					document.getElementById("error2").innerHTML=xhr.status;
					console.log(xhr.status);
					return false;
				}
			},
			error: function () {
				console.log(error);
			}
		});
	}
function urlToobj(){
	var obj={};
	var url=location.href;
	var arr1=url.split('?');
	var arr2=arr1[1].split('&');
	var arr3;
	for (let i=0; i<arr2.length; i++) {
		arr3=arr2[i].split('=');
		obj[arr3[0]]=arr3[1];
	}
	return obj;
}
var table=document.getElementById("list");
var selectlab=document.getElementById("labname");
var selectcomputer=document.getElementById("computerposition");
var labname="";
var computerposition="";
var studentid="";
window.onload=loadlab();//页面加载完成后加载第一个选项列表
//window.onload=loadcomputer(1);//页面加载完成后加载第二个选项列表
window.onload=withoutend();//页面加载完成后显示所有没有完成的记录
$("#labname").change(changeselect);//当第一个选项改变时改变第二个选项的列表
function withoutend(){//显示全部没有结束的记录
	$.ajax({
		url:"http://localhost:8080/LabManager/loadRecordsWithoutEnd",
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
				if(arr && arr.length > 0)
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.studentName+"</td><td>"+obj.startTime+"</td><td><span onclick='endcomputer("+obj.recordId+")'>结束上机</span></td>";
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
function loadlab(){//加载第一个选项列表
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
					var op=document.createElement("option");
					op.value=""+obj.labName;
					op.innerText=obj.labName;
					selectlab.appendChild(op);
				}
				window.onload=loadcomputer(selectlab.options[0].value);//页面加载完成后加载第二个选项列表
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
function loadcomputer(name){//加载第二个选项列表
	selectcomputer.innerHTML="";
	labname=name;
	$.ajax({
		url:"http://localhost:8080/LabManager/getComputersBylabId",
		data:{
			labName: labname
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
				if(arr && arr.length > 0)
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						var op=document.createElement("option");
						op.value=""+obj.computerPosition;
						op.innerText=obj.computerPosition;
						selectcomputer.appendChild(op);
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
function changeselect(){//第一个列表选项变化时改变第二个列表
	var index=selectlab.selectedIndex;
	console.log(index);
	var value=selectlab.options[index].value;
	loadcomputer(value);
}
function startcomputer(){//开始上机
	var index1=selectlab.selectedIndex;
	var value1=selectlab.options[index1].value;
	var index2=selectcomputer.selectedIndex;
	var value2=selectcomputer.options[index2].value;
	var studentid=document.getElementById("studentid").value;

	console.log(value2)
	if(checknull(studentid)||!checknumber(studentid)){
		startcomputer
		return false;
	}
	$.ajax({
		url:"http://localhost:8080/LabManager/startRecord",
		data:{
			labName: value1,
			computerPosition: value2,
			studentId: studentid
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
				console.log(xhr.status);
			}
		},
		error: function (error) {
			console.log(error);
		}
	});	
}
function endcomputer(recordid){//结束上机
	$.ajax({
		url:"http://localhost:8080/LabManager/endRecord",
		data:{
			recordId: recordid
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
				console.log(xhr.status);
			}
		},
		error: function (error) {
			console.log(error);
		}
	});
}

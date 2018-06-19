var table=document.getElementById("list");
var selectlab=document.getElementById("labname");
var selectcomputer=document.getElementById("computerposition");
var labname="";
var computerposition="";
var studentid="";
window.onload=withoutend();
window.onload=loadlab();
function withoutend(){
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
function loadlab(){
	$.ajax({
		url:"http://localhost:8080/LabManager/loadAllLab",
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
					op.setAttribute("value",obj.labName);
					op.value=obj.labName;
					selectlab.appendChild(op);
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
function loadcomputer(){
	
}
function startcomputer(){
	
}

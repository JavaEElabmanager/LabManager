var table=document.getElementById("record");
var myselect=document.getElementById("myselect");
var choice=""
var labname="";
var studentname="";
var keywords="";
window.onload=allrecord();
	function searchbystudent(){
		keywords="";
		keywords=document.getElementById("keywords").value;
		if(checknull(keywords)){
			location.reload();
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/searchRecordsByStudent",
			data: {
				studentName: keywords
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
					console.log(xhr.responseText);
					var arr=eval(xhr.responseText);
					console.log(arr);
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						if(obj.endTime===undefined)
							obj.endTime="该学生正在上机";
						var time=secondsTotime(obj.duration);
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td><td>"+time+"</td>";
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
	function searchbylab(){
		keywords="";
		keywords=document.getElementById("keywords").value;
		if(checknull(keywords)){
			location.reload();
			return false;
		}
		$.ajax({
			url:"http://localhost:8080/LabManager/searchRecordsByLab",
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
					console.log(xhr.responseText);
					var arr=eval(xhr.responseText);
					console.log(arr);
					for (let i=0; i<arr.length; i++) {
						var obj=arr[i];
						if(obj.endTime===undefined)
							obj.endTime="该学生正在上机";
						var time=secondsTotime(obj.duration);
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td><td>"+time+"</td>";
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
	function allrecord(){
		$.ajax({
			url:"http://localhost:8080/LabManager/allRecords",
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
						console.log(obj);
						if(obj.endTime===undefined)
							obj.endTime="该学生正在上机";
						var time=secondsTotime(obj.duration);
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td><td>"+time+"</td>";
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
function search(){
	var index=myselect.selectedIndex;
	choice=myselect.options[index].value;
	if(choice==='student')
		searchbystudent();
	else
		searchbylab();
}
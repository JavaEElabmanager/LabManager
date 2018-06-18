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
					var obj=JSON.parse(xhr.responseText);
					console.log(obj);
					var tr=document.createElement("tr");
					tr.innerHTML="<td>"+obj.recordId+"</td><td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td>";
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
					var obj=JSON.parse(xhr.responseText);
					console.log(obj);
					var tr=document.createElement("tr");
					tr.innerHTML="<td>"+obj.recordId+"</td><td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td>";
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
						var tr=document.createElement("tr");
						tr.innerHTML="<td>"+obj.recordId+"</td><td>"+obj.studentName+"</td><td>"+obj.labName+"</td><td>"+obj.computerPosition+"</td><td>"+obj.startTime+"</td><td>"+obj.endTime+"</td>";
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
function search(){
	var index=myselect.selectedIndex;
	choice=myselect.options[index].value;
	if(choice==='student')
		searchbystudent();
	else
		searchbylab();
}
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="css/bootstrap.min.css">
	    <script src="js/jquery-1.11.0.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
<title>manager</title>
</head>
<body>
	<ul class="nav nav-tabs nav-justified">
			<li class="active"><a href="#">管理员界面</a></li>
			<li><a href="managelab.jsp">实验室管理</a></li>
			<li><a href="managestudent.jsp">学生管理</a></li>
			<li><a href="managerecord.jsp">统计分析</a></li>
		</ul>
		<center><div style="padding: 50px 100px 10px;width:100%">
			<form class="bs-example bs-example-form" role="form" action="">
				<div class="row">
					<div class="col-lg-12">
				<div class="input-group">
					<span class="input-group-addon" >实验室名称</span>
					<span class="input-group-btn" >
						<select class="btn btn-default" id="" >
							<option value ="">实验室名称</option>
  							<option value ="">test</option>
						</select>
					</span>
					<span class="input-group-addon" >机号</span>
					<span class="input-group-btn" >
						<select class="btn btn-default" id="" >
							<option value ="">机号</option>
  							<option value ="">test</option>
						</select>
					</span>
					<span class="input-group-addon">学生学号</span>
					<input type="text" class="form-control" placeholder="请输入学生学号...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">开始上机</button>
					</span>
				</div>
			</div>
				</div>
			</form>
		</div></center>
		<div style="padding: 50px 100px 10px;">
			<table class="table table-hover">
  				<thead>
    				<tr>
      					<th>实验室名称</th>
      					<th>电脑机号</th>
      					<th>学生姓名</th>
      					<th>开始时间</th>
      					<th>操作</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
      					<td>example</td>
      					<td></td>
      					<td></td>
      					<td></td>
      					<td><a href="#"></a>结束上机</td>    					
    				</tr>
  				</tbody>
			</table>
		</div>
</body>
</html>
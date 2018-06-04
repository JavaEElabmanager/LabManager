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
<title>managerecord</title>
</head>
<body>
	<ul class="nav nav-tabs nav-justified">
			<li><a href="manager.jsp">管理员界面</a></li>
			<li><a href="managelab.jsp">实验室管理</a></li>
			<li><a href="managestudent.jsp">学生管理</a></li>
			<li class="active"><a href="#">统计分析</a></li>
		</ul>
		<center><div style="padding: 50px 100px 10px;width:100%">
			<form class="bs-example bs-example-form" role="form" action="">
				<div class="row">
					<div class="col-lg-12">
				<div class="input-group">
					<span class="input-group-btn">
						<select class="btn btn-default" id="">
							<option value ="student">学生</option>
  							<option value ="lab">实验室</option>
						</select>
					</span>
					<input type="text" class="form-control" placeholder="请输入关键字...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">查询</button>
					</span>
				</div><!-- /input-group -->
			</div><!-- /.col-lg-6 -->
				</div>
			</form>
		</div></center>
		<div style="padding: 50px 100px 10px;">
			<table class="table table-hover">
  				<thead>
    				<tr>
      					<th>记录编号</th>
      					<th>学生姓名</th>
      					<th>实验室名</th>
      					<th>电脑机号</th>
      					<th>开始时间</th>
      					<th>结束时间</th>
    				</tr>
  				</thead>
  				<tbody>
    				<tr>
      					<td>example</td>
      					<td></td>
      					<td></td>
      					<td></td>
      					<td></td>
      					<td></td>
    				</tr>
  				</tbody>
			</table>
		</div>
</body>
</html>
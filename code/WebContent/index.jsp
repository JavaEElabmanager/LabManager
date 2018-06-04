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
<title>Lab Manage System</title>
</head>
<body>
	<img src="img/index.jpg" alt="index.jpg" style="width: 100%;"/>
		<center><div style="padding: 100px 100px 10px;width: 50%">
			<form class="bs-example bs-example-form" action="checklogin.jsp" method="post">
				<div class="input-group">
					<span class="input-group-addon">用 户:</span>
					<input type="text" class="form-control" name="username">
				</div>
				<br />
				<div class="input-group">
					<span class="input-group-addon">密 码:</span>
					<input type="password" name="pwd" class="form-control" >
				</div>
				<br />
				<button type="submit" class="btn btn-primary" >登录</button>
			</form>
			
		</div></center>
<%
   String errmsg=(String)session.getAttribute("errormsg");
   if(errmsg!=null){
     session.removeAttribute("errormsg");
     out.println(errmsg);
   }
%>
</body>
</html>
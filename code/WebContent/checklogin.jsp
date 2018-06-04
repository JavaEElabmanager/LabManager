<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ include file="dbconn.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
      
	  try {
			String username = request.getParameter("username");
        	if (username == null && username.length() == 0)
            	throw new Exception("请输入用户名");
        
	        String pwd=request.getParameter("pwd");
    	    if(pwd==null)pwd="";
      
            ResultSet rs = st.executeQuery("select * from administrator where adminName ='" + username + "'");
            if (rs.next()) {
                if (!pwd.equals(rs.getString("adminPwd")))
                    throw new Exception("密码错误");
                username = rs.getString("adminName");
                
            } else
                throw new Exception("用户不存在");
			
        	session.setAttribute("username",username);
        	response.sendRedirect("manager.jsp");       	   
            
        } catch (Exception ex) {
            session.setAttribute("errormsg",ex.getMessage());
            response.sendRedirect("index.jsp");
        }
        

%>
</body>
</html>
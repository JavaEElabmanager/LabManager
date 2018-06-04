<%@ page import="java.sql.*,java.util.*"%>
<%!
	Connection conn=null;
    Statement st=null;
    Statement st2=null;
    public void jspInit() { 
        try{
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/labdb",
                            "root", "123456");
          st = conn.createStatement();
          st2 = conn.createStatement();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
	public void jspDestroy(){
	   		if(st!=null) {
               try{
                  st.close();
               }
               catch(Exception e){
               }
            }
            if(st2!=null) {
               try{
                  st2.close();
               }
               catch(Exception e){
               }
            }
            if(conn!=null) {
               try{
                  conn.close();
               }
               catch(Exception e){
               }
            }
	}
%>
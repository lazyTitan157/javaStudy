<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jdbc.connection.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>dbconn test</title>
</head>
<body>
<%
	//java7부터 지원하는 try with resource구문 : finally에서 connection닫는거 대신 try블록끝나면 괄호안의 자원의 close실행해줌
	try(Connection conn = ConnectionProvider.getConnection()){
		out.println("connection success");
	} catch(SQLException ex){
		out.println("connection failure : "+ex.getMessage());
		application.log("connection failure : ", ex);
	}
%>
</body>
</html>
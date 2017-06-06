<%@page import="com.tacademy.sam.vo.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="com.tacademy.sam.vo.Data" scope="session"/>
<jsp:setProperty property="name" name="data"/>
m3 name: <jsp:getProperty property="name" name="data"/>
<%
	//response.sendRedirect("m4.jsp");
	//request에는 객체공유 안되지만, session scope에서는 공유가능. 
	//창이열린상태에서 페이지 이동하는 두가지 경우
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("m4.jsp");
	dispatcher.forward(request, response); 
	
%>
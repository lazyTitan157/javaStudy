<%@page import="com.tacademy.sam.vo.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="data" class="com.tacademy.sam.vo.Data" scope="request"/>
<jsp:setProperty property="name" name="data"/>
name: <jsp:getProperty property="name" name="data"/>
<%
	//response.sendRedirect("m2.jsp");
	//이렇게 연결해도 객체 공유 안되네
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("m2.jsp");
	dispatcher.forward(request, response);
%>
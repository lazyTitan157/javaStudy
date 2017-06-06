<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session = "false" in page directive
//HttpSession session = request.getSession(false);
//null exception 처리도 추가 
	//logout success & redirect k1
	session.invalidate();
	response.sendRedirect("k1.jsp");
%>
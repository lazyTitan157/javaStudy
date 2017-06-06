<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//i2.jsp로 이동
	response.sendRedirect("i2.jsp");
	
	/* 
	//forward는 i1.jsp주소로 이동 302statuscode상태코드가 전송되서 방향을 바꿔서 다른페이지로 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("i2.jsp");
	dispatcher.forward(request, response); 
	*/
%>

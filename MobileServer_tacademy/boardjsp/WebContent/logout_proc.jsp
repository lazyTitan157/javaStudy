<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%
//session="false" 는 jsp내장객체를 안쓴다는 것 (나중에 내가 재정의할거라서)
	// 세션 정보를 삭제하고, login.jsp로 이동
	HttpSession session = request.getSession();
	session.invalidate();
	
	response.sendRedirect("login.jsp");
	//forward도 되지만 url도 login.jsp로 바꿔야되니까 sendRedirect로 해야함.
%>
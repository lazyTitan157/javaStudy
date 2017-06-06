<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 두 수를 입력받아 그 합을 구해라
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	int su1 = Integer.parseInt(num1);
	int su2 = Integer.parseInt(num2);
	int sum = su1 + su2;
	
	//dispatcher에 요청할/이동할 페이지를 설정
	request.setAttribute("sum", sum); //보낼변수의 이름, object(아무타입s이나 입력가능)
	RequestDispatcher dispatcher = request.getRequestDispatcher("h2.jsp");
	dispatcher.forward(request, response);
%>
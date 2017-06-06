<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
두 수 입력받아서 합 출력 <br>
<%
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	int su1 = Integer.parseInt(num1);
	int su2 = Integer.parseInt(num2);
	int sum = su1+su2;
%>
sum = <%=sum%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request에 있는 sum변수의 값을 뽑아냄
	int sum1 = (int)request.getAttribute("sum");
	//getAttribute의 return = object타입이므로 형변환필ㄹ요
%>

sum1 : <%= sum1 %> <br>
<!-- sum이라는 변수가 request에 존재하면 아래의 EL로도 사용가능 --> 
sum : ${sum} <br>

num1 : <%=request.getParameter("num1")%><br>
<!-- parameter로 오는 것중에 num1 -->
num1 : ${param.num1 } <br>
<!-- parameter값이 null이면 null띄우지 않고 그냥 안보냄-->
num1 : ${param.num3 } <br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="num1" value="10" />
<c:set var="num2" value="17" />
<c:set var="result" value="${num1*num2}" />
<c:set var="CODE" value="80012" scope="request" />
<c:set var="NAME" value="온습도계" scope="request"/>
<c:set var="PRICE" value="15000" scope="request" />
<c:set var="NUM" value="1"/>
<%
	String arr[] = {"칼국수", "고등어자반", "김치찌개"};
	request.setAttribute("MENU",arr);
%>
<jsp:forward page="d.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${num1} x ${num2 } = ${result}
</body>
</html>
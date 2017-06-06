<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="d2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");

%>
정상실행<br>
받은 문자열 길이 <%= name.length() %><br>
<!-- name이 없으면 널포인터익셉션 (응답코드 500) 에러남 : 그런경우 에러페이지로 넘겨서 응답코드를 수정하고 전송 -->

</body>
</html>
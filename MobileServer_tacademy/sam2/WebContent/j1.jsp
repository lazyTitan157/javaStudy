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
	Cookie c1 = new Cookie("name", "kim");
	Cookie c2 = new Cookie("age", "30");
	Cookie c3 = new Cookie("address", "seoul");
	// 쿠키 3개 생성
	
	c1.setMaxAge(60 * 60);
	c3.setMaxAge(60 * 60);
	// 쿠키만료시점 설정
	
	response.addCookie(c1);
	response.addCookie(c2);
	response.addCookie(c3);
	// 클라이언트로 쿠키 값 전송
%>
쿠키가 생성되었습니다.<br>
</body>
</html>
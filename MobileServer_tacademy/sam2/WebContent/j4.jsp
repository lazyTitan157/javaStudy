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
	Cookie c = new Cookie("address", ""); //쿠키값 초기화해서 저장
	c.setMaxAge(0);
	
	response.addCookie(c); //응답객체로 addcookie를 실행하면
	//쿠키 삭제 완료
%>
쿠키가 삭제됨 <br>
</body>
</html>
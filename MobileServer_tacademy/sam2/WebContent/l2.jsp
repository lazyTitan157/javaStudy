<%@page import="com.tacademy.sam.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//client에서 server로 넘어오는데 한글이 포함된다
	request.setCharacterEncoding("utf-8");
	//post방식 
	
	/* 
	Member member1 = new Member();
	//jsp action tag이용해서 위의 기능 수행
	// 			id = 		class
	member1.setId(request.getParameter("id")); //파라미터로 id를 받아서 member객체의 id로 설정
	out.println(member1.getId());
	*/
%>
<jsp:useBean id="member" class="com.tacademy.sam.vo.Member" />
<jsp:setProperty property="*" name="member" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
id <jsp:getProperty property="id" name="member"/><br>
pw <jsp:getProperty property="pw" name="member"/><br>
name <jsp:getProperty property="name" name="member"/><br>
address <jsp:getProperty property="address" name="member"/><br>
</body>
</html>
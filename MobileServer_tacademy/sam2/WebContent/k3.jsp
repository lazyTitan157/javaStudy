<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%
	HttpSession session = request.getSession(false);

	if(session == null){
		response.sendRedirect("k1.jsp"); //다시로그인페이지로
		return;
	}
	
	String name1 = (String)session.getAttribute("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원전용페이지 <br>
name : <%= name1 %> <br>
<!-- 헐왜이건안돼!? -->
name : ${name} <br>
<a href="k4.jsp" >로그아웃</a>
</body>
</html>
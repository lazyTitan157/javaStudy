<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
포함하는 문서<br>
<%
	int cnt =30;
	//정적인 인클루드 해서 에러 발생하게됨
	//고유 스트링을 받거나 하는 경우에 사용
	
	//동적인 인클루드 : 표준액션태그! <jsp:include> 
	//에러발생안함, 포함되는 문서에 독립적인 변수가 있는경우 충돌 방지
%>
----------------------<br>
<%-- include file="e2.jsp" --%>
<jsp:include page="e2.jsp"/>
----------------------<br>
</body>
</html>
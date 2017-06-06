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
	Cookie[] cookies = request.getCookies();
	//클라이언트에서 가져온 쿠키들을 쿠키들의 배열에 저장
	if(cookies == null){
%>
		저장되 쿠키 정보가 없습니다.<br>
<%		
	}else{
		for(Cookie c : cookies){ //각각의 쿠키에 대해 반복수행
%>
			이름 : <%= c.getName() %> , 값 <%=c.getValue() %><br>
<%		
		}
	}
%>

</body>
</html>
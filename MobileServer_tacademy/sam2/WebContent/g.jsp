<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
내장객체 예제 <br>
<% 
// 입력데이터를 가공해서 결과를 출력할 수 있는 것 = 동적 웹 페이지
	String data = request.getParameter("age");
	int age = Integer.parseInt(data);
	if(data != null) {
		try{
			age = Integer.parseInt(data);
		} catch(NumberFormatException e){
			age = 100;
		}
	}
%>
받은 데이터 : <%= data %><br>
<%	
	if(age >=18){
%>		
승인
<!-- html에 출력되는 부분을 스크립트릿에서 빼야 디자이너가 수정하기 편하다 -->
<%
	} else {
%>
거부
<%		
	}
%>
</body>
</html>
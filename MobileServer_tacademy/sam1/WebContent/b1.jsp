<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
데이터확인페이지<br>
<% 
	String id =  request.getParameter("id");
	String bigo =  request.getParameter("bigo");
	//클라이언트에서 서버로 값을 보내는 방법은 form태그 또는 url에 get방식 파라미터 입력
	//서버에서 클라이언트의 입력값을 받는방법은 아래의 두 함수뿐
	String size = request.getParameter("size");
	String[] langs = request.getParameterValues("lang");
	//아무 입력값이 없으면 null point exception발생 = 500 서버에러 
	//org.apache.jasper.JasperException: 자바코드로 변환시 나는 에러종류
	//하나의 name에 여러개의 입력값이 있는 경우
	String result ="";
	if(langs==null){ //null pointer exception 처리
		result = "no select";
	} else {
		for(int i =0 ; i<langs.length; i++){
			result += langs[i];
		}
	}
	String job = request.getParameter("job");
%>
id <%= id %> <br>
bigo <%= bigo %> <br>
size <%= size %> <br>
langs <%= result %> <br>
job <%= job %> <br>
</body>
</html>
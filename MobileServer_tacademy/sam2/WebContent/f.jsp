<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
jsp 선언예제<br>
<%!
//선언부에 멤버변수,메서드를 초기화 - 
	//보통 따로 class를 따로 만들어서 인클루드함.
	int cnt = 0;
//퍼센트태그의 경우 서블릿 메서드 안에 일단 들어가니까 함수정의는 불가능
//선언부에서 함수정의 가능
	void aa(HttpServletRequest request){
		//String name = request.getParameter("name");
		//메서드 안에 있는 변수만 함수에 사용가능
		//request객체는 aa()에 없다. 
		//servlet메서드에서는 request내장객체가 정의되어 있었다. 
		//매개변수로 servlet메서드에 실행되는 퍼센트 태그에서 인자로 전달
	}
%>
<%-- 선언부는 자바파일의 멤버변수/크래스 정의 영역에 java로서 그대로 들어감 --%>
<%
	String name = request.getParameter("name");
	aa(request);
	cnt++;
%>
cnt: <%=cnt %> <br>
</body>
</html>
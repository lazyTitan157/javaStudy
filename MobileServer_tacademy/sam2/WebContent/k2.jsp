<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!--  session="true" : session 변수사용 선언 (true가 default) - 이걸해야 session변수중복에러 안뜸 -->
<!--  error check page & redirect -->
<%
	//k1에서 넘긴 id, pw값
	String id = request.getParameter("id"); 
	String pw = request.getParameter("pw");
	
	//null check
	if(id==null || pw==null){
		response.sendRedirect("k1.jsp");
		return;
		//sendRedirect로 가니까 return으로 이 페이지를 종료시켜주는게 안전
	}
	
	if("abcd".equals(id) && "1234".equals(pw)){
		HttpSession session  = request.getSession(true);
		//true : 서버에 세션이 없으면 만들어서 반환하고, 세션이 있으면 찾아서 반환하는 설정 (매번만드는게아님)
		//false : 세션이 없으면 null을 반환하고, 있으면 세션을 반환
		//default = true
		
		session.setAttribute("name", "tacademy"); //session읽어들이기 name=tacademy
		// parameter resending
		
		response.sendRedirect("k3.jsp");
		return;
	} else {
		response.sendRedirect("k1.jsp");
		return;
	}
%>
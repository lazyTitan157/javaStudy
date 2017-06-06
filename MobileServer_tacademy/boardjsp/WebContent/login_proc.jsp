<%@page import="com.tacademy.board.vo.Member"%>
<%@page import="com.tacademy.board.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!-- login procedure : send to boardlist -->

<%
	//클라이언트에서 id/pw를 받아서 DB와 비교하고,
	// 성공하면 getBoardList.jsp로 이동 (이름가지고 가기)
	// 실패하면 login.jsp로 이동
	
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
	
		dao.doLogin(member);
		if(member.getName()!=null){
			HttpSession session = request.getSession(true); //없으면 만들어서 return
			session.setAttribute("member",member);
			//System.out.println("login success : " + member.getName());
			response.sendRedirect("getBoardList.jsp"); //request scope유지 안됨
			//그래서 sessiono사용
			
		} else {
			//System.out.println("login fail");
			response.sendRedirect("login.jsp");
		}
	
%>
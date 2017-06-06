<%@page import="com.tacademy.board.vo.Board"%>
<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//기능 구현 한 것에, 클라이언트에서 제목, 글쓴이, 내용을 받아 DAO를통해 DB에 삽입후,
	// getBoardList.jsp로 이동
	//request, response 객체를 사용하는 부분만 웹 작업에 해당하는 것 (기능구현과 웹 작업 섞인 상태)
	
	//한글도 넘어올 수 있으므로 받는 이 문서에서 한글깨지지 않게 
	request.setCharacterEncoding("utf-8");
	BoardDAO dao = new BoardDAO();
	
	Board board = new Board();
	board.setTitle(request.getParameter("title"));
	board.setWriter(request.getParameter("writer"));
	board.setContent(request.getParameter("content"));
	
	dao.doInsert(board); //board객체를 인자로 dao가 쿼리 실행
	
	response.sendRedirect("getBoardList.jsp");

%>

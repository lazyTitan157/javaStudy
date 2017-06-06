<%@page import="com.tacademy.board.vo.Board"%>
<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 잘삭제외었다 -->
<% //삭제하고 getBoardList.jsp로 이동
	//dao에 삭제하는 sql변수 작성하고, 메서드 생성
	//
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		dao.doDelete(board);

		response.sendRedirect("getBoardList.jsp");
%>
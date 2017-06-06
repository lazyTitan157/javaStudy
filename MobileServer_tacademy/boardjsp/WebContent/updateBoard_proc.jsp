<%@page import="com.tacademy.board.vo.Board"%>
<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 잘출렸했다 -->
<% //리스트페이지로 넘어가자(웹) / 모바일에서는 잘출력함데이터만 넘기기
	//클라이언트에서 seq,title,content를 받아서 수정하고,
	//getBoardList.jsp로 이동
		//이런 기능을 수행하는 sql을 만들고 dao에 sql문과 메서드를 추가
		//한글 포함될수 있으므로 받는(요청문자열) 인코딩
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		dao.doUpdate(board);
		
		response.sendRedirect("getBoardList.jsp");
%>

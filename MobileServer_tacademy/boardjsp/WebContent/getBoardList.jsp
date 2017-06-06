<%@page import="com.tacademy.board.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tacademy.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    //board table내용을 가져와서 table양식으로 출력하기
    	//board table접근해서 가져오는 메서드 이용 - BoardDAO이용(이 페이지에서 사용할 메서드 생성 필요)
    BoardDAO dao = new BoardDAO();
		
		ArrayList<Board> list = dao.getBoardList();
		//일반적인 변수는 $로 접근이 안됨. 
		//객체로 받아야됨:<c:set>이용 - JSTL이용
		//html에서 $로 접근 가능 : set으로 지정되어있는건 $로 출력할 수 있다.
    %>
 	<c:set var="list" value="<%=list %>" />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div id = "main">
<h1>글 리스트</h1>
<h3>${member.name}님 로그인 환영합니다......
<a href="logout_proc.jsp">Log-out</a></h3>
<table id = "table2">
<tr>
	<th id = "col1" width="100">번호</th>
	<th id = "col2" width="200">제목</th>
	<th id = "col3" width="150">작성자</th>
	<th id = "col4" width="150">등록일</th>
	<th id = "col5" width="100">조회수</th>
</tr>

<c:forEach var="board" items="${list }">
<tr>
	<td>${board.seq }</td>
	<td align="left">
		<a href="getBoard.jsp?seq=${board.seq }">${board.title}</a>
		<!-- get method : ?seq=num 으로 각각 다른페이지 출력 -->
	</td>
	<td>${board.writer}</td>
	<td>${board.regdate}</td>
	<td>${board.cnt}</td>
</tr>
</c:forEach>
</table>
<br>
<h4><a href="addBoard.jsp">새글 등록</a></h4>
</div>
</body>
</html>
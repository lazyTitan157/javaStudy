<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<a href="member?action=logout">Log-out</a></h3>
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
		<a href="board?action=getBoard&seq=${board.seq }">${board.title}</a>
		<!-- [MVC1]get method : ?seq=num 으로 각각 다른페이지 출력 -->
		<!-- [MVC2] member?action="" 으로 각각 다른페이지 출력 -->
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
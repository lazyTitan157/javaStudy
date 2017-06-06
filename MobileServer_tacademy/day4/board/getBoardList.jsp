<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3>홍길동님 로그인 환영합니다......
<a href="logout_proc.jsp">Log-out</a></h3>
<table id = "table2">
<tr>
	<th id = "col1" width="100">번호</th>
	<th id = "col2" width="200">제목</th>
	<th id = "col3" width="150">작성자</th>
	<th id = "col4" width="150">등록일</th>
	<th id = "col5" width="100">조회수</th>
</tr>

<tr>
	<td>test</td>
	<td align="left"><a href="getBoard.jsp">홍길동</a></td>
	<td>test</td>
	<td>test</td>
	<td>test</td>
</tr>

</table>
<br>
<h4><a href="addBoard.jsp">새글 등록</a></h4>
</div>
</body>
</html>
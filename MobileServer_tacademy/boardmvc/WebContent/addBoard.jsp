<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>새글등록</title>
<link rel="stylesheet" href = "board.css">
</head>
<body>
<div class="main">
<h3>
	새글 등록하기............<a href='member?action=logout'>LOG-OUT</a>
</h3>
<hr>
<form action="board" method="post">
	<!-- servlet member실행, member에서 action에 따라 각각 다른 페이지로 이동 
		form tag : input tag
		a tag : style value -->
	<input type="hidden" name="action" value="addBoard"/>
	<table id="table1">
		<tr>
			<td>제목</td>
			<td align="left"><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td align="left"><input type="text" name="writer" size="10" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value=" 새글 등록 " /></td>
		</tr>
	</table>
</form>
<hr>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
max value <br>
최대값 : 
<c:if test="${param.num1 - param.num2 >=0}">
	${param.num1 }
</c:if>
<c:if test="${param.num1 - param.num2<0 }">
	${param.num2 }
</c:if>

<c:choose>
	<c:when test="${param.NUM==0 }">
		일본어 <br>
	</c:when>
	<c:when test="${param.NUM==1 }">
		중국어 <br>
	</c:when>
	<c:otherwise>
		한국어 <br>
	</c:otherwise>
</c:choose>
<!-- $표현식 : 내부적으로  null이면 0반환하고, 형변환 (개굿) -->
<UL>
<c:forEach var="dish" items="${MENU}">
	<LI>${dish }</LI>
</c:forEach>
</UL>
</body>
</html>
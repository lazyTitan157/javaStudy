<!--
 로그인 여부를 검사하는 커스텀태그
 c:if태그 대신 코드의 의미가 잘드러나도록 커스텀태그화
 
 세션에 authUser속성이 존재하는 경우, 태그의 몸체내용을 출력한다.
-->
<%@ tag body-content="scriptless" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%
	HttpSession httpSession = request.getSession(false);
	if (httpSession != null && httpSession.getAttribute("authUser") != null) {
%>
<jsp:doBody />
<%
	}
%>
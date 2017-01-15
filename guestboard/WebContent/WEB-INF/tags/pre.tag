<%@ tag body-content="empty" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="value" type="java.lang.String" required="true"%>
<%
	value = value.replace("&", "&amp;");
	value = value.replace("<", "&lt;");
	value = value.replace(" ", "&nbsp;");
	value = value.replace("\n", "\n<br>");
%>
<%= value %>
<!-- 최대한 입력한 내용을 그대로 출력해서 read.do에서 읽을 수 있도록 내용을 치환해주는 커스텀 태그 -->
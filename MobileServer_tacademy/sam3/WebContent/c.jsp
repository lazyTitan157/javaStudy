<%@page import="com.google.gson.Gson"%>
<%@page import="com.tacademy.sam.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- bpage에서 scope에 따라 값을 가져옴ㄴ-->
<%
	Product product = new Product();
	product.setName("notebook20");
	product.setCode("Node=20");
	product.setPrice(2000);

	String num = request.getParameter("num1");
	String format = request.getParameter("format");
	String returnURL = "c2.jsp";
	if ("json".equals(format)) {
		//json문자열로 객체를 변환 = gson이용
		Gson gson = new Gson();
		String result = gson.toJson(product);
		request.setAttribute("result", result);
		returnURL = "c3.jsp"; //html태그 없이 그냥 json자료만 보여주는 페이지
	} else if(num!=null){
		returnURL = "c0.jsp";
	} else {
		//jstl 은 core객체 사용, jsp는 아래
		request.setAttribute("product", product);
	}
	//<jsp:forward태그>말고 dispatcher사용
	RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
	dispatcher.forward(request, response);
%>
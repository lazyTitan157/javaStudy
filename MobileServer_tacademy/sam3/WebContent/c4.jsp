<%@page import="com.tacademy.sam.vo.Result"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.tacademy.sam.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Product> list = new ArrayList<>();
    list.add(new Product("notebook1", "code1", 1000));
    list.add(new Product("notebook1", "code1", 1000));
    list.add(new Product("notebook1", "code1", 1000));
    list.add(new Product("notebook1", "code1", 1000));
    list.add(new Product("notebook1", "code1", 1000));
    list.add(new Product("notebook1", "code1", 1000));
    
	String format = request.getParameter("format");
	String returnURL="c5.jsp";
	if ("json".equals(format)) {
		//json문자열로 객체를 변환 = gson이용
 		Gson gson = new Gson();
		Result productListResult = new Result();
		productListResult.setList(list);
		productListResult.setStatus("success");
		productListResult.setCount(list.size());
		//String result = gson.toJson(list);
		String result = gson.toJson(productListResult);
		request.setAttribute("result", result); 
		returnURL = "c3.jsp"; //html태그 없이 그냥 json자료만 보여주는 페이지
	} else {
		//jstl 은 core객체 사용, jsp는 아래
		request.setAttribute("list", list);
	}
	//<jsp:forward태그>말고 dispatcher사용
	RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
	dispatcher.forward(request, response);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
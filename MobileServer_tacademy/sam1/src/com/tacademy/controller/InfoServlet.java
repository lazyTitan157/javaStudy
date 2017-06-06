package com.tacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("servlet info 테스트<br>");
		String method = request.getMethod();
		out.println("method: " + method +"<br>");
		//입력받아보기
		String name = request.getParameter("name");
		out.println("name: " + name +"<br>");
		//어플리케이션에서 유일한 객체 servletcontext
		ServletContext application = getServletContext();
		String path = application.getContextPath(); //어플리케이션의 지정된 루트 경로
		out.println("path: "+path+"<br>");
		String docPath = application.getRealPath("doc"); //어플리케이션의 실제 경로 가져오는 함수
		out.println("realpath: " + docPath +"<br>");
		
		//mobile server 에서는 web app,nativeapp을 구분하는 user-agent를 분기시켜줘야 함
		//web에서는 자동으로 user-agent를 설정해서 보내주지만 android설정은 없으므로
		String brower = request.getHeader("User-Agent");
		out.println("brower : " + brower + "<br>");
		
		//postman에서 헤더 조작해서 테스트 가능
		String id = request.getHeader("id");
		//url,body에는 안보이는 header에서 전송가능 - RESTful,openAPI에는 권장하지 않음
		out.println("id: "+id+"<br>");
		
		String ip = request.getRemoteAddr();
		out.println("ip: "+ip+"<br>");
		
		//setAttribute, getAttribute method도 사용
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.tacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getWriter하기 전에 응답객체에 charset 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //ctrl shift o로 import
		out.println("Hello 모바일 get<br>");
		//println이어도 엔터자동안됨, 엔터하려면 <br>이 필요
		
		//파라미터 넘겨주는 방법은 url
		String name = request.getParameter("name");
		//out.println("name: "+ name);
		out.println(String.format("name %s", name));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//post전송시 한글깨짐을 막기위해 요청을 보내는 request객체에 인코딩 설정
		
		//getWriter하기 전에 응답객체에 charset 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); //ctrl shift o로 import
		out.println("Hello 모바일 post<br>");
		//println이어도 엔터자동안됨, 엔터하려면 <br>이 필요
		
		//파라미터를 넘겨주는 방법은 form태그 또는 크롬에서 
		String name = request.getParameter("name");
		//out.println("name: "+ name);
		out.println(String.format("name %s", name));
	}
	//HttpServlet에 추상메서드 없음,메서드 재정의는 가능(서블릿생성시 설정)
	

}

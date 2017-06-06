package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		//String url = request.getRequestURL().toString();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		//path를 매핑에서 찾음
		HandlerMapping mappings = new HandlerMapping();
		Controller controler = null;
		//mappings.get(path)를 만환받아서 controler에 저장 후, 이를 returnURL에 저장
		controler = mappings.getController(path);
		
		//String returnURL = controler.handleRequest(request, response);
		//위 코드는 널포인터 익셉션이 발생하므로
		String returnURL = "login.jsp"; //deafault지정
		if(controler != null){
			returnURL = controler.handleRequest(request, response);
		}
		switch(returnURL){
		case "login.jsp":
		case "getBoardList.do" :
			response.sendRedirect(returnURL);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
			dispatcher.forward(request, response);
			break;
		}
		//forward가 default
		//logout에서는 forward로 하면 logout.do가 되니까 sendRedirect로 url을 변경해주는 게 좋음
		
		System.out.println("uri : " + uri);
		System.out.println("path : " + path);
//		//System.out.println("url : " + url);
//		// uri : /board/action.do (ip제외)
//		// url : http://localhost/board/action.do
//		// ?이하는 쿼리스트링으로 값을 가져옴
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tacademy.board.dao.MemberDAO;
import com.tacademy.board.vo.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action){
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogout(request,response);
			break;
		default:
				break;
		}
	}
	
	void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//throws로 login_proc()의 try catch역할
		
		//login_proc()와 같은 코드, 출력은 jsp에서함 
		//(MVC1에서는 jsp에서 login_proc로 처리했던 작업을 여기 서블릿에서 처리) 
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
	
		dao.doLogin(member);
		if(member.getName()!=null){
			HttpSession session = request.getSession(true); //없으면 만들어서 return
			session.setAttribute("member",member);
			//response.sendRedirect("getBoardList.jsp"); //request scope유지 안됨
				//그래서 sessiono사용
			//바로 getBoardList가 아니라 boardservlet에서 db연결을 해주고 getBoardList로 이동
			response.sendRedirect("board?action=getBoardList"); 
		} else {
			response.sendRedirect("login.jsp");
		}
	}
	
	void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//클라이언트에서 넘어오는 문자열 인코딩으로 깨짐 방지 - 필터로 해도 됨
		request.setCharacterEncoding("utf-8"); //post에만 해당
		doGet(request, response);
	}

}

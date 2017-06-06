package com.tacademy.webdata;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tacademy.webdata.dao.MemberDAO;
import com.tacademy.webdata.vo.Member;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//post방식만 처리
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//post방식만 처리
		//doGet(request, response);
		//action Parameter로 전송된 문자열에 따라 분기 처리
		String action = request.getParameter("action");
		switch(action){
		case "login":
			doLogin(request, response);
			break;
//		case "logout":
//			doLogout(request,response);
//			break;
		case "insert":
			doInsert(request,response);
		case "check":
			doCheck(request, response);
		default:
				break;
		}
	}
	void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		
		dao.doCheck(member);
		if(member.getId()!=null){
			String id = member.getId();
			request.setAttribute("result",id);
		} else {
			request.setAttribute("result","fail");
		}
		String returnURL="result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setTel(request.getParameter("tel"));
		member.setAddress(request.getParameter("address"));
		member.setComment(request.getParameter("comment"));
		
		dao.doInsert(member);
		if(member.getName()!=null){
			String name = member.getName();
			request.setAttribute("result",name);
		} else {
			request.setAttribute("result","fail");
		}
		String returnURL="result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	
	void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//	    //  “id”, “pw” 값 받아서 anMember 테이블과 매칭함
		
		dao.doLogin(member);
//		//실패하면 “fail”  성공하면  name 컬럼 값 반환(값반환해서 띄워주는방식은 자유)
		if(member.getName()!=null){
			String name = member.getName();
			request.setAttribute("result",name);
		} else {
			request.setAttribute("result","fail");
		}
		String returnURL="result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	
//	void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		HttpSession session = request.getSession();
//		session.invalidate();
//		String returnURL="";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
//		dispatcher.forward(request, response);
//	}

}

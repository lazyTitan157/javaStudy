package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tacademy.board.dao.MemberDAO;
import com.tacademy.board.vo.Member;

public class LoginController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "login.jsp";
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		
		dao.doLogin(member);
		if(member.getName()!= null){
			HttpSession session = request.getSession(true);
			session.setAttribute("member", member);
			returnURL = "getBoardList.do";
		}
		return returnURL;
	}
}

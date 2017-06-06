package com.tacademy.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tacademy.board.dao.BoardDAO;
import com.tacademy.board.vo.Board;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			BoardDAO dao = new BoardDAO();
			
			ArrayList<Board> list = dao.getBoardList();
			
			request.setAttribute("list", list);
			return "getBoardList.jsp";
	}

}

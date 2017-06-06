package com.tacademy.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tacademy.board.dao.BoardDAO;
import com.tacademy.board.vo.Board;
import com.tacademy.board.vo.Result;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -458884087860618875L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getParameter("action");
		switch(action){
		case "addBoard":
			doAddBoard(request, response);
			break;
		case "getBoard":
			doGetBoard(request, response);
			break;
		case "updateBoard":
			doUpdateBoard(request, response);
			break;
		case "getBoardList":
			doGetBoardList(request, response);
			break;
		case "deleteBoard":
			doDeleteBoard(request, response);
			break;
		}
	}
	void doDeleteBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		dao.doDelete(board);

		response.sendRedirect("board?action=getBoardList");
	}
	void doAddBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		dao.doInsert(board); //board객체를 인자로 dao가 쿼리 실행
		
		response.sendRedirect("board?action=getBoardList");
	}
	void doGetBoardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		
		ArrayList<Board> list = dao.getBoardList();
		//일반적인 변수는 $로 접근이 안되서 객체로 받아야됨:<c:set>이용 - JSTL이용함
		//html에서 $로 접근 가능 : set으로 지정되어있는건 $로 출력할 수 있다.
		//대신 forward를 사용했으므로 jsp의 액션태그 제거 가능
		
		String returnURL = "getBoardList.jsp";
		String format = request.getParameter("format");
		if("json".equals(format)) {
			//android의 경우 , 요청url에 ?format=json이 있으면
			Gson gson = new Gson();
			String result = gson.toJson(list);
			//배열로 출력
			request.setAttribute("result", result);
			
			//객체로 출력
			Result boardResult = new Result();
			boardResult.setCount(list.size());
			boardResult.setList(list);
			boardResult.setStatus("success");
			String result2 = gson.toJson(boardResult);
			request.setAttribute("result2", result2);
			
			returnURL = "result.jsp";
		} else{ //json외의 모든 format도 여기로 
			request.setAttribute("list", list);
		}
		// board를 $표시로 jsp에서 사용 가능
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	void doGetBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//board table접근해서 가져오는 메서드 이용 - BoardDAO이용(이 페이지에서 사용할 메서드 생성 필요)
		//boardDAO에 db접근하는 메서드가 추가되어 여기서 그 메서드를 사용
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		dao.getBoard(board);
		
		String returnURL = "getBoard.jsp";
		String format = request.getParameter("format");
		if("json".equals(format)) {
			//android의 경우 , 요청url에 ?format=json이 있으면
			Gson gson = new Gson();
			String result = gson.toJson(board);
			request.setAttribute("result", result);
			returnURL = "result.jsp";
		} else{ //json외의 모든 format도 여기로 
			request.setAttribute("board", board);
		}
		// board를 $표시로 jsp에서 사용 가능
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	void doUpdateBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		dao.doUpdate(board);
		
		response.sendRedirect("board?action=getBoardList");	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}

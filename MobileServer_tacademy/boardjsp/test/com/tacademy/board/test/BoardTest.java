package com.tacademy.board.test;

import java.util.ArrayList;

import com.tacademy.board.dao.BoardDAO;
import com.tacademy.board.vo.Board;

public class BoardTest {

	//기능 구현 -성공-> 웹에 연결하면 됨
	public BoardTest() {
		BoardDAO dao = new BoardDAO();
		
		Board board = new Board();
		board.setSeq("7");
		dao.doDelete(board);
		System.out.println(board);
		
//		board.setSeq("2");
//		board.setTitle("수정된타이틀");
//		board.setContent("update contents");
//		dao.doUpdate(board);
//		System.out.println(board);
		
//		board.setSeq("3");
//		dao.getBoard(board);
//		System.out.println(board);
		
//		ArrayList<Board> list = dao.getBoardList();
//		
//		for(Board board : list) { // 전체 컬렉션을 반복할때
//			System.out.println(board);
//		}
		
		
//		board.setTitle("this is a title.");
//		board.setWriter("i am writer");
//		board.setContent("new contentsㅇㅁㅇ");
//		
//		dao.doInsert(board); //board객체를 인자로 dao가 쿼리 실행
	}

	public static void main(String[] args) {
		new BoardTest();
	}

}

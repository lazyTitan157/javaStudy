package com.tacademy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tacademy.board.vo.Board;

public class BoardDAO {
	
	private static final String insertSQL = "INSERT INTO BOARD( TITLE, WRITER, CONTENT )"
			+ " VALUES( ?, ?, ?);" ;
	private static final String listSQL = "select * from BOARD order by seq desc;";
	private static final String selectSQL = "select * from BOARD where seq = ? ;";
	private static final String updateCntSQL = "update board set cnt=cnt+1 where seq = ? ;";
	private static final String updateSQL = "update board set title=? , content=? where seq = ? ;";
	private static final String deleteSQL = "delete from BOARD where seq = ? ;";
	//jdbc와 sql문도 분리 - 나중에 텍스트 파일로 sql봄
	
	public void doDelete(Board board){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(deleteSQL);
			stmt.setInt(1, Integer.parseInt(board.getSeq())); 
			int cnt = stmt.executeUpdate(); //영향받은 레코드 개수 리턴
			System.out.println("delete " + (cnt==1 ? "success" : "fail") );
			//삭제할 데이터가 없는경우 : post로 seq값을 변경해서 넘긴 경우 에러유발
		} catch(SQLException e){
			System.out.println("delete e : " + e);
		} finally {
			//try/catch실행 후
			JDBCUtil.close(stmt, conn);
		}
	}

	public void doUpdate(Board board){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(updateSQL);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setInt(3, Integer.parseInt(board.getSeq())); //
			int cnt = stmt.executeUpdate(); //영향받은 레코드 개수 리턴
			System.out.println("update " + (cnt==1 ? "success" : "fail"));
		} catch(SQLException e){
			System.out.println("update e : " + e);
		} finally {
			//try/catch실행 후
			JDBCUtil.close(stmt, conn);
		}
	}
	
	public ArrayList<Board>	getBoardList(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		ArrayList<Board> list = new ArrayList<Board>();
		try{
			conn = JDBCUtil.getConnection();
			//하나의 접속요청에 하나의 getConnection으로 접속요청을 할 것, 종료시 커넥션 종료 (그래야 요청 섞이지 않음)
			
			stmt = conn.prepareStatement(listSQL);
			rst = stmt.executeQuery();
			Board board = null;
			//반환하는 것 여러개일수 있으므로 반복수행
			while(rst.next()) { //rst의 마지막 까지실행
				board = new Board();
				board.setSeq(rst.getInt(1)+""); //int에서 문자열로 형변환
				board.setTitle(rst.getString(2));
				board.setWriter(rst.getString(3));
				board.setContent(rst.getString(4));
				board.setRegdate(rst.getString(5));
				board.setCnt(rst.getInt(6)+"");
				
				list.add(board);
			}
		} catch(SQLException e){
			System.out.println("list e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return list; //객체 반환
	}
	
	//객체안의 변수가 아니라 객체를 입력받고 리턴하자(캡슐화)
	public void doInsert(Board board){
	
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getWriter());
			stmt.setString(3, board.getContent());
			int cnt = stmt.executeUpdate(); //영향받은 레코드 개수 리턴
			System.out.println("insert " + (cnt==1 ? "success" : "fail"));
		} catch(SQLException e){
			System.out.println("insert e : " + e);
		} finally {
			//try/catch실행 후
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//string seq 할수도 있지만 객체로 받아서 추후 기능확장 가능하도록 구현
	public void	getBoard(Board board){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		try{
			conn = JDBCUtil.getConnection();
			//하나의 접속요청에 하나의 getConnection으로 접속요청을 할 것, 종료시 커넥션 종료 (그래야 요청 섞이지 않음)
			stmt = conn.prepareStatement(updateCntSQL);
			stmt.setInt(1, Integer.parseInt(board.getSeq()));
			stmt.executeUpdate();
			
			stmt = conn.prepareStatement(selectSQL);
			//selectSQL 의 ?자리 채우기
			stmt.setInt(1, Integer.parseInt(board.getSeq()));
			rst = stmt.executeQuery();
			//반환하는 것 여러개일수 있으므로 반복수행
			if(rst.next()) { //rst이 있는지 확인
				board.setSeq(rst.getInt(1)+""); //int에서 문자열로 형변환
				board.setTitle(rst.getString(2));
				board.setWriter(rst.getString(3));
				board.setContent(rst.getString(4));
				board.setRegdate(rst.getString(5));
				board.setCnt(rst.getInt(6)+"");
			}
		} catch(SQLException e){
			System.out.println("getBoard e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}

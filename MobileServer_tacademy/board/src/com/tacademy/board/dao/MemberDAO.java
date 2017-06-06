package com.tacademy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tacademy.board.vo.Member;

public class MemberDAO {

	private static final String loginSQL = "select name from member where id=? and password=?";
	//xml에서 컨트롤 = DB관리자가 따로 제어할 수 있게분리
	
	public void doLogin(Member member) {
		//.java에 종속되는 변수
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		//connection, 명령문, 결과받을 변수 설정
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loginSQL);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPassword());
			rst = stmt.executeQuery();
			//한명받으니까 if로
			if(rst.next()){
				member.setName(rst.getString(1));
				//member.setName("name");
			}
		} catch(SQLException e){
			System.out.println("login e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

}

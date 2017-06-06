package com.tacademy.webdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tacademy.webdata.vo.Member;

public class MemberDAO {

	private static final String loginSQL = "select name from anmember where id=? and pw=?";
	private static final String insertSQL = "insert into ANMEMBER "
			+ "values(null, ?, ?, ?, ?, ?, ?, now() );";
	private static final String checkSQL = "select id from anmember where id=? ";
	//xml에서 컨트롤 = DB관리자가 따로 제어할 수 있게분리
	public void doCheck(Member member) {
		Connection conn = null;
		PreparedStatement stmt = null;
		//connection, 명령문, 결과받을 변수 설정
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(checkSQL);
			stmt.setString(1, member.getId());
			//한명받으니까 if로
			int cnt = stmt.executeUpdate(); //영향받은 레코드 개수 리턴
			rst = stmt.executeQuery();
			//한명받으니까 if로
			if(rst.next()){
				member.setId(rst.getString(1));
				//member.setName("id");
			}
		} catch(SQLException e){
			System.out.println("insert e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	public void doInsert(Member member) {
		//.java에 종속되는 변수
		Connection conn = null;
		PreparedStatement stmt = null;
		//connection, 명령문, 결과받을 변수 설정

		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(insertSQL);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getId());
			stmt.setString(3, member.getPw());
			stmt.setString(4, member.getTel());
			stmt.setString(5, member.getAddress());
			stmt.setString(6, member.getComment());
			//한명받으니까 if로
			int cnt = stmt.executeUpdate(); //영향받은 레코드 개수 리턴
			if(cnt==1){
				member.setName("name");
			}
		} catch(SQLException e){
			System.out.println("insert e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

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
			stmt.setString(2, member.getPw());
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

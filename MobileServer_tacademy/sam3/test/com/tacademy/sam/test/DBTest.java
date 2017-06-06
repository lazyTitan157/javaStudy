package com.tacademy.sam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public DBTest() {
		// TODO Auto-generated constructor stub
		// 1. 대표 클래스 로딩하기
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loading success");
		}catch(ClassNotFoundException e){
			System.out.println("load e: "+e);
			return;
		}
		
		//2. 접속하기
		Connection conn = null;
		String jdbcURL = "jdbc:mysql://192.168.204.194:3308/db_tacademy";
		String jdbcId = "root";
		String jdbcPw = "01234";
		
//		String sql = "insert into tbl_account(account, password, address, phoneNo) "
//				+ " values('kang', '5555', '광명시 어디쯤', '010-2222-0000');" ;
		
		//템플릿 프로시저 - prepared statement
		//String sql = "insert into tbl_account(account, password, address, phoneNo) "
		//		+ " values(?, ?, ?, ?);" ;
		
		String sql = "select * from tbl_account where 1=1;" ;
		
		//sql 문을 실행하기 위해 statment interface생성 - preparedstatement, co
		//Statement stmt = null;
		PreparedStatement stmt = null;
		ResultSet rst = null; //select 실행시 결과를 관리하는 클래스
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcId, jdbcPw);
			System.out.println("login success");
			//3. SQL 구문 실행
			stmt = conn.prepareStatement(sql);
			rst = stmt.executeQuery();
			//rst의 첫줄은 column 명, next()는 다음행으로 진행(결과셋의 첫행), afterlast(종료후 없는 값)
			while(rst.next()) {
				System.out.println( rst.getInt(1) + rst.getString("account") + rst.getString(5) );
			}
			
//			stmt = conn.createStatement();
//			int cnt = stmt.executeUpdate(sql);
			
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "PHO"); // jdbc index start from 1
//			stmt.setString(2, "PHO");
//			stmt.setString(3, "PHO");
//			stmt.setString(4, "010-2056-5236");
//			int cnt = stmt.executeUpdate();
			
			//System.out.println(cnt==1? "insert success" : "insert fail");
			
		} catch(SQLException e){
			System.out.println("db e: " + e);
			
		} finally { //try-catch 후 종료 프로세스
			//rst 객체 먼저해제
			if(rst !=null) {
				try {
					rst.close();
				} catch(SQLException e){
					
				}
			}
			// statement 객체 먼저 해제
			if(stmt !=null) {
				try {
					stmt.close();
				} catch(SQLException e){
					
				}
			}
			// conn 객체 해제
			if(conn !=null) {
				try {
					conn.close();
				} catch(SQLException e){
					
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBTest();
	}

}

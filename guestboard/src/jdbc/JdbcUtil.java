/*
 * 간단한 close(), rollback()처리코드를 위한 jdbcUtil 클래스
 * 설명 : connection, statement, resultset같은 클래스는 사용이 끝나면 close()로 자원반환 필수
 * 	익셉션발생여부에 상관없이 close하도록 finally블록에서 close()호출을 반복해서 코드 작성 필요
 * 	so, 반복되는 코드를 줄이기 위해 아래의 보조클래스 작성하여 jdbcUtil클래스를 이용할 것.
 * 이용 : JdbcUtil.close(rs); //ResultSet rs = null; 로 생성하고 클로즈시 try catch안써도됨.
 * 	JdbcUtil.close(pstmt); JdbcUtil.close(conn); 
 */
package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	public static void close(ResultSet rs){
		if(rs != null) {
			try{
				rs.close();
			} catch(SQLException ex){
			}
		}
	}
	
	public static void close(Statement stmt){
		if(stmt!=null){
			try{
				stmt.close();
			} catch (SQLException ex) {
			}
		}
	}
	
	public static void close(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			} catch(SQLException ex){
			}
		}
	}
	
	public static void rollback(Connection conn){
		if(conn!=null){
			try{
				conn.rollback();
			} catch(SQLException ex){
			}
		}
	}
}

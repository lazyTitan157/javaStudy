/*
* MessageDao클래스 
* 설명 : guestbook_message테이블에 대한 CRUD메서드를 제공한다.
*  CRUD를 수행하고 finally로 JdbcUtil.close로 resultset과 pstmt를 반환해준다.
* 참고 : 이 DAO를 이용하는 서비스는
*  GetMessageListService(방명록에 등록된 메시지 목록 제공)
*  WriteMessageService(신규 메시지 등록 기능)
*  DeleteMessageService(메시지 삭제 기능)
*/
package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guestbook.model.Message;
import jdbc.JdbcUtil;

public class MessageDao {
	private static MessageDao messageDao = new MessageDao();
	public static MessageDao getInstance(){
		return messageDao;
	}
	
	private MessageDao() {} //MessageDao 생성자
	
	public int insert(Connection conn, Message message) throws SQLException{
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(
					"insert into guestbook_message "+
			"(guest_name, password, message) values (?,?,?)");
			pstmt.setString(1,  message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(
					"select * from guestbook_message where message_id=?");
			pstmt.setInt(1, messageId);
			rs  = pstmt.executeQuery();
			if(rs.next()){
				return makeMessageFromResultSet(rs);
				//아래에서 message를 반환하는 private 함수로 정의
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from guestbook_message");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	//guestbook_message 테이블의 데이터를 id기준으로 내림차순정렬해서 조회
	public List<Message> selectList(Connection conn, int firstRow, int endRow)
		throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement(
					"select * from guestbook_message "+
					"order by message_id desc limit ?,?");
			pstmt.setInt(1, firstRow-1);
			pstmt.setInt(2, endRow-firstRow+1);
			rs = pstmt.executeQuery();
			if(rs.next()){
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while(rs.next());
					return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int delete(Connection conn, int messageId) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(
					"delete from guestbook_message where message_id =?");
			pstmt.setInt(1, messageId);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
}

package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteMessageService {

	private static WriteMessageService instance = new WriteMessageService();
	
	public static WriteMessageService getInstance(){
		return instance;
	}
	
	private WriteMessageService(){}
	
	public void write(Message message) throws ServiceException{
		//메시지파라미터에 담긴값이 올바르지 않은 경우 
		if(message.getGuestName()==null || message.getGuestName().isEmpty()){
			throw new IllegalArgumentException("invalid guest name");
		}
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			messageDao.insert(conn, message); //메시지를 테이블에 추가
		} catch(SQLException e){ 
			throw new ServiceException("메시지등록실패: "+e.getMessage(),e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}

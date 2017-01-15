package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

/*
 * 회원가입 기능을 제공하는 JoinService클래스
 * 동작 : 
 *  1. DB커넥션을 구하고, 트랜잭션을 시작한다. //setAutoCommit(false);
 *  2. memberDao의 selectById()를 이용해서 , joinReq, getId()에 해당하는 회원데이터를 구한다.
 *  3. 가입하려는 ID에 해당하는 데이터가 이미 존재하면, //if(member!=null) {
 *   트랜잭션을 롤백하고, //JdbcUtil.rollback(conn);
 *   DuplicateException을 발생시킨다. //throw new DuplicateIdException);
 *  4. joinReq를 이용해서 Member객체를 생성하고,  
 *   그 값으로 MemberDao의 insert()를 실행해서 회원데이터를 삽입한다.
 *  5. 트랜잭션을 커밋한다. //처리도중 SQLException이 발생하면 롤백하고 new RuntimeException();을 발생시킨다.
 */
public class JoinService {

	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			memberDao.insert(conn, 
					new Member(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPassword(), 
							new Date())
					);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}

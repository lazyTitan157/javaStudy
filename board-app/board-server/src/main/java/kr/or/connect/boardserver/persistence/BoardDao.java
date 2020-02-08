package kr.or.connect.boardserver.persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//커넥션 풀링을 제공하는 Commons DBCP 라이브러리: commons-dbcp2에서 제공하는 BasicDataSource 클래스
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.domain.Board;

/**
 * DataSource 구현체로 교체하는 일이 생기더라도 BookDao는 수정할 부분이 없도록 만든다.
 * @Repository : Spring에서 'component scan' 대상인 클래스를 표시하기 위해 제공하는 애너테이션
 * 이 클래스의 동작은 BookLauncher에서 검증
 */
@Repository
public class BoardDao {

	private NamedParameterJdbcTemplate jdbc;
	private static final String COUNT_POST = "SELECT COUNT(*) FROM board";
	//테이블을 id로 조회하는 쿼리
	private static final String SELECT_BY_ID =
			"SELECT id, title, author, contents, writeDate FROM board where id = :id";
	

	private SimpleJdbcInsert insertAction; //to insert
	public BoardDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("board")
				.usingGeneratedKeyColumns("id");
	}
	
	public int countPosts() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_POST, params, Integer.class);
	}
	
	//멀티스레드에서 접근해도 안전하기 때문에 아래와 같이 멤버 변수로 선언하고 바로 초기화를 해도 무방
	private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
	/**
	 * board 테이블을 id로 조회하는 쿼리 호출(BeanPropertyRowMapper로 RowMapper를 정의)
	 * @param id
	 * @return
	 */
	public Board selectById(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	
	/**
	 * 데이터 입력
	 * @param board
	 * @return
	 */
	public Integer insert(Board board) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(board);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM board WHERE id= :id";
	/**
	 * Board data 1건 삭제
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	private static final String UPDATE =
			"UPDATE board SET\n"
			+ "title = :title,"
			+ "author = :author,"
			+ "contents = :contents\n"
			+ "WHERE id = :id";
	/**
	 * 테이블 업데이트
	 * @param board
	 * @return
	 */
	public Board update(Board board) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(board);
		jdbc.update(UPDATE, params);
		return this.selectById(board.getId());
	}
	
	private static final String SELECT_ALL =
			"SELECT id, title, author, contents, writedate FROM board";
	/**
	 * 
	 * @return
	 */
	public List<Board> selectAll() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}
}

package kr.or.connect.bookserver.persistence;

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

import kr.or.connect.domain.Book;

/**
 * DataSource 구현체로 교체하는 일이 생기더라도 BookDao는 수정할 부분이 없도록 만든다.
 * @Repository : Spring에서 'component scan' 대상인 클래스를 표시하기 위해 제공하는 애너테이션
 * 이 클래스의 동작은 BookLauncher에서 검증
 */
@Repository
public class BookDao {

	private NamedParameterJdbcTemplate jdbc;
	private static final String COUNT_BOOK = "SELECT COUNT(*) FROM book";
	//book 테이블을 id로 조회하는 쿼리
	private static final String SELECT_BY_ID =
			"SELECT id, title, author, pages FROM book where id = :id";
	
	/**
	 * ApplicationContext에 등록: BookLauncher였는데 BookDao로 변경해서, BookLauncher도 Context에서 BookDao를 가져오도록 변경 
	 *  BookDao를 Context에 등록(@Repository)하고, AppConfig에서 읽어서 BookLauncher에서 사용
	 * 
	 * Spring에서 제공하는 Dependency Injection 기능(@Configuration, @Bean): ApplicationContext에서 관리 
	 * 활용시의 장점: 
	 * 직접 의존성 관리 대상 객체를 생성하는 메서드를 추가할 필요 없이 패키지 범위를 지정하여 일괄 등록할 수 있다. ( component scan 기능)
	     객체 간의 의존관계가 여러 단계로 얽혀있을 때 이를 더 효율적으로 관리할 수 있다.
		예를 들면 BookController 객체는 BookService 객체를 주입받고, BookService 객체는 BookDao 객체를 주입받는 경우이다.
	   Spring이 관리하는 객체에 공통적인 기능을 일괄적으로 집어 넣을 수 있다. 예를 들면 로깅, 트랜잭션 시작과 종료, 예외 변환, 메서드 접근 통제 등이다. 이런 기법을 AOP(Aspect Oriented Proramming)이라고 한다.
	     객체가 참조할 속성이지만 환경마다 달라지는 값을 별도의 속성파일로 추출하여 설정할 수 있다. 예를 들면 데이터베이스의 접속 주소 같은 것들이다.
	     어플리케이션 시작 혹은 종료 시에 실행되어야 할 메서드를 호출한다. 예를 들면 @Bean선언 등으로 관리되는 객체가 java.lang,AutoCloseable을 구현한 클래스라면 ConfigurableApplicationContext.close()이 호출되는 시점에 일괄적으로 해당 bean 클래스의 close() 메서드가 호출된다.
	 *  
	 * Spring에서 제공하는 Dependency Injection 기능을 활용하지 않고도 Dependency injection 기법을 적용
	 * : BookDao 가 클래스 내부에서 직접 DataSource 구현 클래스를 생성하지 않고, BookLauncher에서 DAO클래스 각각에 다른 정보 주입 가능.
	     BookDao와 BasicDataSource의 실제적인 의존성은 DataSource를 생성하고 주입한 BookLauncher에 의해 결정.
	   > BookDao의 코드만 본다면 컴파일 시점이 아닌 실행 시점에 의존성이 주입.
	   -> DBCP외의 Connection pool 라이브러리를 사용해도 BookDao에 변경 필요 없음.
	 */

	private SimpleJdbcInsert insertAction; //to insert
	//public BookDao(DriverManagerDataSource dataSource) {
	public BookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("book")
				.usingGeneratedKeyColumns("id");
	}
	
	public int countBooks() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(COUNT_BOOK, params, Integer.class);
	}
	
	/**
	 * book 테이블을 id로 조회하는 쿼리 호출(람다표현식으로 정의한 RowMapper)
	 * @param id
	 * @return
	 */
	/*
	public Book selectById(Integer id) {
		//rowMapper를 정의: 람다표현식 ( (rs, i) -> {})
		RowMapper<Book> rowMapper = (rs, i) -> {
			Book book = new Book();
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPages((Integer) rs.getObject("pages"));
			return book;
		};

		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	*/
	
	//멀티스레드에서 접근해도 안전하기 때문에 아래와 같이 멤버 변수로 선언하고 바로 초기화를 해도 무방
	private RowMapper<Book> rowMapper = BeanPropertyRowMapper.newInstance(Book.class);
	/**
	 * book 테이블을 id로 조회하는 쿼리 호출(BeanPropertyRowMapper로 RowMapper를 정의)
	 * @param id
	 * @return
	 */
	public Book selectById(Integer id) {
		//RowMapper<Book> rowMapper = BeanPropertyRowMapper.newInstance(Book.class); 
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(SELECT_BY_ID, params, rowMapper);
	}
	
	/**
	 * Book 데이터 입력
	 * @param book
	 * @return
	 */
	public Integer insert(Book book) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(book);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	private static final String DELETE_BY_ID = "DELETE FROM book WHERE id= :id";
	/**
	 * Book data 1건 삭제
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	private static final String UPDATE =
			"UPDATE book SET\n"
			+ "title = :title,"
			+ "author = :author,"
			+ "pages = :pages\n"
			+ "WHERE id = :id";
	/**
	 * Book 테이블 업데이트
	 * @param book
	 * @return
	 */
	public int update(Book book) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(book);
		return jdbc.update(UPDATE, params);
	}
	
	private static final String SELECT_ALL =
			"SELECT id, title, author, pages FROM book";
	/**
	 * 
	 * @return
	 */
	public List<Book> selectAll() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}
}

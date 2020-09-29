/**
 * 
 */
package kr.or.connect.bookserver;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.bookserver.persistence.BookDao;
import kr.or.connect.domain.Book;

/**
 * @author 2983r
 * BookLauncher클래스 역할: DataSource를 생성
   BookDao에 DataSource를 주입하고 생성
   BookDao.countBooks()를 호출하여 테스트
   
   DriverManagerDataSource -> BasicDataSource
 */
public class BookLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//BookDao 클래스 내부에서 직접 DataSource 구현 클래스를 생성하지 않고, BookLauncher에서 DAO클래스 각각에 다른 정보 주입 가능.
		//BookLauncher 클래스도 내부에서 직접 DataSource 구현 클래스를 생성하지 않고,
		//	BasicDataSource dataSource = new BasicDataSource();
		//  AppConfig에서 DataSource 설정하여 ApplicationContext를 거쳐서 BookLauncher에서 참조
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookDao dao = context.getBean(BookDao.class);
		//BookDao에서 DataSource 인터페이스를 의존하도록 Constructor 수정
		//Context에서 BookDao를 가져오도록 변경
		//= DataSource dataSource = context.getBean(DataSource.class);
		//  BookDao dao = new BookDao(dataSource);
		//= DataSource dataSource = new AppConfig().dataSource();
		int count = dao.countBooks();

		System.out.println(count);
		
		//BookDao.selectById(Integer)를 호출
		Book book = dao.selectById(1);
		System.out.println(book);
		
		Book book2 = new Book("네이버 Java", "김강산", 512);
		Integer newId = dao.insert(book2);
		System.out.println(newId);
		System.out.println(dao.selectById(newId));
		
		context.close();
	}

}

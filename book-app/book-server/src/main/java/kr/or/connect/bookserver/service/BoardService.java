/**
 * 
 */
package kr.or.connect.bookserver.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import kr.or.connect.bookserver.persistence.BoardDao;
import kr.or.connect.bookserver.persistence.BookDao;
import kr.or.connect.domain.Board;
import kr.or.connect.domain.Book;

/**
 * @author 2983r
 * 데이터를 읽어오는 책임을 BookService라는 클래스에 부여: @Service (Spring에서 component scan의 대상으로 인지되는 애너테이션)
 */
@Service
public class BoardService {

	/*
	//편의상 고정된 값 반환하도록 설정
	public Book findById(Integer id) {
		return new Book(1, "Java 이렇게 공부하자", "김자바", 300);
	}

	public Collection<Book> findAll() {
		return Arrays.asList(
			new Book(1, "네이버 네비 좋아요", "김광근", 300),
			new Book(2, "HTTP 완벽 이해하기", "김명호", 300)
		);
	}
	*/
	
	// Java Dao
	//private ConcurrentMap<Integer, Book> repo = new ConcurrentHashMap<>();
	//private AtomicInteger maxId = new AtomicInteger(0);
	
	private BoardDao dao;

	public BoardService(BoardDao dao) {
		this.dao = dao;
	}
	
	public Board findById(Integer id) {
		//return repo.get(id);		

		return dao.selectById(id);
	}

	public Collection<Board> findAll() {
		//return repo.values();
				
		return dao.selectAll();
	}

	/**
	 * Book데이터 입력 메서드
	 * @param book
	 * @return
	 */
	public Board create(Board board) {
//		Integer id = maxId.addAndGet(1);
//		book.setId(id);
//		repo.put(id, book);
//		return book;
		
		Integer id = dao.insert(board);
		board.setId(id);
		return board;
	}
	
	/**
	 * Book데이터 수정 메서드
	 * @param book
	 * @return
	 */
	public Board update(Board board) {
//		Book old = repo.put(book.getId(), book);
//		return old != null;
		
		//int affected = dao.update(board);
		//return affected == 1;
		return dao.update(board);
		
	}
	
	/**
	 * Book데이터 삭제 메서드
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id) {
//		Book old = repo.remove(id);
//		return old != null;
		
		int affected = dao.deleteById(id);
		return affected == 1;
	}
}

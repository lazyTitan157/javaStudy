/**
 * 
 */
package kr.or.connect.boardserver.service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import kr.or.connect.boardserver.persistence.BoardDao;
import kr.or.connect.domain.Board;

/**
 * @author 2983r
 * 데이터를 읽어오는 책임을 Service 클래스에 부여: 
 * @Service (Spring에서 component scan의 대상으로 인지되는 애너테이션)
 */
@Service
public class BoardService {

	
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
	 * 데이터 입력 메서드
	 * @param board
	 * @return
	 */
	public Board create(Board board) {
		
		Integer id = dao.insert(board);
		board.setId(id);
		return board;
	}
	
	/**
	 * 데이터 수정 메서드
	 * @param board
	 * @return
	 */
	public Board update(Board board) {
		return dao.update(board);
		
	}
	
	/**
	 * 데이터 삭제 메서드
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id) {
		
		int affected = dao.deleteById(id);
		return affected == 1;
	}
}

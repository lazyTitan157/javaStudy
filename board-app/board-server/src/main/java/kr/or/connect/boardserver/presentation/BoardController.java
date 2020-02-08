/**
 * 
 */
package kr.or.connect.boardserver.presentation;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.boardserver.service.BoardService;
import kr.or.connect.domain.Board;

/**
 * @author 2983r
 * @RestController: Controller에서 Service를 참조할 때도 보통 Spring의 Dependency injection을 이용해서 객체 간의 관계를 구성
 *  Spring framework 4.3 버전 이후부터는 생성자가 1개인 클래스에서는 @Autowired를 생략 가능
 * @RequestMapping: 조회 API의 경로는 /api/books, /api/books/{id} 중 공통부분을 Class레벨에서 정의(앞부분주소 바뀌면 수정 용이)
 */
@RestController
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService service;
	//Logging
	private final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	//요청을 처리할 메서드 추가
	/**
	 * get all list
	 * URI: /api/board
	 * @return
	 */
	@GetMapping
	Collection<Board> readList() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	Board read(@PathVariable  Integer id) {
		return service.findById(id);
	}
	
	/**
	 * HTTP 메서드 중 POST, 응답코드는 CREATED
	 * @param book
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Board create(@RequestBody Board board) { 
		//입력 요청의 파라미터는 요청 본문으로 받고 
		return service.create(board); 
		//다시 JSON으로 입력된 Book객체를 반환
	}
	
	/**
	 * HTTP 메서드 중 PUT, 응답코드는 없음? NO_CONTENT
	 * @param id
	 * @param book
	 */
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	Board update(@PathVariable Integer id, @RequestBody Board board) {
		board.setId(id);
		return service.update(board);
	}

	/**
	 * HTTP 메서드 중 DELETE, 응답코드는 없음? NO_CONTENT
	 * @param id
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}

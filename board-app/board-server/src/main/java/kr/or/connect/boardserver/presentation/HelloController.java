/**
 * 
 */
package kr.or.connect.boardserver.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2983r
 * Spring의 ApplicationContext에 등록
 */
@RestController
public class HelloController {
	@GetMapping("/hello")
	String hello(){
		return  "Hello World";
		//hello메서드의 반환형은 String이고, 이 값이 바로 웹브라우저로 출력된다. 
		//@RestController가 붙은 클래스의 메서드의 반환값은 API의 결과로 간주된다. 
		//그래서 JSP와 같은 별도의 뷰로 이동하지 않고 바로 응답 본문으로 반영
	}
}

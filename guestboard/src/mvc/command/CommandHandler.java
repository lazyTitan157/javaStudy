package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 특정이름의 파라미터에 명령어 정보를 전달하는 CommandHandler 인터페이스 정의
 * 모든 명령어 핸들러 클래스가 공통으로 구현해야하는 process메서드를 정의
 * process() : 알맞은 로직(명령어와 관련된 비즈니스로직)을 구현하고
 * 	뷰페이지에서 사용할 정보를 저장하고, //request.setAttribute("",);
 * 	결과를 보여줄 jsp의 uri를 리턴한다. 
 */
public interface CommandHandler {
	public String process(HttpServletRequest request, HttpServletResponse res)
			throws Exception;
}

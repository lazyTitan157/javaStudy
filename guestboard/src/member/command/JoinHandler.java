package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;
/*
 * commandHandler(인터페이스)를 구현한 클래스 = JoinHandler클래스
 * JoinHandler클래스 동작 :
 *  Get방식 요청이 오면 폼을 보여주는 뷰(joinForm.jsp)를 리턴
 *  Post방식 요청이 오면, 회원가입을 처리하고 결과를 보여주는 뷰 리턴
 *  - 입력이 잘못된 경우, 다시 joinForm.jsp뷰 리턴
 *  - 회원가입에 성공한 경우, joinSuccess.jsp뷰 리턴
 *  
 *  이 클래스를 위한 매핑설정을 commandHandlerURI.properties파일에 작성한다.
 */
public class JoinHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	//폼을 보여주는 뷰 경로(FORM_VIEW)를 리턴
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	//폼 전송을 처리
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		//joinRequest객체 생성 - 폼에 입력한데이터로
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		//에러정보를 담을 맵객체
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		//joinRequest값이 올바른지 확인
		joinReq.validate(errors);
		
		//에러인 경우, 다시 폼을 보여준다.
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			//올바르게 성공한 경우 join()메서드 실행하고, 성공페이지 보여줌
			joinService.join(joinReq);
			return "/WEB-INF/view/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			//동일아이디 존재하면 다시 폼을 보여준다.
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}

package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

/*
 * 설정파일에 URI(controllerusingfile)/command와 클래스의 관계를 명시하는 클래스
 * 요청 URI를 명령어로 사용하기 
 * web.xml에 servlet-mapping정보 추가
 */
public class ControllerUsingURI extends HttpServlet {

	//<커맨드, 핸들러 인스턴스> 매핑정보 저장
	private Map<String, CommandHandler> commandHandlerMap =
			new HashMap<>();
	
	//프로퍼티에 저장된 각 프로퍼티의 키에 대해 아래의 작업 반복
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop  = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);
		} catch (IOException e){
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()){
			//프로퍼티 이름을 커맨드 이름으로 사용
			String command = (String)keyIter.next();
			//커맨드 이름에 해당하는 핸들러클래스 이름을 properties파일에서 구한다. 
			String handlerClassName = prop.getProperty(command);
			try{
				//핸들러클래스 이름을 이용해 class객체를 구한다.
				Class<?> handlerClass = Class.forName(handlerClassName);
				//class로부터 핸들러객체 생성, 위에서 구한 이름에 해당하는 클래스의 객체 생성
				CommandHandler handlerInstance =
						(CommandHandler) handlerClass.newInstance();
				//commandHandlerMap에 (커맨드,핸들러객체)매핑정보를 저장한다.
				commandHandlerMap.put(command, handlerInstance);
			} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
				throw new ServletException(e);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 요청한 명령어를 구한다.
		// 커맨드 패턴기반의 코드를 구현하는 방법 두가지 : 파라미터에 명령어정보전달/ 요청URI를 명령어로 사용
		// cmd파라미터를 명령어로 사용하면 
		// String command = request.getParameter("cmd"); 
		//여기서는 URI방법이용하므로 URI를 가져와서 파싱
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0){
			command = command.substring(request.getContextPath().length());
		}
		//commandHandlerMap에서 요청을 처리할 핸들러 객체를 구한다. cmd파라미터값을 키로 사용한다.
		CommandHandler handler = commandHandlerMap.get(command);
		//명령어에 해당하는 핸들러가 존재하지 않는 경우, NullHandler사용
		if(handler == null){
			handler = new NullHandler();
		}
		String viewPage = null;
		try{
			//구한 핸들러 객체의 process()메서드를 호출해서 요청처리하고 뷰에 보여줄 결과값을 request나 session의 속성에 저장
			viewPage = handler.process(request, response);
		} catch(Throwable e){
			throw new ServletException(e);
		}
		if(viewPage!=null){
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
	
}

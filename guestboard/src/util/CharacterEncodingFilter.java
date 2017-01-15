package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 * 필터구현의 핵심 인터페이스와 클래스 : 아래의 세타입을 이용해서 필터구현, 요청/응답정보 변경 기능구현 가능
 * - javax.servlet.Filter (인터페이스) : 필터를 나타내는 객체가 구현해야하는 인터페이스
 * 		- filter인터페이스가 선언하는 메서드 : 
 * 		public void init(FilterConfig filterConfig) throws ServletException : 필터초기화시 호출
 * 		public void doFilter(~~) throws java.io.IOException, ServletException : 필터의 기능 수행, chain을 이용해서 체인의 다음 필터로 처리 전달 가능
 * 		public void destroy() : 필터가 웹 컨테이너에서 삭제될 때 호출된다.
 * - javax.servlet.ServletRequestWrapper (클래스) : 요청변경결과저장하는 래퍼
 * - javax.servlet.ServletResponseWrapper (클래스) : 응답변경하는 래퍼
 */
//web.xml에 등록하거나 어노테이션으로 필터 등록
//둘다에 등록하면 서버 실행시 에러날 수 있음.
//(어노테이션)WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {

	private String encoding;
	/**
	 * 주로 필터가 사용한 자원을 판납
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// 1. request파라미터를 이용하여 요청의 필터 작업 수행 : 요청 캐릭터 인코딩 설정
		request.setCharacterEncoding(encoding);
		// 2. pass the request along the filter chain 체인의 다음필터 처리
		chain.doFilter(request, response);
		// 3. response를 이용하여 응답의 필터링 작업 수행
	}

	/**
	 * 필터초기화 작업
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// dofilter에서 사용할 인코딩 설정 : encoding 초기화 파라미터를 이용해서 설정
		encoding = config.getInitParameter("encoding");
		if(encoding == null){
			encoding = "UTF-8";
		}
	}

}

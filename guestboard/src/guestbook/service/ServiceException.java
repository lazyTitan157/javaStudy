/*
 * 방명록에 사용되는 서비스 클래스들이 DAO를 실행하는 도중에 SQLException이 발생하는 경우 
 * 본 클래스를 통해 ServiceException을 발생시키도록 구현 : try catch(SQLEXception ex) { throw new ServiceExption(""); }
 */

package guestbook.service;

public class ServiceException extends RuntimeException {

	public ServiceException(String message, Exception cause){
		super(message, cause);
	}
	
	public ServiceException(String message){
		super(message);
	}
}

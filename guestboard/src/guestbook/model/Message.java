/*
 *  guestbook_message 테이블 칼럼과 매핑되는 프로퍼티들을 가지는 클래스
 *  hasPassword() : 방명록메시지에 암호가 지정되어있는지 확인
 *  matchPassword() : 파라미터로 받은 pwd가 암호를 저장한 password필드와 같은지 확인
 *  hasPassword(), matchPassword()는 DeleteMessageService클래스에서 삭제기능 구현에 사용
 */

package guestbook.model;

public class Message {
	private int id;
	private String guestName;
	private String password;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean hasPassword(){
		return password != null && !password.isEmpty();
	}
	public boolean matchPassword(String pwd){
		return password != null && password.equals(pwd);
	}
	
}

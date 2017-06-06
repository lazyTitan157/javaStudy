package school;
//same with login.java's member
import exception.UserException;

public class Login2 {
	private String loginId;
	private String loginPw;
	public Login2(String loginId, String loginPw) throws UserException {
		setLoginId(loginId);
		setLoginPw(loginPw);
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) throws UserException {
		if(!(loginId.length()<=8)) {
//			this.loginId = loginId;		
//			return;
			throw new UserException("input 4characters"); //class
			//throw include return
		} //else syso "more than 8 characters" , but don't use else
		this.loginId = loginId;
		
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		if(loginPw.length()!=4) {
		}
		this.loginPw = loginPw;
	}
	@Override
	public String toString() {
		return "loginId=" + loginId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((loginPw == null) ? 0 : loginPw.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login2 other = (Login2) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (loginPw == null) {
			if (other.loginPw != null)
				return false;
		} else if (!loginPw.equals(other.loginPw))
			return false;
		return true;
	}

	
}

package school;
// userinfo - id, pw, name .....

//= LoginVO
public class Member {

	private String userId;
	private String password;
	private String name;
	// data first, and then generate'

	//overloading makes work together, as people need
	public Member(String userId, String password) {
		//super();
		setUserId(userId);
		setPassword(password);
	}
	public Member(String userId, String password, String name) {
		//super();
		setUserId(userId);
		setPassword(password);
		setName(name);
	}
	
	public String getUserId() {
		return userId;
	}
	/*document comment!
	 * @param userId
	 * @
	 */
	public void setUserId(String userId) {
		if(userId == null || userId.trim().length()<8)
			throw new LoginIDMinLengthException();
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password == null || password.trim().length() != 4)
			throw new PasswordDefaultLengthException();
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}

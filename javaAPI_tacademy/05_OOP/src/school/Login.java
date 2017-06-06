package school;

public interface Login {
/*
 * login
 * - input : id, pw
 * - output : boolean(yes) or (no)void-return exception or Name or userInfo
 * 	(no) --> exception class
 *  : JDBC like this
 * - return type : userInfo - member
 */
	//operation oriented programming
	Member login(String userId, String userPw) 
			throws LoginIDMinLengthException, PasswordDefaultLengthException;
	// about 'no' exception
	
}

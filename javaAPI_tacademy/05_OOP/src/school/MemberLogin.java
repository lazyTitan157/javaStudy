package school;

/*
 * DAO(DataAccessObject) - DBMS - JDBC
 * data : local data, RDBMS, server DB, big data
 * 
 */
public class MemberLogin implements Login{

	//interface implementation
	@Override
	public Member login(String userId, String userPw) throws LoginIDMinLengthException, PasswordDefaultLengthException {
		// throw delete is okay, because it's non-checked Exception
		// DBMS, file check
		Member m = null; // local var get default val
		m = new Member(userId, userPw);
		//mock instance
		return m;
	}
	
}

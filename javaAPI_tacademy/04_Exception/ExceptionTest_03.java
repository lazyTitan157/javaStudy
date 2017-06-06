class UserObjectMethodBException extends Exception{
	UserObjectMethodBException(String message){
		super(message);
	}
}
class UserObject{
	public UserObject() throws UserObjectMethodBException{
		methodA();
		System.out.println("UserObject()");
	}

	private void methodA() throws UserObjectMethodBException {
		methodB();
		System.out.println("methodA()");
	}

	private void methodB() throws UserObjectMethodBException {
		if(true)
			throw new UserObjectMethodBException("B method");
		System.out.println("methodB");
	}
}
public class ExceptionTest_03 {
	public static void main(String[] args) {
		try {
			new UserObject();
		} catch (UserObjectMethodBException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		} catch(Throwable e){
			e.printStackTrace();
		}finally {
			System.out.println("마지막에 자원을 반환");
		}
		System.out.println("end");
	}
}

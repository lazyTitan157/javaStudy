package school;
//id min = 8
public class LoginIDMinLengthException extends RuntimeException {
	public LoginIDMinLengthException(String message){
		super(message);
	}
	public LoginIDMinLengthException(){
		this("8 characters");
	}
}

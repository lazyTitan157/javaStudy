package school;
//pw = numbers 4
public class PasswordDefaultLengthException extends RuntimeException {
	public PasswordDefaultLengthException(String message){
		super(message);
	}
	public PasswordDefaultLengthException(){
		this("4 numbers");
	}
}

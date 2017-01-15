package guestbook.service;

public class MessageNotFoundException extends Exception {
	public MessageNotFoundException(String message){
		super(message);
	}
}

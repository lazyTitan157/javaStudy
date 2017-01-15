package member.service;

import java.util.Map;

/*
 * joinservice가 회원가입기능을 구현할때 필요한 요청데이터를 담는 클래스
 * 각 필드를 위한 get/set메서드
 * isPasswordEqualToConfirm() : password필드와 confirmPassword필드의 값이 같은지 검사한다.
 * 	필드 데이터가 유효한지 여부를 검사할 때 사용된다.
 * validate() : 각 필드의 데이터가 유효한지/올바른지 검사한다.
 *  올바르지않으면, 
 *  errors맵 객체의 filedName키에 true를 값으로 추가한다.  
 *  (errors맵 객체는 에러정보를 담기위해 사용한다.) 
 * checkEmpty() : value값이 없는 경우 
 *  errors맵 객체의 filedName키에 true를 값으로 추가한다.  
 */
public class JoinRequest {
	
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public boolean isPasswordEqualToConfirm() {
		return password !=null && password.equals(confirmPassword);
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		if(!errors.containsKey("confirmPassword")){
			if(!isPasswordEqualToConfirm()){
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()){
			errors.put(fieldName, Boolean.TRUE);
		}
	}
}

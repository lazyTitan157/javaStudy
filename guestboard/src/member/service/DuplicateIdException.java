package member.service;
/*
 * 회원가입을 처리할때 동일한 아이디를 갖는 데이터가 이미 존재하면,
 * 익셉션을 발생한다. (이때 사용할 익셉션 클래스)
 */
public class DuplicateIdException extends RuntimeException {

}

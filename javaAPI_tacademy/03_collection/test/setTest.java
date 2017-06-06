package test;
import java.util.*;

import school.Login;

//객체들을 비연속적으로 관리하는 업무에서 - 순서, 나중에 변경 가능
public class setTest {

	public static void main(String[] args) {
		Collection c;
		c = new HashSet();
		System.out.println(c.add("hello")); 
		//중복제거를 안된는 셋이라니? 무ㅓ가 빠진거지?
		//라이프 사이클은 콜백
		
		System.out.println(c.add(new String("hello")));
		System.out.println(c.add(1234));
		System.out.println(c.add(new Integer(1234)));
		System.out.println(c.add(new Login("userid", "userpw")));
		
		System.out.println(c.add("hello")); 
		System.out.println(c.add(new String("hello")));
		System.out.println(c.add(1234));
		System.out.println(c.add(new Integer(1234)));
		System.out.println(c.add(new Login("userid", "userpw")));
		
		System.out.println(c);
	}

}

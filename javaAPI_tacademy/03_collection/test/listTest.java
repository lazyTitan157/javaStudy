package test;
import java.util.*;

import school.Login;

//객체들을 비연속적으로 관리하는 업무에서 - 순서, 나중에 변경 가능
public class listTest {

	public static void main(String[] args) {
		Collection c;
		c = new ArrayList();
		System.out.println(c.add("hello")); 
		//뭐든 넣을 수 있고, 오브젝트 객체로 변환된다.
		//주소 있으면 다 객체(레퍼런스), 완전한 객체는 new가 있어야함.
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

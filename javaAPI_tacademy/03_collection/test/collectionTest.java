package test;
import java.util.*;

import school.Login;

//객체들을 비연속적으로 관리하는 업무에서 - 순서, 나중에 변경 가능
public class collectionTest {

	public static void main(String[] args) {
		//<Login>이라고 명시적으로 선언과 사용을 해야하지만, 7버전부터 사용할때는 명시하지않아도 괜찮음.
		System.out.println(new CollectionTest().getObjects(new ArrayList<Login>()));
		Collection<Login> set = new CollectionTest().getObjects(new HashSet());	
		for (Login tmp : set) {
			System.out.println(tmp.getLoginId()); //toString : 불필요한것필요
		} //foreach
	}
	
	//print - Collection<Element> : VO
	Collection<Login> getObjects(Collection<Login> c){

		Collection<Login> result = c;
		//c = new HashSet();
		//System.out.println(c.add("hello")); 
		//중복제거를 안된는 셋이라니? 무ㅓ가 빠진거지?
		//라이프 사이클은 콜백
		// hashcode, equals 추가하니 작동 
//		System.out.println(c.add(new String("hello")));
//		System.out.println(c.add(1234));
//		System.out.println(c.add(new Integer(1234)));
		System.out.println(c.add(new Login("userid", "userpw")));
		
//		System.out.println(c.add("hello")); 
//		System.out.println(c.add(new String("hello")));
//		System.out.println(c.add(1234));
//		System.out.println(c.add(new Integer(1234)));
		System.out.println(c.add(new Login("userid", "userpw")));

		return result;

	}
}

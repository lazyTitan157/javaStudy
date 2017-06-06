package test;

import school.Login;
import school.Member;
import school.MemberLogin;

public class UnitTest_02 {

	public static void main(String[] args) {
		Login l = new MemberLogin();
		
		//connect with member by toString
		System.out.println(l.login("12345678", "1234"));
		System.out.println(l.login("123", "1234"));
		
		System.out.println("end"); //end¾È¶ß°í ÀÍ¼Á¼Ç ¹ß»ý - non-checked exception
	}

}

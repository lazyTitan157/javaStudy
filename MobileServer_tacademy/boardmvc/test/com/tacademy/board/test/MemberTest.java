package com.tacademy.board.test;

import com.tacademy.board.dao.MemberDAO;
import com.tacademy.board.vo.Member;

public class MemberTest {

	public MemberTest() {
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId("test");
		member.setPassword("aaa");
	
		dao.doLogin(member);
		if(member.getName()!=null){
			System.out.println("login success : " + member.getName());
		} else {
			System.out.println("login fail");
		}
	}

	public static void main(String[] args){
		new MemberTest();
	}
}

package com.tacademy.test;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.tacademy.vo.Member;
import com.tacademy.vo.Result;

public class JsonTest {

	public JsonTest() {
		Member m = new Member();
		m.setName("홍길동");
		m.setAddress("seoul");
		m.setAge(20);
		//System.out.println(m);
		Gson gson = new Gson();
		String result = gson.toJson(m); // json making
		System.out.println(result);

		//String json = m.toString();
		//System.out.println(json);
		//String json = gson.toJson(m);
		String json = "{\"name\":\"홍길동 \", \"age\":20, \"address\":\"seoul \"}";
		//json object 객체
		//System.out.println(json);		
		
		Member m1 = gson.fromJson(json, Member.class);
		System.out.println(m1);
		
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("홍길동1", 20, "seoul1"));
		list.add(new Member("홍길동1", 20, "seoul2"));
		list.add(new Member("홍길동1", 20, "seoul3"));
		list.add(new Member("홍길동1", 20, "seoul4"));
		list.add(new Member("홍길동1", 20, "seoul5"));
		list.add(new Member("홍길동1", 20, "seoul6"));
		list.add(new Member("홍길동1", 20, "seoul7"));
		//json array 객체 -- 변환필요
//		String result1 = gson.toJson(list);
//		System.out.println(result1);
		
		Result memberResult = new Result();
		//collection to class member
		memberResult.setCount(list.size());
		memberResult.setList(list);
		memberResult.setStatus("success");
		String result2 = gson.toJson(memberResult);
		System.out.println(result2);
	}

	public static void main(String[] args) {
		new JsonTest();

	}

}

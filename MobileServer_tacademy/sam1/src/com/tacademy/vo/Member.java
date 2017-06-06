package com.tacademy.vo;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 3개의 데이터를 관리하는 객체
	 * databeans 객체를 관리하는 기본적인 형태
	 */
	private static final long serialVersionUID = 7228648646037631716L;
	private String name;
	private int age;
	private String address;
	
	public Member(){}
	
	public Member(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
//	@Override
//	public String toString() {
//		//return "Member [name=" + name + ", age=" + age + ", address=" + address + "]";
//		return "{name:\" + name + \", age:" + age + ", address:\" + address + \"}";
//		//json규칙에맞는 문자열으로 출력해주면 그게 json객체가 되는것
//	}
	
	
}

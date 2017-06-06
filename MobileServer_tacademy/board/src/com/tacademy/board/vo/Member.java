package com.tacademy.board.vo;

public class Member {

	private String num; //int인데 integer로 바꿔야됨 (입력은 string이라)
	private String id;
	private String name;
	private String password;
	private String role;
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", id=" + id + ", name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

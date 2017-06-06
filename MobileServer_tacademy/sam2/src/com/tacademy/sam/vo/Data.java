package com.tacademy.sam.vo;

public class Data {
	private String name = "korea";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Data [name=" + name + "]";
	}
	
}

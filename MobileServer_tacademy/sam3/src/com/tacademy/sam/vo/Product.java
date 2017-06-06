package com.tacademy.sam.vo;

public class Product {
	private String name;
	private String code;
	private int price;
	public Product(){}
	public Product(String name, String code, int price){
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", price=" + price + "]";
	}
	
	
}

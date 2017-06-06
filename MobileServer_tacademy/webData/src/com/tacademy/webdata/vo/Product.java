package com.tacademy.webdata.vo;

public class Product {

	private int num;
	private String title;
	private String count;
	private int price;
	private String image;
	private String category;

	public Product() {}
	
	public Product(int num, String title, String count, int price, String image, String category) {
		super();
		this.num = num;
		this.title = title;
		this.count = count;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", title=" + title + ", count=" + count + ", price=" + price + ", image=" + image
				+ ", category=" + category + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	
}

package com.tacademy.sam.vo;

import java.util.ArrayList;

public class Result {
	private String status;
	private int count;
	private ArrayList<Product> list;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Product> getList() {
		return list;
	}
	public void setList(ArrayList<Product> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", count=" + count + ", list=" + list + "]";
	}
	
}

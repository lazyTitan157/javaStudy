package com.tacademy.sam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyWrapperRequest extends HttpServletRequestWrapper {

	public MyWrapperRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		// tel 값이 있으면 --, 없으면 000-0000-0000
		String data = super.getParameter(name);
		//super안하면 무한반복됨 계속 client값 가져오는거(부모에서 이미 받았는데
		if("tel".equals(name)){
			if(data == null) {
				return "000-0000-0000";
			} else {
				return data;
			}
		}
		return data;
	}
	
	

}

package com.tacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeServlet
 */
@WebServlet("/LifeServlet")
public class LifeServlet extends HttpServlet {

	private int cnt = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		System.out.println("service cnt:"+cnt);
		
		super.service(request, response); 
	}

	@Override
	public void destroy() {
		cnt++;
		System.out.println("destroy cnt:"+cnt);
	}

	@Override
	public void init() throws ServletException {
		cnt++;
		System.out.println("init cnt:"+cnt);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		System.out.println("doGet1 cnt:"+cnt);
		PrintWriter out = response.getWriter();
		out.println("doGet cnt:"+cnt);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); //doGet과 doPost를 하나로 합쳐줌(결국 doGet만 실행되는)
	}

}

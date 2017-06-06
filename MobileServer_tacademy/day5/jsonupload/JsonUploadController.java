package com.tacademy.board.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tacademy.board.vo.Board;

public class JsonUploadController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(request.getInputStream()));
		
		StringBuilder sb = new StringBuilder();
		String data = "";
		try{
			while((data = br.readLine()) != null){
				sb.append(data).append("\n");
			}
		}catch(IOException e ){
			System.out.println("error : " + e);
		}
		System.out.println("sb : " + sb.toString());
		Gson gson = new Gson();	
		Board board = gson.fromJson(sb.toString(), Board.class);
		request.setAttribute("board",  board);
		return "result1.jsp";
	}

}

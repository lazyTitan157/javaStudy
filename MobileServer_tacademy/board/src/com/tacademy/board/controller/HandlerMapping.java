package com.tacademy.board.controller;

import java.util.HashMap;

public class HandlerMapping {
	private HashMap<String, Controller> mappings = new HashMap<>();
	
	public HandlerMapping() {
		// TODO Auto-generated constructor stub
		init();
	}
	void init(){
		//여기에 매핑을 해줘야 url들이 해당 path로 dispatcher를 통해 분류됨.
		mappings.put("/hello.do", new HelloController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/addBoard.do", new AddBoardController());
		mappings.put("/getBoardJson.do", new GetBoardJsonController());
		
	}
	public Controller getController(String path){
		//부모 클래스인 controller에 반환
		return mappings.get(path);
	}
}

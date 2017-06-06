package com.tacademy.board.controller;

import java.util.HashMap;

public class HandlerMapping {
	private HashMap<String, Controller> mappgings = new HashMap<String, Controller>();
	
	public HandlerMapping(){
		initConfig();
	}
	
	void initConfig(){
		mappgings.put("/hello.do", new HelloController());
		mappgings.put("/login.do", new LoginController());
		mappgings.put("/logout.do", new LogoutController());
		mappgings.put("/getBoard.do", new GetBoardController());
		mappgings.put("/getBoardList.do", new GetBoardListController());
		mappgings.put("/getBoardListJson.do", new GetBoardListJsonController());
		mappgings.put("/addBoard.do", new AddBoardController());
		mappgings.put("/getBoardJson.do", new GetBoardJsonController());
		mappgings.put("/jsonUpload.do", new JsonUploadController());
	}
	public Controller getController(String path){
		return mappgings.get(path);
	}
	
}

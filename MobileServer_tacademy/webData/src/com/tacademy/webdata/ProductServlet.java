package com.tacademy.webdata;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tacademy.webdata.dao.ProductDAO;
import com.tacademy.webdata.vo.Product;
import com.tacademy.webdata.vo.Result;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doSearch(request,response);
	}

	void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ProductDAO dao = new ProductDAO();
		
		Product product = new Product();

		String key = request.getParameter("key"); 
		byte[] arr = key.getBytes("iso-8859-1");
		String tKey = new String(arr,"UTF-8");
		String category = request.getParameter("category");
		String type = request.getParameter("type");
		ArrayList<Product> pList = dao.doSearchKey(product, key, tKey, category);

		String returnURL = "";
		if("0".equals(type)) {			//android의 경우 , 요청url에 ?format=json이 있으면
			Gson gson = new Gson();			//객체로 출력
			Result productResult = new Result();
			productResult.setStatus("success");
			productResult.setCount(pList.size());
			productResult.setList(pList);
			String result = gson.toJson(productResult);
			request.setAttribute("result", result);
		} else if("1".equals(type)){ 
			StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<pList>");
			for(Product p:pList){
				sb.append("<item>");
				sb.append("<title>"+p.getTitle()+"</title>");
				sb.append("<count>"+p.getCount()+"</count>");
				sb.append("<price>"+p.getPrice()+"</price>");
				sb.append("<image>"+p.getImage()+"</image>");
				sb.append("<category>"+p.getCategory()+"</category>");
				sb.append("</item>");
			}
			sb.append("</pList>");
			String result = sb.toString();
			request.setAttribute("result", result);
		} else {
			request.setAttribute("result", pList);
		}
		returnURL = "result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response); //get으로 처리
	}

}

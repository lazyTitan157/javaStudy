package com.tacademy.webdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tacademy.webdata.vo.Product;

public class ProductDAO {

	public ArrayList<Product> doSearchKey(Product product, String key, String tkey, String category) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
//		//connection, 명령문, 결과받을 변수 설정
		ResultSet rst = null;
		ArrayList<Product> pList = new ArrayList<Product>();
		
		String sql = "";		
		StringBuilder sb = new StringBuilder("select num,title,count,price,image,category  from product ");
	
		try{
			conn = JDBCUtil.getConnection();
			if(!key.equals("empty")){
				sb.append("where title like '%" + key + "%' ");
				if(!category.equals("0")){
					sb.append("and category = '" + category + "'");
				}
			}else{
				if(!category.equals("0")){
					sb.append("where category = '" + category + "'");
				}
			}
			sql = sb.toString();
			System.out.println("클래스 로딩 성공 conn : " + conn);
			System.out.println("sql : " + sql);
			stmt = conn.prepareStatement(sql);
			
			rst = stmt.executeQuery();
			Product p = null;
			//반환하는 것 여러개일수 있으므로 반복수행
			while(rst.next()) { //rst의 마지막 까지실행
				p = new Product();
				p.setNum(rst.getInt(1)); //int에서 문자열로 형변환
				p.setTitle(rst.getString(2));
				p.setCount(rst.getString(3));
				p.setPrice(rst.getInt(4));
				p.setImage(rst.getString(5));
				p.setCategory(rst.getString(6));
				pList.add(p);
			}
		} catch(SQLException e){
			System.out.println("search e : " + e);
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return pList; //객체 반환
	}

}

package com.artcenter.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	
	public static Connection getConnection() {
	      Connection conn = null;
	      
	      String driver = "oracle.jdbc.driver.OracleDriver";
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String id ="artcenter";
	      String pw ="0108";
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url,id,pw);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return conn;
	   }
	
	
		
		
	

	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
		}
	}

	
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
		}
	}



}

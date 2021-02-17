package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.NewsVO;

public class NewsDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static NewsDAO instance = new NewsDAO();
	public static NewsDAO getinstance() {
		return instance;
	}	
		
	
	
	public int subNewletter(NewsVO nvo) {
		String sql = "insert into art_subscriber(num, email, code) values(art_subscriber_seq.nextval,?,'비회원')";
		
		conn = DBManager.getConnection();
		int result = 0;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getSub_email());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	public List<NewsVO> subscriber() {
		String sql = "select email, code from art_customer union select email, code from art_subscriber order by code asc";
		
		conn = DBManager.getConnection();
		List<NewsVO> list = new ArrayList<NewsVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NewsVO nvo = new NewsVO();
				nvo.setSub_email(rs.getString("email"));
				nvo.setCode(rs.getString("code"));
				
				list.add(nvo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
}

package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.FaqVO;

public class FaqDAO {
	
	private static FaqDAO instance = new FaqDAO();
	public static FaqDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<FaqVO> faqList() {
		String sql ="select * from art_question";
		
		conn = DBManager.getConnection();
		List<FaqVO> list = new ArrayList<FaqVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FaqVO fvo = new FaqVO();
				fvo.setNum(rs.getInt("num"));
				fvo.setSpecialnum(rs.getInt("specialnum"));
				fvo.setQuestion(rs.getString("question"));
				fvo.setAnswer(rs.getString("answer"));
				
				list.add(fvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
		
	}
	
	
	public List<FaqVO> faqList(String query) {
		String sql ="select * from art_question where question"+query;
		
		conn = DBManager.getConnection();
		List<FaqVO> list = new ArrayList<FaqVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FaqVO fvo = new FaqVO();
				fvo.setNum(rs.getInt("num"));
				fvo.setSpecialnum(rs.getInt("specialnum"));
				fvo.setQuestion(rs.getString("question"));
				fvo.setAnswer(rs.getString("answer"));
				
				list.add(fvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
		
	}
	
	
	public int questionCount(String query) {
		String sql = "select count(*) from art_question where question"+query;
		
		conn = DBManager.getConnection();
		int totalcount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				totalcount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return totalcount;
	}
	
}

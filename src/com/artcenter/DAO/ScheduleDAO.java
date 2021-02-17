package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.ExhibitionVO;
import com.artcenter.VO.PerformanceVO;
import com.artcenter.VO.ScheduleVO;

public class ScheduleDAO {
	
	private static ScheduleDAO instance = new ScheduleDAO();
	public static ScheduleDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<ScheduleVO> pe_List(String today) {
		String sql = "select * from art_performance where begindate <= ? and enddate >= ? "
				+ "union select * from art_exhibition where begindate <= ? and enddate >= ?";
		
		conn = DBManager.getConnection();
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		ScheduleVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);
			pstmt.setString(2, today);
			pstmt.setString(3, today);
			pstmt.setString(4, today);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new ScheduleVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setImage(rs.getString("image"));
				vo.setContent(rs.getString("content"));
				vo.setBegindate(rs.getString("begindate"));
				vo.setEnddate(rs.getString("enddate"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.getConnection();
		}
		return list;
		
	}
	
	public List<ScheduleVO> pe_dateList(String datepick) {
		String sql = "select * from art_performance where begindate <= ? and enddate >= ? "
				+ "union select * from art_exhibition where begindate <= ? and enddate >= ?";
		
		conn = DBManager.getConnection();
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		ScheduleVO vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, datepick);
			pstmt.setString(2, datepick);
			pstmt.setString(3, datepick);
			pstmt.setString(4, datepick);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new ScheduleVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setImage(rs.getString("image"));
				vo.setContent(rs.getString("content"));
				vo.setBegindate(rs.getString("begindate"));
				vo.setEnddate(rs.getString("enddate"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.getConnection();
		}
		return list;
		
	}
	
	
	
	
	public int performanceInsert(PerformanceVO vo) {
		String sql = "insert into art_performance(num, title, image, content, begindate, enddate) "
				+ "values(art_performance_seq.nextval,?,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getImage());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getBegindate());
			pstmt.setString(5, vo.getEnddate());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		
		return result;
	}
	
	
	public int exhibitionInsert(ExhibitionVO vo) {
		String sql = "insert into art_exhibition(num, title, image, content, begindate, enddate) "
				+ "values(art_exhibition_seq.nextval,?,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getImage());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getBegindate());
			pstmt.setString(5, vo.getEnddate());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		
		return result;
	}
	
	
}

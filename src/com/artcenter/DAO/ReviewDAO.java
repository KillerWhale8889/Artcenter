package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ReviewVO;

public class ReviewDAO {
	
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public List<ReviewVO> getListWithPaging (Criteria cri) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_review art_review_pk)*/ "
				+ "rownum rn, num, title, content, writer, regdate, readcount, appfile from "
				+ "art_review where rownum <= ?*? order by rn desc) where rn > (?-1)*? order by num desc" ;

		
		conn = DBManager.getConnection();
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewVO rvo = new ReviewVO();
				rvo.setNum(rs.getInt("num"));
				rvo.setRn(rs.getInt("rn"));
				rvo.setTitle(rs.getString("title"));
				rvo.setContent(rs.getString("content"));
				rvo.setWriter(rs.getString("writer"));
				rvo.setRegdate(rs.getDate("regdate"));
				rvo.setAppfile(rs.getString("appfile"));
				rvo.setReadcount(rs.getInt("readcount"));
				
				list.add(rvo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public List<ReviewVO> getSerchListWithPaging (Criteria cri, String query) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_review art_review_pk)*/ "
				+ "rownum rn, num, title, content, writer, regdate, appfile, readcount from "
				+ "(select * from art_review where "+query+" order by num desc) where rownum <= ?*? order by num desc) where rn > (?-1)*? order by rn asc";

		conn = DBManager.getConnection();
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewVO rvo = new ReviewVO();
				rvo.setNum(rs.getInt("num"));
				rvo.setRn(rs.getInt("rn"));
				rvo.setTitle(rs.getString("title"));
				rvo.setContent(rs.getString("content"));
				rvo.setWriter(rs.getString("writer"));
				rvo.setRegdate(rs.getDate("regdate"));
				rvo.setAppfile(rs.getString("appfile"));
				rvo.setReadcount(rs.getInt("readcount"));
				
				list.add(rvo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public int reviewCount() {
		String sql = "select count(*) from art_review";
		
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
	
	
	public int reviewCount(String query) {
		String sql = "select count(*) from art_review where "+query;
		
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
	
	
	public int reviewInsert(ReviewVO rvo) {
		String sql = "insert into art_review(num,title,content,appfile,writer,regdate,readcount) "
				+ "values (art_review_seq.nextval,?,?,?,?,sysdate,0)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getTitle());
			pstmt.setString(2, rvo.getContent());
			pstmt.setString(3, rvo.getAppfile());
			pstmt.setString(4, rvo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	
	public ReviewVO reviewContent(String num) {
		String sql = "select * from art_review where num="+num;
		
		conn = DBManager.getConnection();
		ReviewVO rvo = new ReviewVO();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rvo.setNum(rs.getInt("num"));
				rvo.setTitle(rs.getString("title"));
				rvo.setContent(rs.getString("content"));
				rvo.setAppfile(rs.getString("appfile"));
				rvo.setWriter(rs.getString("writer"));
				rvo.setRegdate(rs.getDate("regdate"));
				rvo.setReadcount(rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return rvo;
	}
	
	
	public void readCount(String num) {
		String sql = "update art_review set readcount = readcount+1 where num="+num;
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public ReviewVO preView(String num) {
		
		String sql = "select num, title from art_review where num= (select max(num) from art_review where num<?)";
		ReviewVO prevo = null;
		
		conn = DBManager.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				prevo = new ReviewVO();
				prevo.setNum(rs.getInt("num"));
				prevo.setTitle(rs.getString("title"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return prevo;
	}
	
	
		public ReviewVO nextView(String num) {
		
		String sql = "select num, title from art_review where num= (select min(num) from art_review where num>?)";
		ReviewVO prevo = null;
		
		conn=DBManager.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				prevo = new ReviewVO();
				prevo.setNum(rs.getInt("num"));
				prevo.setTitle(rs.getString("title"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt, conn);
		}
		
		return prevo;
	}
		
		
		public int reviewModify(ReviewVO rvo) {
			
		String sql = "update art_review set writer=?, title=?, content=?, appfile=? where num=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getWriter());
			pstmt.setString(2, rvo.getTitle());
			pstmt.setString(3, rvo.getContent());
			pstmt.setString(4, rvo.getAppfile());
			pstmt.setInt(5, rvo.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			DBManager.close(pstmt, conn);
		}
		 return result;	
		
		}
	

		public int reviewDelete(String num) {
			
			String sql = "delete from art_review where num="+num;
			
			conn = DBManager.getConnection();
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
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

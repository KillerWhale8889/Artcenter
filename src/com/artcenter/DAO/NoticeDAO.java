package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.NoticeVO;
import com.artcenter.VO.ReviewVO;

public class NoticeDAO {
	
	private static NoticeDAO instance = new NoticeDAO();
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public List<NoticeVO> getListWithPaging (Criteria cri) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_notice art_notice_pk)*/ "
				+ "rownum rn, num, title, content, writer, regdate, readcount, appfile from "
				+ "art_notice where rownum <= ?*? order by rn desc) where rn > (?-1)*? order by num desc" ;

		
		conn = DBManager.getConnection();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeVO nvo = new NoticeVO();
				nvo.setNum(rs.getInt("num"));
				nvo.setRn(rs.getInt("rn"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setWriter(rs.getString("writer"));
				nvo.setRegdate(rs.getDate("regdate"));
				nvo.setAppfile(rs.getString("appfile"));
				nvo.setReadcount(rs.getInt("readcount"));
				
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
	
	
	
	public List<NoticeVO> getSerchListWithPaging (Criteria cri, String query) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_notice art_notice_pk)*/ "
				+ "rownum rn, num, title, content, writer, regdate, appfile, readcount from "
				+ "(select * from art_notice where content"+query+" order by num desc) where rownum <= ?*? order by num desc) where rn > (?-1)*? order by rn asc";

		conn = DBManager.getConnection();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				NoticeVO nvo = new NoticeVO();
				nvo.setNum(rs.getInt("num"));
				nvo.setRn(rs.getInt("rn"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setWriter(rs.getString("writer"));
				nvo.setRegdate(rs.getDate("regdate"));
				nvo.setAppfile(rs.getString("appfile"));
				nvo.setReadcount(rs.getInt("readcount"));
				
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
	
	
	
	public int noticeCount() {
		String sql = "select count(*) from art_notice";
		
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
	
	
	public int noticeCount(String query) {
		String sql = "select count(*) from art_notice where content"+query;
		
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
	
	
	public int noticeInsert(NoticeVO nvo) {
		String sql = "insert into art_notice(num,title,content,appfile,writer,regdate,readcount) "
				+ "values (art_notice_seq.nextval,?,?,?,?,sysdate,0)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getAppfile());
			pstmt.setString(4, "관리자");
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	
	public NoticeVO noticeContent(String num) {
		String sql = "select * from art_notice where num="+num;
		
		conn = DBManager.getConnection();
		NoticeVO nvo = new NoticeVO();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nvo.setNum(rs.getInt("num"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setAppfile(rs.getString("appfile"));
				nvo.setWriter(rs.getString("writer"));
				nvo.setRegdate(rs.getDate("regdate"));
				nvo.setReadcount(rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return nvo;
	}
	
	
	public void readCount(String num) {
		String sql = "update art_notice set readcount = readcount+1 where num="+num;
		
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public NoticeVO preView(String num) {
		
		String sql = "select num, title from art_notice where num= (select max(num) from art_notice where num<?)";
		NoticeVO prevo = null;
		
		conn = DBManager.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				prevo = new NoticeVO();
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
	
	
		public NoticeVO nextView(String num) {
		
		String sql = "select num, title from art_notice where num= (select min(num) from art_notice where num>?)";
		NoticeVO prevo = null;
		
		conn=DBManager.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				prevo = new NoticeVO();
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
		
		
		public int noticeModify(NoticeVO nvo) {
			
		String sql = "update art_notice set title=?, content=?, appfile=? where num=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getAppfile());
			pstmt.setInt(4, nvo.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			DBManager.close(pstmt, conn);
		}
		 return result;	
		
		}
	

		public int noticeDelete(String num) {
			
			String sql = "delete from art_notice where num="+num;
			
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

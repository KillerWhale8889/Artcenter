package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.GalleryVO;
import com.artcenter.VO.NoticeVO;

public class GalleryDAO {
	
	private static GalleryDAO instance = new GalleryDAO();
	public static GalleryDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<GalleryVO> galleryList() {
		
		String sql = "select * from art_gallery order by num desc";
		
		conn = DBManager.getConnection();
		
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				GalleryVO gvo = new GalleryVO();
				
				gvo.setNum(rs.getInt("num"));
				gvo.setRn(rs.getInt("rn"));
				gvo.setTitle(rs.getString("title"));
				gvo.setImage(rs.getString("image"));
				gvo.setSection(rs.getString("section"));
				gvo.setArtist(rs.getString("artist"));
				
				list.add(gvo);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			DBManager.close(pstmt, conn);
		}
		
		return list;
	}
	
	
	public List<GalleryVO> getListWithPaging (Criteria cri) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_gallery art_gallery_pk)*/ "
				+ "rownum rn, num, title, image, section, artist from "
				+ "art_gallery where rownum <= ?*? order by rn desc) where rn > (?-1)*? order by num desc" ;

		
		conn = DBManager.getConnection();
		List<GalleryVO> list = new ArrayList<GalleryVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				GalleryVO gvo = new GalleryVO();
				gvo.setNum(rs.getInt("num"));
				gvo.setRn(rs.getInt("rn"));
				gvo.setTitle(rs.getString("title"));
				gvo.setImage(rs.getString("image"));
				gvo.setSection(rs.getString("section"));
				gvo.setArtist(rs.getString("artist"));
				
				list.add(gvo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public int galleryUpload(GalleryVO gvo) {
		String sql = "insert into art_gallery(num, title, image, section, artist) values(art_gallery_seq.nextval,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gvo.getTitle());
			pstmt.setString(2, gvo.getImage());
			pstmt.setString(3, gvo.getSection());
			pstmt.setString(4, gvo.getArtist());
			
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

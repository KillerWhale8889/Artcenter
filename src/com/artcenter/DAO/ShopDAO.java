package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.CouponVO;
import com.artcenter.VO.ShopVO;

public class ShopDAO {
	
	private static ShopDAO instance = new ShopDAO();
	public static ShopDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<ShopVO> getListWithPaging (Criteria cri) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_shop art_shop_pk)*/ "
				+ "rownum rn, product_num, product_name, content, price, quantity, image from "
				+ "art_shop where rownum <= ?*? order by rn desc) where rn > (?-1)*? order by product_num desc" ;

		
		conn = DBManager.getConnection();
		List<ShopVO> list = new ArrayList<ShopVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				ShopVO svo = new ShopVO();
				svo.setProduct_num(rs.getInt("product_num"));
				svo.setRn(rs.getInt("rn"));
				svo.setProduct_name(rs.getString("product_name"));
				svo.setContent(rs.getString("content"));
				svo.setPrice(rs.getInt("price"));
				svo.setQuantity(rs.getInt("quantity"));
				svo.setImage(rs.getString("image"));
				
				list.add(svo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public List<ShopVO> getSerchListWithPaging (Criteria cri, String query) {
		String sql = "select * from "
				+ "(select /*+ index_desc (art_shop art_shop_pk)*/ "
				+ "rownum rn, product_num, product_name, content, price, quantity, image from "
				+ "(select * from art_shop where "+query+" order by num desc) where rownum <= ?*? order by product_num desc) where rn > (?-1)*? order by rn asc";

		conn = DBManager.getConnection();
		List<ShopVO> list = new ArrayList<ShopVO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				ShopVO svo = new ShopVO();
				svo.setProduct_num(rs.getInt("product_num"));
				svo.setRn(rs.getInt("rn"));
				svo.setProduct_name(rs.getString("product_name"));
				svo.setContent(rs.getString("content"));
				svo.setPrice(rs.getInt("price"));
				svo.setQuantity(rs.getInt("quantity"));
				svo.setImage(rs.getString("image"));
				
				list.add(svo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public int shopCount() {
		String sql = "select count(*) from art_shop";
		
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
	
	
	public int shopCount(String query) {
		String sql = "select count(*) from art_shop where "+query;
		
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
	
	public int shopInsert(ShopVO svo) {
		String sql = "insert into art_shop(product_num, product_name, content, price, quantity, image) "
				+ "values(art_shop_seq.nextval,?,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getProduct_name());
			pstmt.setString(2, svo.getContent());
			pstmt.setInt(3, svo.getPrice());
			pstmt.setInt(4, svo.getQuantity());
			pstmt.setString(5, svo.getImage());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	}
	
	public ShopVO viewCart(String num) {
		String sql = "select * from art_shop where product_num="+num;
		
		conn = DBManager.getConnection();
		ShopVO svo = new ShopVO();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				svo.setProduct_num(rs.getInt("product_num"));
				svo.setProduct_name(rs.getString("product_name"));
				svo.setContent(rs.getString("content"));
				svo.setPrice(rs.getInt("price"));
				svo.setQuantity(rs.getInt("quantity"));
				svo.setImage(rs.getString("image"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return svo;
	}
	
	
	
	
	
}

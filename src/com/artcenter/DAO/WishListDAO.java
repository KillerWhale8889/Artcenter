package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.WishListVO;

public class WishListDAO {
	
	private static WishListDAO instance = new WishListDAO();
	public static WishListDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<WishListVO> wishlistView(String userid) {
		String sql ="select * from art_wishlist where userid=?";
		
		conn = DBManager.getConnection();
		List<WishListVO> list = new ArrayList<WishListVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WishListVO wvo = new WishListVO();
				wvo.setNum(rs.getInt("num"));
				wvo.setUserid(rs.getString("userid"));
				wvo.setProduct_num(rs.getInt("product_num"));
				wvo.setProduct_name(rs.getString("product_name"));
				wvo.setPrice(rs.getInt("price"));
				wvo.setQuantity(rs.getInt("quantity"));
				wvo.setImage(rs.getString("image"));
				
				list.add(wvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public int addtoWish(WishListVO wvo) {
		String sql = "insert into art_wishlist(num, userid, product_num, product_name, price, quantity, image) "
				+ "values(art_wishlist_seq.nextval,?,?,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wvo.getUserid());
			pstmt.setInt(2, wvo.getProduct_num());
			pstmt.setString(3, wvo.getProduct_name());
			pstmt.setInt(4, wvo.getPrice());
			pstmt.setInt(5, wvo.getQuantity());
			pstmt.setString(6, wvo.getImage());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	
	
	
	public int removeAccount(String userid) {
		String sql = "delete from art_wishlist where userid=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, conn);
		}
		
		return result;		
	}
	
	
	public int removeWishlist(String num) {
		String sql = "delete from art_wishlist where num=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
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

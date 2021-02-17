package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.CartVO;
import com.artcenter.VO.CouponVO;

public class CartDAO {
	
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int addtoCart(CartVO cvo) {
		String sql = "insert into art_cart(num, userid, product_num, product_name, price, quantity, image) "
				+ "values(art_cart_seq.nextval,?,?,?,?,?,?)";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getUserid());
			pstmt.setInt(2, cvo.getProduct_num());
			pstmt.setString(3, cvo.getProduct_name());
			pstmt.setInt(4, cvo.getPrice());
			pstmt.setInt(5, cvo.getQuantity());
			pstmt.setString(6, cvo.getImage());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	public List<CartVO> cartView(String userid) {
		String sql ="select * from art_cart where userid=?";
		
		conn = DBManager.getConnection();
		List<CartVO> list = new ArrayList<CartVO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CartVO cvo = new CartVO();
				cvo.setNum(rs.getInt("num"));
				cvo.setUserid(rs.getString("userid"));
				cvo.setProduct_num(rs.getInt("product_num"));
				cvo.setProduct_name(rs.getString("product_name"));
				cvo.setPrice(rs.getInt("price"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setImage(rs.getString("image"));
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public int coupon(String code) {
		String sql = "select * from salecoupon where codenumber=?";
		
		conn = DBManager.getConnection();
		CouponVO cou = new CouponVO();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
				
			}else {
				result = -1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return result;
	}
	
	public CouponVO salefee(String code) {
		String sql = "select salefee from salecoupon where codenumber=?";
		
		conn = DBManager.getConnection();
		CouponVO cou = new CouponVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cou.setSalefee(rs.getInt("salefee"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return cou;
	}
	
	public int sub_total(String userid) {
		String sql = "select sum(price) from art_cart where userid=?";
		int sub_total = 0;
		conn = DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sub_total = rs.getInt("sum(price)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return sub_total;
		
	}
	
	
	public int removeCart(String num) {
		String sql = "delete from art_cart where num=?";
		
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
	
	
	public int removeAccount(String userid) {
		String sql = "delete from art_cart where userid=?";
		
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
	
}

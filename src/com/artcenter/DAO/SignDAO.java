package com.artcenter.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artcenter.DBManager.DBManager;
import com.artcenter.VO.SignVO;

public class SignDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static SignDAO instance = new SignDAO();
	public static SignDAO getInstance() {
		return instance;
	}
	
	
	public int signUp(SignVO svo) {
		
		String sql = "insert into art_customer(num,name,password,email,regdate,code) values(art_customer_seq.nextval,?,?,?,sysdate,'회원')";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, svo.getName());
			pstmt.setString(2, svo.getPassword());
			pstmt.setString(3, svo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			DBManager.close(pstmt, conn);
		}
		return result;
	
	}
	
	public int signIn(String email, String pw) {
		String sql = "select password from art_customer where email=?";
		
		conn = DBManager.getConnection();
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password")!=null && rs.getString("password").equals(pw)) {
					result = 1;
					
				} else {
					result = 0;
				}
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
	
	
	
	public SignVO userName(String email) {
		String sql = "select name from art_customer where email=?";
		
		conn = DBManager.getConnection();
		SignVO vo = new SignVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setName(rs.getString("name"));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return vo;
	}
	
	
	public SignVO mypageView(String email) {
		String sql = "select * from art_customer where email=?";
		
		conn = DBManager.getConnection();
		SignVO vo = new SignVO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setRegdate(rs.getDate("regdate"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, pstmt, conn);
		}
		return vo;
	}
	
	public int mypageUpdate(SignVO vo) {
		String sql = "update art_customer set password=? where email=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, conn);
		}
		return result;
		
	}
	
	public int emailCheck(String email) {
		String sql = "select email from art_customer where email=?";
		
		conn = DBManager.getConnection();
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("email")!=null && rs.getString("email").equals(email)) {
					result = 1;
					
				} else {
					result = 0;
				}
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
	
	public int removeAccount(String email) {
		String sql = "delete from art_customer where email=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(pstmt, conn);
		}
		
		return result;		
	}
	
	public int newPassword(String password, String email) {
		String sql = "update art_customer set password=? where email=?";
		
		conn = DBManager.getConnection();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			
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

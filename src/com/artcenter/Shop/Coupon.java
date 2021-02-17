package com.artcenter.Shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.CartDAO;
import com.artcenter.VO.CouponVO;

public class Coupon implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String code = request.getParameter("code");
		CouponVO cou = new CouponVO();
		CartDAO sdao = CartDAO.getInstance();
		
		JSONObject obj = new JSONObject();
		
		int result = sdao.coupon(code);
		
		if (result == 1) {
		CouponVO salefee = sdao.salefee(code);
		obj.put("salefee", salefee.getSalefee());
		}
		
		obj.put("result", result);
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json,charset=utf-8");
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

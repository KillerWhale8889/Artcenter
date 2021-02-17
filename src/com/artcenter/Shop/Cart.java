package com.artcenter.Shop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.artcenter.Command.Command;
import com.artcenter.DAO.CartDAO;
import com.artcenter.DAO.ShopDAO;
import com.artcenter.VO.CartVO;
import com.artcenter.VO.CouponVO;

public class Cart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		CartDAO cdao = CartDAO.getInstance();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user");
		
		List<CartVO> list = new ArrayList<CartVO>();
		int sub_total = 0;
		
		list = cdao.cartView(userid);
		sub_total = cdao.sub_total(userid);
		
		request.setAttribute("sub_total", sub_total);
		request.setAttribute("list", list);
		
		

	}

}

package com.artcenter.Shop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.artcenter.Command.Command;
import com.artcenter.DAO.WishListDAO;
import com.artcenter.VO.WishListVO;

public class Wishlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WishListDAO wdao = WishListDAO.getInstance();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user");
		
		List<WishListVO> list = new ArrayList<WishListVO>();
		
		list = wdao.wishlistView(userid);
		
		request.setAttribute("list", list);

	}

}

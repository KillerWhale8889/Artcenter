package com.artcenter.Shop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ShopDAO;
import com.artcenter.DAO.WishListDAO;
import com.artcenter.VO.ShopVO;
import com.artcenter.VO.WishListVO;

public class Add_wishlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user");
		ShopDAO sdao = ShopDAO.getInstance();
		
		System.out.println(num);
		ShopVO svo = sdao.viewCart(num);
		WishListDAO wdao = WishListDAO.getInstance();
		WishListVO wvo = new WishListVO();
		
		wvo.setUserid(userid);
		wvo.setProduct_num(svo.getProduct_num());
		wvo.setProduct_name(svo.getProduct_name());
		wvo.setPrice(svo.getPrice());
		wvo.setQuantity(svo.getQuantity());
		wvo.setImage(svo.getImage());
		
		int result = wdao.addtoWish(wvo);
		
		JSONObject obj = new JSONObject();
		
        obj.put("wishresult", result);
        obj.put("msg", "その物品がウィッシュリストに入っています。");
        
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

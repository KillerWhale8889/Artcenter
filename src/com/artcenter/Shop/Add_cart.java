package com.artcenter.Shop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.CartDAO;
import com.artcenter.DAO.ShopDAO;
import com.artcenter.VO.CartVO;
import com.artcenter.VO.ShopVO;

public class Add_cart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("user");
		ShopDAO sdao = ShopDAO.getInstance();
		
		System.out.println(num);
		ShopVO svo = sdao.viewCart(num);
		CartDAO cdao = CartDAO.getInstance();
		CartVO cvo = new CartVO();
		
		cvo.setUserid(userid);
		cvo.setProduct_num(svo.getProduct_num());
		cvo.setProduct_name(svo.getProduct_name());
		cvo.setPrice(svo.getPrice());
		cvo.setQuantity(svo.getQuantity());
		cvo.setImage(svo.getImage());
		
		int result = cdao.addtoCart(cvo);
		
		JSONObject obj = new JSONObject();
		
        obj.put("cartresult", result);
        obj.put("msg", "その商品がカートに入っています。");
        
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

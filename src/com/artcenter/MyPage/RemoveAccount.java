package com.artcenter.MyPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.CartDAO;
import com.artcenter.DAO.SignDAO;
import com.artcenter.DAO.WishListDAO;
import com.artcenter.VO.CartVO;
import com.artcenter.VO.WishListVO;

public class RemoveAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		
		SignDAO sdao = SignDAO.getInstance();
		
		int signresult = sdao.removeAccount(email);
		
		
		
		JSONObject obj = new JSONObject();
		if (signresult == 1) {
			CartDAO cdao = CartDAO.getInstance();
			WishListDAO wdao = WishListDAO.getInstance();
			List<CartVO> searchcart = cdao.cartView(email);
			List<WishListVO> searchwish = wdao.wishlistView(email);
			
			if(searchcart != null) {
			cdao.removeAccount(email);
			wdao.removeAccount(email);
			}
			
			obj.put("msg", "脱退が成功的に行われました。");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			obj.put("msg", "退会に失敗しました。しばらくしてからもう一度ご利用ください。");

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

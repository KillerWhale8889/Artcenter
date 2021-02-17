package com.artcenter.Shop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.WishListDAO;

public class Remove_wishlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		WishListDAO wdao = WishListDAO.getInstance();
		int result = wdao.removeWishlist(num);
		
		JSONObject obj = new JSONObject();
		
		if(result == 1) {
			obj.put("msg", "その物品がウィッシュリストから削除されました。" );
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			obj.put("msg", "しばらくしてからもう一度試してください。");
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

package com.artcenter.Shop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.CartDAO;

public class Remove_cart implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		CartDAO cdao = CartDAO.getInstance();
		int result = cdao.removeCart(num);
		
		JSONObject obj = new JSONObject();
		System.out.println(result);
		
		if(result == 1) {
			obj.put("msg", "その物品がカートから削除されました。 " );
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

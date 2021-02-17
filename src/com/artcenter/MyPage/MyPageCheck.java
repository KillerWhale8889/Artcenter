package com.artcenter.MyPage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Utility;

public class MyPageCheck implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String email = request.getParameter("email");
		String pw = Utility.encoding(request.getParameter("pw"));
		
		SignDAO sdao = SignDAO.getInstance();
		
		int result = sdao.signIn(email, pw);
		
		JSONObject obj = new JSONObject();
		if(result == 1) {
			
			obj.put("msg", "本人確認が取れました。");
			obj.put("email", email);
			obj.put("pw", pw);
			obj.put("check", "ok");
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json,charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			} else {
				obj.put("msg", "パスワードが一致しません。");
				
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

}

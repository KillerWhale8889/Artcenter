package com.artcenter.Sign;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Utility;
import com.artcenter.VO.SignVO;

public class ForgotCertiCheck implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 
		String email = request.getParameter("email");
		String newpw = request.getParameter("newpw");
		String authKey = (String) request.getSession().getAttribute("AuthenticationKey");
		
		SignDAO sdao = SignDAO.getInstance();
		JSONObject obj = new JSONObject();
		HttpSession session = request.getSession();
		String resetpw = "";
		
		if(newpw.equals(authKey)) {
			
			resetpw = Utility.encoding(newpw);
			
			int result = sdao.newPassword(resetpw, email);
			
			
		} else {
			obj.put("msg", "臨時発行されたパスワードを確認してください。 ");
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		int result = sdao.signIn(email, resetpw);
		
		SignVO svo = new SignVO();
		svo = sdao.userName(email);
		
		if(result == 1) {
			session.setAttribute("user", email);
			session.setAttribute("username", svo);
			
			obj.put("msg", "臨時パスワードでログインされました。 セキュリティのため、マイページでパスワードを変更してください。 ");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (result == 0) {
			session.setAttribute("msg", "パスワードを確認してください。");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			session.setAttribute("msg", "メールアドレスを確認してください。");
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

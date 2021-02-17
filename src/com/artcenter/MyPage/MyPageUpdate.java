package com.artcenter.MyPage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Utility;
import com.artcenter.VO.SignVO;

public class MyPageUpdate implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
//		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String pw = Utility.encoding(request.getParameter("pw"));
		
		SignVO svo = new SignVO();
		
//		svo.setName(name);
		svo.setEmail(email);
		svo.setPassword(pw);
		
		SignDAO sdao = SignDAO.getInstance();
		JSONObject obj = new JSONObject();
		
		int result = sdao.mypageUpdate(svo);
		
		if (result == 1) {
			obj.put("msg", "情報修正が完了しました。" );
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json, charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			obj.put("msg", "情報の修正に失敗しました。しばらくしてからもう一度実行してください。" );
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

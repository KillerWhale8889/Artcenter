package com.artcenter.Sign;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Utility;
import com.artcenter.VO.SignVO;

public class Signin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("signin-email");
		String pw = Utility.encoding(request.getParameter("signin-password"));
			
		SignDAO sdao = SignDAO.getInstance();
		HttpSession session = request.getSession();
		
		int result = -1;
		result = sdao.signIn(email,pw);
		
		SignVO svo = new SignVO();
		svo = sdao.userName(email);
		
		if(result == 1) {
			session.setAttribute("user", email);
			session.setAttribute("username", svo);
			
			
			
		} else if (result == 0) {
			session.setAttribute("msg", "パスワードを確認してください。");
			
		} else {
			session.setAttribute("msg", "このメールアドレスがありません。");
			
		}

	}

}

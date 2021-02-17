package com.artcenter.Sign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Utility;
import com.artcenter.VO.SignVO;

public class Signup implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String name = request.getParameter("signup-username");
		String email = request.getParameter("signup-email");
		String pw = Utility.encoding(request.getParameter("signup-password"));
		
		SignVO svo = new SignVO();
		
		svo.setName(name);
		svo.setEmail(email);
		svo.setPassword(pw);
		
		SignDAO sdao = SignDAO.getInstance();
		
		int result = 0;
		result = sdao.signUp(svo);
		
		request.setAttribute("signup_result", result);

	}

}

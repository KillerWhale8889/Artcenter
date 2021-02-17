package com.artcenter.MyPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;
import com.artcenter.VO.SignVO;

public class MyPageOK implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		SignDAO sdao = SignDAO.getInstance();
		try {
			SignVO vo = sdao.mypageView(email);
			request.setAttribute("myprofile", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

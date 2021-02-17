package com.artcenter.Review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ReviewDAO;

public class Review_delete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		ReviewDAO rdao = ReviewDAO.getInstance();
		int result = rdao.reviewDelete(num);
		
		request.setAttribute("Deleteresult", result);

	}

}

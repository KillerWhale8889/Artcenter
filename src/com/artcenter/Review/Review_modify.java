package com.artcenter.Review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ReviewDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ReviewVO;
import com.artcenter.VO.pageVO;

public class Review_modify implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		ReviewDAO rdao = ReviewDAO.getInstance();
		
		Criteria cri = new Criteria();
		
		int pagenum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null) {
		pagenum = Integer.parseInt(request.getParameter("pageNum"));
		amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		int tcount = rdao.reviewCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		
		ReviewVO rvo = rdao.reviewContent(num);
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("modify", rvo);
	}

}

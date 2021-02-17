package com.artcenter.Review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ReviewDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ReviewVO;
import com.artcenter.VO.pageVO;

public class Review implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ReviewDAO rdao = ReviewDAO.getInstance();
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		Criteria cri = new Criteria();
		
		int tcount= 0;
		int pagenum = 1;
		int amount = 10;
		
		String sel,word,query = "";
		pageVO pvo = null;
		
		if(request.getParameter("pageNum") != null) {
			pagenum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
			}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		list = rdao.getListWithPaging(cri);
		tcount = rdao.reviewCount();
		
		
		pvo = new pageVO(cri, tcount);
		
		
		
		if(request.getParameter("sel") != null && request.getParameter("word") != null) {
			
			sel = request.getParameter("sel");
			word = request.getParameter("word");
			
			query = sel+ " like '%" + word + "%'";
			
	
		
		list= rdao.getSerchListWithPaging (cri, query);
		tcount = rdao.reviewCount(query);
		
		pvo = new pageVO(cri, tcount);
		
		request.setAttribute("sel", sel);
		request.setAttribute("word", word);
		
		}
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("list", list);
		request.setAttribute("tcount", tcount);

	}

}

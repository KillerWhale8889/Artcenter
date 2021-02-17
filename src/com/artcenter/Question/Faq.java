package com.artcenter.Question;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.FaqDAO;
import com.artcenter.VO.FaqVO;

public class Faq implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		FaqDAO fdao = FaqDAO.getInstance();
		
		String word,query = "";
		int tcount= 0;
		
		List<FaqVO> list = new ArrayList<FaqVO>();
		list = fdao.faqList();
		
		if(request.getParameter("word") != null) {
			
			word = request.getParameter("word");
			
			query = " like '%" + word + "%'";
			
			
		tcount = fdao.questionCount(query);
		list = fdao.faqList(query);
		request.setAttribute("word", word);
		
		}
		
		request.setAttribute("list", list);
		request.setAttribute("tcount", tcount);
	}

}

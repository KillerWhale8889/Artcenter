package com.artcenter.Notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NoticeDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.NoticeVO;
import com.artcenter.VO.pageVO;

public class Notice implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Criteria cri = new Criteria();
		
		int tcount= 0;
		int pagenum = 1;
		int amount = 10;
		
		String word,query = "";
		pageVO pvo = null;
		
		if(request.getParameter("pageNum") != null) {
			pagenum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
			}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		list = ndao.getListWithPaging(cri);
		tcount = ndao.noticeCount();
		
		
		pvo = new pageVO(cri, tcount);
		
		
		
		if(request.getParameter("word") != null) {
			
			word = request.getParameter("word");
			
			query = " like '%" + word + "%'";
			
	
		
		list= ndao.getSerchListWithPaging (cri, query);
		tcount = ndao.noticeCount(query);
		
		pvo = new pageVO(cri, tcount);
		
		request.setAttribute("word", word);
		
		}
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("list", list);
		request.setAttribute("tcount", tcount);

	}

}

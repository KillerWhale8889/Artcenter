package com.artcenter.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NoticeDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.NoticeVO;
import com.artcenter.VO.ReviewVO;
import com.artcenter.VO.pageVO;

public class Notice_content implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		Criteria cri = new Criteria();
		
		int pagenum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null) {
		pagenum = Integer.parseInt(request.getParameter("pageNum"));
		amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		int tcount = ndao.noticeCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		
		ndao.readCount(num);
		NoticeVO preview = ndao.preView(num);
		NoticeVO nextview = ndao.nextView(num);
		
		NoticeVO result = ndao.noticeContent(num);
		
		request.setAttribute("pageMaker", pvo);		
		request.setAttribute("view", result);
		request.setAttribute("preview", preview);
		request.setAttribute("nextview", nextview);

	}

}

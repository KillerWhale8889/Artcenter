package com.artcenter.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NoticeDAO;

public class Notice_delete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		
		NoticeDAO rdao = NoticeDAO.getInstance();
		int result = rdao.noticeDelete(num);
		
		request.setAttribute("Deleteresult", result);

	}

}

package com.artcenter.Footer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NewsDAO;
import com.artcenter.DAO.SignDAO;
import com.artcenter.VO.NewsVO;

public class Subscribe implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsDAO ndao = NewsDAO.getinstance();
		
		List<NewsVO> list = ndao.subscriber();
		
		request.setAttribute("subs_list", list);

	}

}

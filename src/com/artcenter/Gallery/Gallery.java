package com.artcenter.Gallery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.GalleryDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.GalleryVO;

public class Gallery implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		GalleryDAO gdao = GalleryDAO.getInstance();
		Criteria cri = new Criteria();
		List<GalleryVO> list = gdao.getListWithPaging(cri);
		
		request.setAttribute("list",list);
	}

}

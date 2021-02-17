package com.artcenter.Review;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ReviewDAO;
import com.artcenter.DAO.SignDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ReviewVO;
import com.artcenter.VO.SignVO;
import com.artcenter.VO.pageVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Review_writepro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("reviewUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 50*1024*1024;
		
		MultipartRequest multi = null;
		String title, content, appfile, writer = null;
		
		
		try {
			multi = new MultipartRequest(request, path, uploadSizeLimit, enctype, new DefaultFileRenamePolicy());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		appfile = multi.getFilesystemName("appfile");
		writer = multi.getParameter("writer");
		
		Criteria cri = new Criteria();
		
		int pagenum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null) {
		pagenum = Integer.parseInt(request.getParameter("pageNum"));
		amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		ReviewVO rvo = new ReviewVO();
		
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setAppfile(appfile);
		rvo.setWriter(writer);
		
		ReviewDAO rdao = ReviewDAO.getInstance();
		
		int tcount = rdao.reviewCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		int result = rdao.reviewInsert(rvo);
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("result", result);
		request.setAttribute("tcount", tcount);

		

	}

}

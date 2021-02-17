package com.artcenter.Review;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ReviewDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ReviewVO;
import com.artcenter.VO.pageVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Review_modifypro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("reviewUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 50*1024*1024;
		
		MultipartRequest multi = null;
		String title, content, appfile, writer = null;
		int num ;
		
		
		try {
			multi = new MultipartRequest(request, path, uploadSizeLimit, enctype, new DefaultFileRenamePolicy());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		String rnum = multi.getParameter("num");
		num = Integer.parseInt(multi.getParameter("num"));
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
		
		rvo.setNum(num);
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setAppfile(appfile);
		rvo.setWriter(writer);
		
		ReviewDAO rdao = ReviewDAO.getInstance();
		
		int tcount = rdao.reviewCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		int result = rdao.reviewModify(rvo);
		
		
		ReviewVO mrvo = rdao.reviewContent(rnum);
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("view", mrvo);
		request.setAttribute("modifyresult", result);

	}

}

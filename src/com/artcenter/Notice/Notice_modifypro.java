package com.artcenter.Notice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NoticeDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.NoticeVO;
import com.artcenter.VO.pageVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Notice_modifypro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("noticeUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 50*1024*1024;
		
		MultipartRequest multi = null;
		String title, content, appfile = null;
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
		
		Criteria cri = new Criteria();
		
		int pagenum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum") != null) {
		pagenum = Integer.parseInt(request.getParameter("pageNum"));
		amount = Integer.parseInt(request.getParameter("amount"));
		}
		
		cri.setPageNum(pagenum);
		cri.setAmount(amount);
		
		NoticeVO nvo = new NoticeVO();
		
		nvo.setNum(num);
		nvo.setTitle(title);
		nvo.setContent(content);
		nvo.setAppfile(appfile);
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		
		int tcount = ndao.noticeCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		int result = ndao.noticeModify(nvo);
		
		
		NoticeVO mnvo = ndao.noticeContent(rnum);
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("view", mnvo);
		request.setAttribute("modifyresult", result);

	}

}

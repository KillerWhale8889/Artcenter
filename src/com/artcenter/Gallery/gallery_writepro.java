package com.artcenter.Gallery;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.GalleryDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.GalleryVO;
import com.artcenter.VO.pageVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class gallery_writepro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("galleryUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 50*1024*1024;
		
		MultipartRequest multi = null;
		String title, image, section, artist = null;
		
		
		try {
			multi = new MultipartRequest(request, path, uploadSizeLimit, enctype, new DefaultFileRenamePolicy());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		title = multi.getParameter("title");
		image = multi.getFilesystemName("appfile");
		section = multi.getParameter("section");
		artist = multi.getParameter("artist");
		
		
		GalleryVO gvo = new GalleryVO();
		
		gvo.setTitle(title);
		gvo.setImage(image);
		gvo.setSection(section);
		gvo.setArtist(artist);
		
		GalleryDAO gdao = GalleryDAO.getInstance();
		
		int result = gdao.galleryUpload(gvo);
		
		request.setAttribute("result", result);
		

	}

}

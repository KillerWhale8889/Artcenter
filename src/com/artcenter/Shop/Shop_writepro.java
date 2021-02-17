package com.artcenter.Shop;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ShopDAO;
import com.artcenter.Util.Criteria;
import com.artcenter.VO.ShopVO;
import com.artcenter.VO.pageVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Shop_writepro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("shopUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 1000*1024*1024;
		
		MultipartRequest multi = null;
		String product_name, content, appfile= null;
		int price, quantity = 0;
		
		try {
			multi = new MultipartRequest(request, path, uploadSizeLimit, enctype, new DefaultFileRenamePolicy());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		product_name = multi.getParameter("product_name");
		content = multi.getParameter("content");
		price = Integer.parseInt(multi.getParameter("price"));
		quantity = Integer.parseInt(multi.getParameter("quantity"));
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
		
		ShopVO svo = new ShopVO();
		
		svo.setProduct_name(product_name);
		svo.setContent(content);
		svo.setPrice(price);
		svo.setQuantity(quantity);
		svo.setImage(appfile);
		
		ShopDAO sdao = ShopDAO.getInstance();
		
		int tcount = sdao.shopCount();
		
		pageVO pvo = new pageVO(cri, tcount);
		int result = sdao.shopInsert(svo);
		
		request.setAttribute("pageMaker", pvo);
		request.setAttribute("result", result);
		request.setAttribute("tcount", tcount);
		

	}

}

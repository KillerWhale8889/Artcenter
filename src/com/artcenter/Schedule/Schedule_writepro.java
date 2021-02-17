package com.artcenter.Schedule;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ScheduleDAO;
import com.artcenter.VO.ExhibitionVO;
import com.artcenter.VO.PerformanceVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Schedule_writepro implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ScheduleDAO sdao = ScheduleDAO.getInstance();
		
		ServletContext svc = request.getServletContext();
		String path = svc.getRealPath("pe_scheduleUpload");
		String enctype = "utf-8";
		int uploadSizeLimit = 50*1024*1024;
		
		MultipartRequest multi = null;
		String title, content, appfile, begindate, enddate  = null;
		int result= 0;
		
		
		try {
			multi = new MultipartRequest(request, path, uploadSizeLimit, enctype, new DefaultFileRenamePolicy());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String beginmonth= "";
		String beginday="";
		if(Integer.parseInt(multi.getParameter("beginmonth")) < 10) {
			beginmonth= "0" + multi.getParameter("beginmonth");
		} else {
			beginmonth= multi.getParameter("beginmonth");
		}
		
		if(Integer.parseInt(multi.getParameter("beginday")) < 10) {
			beginday= "0" + multi.getParameter("beginday");
		}else {
			beginday= multi.getParameter("beginday");
		}
		
		String endmonth = "";
		String endday="";
		if(Integer.parseInt(multi.getParameter("endmonth")) < 10) {
			endmonth= "0" + multi.getParameter("endmonth");
		}else {
			endmonth= multi.getParameter("endmonth");
		}
		if(Integer.parseInt(multi.getParameter("endday")) < 10) {
			endday= "0" + multi.getParameter("endday");
		} else {
			endday= multi.getParameter("endday");
		}
		
		
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		appfile = multi.getFilesystemName("appfile");
		begindate = multi.getParameter("beginyear")+"-" + beginmonth +"-" + beginday;
		enddate = multi.getParameter("endyear") +"-" + endmonth +"-" + endday;
		
		String sel = multi.getParameter("sel");
		
		System.out.println(sel);
		
		if(sel.equals("performance")) {
			PerformanceVO vo = new PerformanceVO();
			
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImage(appfile);
			vo.setBegindate(begindate);
			vo.setEnddate(enddate);
			
			
			result = sdao.performanceInsert(vo);
			
		} else if (sel.equals("exhibition")) {
			ExhibitionVO vo = new ExhibitionVO();

			vo.setTitle(title);
			vo.setContent(content);
			vo.setImage(appfile);
			vo.setBegindate(begindate);
			vo.setEnddate(enddate);
			
			result = sdao.exhibitionInsert(vo);
			
		} else {
			
		}
		
		request.setAttribute("result", result);
		
	}

}

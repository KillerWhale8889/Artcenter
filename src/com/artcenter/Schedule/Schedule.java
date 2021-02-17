package com.artcenter.Schedule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ScheduleDAO;
import com.artcenter.VO.ScheduleVO;

public class Schedule implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ScheduleDAO sdao = ScheduleDAO.getInstance();
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		
		Calendar cal = Calendar.getInstance();
		 
		//현재 년도, 월, 일
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int day = cal.get ( cal.DATE ) ;
		
//		String pick_month = request.getParameter("month");
//		if(pick_month != "") {
//			JSONObject obj = new JSONObject();
//			obj.put("month", "0"+pick_month);
//			obj.put("year", year);
//			obj.put("day", day);
//			
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("application/x-json, charset=utf-8");
//			try {
//				response.getWriter().print(obj);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}else {
			
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
			String today = format.format(cal.getTime());
			
			list = sdao.pe_List(today);
//		}
		
		if (month <10) {
			request.setAttribute("month", "0"+month);
		} else {
			request.setAttribute("month", month);
		}
		
		request.setAttribute("year", year);
		
		
		request.setAttribute("day", day);
		request.setAttribute("schedule_list", list);
		
		
		
		
		
	}

}

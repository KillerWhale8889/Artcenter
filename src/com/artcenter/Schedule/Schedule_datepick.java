package com.artcenter.Schedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.ScheduleDAO;
import com.artcenter.VO.ScheduleVO;

public class Schedule_datepick implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ScheduleDAO sdao = ScheduleDAO.getInstance();
		
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		String datepick = year+"-"+month+"-"+day;
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(datepick);
		
		list = sdao.pe_dateList(datepick);
		
		System.out.println(list.size());
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("schedule_list", list);

	}

}

package com.artcenter.Sign;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.SignDAO;

public class ForgotChek implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("remail");
		
		SignDAO sdao = SignDAO.getInstance();
		
		int result = sdao.emailCheck(email);
		
		JSONObject obj = new JSONObject();
		
		obj.put("mailcheck", result);
		
		response.setContentType("application/x-json,charset=utf-8");
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

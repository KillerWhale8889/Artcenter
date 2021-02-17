package com.artcenter.Sign;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;

public class SignCertiCheck implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String certinum = request.getParameter("certinumber");
		String authKey = (String) request.getSession().getAttribute("AuthenticationKey");
		
		JSONObject obj = new JSONObject();
		
		if(certinum.equals(authKey)) {
		
		obj.put("msg", "本人認証が完了しました。");
		obj.put("certinumber", certinum);
		obj.put("authKey", authKey);
		obj.put("check", "ok");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json,charset=utf-8");
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // obj에 담은 값이 ajax success 부분으로 넘어간다
		
		
		} else {
			obj.put("msg", "認証番号を確認してください。");
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/x-json,charset=utf-8");
			try {
				response.getWriter().print(obj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // obj에 담은 값이 ajax success 부분으로 넘어간다
			
		}

	}

}

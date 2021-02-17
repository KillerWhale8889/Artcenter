package com.artcenter.Footer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;
import com.artcenter.DAO.NewsDAO;
import com.artcenter.VO.NewsVO;

public class Newsletter implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sub_email = request.getParameter("subs");
		
		NewsVO nvo = new NewsVO();
		
		nvo.setSub_email(sub_email);
		
		NewsDAO ndao = NewsDAO.getinstance();
		
		int result = ndao.subNewletter(nvo);
		
		//mail server 설정
        String host = "smtp.naver.com";
        String user = "nooonaa@naver.com"; //자신의 네이버 계정
        String password = "zktxns4fkd!";//자신의 네이버 패스워드
        
        //메일 받을 주소
        String to_email = sub_email;
        
        //SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
   
       
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        
        //email 전송
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user, "MJ "));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            
            //메일 제목
            msg.setSubject("MJ ArtCenterニュースレターの購読を感謝いたします。");
            //메일 내용
            msg.setText("本メールは、ニュースレター購読者に限り送信されます。");
            
            Transport.send(msg);
            System.out.println("이메일 전송완료 ");
            
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
		
		JSONObject obj = new JSONObject();
		
		obj.put("newsletter", result);
		obj.put("msg", "購読申し込みが完了しました。 ");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json,charset=utf-8");
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

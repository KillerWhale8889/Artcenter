package com.artcenter.Sign;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.artcenter.Command.Command;

public class ForgotCerti implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String email = request.getParameter("email");
		
		//mail server 설정
        String host = "smtp.naver.com";
        String user = "nooonaa@naver.com"; //자신의 네이버 계정
        String password = "zktxns4fkd!";//자신의 네이버 패스워드
        
        //메일 받을 주소
        String to_email = email;
        
        //SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        
        //인증 번호 생성기
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        String AuthenticationKey = temp.toString();
        System.out.println(AuthenticationKey);
        
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
            msg.setSubject("MJ ArtCenterで臨時パスワードを送信します。");
            //메일 내용
            msg.setText("ログイン入力ウィンドウに以下の臨時パスワードを入力してください。\n臨時パスワード:"+temp);
            
            Transport.send(msg);
            System.out.println("이메일 전송완료 ");
            
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        HttpSession saveKey = request.getSession();
        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
        
        JSONObject obj = new JSONObject();
        obj.put("msg", "臨時パスワードがメールに送信されました。");
        
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

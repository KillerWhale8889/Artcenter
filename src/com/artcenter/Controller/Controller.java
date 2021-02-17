package com.artcenter.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artcenter.Footer.Newsletter;
import com.artcenter.Footer.Subscribe;
import com.artcenter.Gallery.Gallery;
import com.artcenter.Gallery.gallery_writepro;
import com.artcenter.Main.Artcenter;
import com.artcenter.MyPage.MyPageCheck;
import com.artcenter.MyPage.MyPageOK;
import com.artcenter.MyPage.MyPageUpdate;
import com.artcenter.MyPage.RemoveAccount;
import com.artcenter.Notice.Notice;
import com.artcenter.Notice.Notice_content;
import com.artcenter.Notice.Notice_delete;
import com.artcenter.Notice.Notice_modify;
import com.artcenter.Notice.Notice_modifypro;
import com.artcenter.Notice.Notice_writepro;
import com.artcenter.Question.Faq;
import com.artcenter.Review.Review;
import com.artcenter.Review.Review_content;
import com.artcenter.Review.Review_delete;
import com.artcenter.Review.Review_modify;
import com.artcenter.Review.Review_modifypro;
import com.artcenter.Review.Review_writepro;
import com.artcenter.Schedule.Schedule;
import com.artcenter.Schedule.Schedule_datepick;
import com.artcenter.Schedule.Schedule_writepro;
import com.artcenter.Shop.Add_cart;
import com.artcenter.Shop.Add_wishlist;
import com.artcenter.Shop.Cart;
import com.artcenter.Shop.Coupon;
import com.artcenter.Shop.Remove_cart;
import com.artcenter.Shop.Remove_wishlist;
import com.artcenter.Shop.Shop;
import com.artcenter.Shop.Shop_writepro;
import com.artcenter.Shop.Wishlist;
import com.artcenter.Sign.ForgotCerti;
import com.artcenter.Sign.ForgotCertiCheck;
import com.artcenter.Sign.ForgotChek;
import com.artcenter.Sign.SignCerti;
import com.artcenter.Sign.SignCertiCheck;
import com.artcenter.Sign.Signin;
import com.artcenter.Sign.Signup;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO (request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO (request, response);
	}
	
	protected void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		switch(com) {
			case "/artcenter.do":
				new Artcenter().execute(request, response);
				viewPage = "index.jsp";
				break;
			
			case "/sign-certi.do":
				new SignCerti().execute(request, response);
				break;
			
			case "/sign-certiCheck.do":
				new SignCertiCheck().execute(request, response);
				break;
				
			case "/signup.do":
				new Signup().execute(request, response);
				viewPage = "artcenter.do";
				break;	
			
			case "/signin.do":
				new Signin().execute(request, response);
				viewPage = "artcenter.do";
				break;
			
			case "/signout.do":
				viewPage = "sign/signout.jsp";
				break;
				
			case "/terms.do":
				viewPage = "sign/terms.jsp";
				break;
				
			case "/forgot-emailChek.do":
				new ForgotChek().execute(request, response);
				break;
				
			case "/forgotcerti.do":
				new ForgotCerti().execute(request, response);
				break;
				
			case "/forgotcerticheck.do":
				new ForgotCertiCheck().execute(request, response);
				break;
				
			case "/login.do":
				viewPage = "sign/login.jsp";
				break;
			
			case "/map.do":
				viewPage = "map/map.jsp";
				break;
			
			case "/review.do":
				new Review().execute(request, response);
				viewPage = "review/review.jsp";
				break;
			
			case "/review_search.do":
				new Review().execute(request, response);
				viewPage = "review.do";
				break;
				
			case "/review_write.do":
				viewPage = "review/review_write.jsp";
				break;
				
			case "/review_writepro.do":
				new Review_writepro().execute(request, response);
				viewPage = "review.do";
				break;	
			
			case "/review_content.do":
				new Review_content().execute(request, response);
				viewPage = "review/review_content.jsp";
				break;
			
			case "/review_modify.do":
				new Review_modify().execute(request, response);
			    viewPage = "review/review_modify.jsp";
			    break;
			    
			case "/review_modifypro.do":
				new Review_modifypro().execute(request, response);
				viewPage = "review/review_content.jsp";
				break;
				
			case "/review_delete.do":
				new Review_delete().execute(request, response);
				viewPage = "review.do";
				break;
			
			case "/mypage.do":
				viewPage = "myPage/mypageCheck.jsp";
				break;
			
			case "/mypageCheck.do":
				new MyPageCheck().execute(request, response);
				break;
			
			case "/mypageok.do":
				new MyPageOK().execute(request, response);
				viewPage = "myPage/mypageOK.jsp";
				break;
				
			case "/adminpage.do":
				viewPage= "admin/admin.jsp";
				break;
			
			case "/updateacc.do":
				new MyPageUpdate().execute(request, response);
				break;
				
			case "/remove_account.do":
				new RemoveAccount().execute(request, response);
				break;
				
			case "/gallery.do":
				new Gallery().execute(request, response);
				viewPage = "gallery/gallery.jsp";
				break;	
				
			case "/gallery_write.do":
				viewPage = "gallery/gallery_write.jsp";
				break;
			
			case "/gallery_writepro.do":
				new gallery_writepro().execute(request, response);
				viewPage = "gallery.do";
				break;
				
			case "/shop.do":
				new Shop().execute(request, response);
				viewPage = "shop/shop.jsp";
				break;
				
			case "/shop_write.do":
				viewPage = "shop/shop_write.jsp";
				break;
			
			case "/shop_writepro.do":
				new Shop_writepro().execute(request, response);
				viewPage = "shop.do";
				break;
				
			case "/cart.do":
				new Cart().execute(request, response);
				viewPage = "shop/cart.jsp";
				break;
				
			case "/add_cart.do":
				new Add_cart().execute(request, response);
				break;
				
			case "/remove_cart.do":
				new Remove_cart().execute(request, response);
				break;
				
			case "/coupon.do":
				new Coupon().execute(request, response);
				break;
				
			case "/wishlist.do":
				new Wishlist().execute(request, response);
				viewPage = "shop/wishlist.jsp";
				break;
				
			case "/add_wishlist.do":
				new Add_wishlist().execute(request, response);
				break;
				
			case "/remove_wish.do":
				new Remove_wishlist().execute(request, response);
				break;
				
//			case "/checkout.do":
//				viewPage = "shop/checkout.jsp";
//				break;
				
			case "/order.do":
				viewPage = "shop/order.jsp";
				break;
				
			case "/listinfo.do":
				new Schedule().execute(request, response);
				viewPage = "pe_schedule/schedule.jsp";
				break;
			
			case "/datepicklist.do":
				new Schedule_datepick().execute(request, response);
				viewPage = "pe_schedule/schedule.jsp";
				break;
				
			case "/schedule_write.do":
				viewPage = "pe_schedule/schedule_write.jsp";
				break;
			
			case "/schedule_writepro.do":
				new Schedule_writepro().execute(request, response);
				viewPage= "listinfo.do";
				break;
			
			case "/tickecting.do":
				viewPage = "ticketing/ticket.jsp";
				break;
				
			case "/notice.do":
				new Notice().execute(request, response);
				viewPage = "notice/notice.jsp";
				break;
				
			case "/notice_write.do":
				viewPage = "notice/notice_write.jsp";
				break;
				
			case "/notice_writepro.do":
				new Notice_writepro().execute(request, response);
				viewPage = "notice.do";
				break;	
			
			case "/notice_content.do":
				new Notice_content().execute(request, response);
				viewPage = "notice/notice_content.jsp";
				break;
			
			case "/notice_modify.do":
				new Notice_modify().execute(request, response);
			    viewPage = "notice/notice_modify.jsp";
			    break;
			    
			case "/notice_modifypro.do":
				new Notice_modifypro().execute(request, response);
				viewPage = "notice/notice_content.jsp";
				break;
				
			case "/notice_delete.do":
				new Notice_delete().execute(request, response);
				viewPage = "notice.do";
				break;	
				
				
			case "/faq.do":
				new Faq().execute(request, response);
				viewPage = "qna/faq.jsp";
				break;
				
			case "/newsletter.do":
				new Newsletter().execute(request, response);
				break;
				
			case "/newsletterlist.do":
				viewPage = "newsletter/newsletter.jsp";
				break; 
				
			case "/subscriber.do":
				new Subscribe().execute(request, response);
				viewPage = "newsletter/subscribe.jsp";
				break;
				
			case "/newsletter_write.do":
				viewPage = "newsletter/news_write.jsp";
				break;
			
			case "/newsletter_send.do":
				viewPage= "newsletter.do";
				break;
		
		}
		
		if(viewPage != null) {
			RequestDispatcher disp = request.getRequestDispatcher(viewPage);
			disp.forward(request, response);
			
		}
	}

}

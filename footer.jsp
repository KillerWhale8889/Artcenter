<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
             <!-- Start gallery Feed  -->
    <div class="shop-box">
        <div class="main-instagram owl-carousel owl-theme">
        <c:forEach var="glist" items="${gallery_list }">
            <div class="item">
                <div class="ins-inner-box">
                    <img src="galleryUpload/${glist.image }" alt="" />
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
        </c:forEach>
         
            
        </div>
    </div>
    <!-- End Instagram Feed  -->
     

    <!-- Start Footer  -->
    <footer>
        <div class="footer-main">
            <div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>営業時間 </h3>
							<ul class="list-time">
								<li> 平日: 8am - 5pm</li> 
								<li> 土曜日: 10 am - 8pm</li>
								 <li> 日曜日: <span>閉じる </span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>ニュースレター </h3>
							<form class="newsletter-box">
								<div class="form-group">
									<input class="" type="email" name="email" id="sub_email" placeholder="メールアドレス" />
									<i class="fa fa-envelope"></i>
								</div>
								<button class="btn hvr-hover" id="sub_newsletter" type="button">購読する </button>
							</form>
							
							<script>
								$(function(){
									$("#sub_newsletter").on("click", function(e){
										e.preventDefault();
										
										var subs = $.trim($("#sub_email").val());
										
										if($.trim($("#sub_email").val()) == ""){
											alert("メールアドレスを入力してください。");
											$("#ub_email").val("").focus();
											return false;
											
										} else {
										$.ajax ({
											data: "post",
											dataType: "json",
											async: false,
											data: {"subs": subs},
											url: "newsletter.do",
											success: function(data){
												alert (data.msg);
												
											}, error: function(){
												alert ("購読申請が完了していません。しばらくしてからもう一度申請してください。");
											}
											
											
										})
										
										}
										
									});
								});
							
							</script>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-top-box">
                            <h3>お問い合わせ先</h3>
                            
                                    <p><i class="fas fa-map-marker-alt"></i> 住所: 地球のどこか美しい街 </p>
                               
                                
                                    <p><i class="fas fa-phone-square"></i> 電話番号: <a href="tel:+821033096497" class=contact>+82-10-3309-6497</a></p>
                                
                                
                                    <p><i class="fas fa-envelope"></i> メール: <a href="mailto:killerwhale8889@gmail.com" class=contact>killerwhale8889@gmail.com</a></p>
                                
                        </div>
                    </div>
				</div>
				<hr>
                
            </div>
        </div>
    </footer>
    <!-- End Footer  -->

    <!-- Start copyright  -->
    <div class="footer-copyright">
        <p class="footer-company">All Rights Reserved. &copy; 2020 <a href="#">Art Gallery</a> Design By : Sienna
          </p>
    </div>
    <!-- End copyright  -->

    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

    
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="js/jquery.superslides.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/inewsticker.js"></script>
    <script src="js/bootsnav.js."></script>
    <script src="js/images-loded.min.js"></script>
    <script src="js/isotope.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/baguetteBox.min.js"></script>
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script> -->
    <script src="js/search.js"></script>
    <script src="js/registerlogin.js"></script>
    
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<!-- Basic -->

<head profile="http://www.w3.org/2005/10/profile">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- ALL JS FILES -->
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="js/jquery.js"></script> 
	<script src="js/jquery.nice-select.js"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery.colorbox.js"></script>
  	
	

    <!-- Site Metas -->
    <title>2020 MJ Art Center </title>
    
    <link rel="icon" type="image/png" href="http://example.com/myicon.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="css/colorbox.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/style.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    

</head>

<body>
    <!-- Start Main Top -->
    <div class="main-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="sns bootsnav">
                    <ul>
                            <li><a href="#">FaceBook</a></li>
                            <li><a href="#">Twitter</a></li>
                            <li><a href="#">Instagram</a></li>
                            <li class="navbar dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Shop </a>
                            <ul class="dropdown-menu sns_dropdown">
								<li><a href="shop.do">Shop </a></li>
								<li><a href="cart.do">Cart </a></li>
                                <li><a href="wishlist.do">WishList </a></li>
                            </ul>
                        </li>
                        </ul>
                        </div>
                </div>
                        
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="login-box">
						<c:choose>
						<c:when test ="${empty user}">
                        <ul class="main-nav reg-sign">
                            <li><a class="signin" href="#0">ログイン </a> </li>
                            <li><a class="signup" href="#0">会員加入 </a> </li>
                        </ul>
                        </c:when>
                        
                        <c:when test ="${not empty user && user eq 'admin@artcenter.com'}">
                        <ul class="reg-sign">
                            <li><a class="signout" id="signout" href="signout.do">ログアウト </a> </li>
                            <li><a class="adminpage" href="adminpage.do">管理者ページ </a> </li>
                        </ul>
                        </c:when>
                        
                        <c:when test ="${not empty user}">
                        <ul class="reg-sign">
                            <li><a class="signout" id="signout" href="signout.do">ログアウト </a> </li>
                            <li><a class="mypage" href="mypage.do?email=${user }">マイページ </a> </li>
                        </ul>
                        </c:when>
                        
                        </c:choose>
					</div>
					
					
					
					<script>
					
						$(function(){
							$("#signout").on("click",function(){
								session.invalidate();
								response.sendRedirect("artcenter.do");
								
							})
						})
					
					</script>
					
                    
                    <div class="text-slid-box">
                        <div id="offer-box" class="carouselTicker">
                            <ul class="offer-box">
                                <li><a href="#">
                                    르네 마그리트 특별전 
                                    </a>    
                                </li>
                                <li><a href="#">
                                    장 미쉘 바스키아거리 영웅, 예술전 
                                    </a>
                                </li>
                                <li><a href="#">
                                    To the moon with snoopy 
                                    </a>
                                </li>
                                <li><a href="#">
                                    아트인더컬러 (ART in the COLOR) 
                                    </a>
                                </li>
                                <li><a href="#">
                                    빛의 벙커 : 반 고흐 
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Main Top -->

    <!-- Start Main Top -->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="artcenter.do">
                    <!-- <img src="images/logo.png" class="logo" alt=""> -->
                    Art Center</a>
                </div>
                <!-- End Header Navigation -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="dropdown">
                            <a href="index.jsp" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">アートセンター </a>
                            <ul class="dropdown-menu">
								<li><a href="#">紹介ページ  </a></li>
								<li><a href="#">運営目的 </a></li>
                                <li><a href="map.do">アクセス </a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">公演•展示 </a>
                            <ul class="dropdown-menu">
								<li><a href="listinfo.do">日程案内 </a></li>
								<li><a href="tickecting.do">チケット予約 </a></li>
                                <li><a href="review.do">公演レビュー </a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">教育•講座 </a>
                            <ul class="dropdown-menu">
								<li><a href="#">講座案内 </a></li>
                                <li><a href="#">受講申し込み </a></li>
                                <li><a href="#">私の講座 </a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">施設案内 </a>
                            <ul class="dropdown-menu">
								<li><a href="#">貸館案内 </a></li>
								<li><a href="#">貸館申請 </a></li>
                                <li><a href="#">貸観控股 </a></li>
                                <li><a href="#">貸館料 </a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">カスタマーセンター </a>
                            <ul class="dropdown-menu">
								<li><a href="notice.do">お知らせ </a></li>
                                <li><a href="faq.do">よくある質問  </a></li>
                                <li><a href="newsletterlist.do">ニュースレター </a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gallery.do">ギャラリー </a>
                        
                        </li>
                        
                    </ul>
                </div>
                
                <!-- /.navbar-collapse -->
            

                <!-- Start Atribute Navigation -->
   
 <!--   <div id="page">
    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
    
    
  		<div id="toggle">
  		<div class="bar">
  			<a href="#">
    		<i class="fa fa-search"></i></a>
    		</div>
  		</div>
  		<section id="overlay">
    		<nav class=search2>
       			<div class="container">
            		<div class="input-group">
            			<form>		
                			<input type="text" class="form-control2" placeholder="내용을 입력하세요 ">
                			<input type="hidden" class="search_submit">
                		</form>	
            		</div>
        	   </div>
    	  </nav>
  		</section>
  		</div>
	</div>  -->
                <!-- End Atribute Navigation -->
            </div>
  
        </nav>
        <!-- End Navigation -->
    </header>
    <!-- End Main Top -->
    
    
    
    
    <!-- register & login modal -->
    
    <div class="user-modal">
		<div class="user-modal-container">
			<ul class="switcher">
				<li><a href="#0">ログイン </a></li>
				<li><a href="#0">会員加入 </a></li>
			</ul>

			<div id="login">
				<form class="form" id="signin_form" method="post" action="signin.do">
					<p class="fieldset">
						<label class="image-replace email" for="signin-email">メール</label>
						<input class="full-width has-padding has-border" name= "signin-email" id="signin-email" type="email" placeholder="メール">
					</p>

					<p class="fieldset">
						<label class="image-replace password" for="signin-password">パスワード</label>
						<input class="full-width has-padding has-border" name="signin-password" id="signin-password" type="password"  placeholder="パスワード">
						<a href="#0" class="hide-password">暗号表示</a>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="remember-me" checked>
						<label for="remember-me">次も記憶する</label>
					</p>

					<p class="fieldset">
						<input class="full-width" id="signin_submit" type="submit" value="ログイン">
					</p>
				</form>
				
				<p class="form-bottom-message"><a href="#0">パスワードをお忘れですか？</a></p>
				<!-- <a href="#0" class="close-form">Close</a> -->
			</div>




			<div id="signup">
				<form class="form" id="signup_form" name="signup_form" method="post" action="signup.do" onsubmit="return signupCheck();">
					<p class="fieldset">
						<label class="image-replace username" for="signup-username">名前</label>
						<input class="full-width has-padding has-border" name="signup-username" id="signup-username" type="text" placeholder="名前">
						
					</p>

					<p class="fieldset">
						<label class="image-replace email" for="signup-email">メール</label>
						<input class="has-padding has-border has-width" name="signup-email" id="signup-email" type="email" placeholder="メール">
						<input class="has-padding has-border has-width2" href="#signup-certi2" id="signup-certi" data-toggle="collapse" type="button" value="転送" aria-expanded="false" aria-controls="#signup-certi2">
						<span id="signup-check">  </span>
					</p>
					
					<p class="fieldset collapse" id="signup-certi2">
						<label class="image-replace password" for="signup-password-certi">認証番号入力 </label>
						<input class="has-padding has-border has-width" name="signup-password-certi" id="signup-password-certi" type="password"  placeholder="認証番号">
						<a href="#0" class="hide-password hide-certified">暗号表示</a>
						<input class="has-padding has-border has-width3" id="signup-certified" type="button" value="確認 ">
					</p>
			

					<p class="fieldset">
						<label class="image-replace password" for="signup-password">パスワード</label>
						<input class="full-width has-padding has-border" name="signup-password" id="signup-password" type="password"  placeholder="パスワード">
						<a href="#0" class="hide-password">暗号表示</a>
						
					</p>
					
					<p class="fieldset">
						<label class="image-replace password" for="signup-password2">パスワード</label>
						<input class="full-width has-padding has-border" name="signup-password2" id="signup-password2" type="password"  placeholder="パスワード">
						<a href="#0" class="hide-password">暗号表示</a>
						
					</p>

					<p class="fieldset">
						<input type="checkbox" id="accept-terms" name="accept-terms">
						<label for="accept-terms"> <a class="accept-terms" href="#0"> 利用約款 </a>に 同意します。</label>
					</p>

					<p class="fieldset full-width has-padding signupsubmit">
						<!-- <a href="javascript:signupcheck();" id="signup_submit" class="full-width has-padding signupsubmit">
						Create account -->
						 <input id="signup_submit" class="full-width has-padding" type="submit" value="加入">
						<!-- </a> -->
					</p>
				</form>

				<!-- <a href="#0" class="cd-close-form">Close</a> -->
			</div>

			<div id="reset-password">
				<p class="form-message">パスワードをお忘れですか？メールアドレスを入力してください。</br> 新しいパスワードを作成するためのリンクが表示されます。</p>

				<form class="form">
					<p class="fieldset">
						<label class="image-replace email" for="reset-email">メール</label>
						<input class="has-padding has-border has-width" name="reset-email" id="reset-email" type="email" placeholder="メール" onkeyup="remail_check();">
						<input class="has-padding has-border has-width2" href="#reset-password2" id="send-password" data-toggle="collapse" type="button" value="転送" aria-expanded="false" aria-controls="#reset-password2">
						<span id="remail-check">  </span>
					</p>
					
					
					<p class="fieldset collapse" id="reset-password2">
						<label class="image-replace password" for="reset-password1">パスワード</label>
						<input class="full-width has-padding has-border" name="reset-password1" id="reset-password1" type="password"  placeholder="パスワード">
						<a href="#0" class="hide-password">暗号表示</a>
						
					</p>

					<p class="fieldset">
						<input class="full-width has-padding" type="submit" id="reset-pw" value="ログイン">
					</p>
				</form>
				<a href="#0" class="close-form">閉じる</a>
				<!-- <p class="form-bottom-message"><a href="#0">Back to log-in</a></p> -->
			</div>
			
		</div>
	</div>
	
	<script>
	$(function (){
		$("#send-password").on("click", function(e){
			e.preventDefault();
			
			var reset_email = $.trim($("#reset-email").val());
			var emailpattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9_\.\-]+\.[A-Za-z0-0\-]+/;
			
			if(emailpattern.test($("#reset-email").val()) == false){
				alert("メールアドレスが無効です。");
				$("#reset-email").val("").focus();
				return false;
			}
			if($.trim($("#reset-email").val()) == ""){
			alert("認証番号を受信するメールアドレスを入力してください。");
			$("#reset-email").val("").focus();
			return false;
			
		} else {
			$.ajax ({
				data: "post",
				dataType: "json",
				async: false,
				data: {"email": reset_email },
				url: "forgotcerti.do",
				success: function(data){
					alert (data.msg);
					
				}, error: function(){
					alert ("認証番号の送信に失敗しました。しばらくしてからもう一度実行してください。");
				}
			})
		}
			
		});
	});
</script>

<script>
$(function(){
		
		$("#reset-pw").on("click", function(e){
			e.preventDefault();
			
			var email = $("#reset-email").val();
			var newpw = $("#reset-password1").val();
			
			if($("#reset-password1").val() == ""){
				alert("パスワードを入力してください。");
				$("#reset-password1").val("").focus();
				return false;
				
			} else {
				$.ajax ({
					type: "post",
					dataType: "json",
					async: false,
					data: {"newpw": newpw, "email":email},
					url: "forgotcerticheck.do",
					success: function(data){
						alert (data.msg);
						
					}, error: function(){
						alert ("error!");
					}
				})
			}
		
		
	});
});
	
	</script>
	
	
	
	
	
	<script>
		
		function signupCheck() {
			if($("#signup-username").val() == ""){
				alert("名前を入力してください。");
				$("#signup-username").val("").focus();
				return false;
			}
			
			var emailpattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9_\.\-]+\.[A-Za-z0-0\-]+/;
			
			if(emailpattern.test($("#signup-email").val()) == false){
				alert("メールアドレスが無効です。");
				$("#signup-email").val("").focus();
				return false;
			}
			
			if($("#signup-email").val() == ""){
				alert("メールアドレスを入力してください。");
				$("#signup-email").val("").focus();
				return false;
			}
			
			
			
			if($("#signup-password").val() == ""){
				alert("パスワードを入力してください。");
				$("#signup-password").val("").focus();
				return false;
			}
			
			if($("#signup-password2").val() == ""){
				alert("パスワードを確認するため、もう一度入力してください。");
				$("#signup-password2").val("").focus();
				return false;
			}
			
			if($("#signup-password").val() != $("#signup-password2").val()){
				alert("2つのパスワードが一致しません。");
				$("#signup-password2").val("").focus();
				return false;
			}
			
			if($("input:checkbox[name=accept-terms]").is(":checked") != true) {
				alert("利用約款に非同意の場合、会員登録ができません。");
				$("input:checkbox[name=accept-terms]").val("").focus();
				return false;
				}
			
		 signup_form.submit();
		
	}
	
	</script>
	
	<script>
	$(function (){
		$("#signup-certi").on("click", function(e){
			e.preventDefault();
			
			var email = $("#signup-email").val();
			var emailpattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9_\.\-]+\.[A-Za-z0-0\-]+/;
			
			if(emailpattern.test($("#signup-email").val()) == false){
				alert("メールアドレスが無効です。");
				$("#signup-email").val("").focus();
				return false;
			}
			
			if($("#signup-email").val() == ""){
			alert("メールアドレスを入力してください。");
			$("#signup-email").val("").focus();
			return false;
			
			} 
			
			if($("#signup-email").val() != ""){
				
				$.ajax({
					type : "post",
					dataType : "json",
					async : false,
					data : {"remail" : email},
					url : "forgot-emailChek.do",
					success : function(data) {
						if (data.mailcheck != 1
								&& $("#signup-email").val() != "") {
							$("#signup-check").html("メールアドレスに登録された履歴がありません。");
							
							$.ajax ({
								type: "post",
								dataType: "json",
								async: false,
								data: {"email": email },
								url: "sign-certi.do",
								success: function(data){
									alert (data.msg);
									
								}, error: function(){
									alert ("認証番号の送信に失敗しました。しばらくしてからもう一度実行してください。");
								}
							})
							

						} else {
							$("#signup-check").html(
									"メールアドレスが存在します。パスワード検索、または他のメールで登録を実行してください。");
							
							
						}
					},
					error : function() {
						$("#signup-check").html("error! ");
						alert("error!");
					}
				})
				
				/* $.ajax ({
				type: "post",
				dataType: "json",
				async: false,
				data: {"remail": email },
				url: "sign-certi.do",
				success: function(data){
					alert (data.msg);
					
				}, error: function(){
					alert ("인증번호 전송에 실패하였습니다. 잠시 후에 다시 시도해주세요. ");
				}
			}) */
			
			 } else {
				 
			 } 
			
		
	
			
		});
		
		$("#signup-certified").on ("click", function(e){
			e.preventDefault();
			
			var certinumber = $.trim($("#signup-password-certi").val());
			
			if($("#signup-password-certi").val() == ""){
				alert("認証番号を入力してください。");
				$("#signup-password-certi").val("").focus();
				return false;
			} else {
				$.ajax ({
					type: "post",
					dataType: "json",
					async: false,
					data: {"certinumber": certinumber},
					url: "sign-certiCheck.do",
					success: function(data){
						alert (data.msg);
						
					}, error: function(){
						alert ("error!")
					}
				})
			}
		});
		
	});
	
	</script>
	
	
	<script>
	 function remail_check(){
		var remail = $("#reset-email").val();

			if (remail != "") {
				$.ajax({
					type : "post",
					dataType : "json",
					async : false,
					data : {
						"remail" : remail
					},
					url : "forgot-emailChek.do",
					success : function(data) {
						if (data.mailcheck != 1
								&& $("#reset-email").val() != "") {
							$("#remail-check").html("メールアドレスに登録された履歴がありません。");

						} else {
							$("#remail-check").html(
									"メールアドレスが存在します。転送ボタンを押して臨時パスワードを付与してもらってください。");
						}
					},
					error : function() {
						$("#remail-check").html("error! ");
						alert("error!");
					}
				})

			} else {

			}

		}
	</script>
	
	<script>
	$(function (){
		$(".accept-terms").on("click",function(e){
			e.preventDefault();
			window.open("terms.do","","width=600,height=800,left=200");
		})
	})
	
	</script>

	
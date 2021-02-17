<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>

<c:if test="${empty user }">
<div class="title-all text-center">
<h1 style="padding:10%;"> ログインが必要なページです。 </h1>
</div>
	<script>

	$(function (){
		$('#login').show();
		
		$('.switcher').children('li').eq(1).children('a').on("click",function(){
			$('#login').hide();
			$('#signup').show();
		})
		
		$('.switcher').children('li').eq(0).children('a').on("click",function(){
			$('#signup').hide();
			$('#login').show();
		})
		
	    $('.user-modal').addClass('is-visible');
	    ( $(event.target).is('.signup') ) ? signup_selected() : login_selected();
	  //show the selected form
	});
				 
	</script>
</c:if>

<c:if test="${not empty user }">
 <!-- Start Wishlist  -->
    <div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                
                	<div class="title-all text-center">
                        <h1> ウィッシュリスト </h1>
                        <p> ウィッシュリストに入れた品は最大で一ヶ月まで保管できます。 </p>
                    </div>
                
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr class="review_col">
                                    <th>イメージ</th>
                                    <th>製品名</th>
                                    <th>価格($)</th>
                                    <!-- <th>Stock</th> -->
                                    <th>項目追加</th>
                                    <th>削除</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="wlist" items="${list }">
                                <tr>
                                    <td class="thumbnail-img">
                                    
                                        <a href="#">
									<img class="img-fluid" src="shopUpload/${wlist.image }" alt="" />
								</a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#">
									<p>${wlist.product_name }</p>
								</a>
                                    </td>
                                    <td class="price-pr">
                                        <p>${wlist.price }</p>
                                    </td>
                                    <%-- <td class="quantity-box">${wlist.quantity }</td> --%>
                                    <td class="add-pr">
                                    <span id="product_num" class="${wlist.product_num }"> </span> 
                                        <a class="btn hvr-hover add_cart" href="#">カートに入れる</a>
                                    </td>
                                    <td class="remove-pr">
                                    <span id="product_num" class="${wlist.num }"> </span> 
                                        <a class="remove" href="#">
									<i class="fas fa-times"></i>
								</a>
                                    </td>
                                </tr>
                              </c:forEach>
                             
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Wishlist -->
</c:if>

<%@ include file = "../footer.jsp" %>

<script>
  $(function(){
  	$(".add_cart").on("click", function(e){
  		e.preventDefault();
  		var num = $(this).parents(".add-pr").find("span").attr("class");
  		
  		/* var num = $("#product_num").val(); */
  		console.log(num);
  		$.ajax ({
  			type: "post",
  			dataType: "json",
  			url: "add_cart.do",
  			async: false,
  			data: {"num": num},
  			success: function(data){
  					alert(data.msg);
  				
  			},
  			error: function(){
  				alert ("Error!");
  			}
  		})
  		
  	})
  	
  })
                         
</script>

<script>
 $(function(){
	 $(".remove").on("click", function(e){
		 e.preventDefault();
		 
		 var num = $(this).parents(".remove-pr").find("span").attr("class");
		 console.log(num);
		 $.ajax ({
			 type: "post",
			 dataType: "json",
			 url: "remove_wish.do",
			 async: false,
			 data: {"num": num},
			 success: function(data){
				 
				 location.href="wishlist.do";
				 alert(data.msg);
			 },
			 error: function(){
				 alert ("Error!");
			 }
		 })
		 
	 })
 });
</script>
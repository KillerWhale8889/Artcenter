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
  
    $('.user-modal').on('click', function(event){
        if( $(event.target).is($('.user-modal')) || $(event.target).is('.close-form') ) {
        	location.href=history.go(-2);
        	
        } 
      });
});
			 
</script>
</c:if>
                


<c:if test="${not empty user }">
 <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                
                	<div class="title-all text-center">
                        <h1> カート  </h1>
                        <p> 買い物かごに入れた品物が見えます。  </p>
                    </div>
                
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr class="review_col">
                                    <th>イメージ</th>
                                    <th>製品名</th>
                                    <th>価格($)</th>
                                    <th>数量</th>
                                    <th>合計</th>
                                    <th>削除</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                            <c:forEach var="clist" items="${list }">
                           
                          
                                <tr>
                                    <td class="thumbnail-img">
                                     <input type="hidden" class="${clist.num }">
                                        <a href="#">
									<img class="img-fluid" src="shopUpload/${clist.image }" alt="" />
								</a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#"> 
                                        <p>${clist.product_name }</p></a>
                                    </td>
                                    <td class="price-pr">
                                      <p class="proprice"> ${clist.price }</p>
                                    </td>
                                    <td class="quantity-box">
                                    <input type="number" size="${clist.quantity }" name="quantity" value="1" min="0" max="${clist.quantity }" step="1" class="c-input-text qty text"></td>
                                    <td class="total-pr">
                                    <input type ="text" style="width:50px; border:none; text-align:center;" class="${clist.num }" value="${clist.price }" readonly>
                                    </td>
                                    <td class="remove-pr">
                                        <a href="#" class="remove">
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

            <div class="row my-5">
                <div class="col-lg-6 col-sm-6">
                    <div class="coupon-box">
                        <div class="input-group input-group-sm">
                            <input class="form-control" id="coupon_code" placeholder="クーポンコードを入力" aria-label="Coupon code" type="text">
                            <div class="input-group-append">
                                <button class="btn btn-theme" id="coupon" type="button">クーポンの適用</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <div class="update-box">
                        <input value="カートの更新" id="update_cart" type="submit" >
                    </div>
                </div>
            </div>
            
            







            <div class="row my-5">
                <div class="col-lg-8 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
               
                    <div class="order-box">
                    
                        <h3>注文の概要</h3>
                        <div class="d-flex">
                            <h4>小計</h4>
                            <div class="ml-auto font-weight-bold sub_total"> ${sub_total} </div>
                        </div>
                       
                        <hr class="my-1">
                        <div class="d-flex">
                            <h4>クーポン割引</h4>
                            <div class="ml-auto font-weight-bold"> 
                            <span class="disc"> </span>
                             </div>
                        </div>
                        <div class="d-flex">
                            <h4>送料</h4>
                            <div class="ml-auto font-weight-bold"> Free </div>
                        </div>
                        <hr>
                        <div class="d-flex gr-total">
                            <h5>合計</h5>
                            <div class="ml-auto h5 grand_total">  </div>
                        </div>
                        <hr> 
                        
                        </div>
                </div>
                
                
 <script>
	$(function (){
		 $("input[type=number]").change(function(e){
			e.preventDefault();
			
			var num = $(this).parents("tr").find("input").attr("class");
			var quant = $(this).val();
			var price = $(this).parents("tr").find("td").find(".proprice").text();
			
			var totalp = quant * price;
			$("."+num).val(totalp);
			
			
			
			/* var total = 0 ; //variable hold the sum
			var len = $(this).parents("tr").find("td").children("input").val().length;
			console.log(len);
			
		    for(var i =0; i<len; i++){ 
		        total = total + Number(tt[i]); 
		    console.log(total);
		    console.log($("."+num).val());
		       $(".sub_total").html(total);
		    } */
		    
		     }); 
			
		});
		
	   
</script>        			
					

	<script>
	$(function(){
		$("#update_cart").on("click",function(e){
			e.preventDefault();
			
			/* var quan = $(this).parents("div").find("tr").find("td").find("input").attr("value"); */
			var num = $(this).parents("div").find("tr").find("td").find("input").attr("class");
			/* console.log(quan); */
			var cnt = $("."+num).length;  
			console.log(num);
	        console.log(cnt);
	          
			  for( var i=0; i<= cnt; i++){
				 var new_price = $("."+num).val();
				  console.log(new_price);
			     var sub_total = 0;
			     sub_total = sub_total + parseInt(new_price);
			    console.log(sub_total);
			    $(".sub_total").html(sub_total);
			    $(".grand_total").html(sub_total);
			  }
		}) 
	})
	
	</script>



			<script>
                	$(function(){
                		$("#coupon").on("click",function(e){
                			e.preventDefault();
                			
                			var subtotal = $(".sub_total").text();
                			var code = $("#coupon_code").val();
                			
                			$.ajax({
                				type: "post",
                				dataType: "json",
                				data: {"code":code},
                				async: false,
                				url: "coupon.do",
                				success: function(data){
                					if(data.result != 1 && $("#coupon_code").val() != ""){
                						alert ("無効なコード番号です。")
                						code.focus();
                						
        						}else {
                        			var disc = data.salefee;
                        			
                        				var discounted = Math.round(subtotal * (disc/100));
                        				var grandtotal = subtotal - discounted;
                        				$(".disc").html(discounted);
                        				$(".grand_total").html(grandtotal);
        						
                				}},
                				error: function(){
                					alert ("Error!")
                				}
                			})
                		})
                		
                	})
                
                
       </script>	
       
       <script>
       $(function(){
    		 $(".remove").on("click", function(e){
    			 e.preventDefault();
    			 
    			 var num = $(this).parents("tr").find("input").attr("class");
    			 console.log(num);
    			 $.ajax ({
    				 type: "post",
    				 dataType: "json",
    				 url: "remove_cart.do",
    				 async: false,
    				 data: {"num": num},
    				 success: function(data){
    					 
    					 location.href="cart.do";
    					 alert(data.msg);
    				 },
    				 error: function(){
    					 alert ("Error!");
    				 }
    			 })
    			 
    		 })
    	 });
       
       
       
       </script>
                

                
                
                
                
                <div class="col-12 d-flex shopping-box"><a href="#" class="ml-auto btn hvr-hover" id="checkout">お支払いする</a> </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->

<script>
$(function(){
	$("#checkout").on("click",function(e){
		e.preventDefault();
		alert ("決済ページに移動します。");
		window.open("order.do","","width=400,height=400,left=400");


		
	})
	
});

</script>

</c:if>
<%@ include file = "../footer.jsp" %>
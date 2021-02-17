<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>


 <!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                    <div class="right-product-box">
                        <div class="product-item-filter row">
                            <div class="col-12 col-sm-8 text-center text-sm-left">
                                <div class="toolbar-sorter-right">
                                    <span>ソート基準 </span>
                                    <select id="basic" class="selectpicker show-tick form-control" data-placeholder="$ USD">
									<option data-display="Select">何も</option>
									<option value="1">人気</option>
									<option value="2">高価格 → 低価格</option>
									<option value="3">低価格 → 高価格</option>
									<option value="4">ベストセラー</option>
								</select>
                                </div>
                                <p> 計 <span>${tcount}</span> 件の結果 </p>
                            </div>
                            <div class="col-12 col-sm-4 text-center text-sm-right">
                                <ul class="nav nav-tabs ml-auto">
                                    <li>
                                        <a class="nav-link active" href="#grid-view" data-toggle="tab"> <i class="fa fa-th"></i> </a>
                                    </li>
                                    <li>
                                        <a class="nav-link" href="#list-view" data-toggle="tab"> <i class="fa fa-list-ul"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="product-categorie-box">
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">
                                    <div class="row">
                                    <c:forEach var="slist" items="${list }">
                                    
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="shop-img-hover">
                                                <span id="product_num" class="${slist.product_num }"> </span> 
                                                    <img src="shopUpload/${slist.image }" class="img-fluid" alt="Image">
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="#"  class="add_cart" data-toggle="tooltip" data-placement="right" title="カートに入れる"><i class="fa fa-shopping-cart"></i></a></li>
                                                            <li><a href="#" class="add_wishlist" data-toggle="tooltip" data-placement="right" title="ウィッシュリストに入れる"><i class="far fa-heart"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="why-text">
                                                
                                                    <h4>${slist.product_name }</h4>
                                                    <h5> $ ${slist.price }</h5>
                                                </div>
                                            </div>
                                        </div>
                                       </c:forEach>
                                       <input type="hidden" class="userid" value="${user }">
                                       
                                       
                                    </div>
                                </div>
                                
                                
                                
                                <div role="tabpanel" class="tab-pane fade" id="list-view">
                                <c:forEach var="slist" items="${list }">
                                    <div class="list-view-box">
                                        <div class="row">
                                            <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                <div class="products-single fix">
                                                    <div class="box-img-hover">
                                                        <img src="shopUpload/${slist.image }" class="img-fluid" alt="Image">
                                                        <div class="mask-icon">
                                                            <ul>
                                                                <li><a href="add_cart.do" class="add_cart" data-toggle="tooltip" data-placement="right" title="カートに入れる"><i class="fa fa-shopping-cart"></i></a></li>
                                                                <li><a href="add_wishlist.do" class="add_wishlist" data-toggle="tooltip" data-placement="right" title="ウィッシュリストに入れる"><i class="far fa-heart"></i></a></li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                                <div class="why-text full-width">
                                                    <h4>${slist.product_name }</h4>
                                                    <h5>${slist.price }</h5>
                                                    <p>${slist.content }</p>
                                                    <a class="btn hvr-hover add_cart" href="#">カートに入れる </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>
                                    
                         
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                    <div class="product-categori">
                        <div class="search-product">
                            <form action="#">
                                <input class="form-control" placeholder="キーワードを入力してください。" type="text">
                                <button type="submit"> <i class="fa fa-search"></i> </button>
                            </form>
                        </div>
                        <div class="filter-sidebar-left">
                            <div class="title-left">
                                <h3>カテゴリ</h3>
                            </div>
                            <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men" data-children=".sub-men">
                                <div class="list-group-collapse sub-men">
                                    <a class="list-group-item list-group-item-action" href="#sub-men1" data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">芸術作品 <small class="text-muted">(${tcount})</small>
								</a>
                                    <div class="collapse show" id="sub-men1" data-parent="#list-group-men">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item list-group-item-action active">Jean-Michel Basquiat <small class="text-muted">(${tcount})</small></a>
                                            <!-- <a href="#" class="list-group-item list-group-item-action">Untitled <small class="text-muted">(0)</small></a>
                                            <a href="#" class="list-group-item list-group-item-action">Untitled <small class="text-muted">(0)</small></a> -->
                                        </div>
                                    </div>
                                </div>
                                <div class="list-group-collapse sub-men">
                                    <a class="list-group-item list-group-item-action" href="#sub-men2" data-toggle="collapse" aria-expanded="false" aria-controls="sub-men2">マガジン 
								<small class="text-muted">(0)</small>
								</a>
                                    <div class="collapse" id="sub-men2" data-parent="#list-group-men">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item list-group-item-action">Vol.5 <small class="text-muted">(0)</small></a>
                                            <a href="#" class="list-group-item list-group-item-action">Vol.6 <small class="text-muted">(0)</small></a>
                                            <a href="#" class="list-group-item list-group-item-action">Vol.7 <small class="text-muted">(0)</small></a>
                                        </div>
                                    </div>
                                </div>
                                <a href="#" class="list-group-item list-group-item-action"> プログラム  <small class="text-muted">(0) </small></a>
                            </div>
                        </div>
                        <div class="filter-price-left">
                            <div class="title-left">
                                <h3>価格</h3>
                            </div>
                            <div class="price-box-slider">
                                <div id="slider-range"></div>
                                <p>
                                    <input type="text" id="amount" readonly style="border:0; color:#fbb714; font-weight:bold;">
                                    <button class="btn hvr-hover" type="submit">フィルター</button>
                                </p>
                            </div>
                        </div>
                        
                        <div class="rv_write">
						<c:if test="${user eq 'admin@artcenter.com'}">
						<a href="shop_write.do" class="btn_write">商品登録</a>
						</c:if>
						</div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Shop Page -->



<%@ include file = "../footer.jsp" %>

  <script>
        $(function(){
        	$(".add_cart").on("click", function(e){
        		e.preventDefault();
        		var userid = $(".userid").val();
        		var num = $(this).parents(".shop-img-hover").find("span").attr("class");
        		
        		if(userid == ""){
        			alert ("ログインしてご利用ください。")
        			location.href="login.do";
        		} else {
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
        		}
        	})
        	
        })
        
   </script>
   
    <script>
        $(function(){
        	$(".add_wishlist").on("click", function(e){
        		e.preventDefault();
        		var userid = $(".userid").val();
        		var num = $(this).parents(".shop-img-hover").find("span").attr("class");
        		console.log(userid);
        		console.log(num);
        		
        		if(userid == ""){
        			alert ("ログインしてご利用ください。");
        			location.href="login.do";
        		} else {
        		/* var num = $("#product_num").val(); */
        		console.log(num);
        		$.ajax ({
        			type: "post",
        			dataType: "json",
        			url: "add_wishlist.do",
        			async: false,
        			data: {"num": num},
        			success: function(data){
        					alert(data.msg);
        				
        			},
        			error: function(){
        				alert ("Error!");
        			}
        		})
        		}
        		
        	})
        	
        })
        
   </script>

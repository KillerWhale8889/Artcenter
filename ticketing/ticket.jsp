<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>

 <!-- Start Products  -->
    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>今日の</h1>
                        <p>公演と展示会をご案内します。 </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="special-menu text-center">
                        <div class="button-group filter-button-group">
                            <button class="active" data-filter="*">すべて</button>
                            <button data-filter=".performance">公演</button>
                            <button data-filter=".exhibition">展示会</button>
                        </div>
                    </div>
                </div>
            </div>
            
<!--            performance  -->
            <div class="row special-list">
                <div class="col-lg-3 col-md-6 special-grid performance">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="d-day">D-2 </p>
                            </div>
                            <img src="images/item3.gif" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                </ul>
                                <a class="buying" href="#" 
                                onclick="window.open('http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=20003657#','','width=1100,height=800,location=no,status=no,scrollbars=no');">Buy Ticket</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4> 르네 마그리드 특별전  </h4>
                        </div>
                    </div>
                </div>
                

                <div class="col-lg-3 col-md-6 special-grid performance">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="d-day">D-1</p>
                            </div>
                            <img src="images/2.png" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                </ul>
                                <a class="buying" href="#">前売</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Jean-Michel Basquiat</h4>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6 special-grid performance">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="open">Open </p>
                            </div>
                            <img src="images/2.png" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                </ul>
                                <a class="buying" href="#">前売</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Jean-Michel Basquiat </h4>
                        </div>
                    </div>
                </div>
                
                
            
            
            
<!--            exhibition-->
                <div class="col-lg-3 col-md-6 special-grid exhibition">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                                <p class="open">Open</p>
                            </div>
                            <img src="images/1.png" class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="Add to Wishlist"><i class="far fa-heart"></i></a></li>
                                </ul>
                                <a class="buying" href="#">前売</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Jean-Michel Basquiat</h4>
                        </div>
                    </div>
                </div>
            </div>
            
<div class="rv_write">
	<c:if test="${user eq 'admin@artcenter.com'}">
		<a href="#" class="btn_write">書取り</a>
	</c:if>
</div>            
            
        </div>         
 </div>


<!-- End Products  -->


<%@ include file ="../footer.jsp" %>
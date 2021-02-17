<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>

<div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                
                	<div class="title-all text-center">
                        <h1> ニュースレター購読および発送(管理者) </h1>
                        <p> ニュースレターの購読者(会員全員含む)リストを確認し、送信することができます。 </p>
                    </div>
                
                    <div class="table-main table-responsive">
                        <table class="table">
                        <caption class="sr-only"> ニュースレター購読者リスト </caption>
						 <colgroup>
							<col width="15%">
							<col width="*%">
							<col width="15%">
						</colgroup>
                            <thead class="newsmenu">
                                <tr class="review_col">
                                    <th>会員可否 </th>
                                    <th>メールアドレス </th>
                                    <th>購読取り消し </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="slist" items="${subs_list}">
                                <tr>
                                    <td class="sort">
                                    ${slist.code }
                                    </td>
                                    
                                    <td class="title">
                                        <a href="#">
									<p>${slist.sub_email}</p>
									</a>
                                    </td>
                                    
                                    <td class="remove-pr">
                                    <span id="product_num" class="33"> </span> 
                                    <c:if test = "${slist.code eq '비회원' }">
                                        <a class="remove" href="#">
									<i class="fas fa-times"></i>
										</a>
										</c:if>
                                    </td>
                                    
                                </tr>
                              </c:forEach>
                             
                            </tbody>
                        </table>
                    </div>
                    
            <div class="rv_write">
			<a href="newsletter_write.do" class="btn_write">発送する</a>
			
			</div>
                    
                </div>
            
                
            </div>
        </div>
    </div>


<script>
 $(function(){
	 $(".remove").on("click", function(e){
		 e.preventDefault();
		 
		 var num = $(this).parents(".remove-pr").find("span").attr("class");
		 console.log(num);
		 $.ajax ({
			 type: "post",
			 dataType: "json",
			 url: "",
			 async: false,
			 data: {"num": num},
			 success: function(data){
				 
				 location.href=".do";
				 alert(data.msg);
			 },
			 error: function(){
				 alert ("Error!");
			 }
		 })
		 
	 })
 });
</script>

<%@ include file = "../footer.jsp" %>
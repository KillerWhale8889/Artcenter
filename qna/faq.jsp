<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


    <div class="container">
     <div class="row">
       <div class="col-lg-12">
    	<div class="review_box">
	
           <div class="title-all text-center">
                   <h1> よくある質問 </h1>
                   <p style="margin-bottom:3%"> アートセンターについてご気遣わしい点をご確認いただけます。 </p>
                   <div class="search-product search_notice">
                       <form action="#">
                           <input class="form-control" placeholder="何をお探しですか? " type="text" name="word" class="search_word">
                           <button type="submit"> <i class="fa fa-search"></i> </button>
                       </form>
                   </div>
                   </p>
               </div>
              
	  
	<%-- <c:if test="${tcount > 0 }">
		<p> 검색된 결과가 ${tcount } 건 있습니다. </p>			
	</c:if> --%>
	
	  
	  <div class="board_list">
	    <div class="table-main table-responsive">
		<table class="table board_table notice_table">
			<caption class="sr-only"> よくある質問 </caption>
			 <colgroup>
				<col width="10%">
				<col width="50%">
				<col width="5%">
				<col width="5%">
			</colgroup>
			<tbody class="faq_list">
			 <c:forEach var="flist" items="${list }">
				<tr>
					<td>
					<p href="#answer" class="faq_question" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="#answer"> 
					Q. ${flist.question }
					</p>
					
					<p class="collapse faq_answer" id="answer">
					A. ${flist.answer }
					</p>
					
					
				
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
	</div>
	<!-- end contents -->
	
	
	<c:if test="${word != null}">
	<form id ="actionForm" action="faq.do" method="get">
 		<input type="hidden" name="word" value ="${word}">
	</form>
	</c:if>
	
	
	

<!-- <script>

$('.faq_question').click(function(){
    $(this).nextUntil('tr.faq_question').slideToggle(50);
});


</script> -->
   

<%@ include file="../footer.jsp"%>
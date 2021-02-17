<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


    <div class="container">
     <div class="row">
       <div class="col-lg-12">
    	<div class="review_box">
	
           <div class="title-all text-center">
                   <h1> お知らせ </h1>
                   <p> 
                   <div class="search-product search_notice">
                       <form action="#">
                           <input class="form-control" placeholder="検索キーワードを入力してください。 " type="text" name="word" class="search_word">
                           <button type="submit"> <i class="fa fa-search"></i> </button>
                       </form>
                   </div>
                   </p>
               </div>
              
	  

	  
	  <div class="board_list">
	    <div class="table-main table-responsive">
		<table class="table board_table notice_table">
			<caption class="sr-only"> お知らせ  </caption>
			 <colgroup>
				<col width="10%">
				<col width="50%">
				<col width="5%">
				<col width="5%">
			</colgroup>
			<tbody class="notice_list">
			<c:forEach var="nlist" items="${list }">
				<tr>
					<td> 
					<div class="notipoint">お知らせ</div> </td>
					<td class="title">
					<a href="notice_content.do?num=${nlist.num }&pageNum=${pageMaker.cri.pageNum }&amount=${pageMaker.cri.amount}"> ${nlist.title } </a></td>
					
					<td> <fmt:formatDate value="${nlist.regdate}" pattern="yyyy-MM-dd"/> </td>
					<td>${nlist.readcount } </td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
		</div>
		<div class="paging">
			<div class="rv_page">
			
			
			<c:if test = "${pageMaker.prev }">
			<a href="${pageMaker.startPage-1 }">
			<i class="fa fa-angle-left"></i></a>
			</c:if>
			
			<c:forEach var="num" begin ="${pageMaker.startPage }" end="${pageMaker.endPage }">
			<a href="${num }" class="${pageMaker.cri.pageNum == num ? 'active':''}"> ${num }</a>
			</c:forEach>
			
			
			<c:if test = "${pageMaker.next }">
			<a href="${pageMaker.endPage+1 }">
			<i class="fa fa-angle-right"></i></a>
			</c:if>
			
			</div>
			
			
			<div class="rv_write">
			<c:if test="${user eq 'admin@artcenter.com'}">
			<a href="notice_write.do" class="btn_write">書取り</a>
			</c:if>
			</div>
		</div>
	  </div>
	  </div>
	  </div>
	  </div>
	</div>
	<!-- end contents -->
	
	<c:choose>
	<c:when test="${word != null}">
	<form id ="actionForm" action="notice.do" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
 		<input type="hidden" name="word" value ="${word}">
	</form>s
	</c:when>
	
	
	
	<c:otherwise>
	<form id ="actionForm" action="notice.do" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
		<%-- <input type="hidden" name="sel" value ="${sel}">
		<input type="hidden" name="word" value= "${word}"> --%>
	</form>
	</c:otherwise>
	</c:choose>
	
	<c:if test="${result == 1 }">
	<script>
		alert ("文が完了しました。");
		location.href = "notice.do?pageNum="+${pageMaker.cri.pageNum }+"&amount="+${pageMaker.cri.amount};
	</script>
	</c:if>
	
	<c:if test="${Deleteresult == 1 }">
	<script>
		alert ("文が削除されました。");
		location.href = "notice.do?pageNum="+${pageMaker.cri.pageNum }+"&amount="+${pageMaker.cri.amount};
	</script>
	</c:if>
   

<%@ include file="../footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


    <div class="container">
     <div class="row">
       <div class="col-lg-12">
    	<div class="review_box">
    		
                <div class="title-all text-center">
                        <h1> 公演レビュー </h1>
                        <p> 公演・展示の感想を作成して、他の観客の感想を見ることができます。</p>
                    </div>
              
	  <div class="search_wrap">
		<div class="search_group">
			<p class="search_count">総掲示文<span> ${tcount }</span>件</p>
		</div>
			<form name="myform" method="get" action="review_search.do">
				<select name="sel" class="rv_select">
					<option value="title">タイトル</option>
					<option value="writer">書き手 </option>
					<option value="content">内容</option>
				</select>
				<input type="text" name="word" class="search_word">
				<button class="btn_search" type="submit"><i class="fa fa-search"></i>
				<span class="sr-only">捜索する</span></button>
			</form>
	  </div> <!-- search end -->

	  
	  <div class="board_list">
	    <div class="table-main table-responsive">
		<table class="table board_table">
			<caption class="sr-only"> 観覧客のレビュー </caption>
			 <colgroup>
				<col width="10%">
				<col width="60.3%">
				<col width="11%">
				<col width="15%">
				<col width="15.6%">
			</colgroup>
			<thead>
				<tr class="review_col">
					<th>No.</th>
					<th>タイトル</th>
					<th>書き手</th>
					<th>作成日</th>
					<th>ビュー</th>
				</tr>
			</thead>
			<tbody class="review_list">
			<c:forEach var="rlist" items="${list }">
				<tr>
					<td>${tcount-rlist.rn+1 }</td>
					<td class="title">
					<a href="review_content.do?num=${rlist.num }&pageNum=${pageMaker.cri.pageNum }&amount=${pageMaker.cri.amount}"> ${rlist.title } </a></td>
					<td> ${rlist.writer } </td>
					<td> <fmt:formatDate value="${rlist.regdate}" pattern="yyyy-MM-dd"/> </td>
					<td>${rlist.readcount } </td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
		</div>
		<div class="paging">
			<div class="rv_page">
			<%-- <c:if test = "${pageMaker.startPage }">
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			</c:if> --%>
			
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
			
			<%-- <c:if test="${pageMaker.endPage }">
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
			</c:if> --%>
			
			<%-- <% String userid = (String) session.getAttribute("userid");
				if(userid == "admin") {%> --%>
			<%-- <c:if test="${userid.equals('admin')}"> --%>
			</div>
			
			
			<div class="rv_write">
			<c:if test="${not empty user}">
			<a href="review_write.do" class="btn_write">書取り</a>
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
	<form id ="actionForm" action="review.do" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
 		<input type="hidden" name="sel" value ="${sel}">
		<input type="hidden" name="word" value= "${word}">
	</form>
	</c:when>
	
	
	
	<c:otherwise>
	<form id ="actionForm" action="review.do" method="get">
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
		location.href = "review.do?pageNum="+${pageMaker.cri.pageNum }+"&amount="+${pageMaker.cri.amount};
	</script>
	</c:if>
	
	<c:if test="${Deleteresult == 1 }">
	<script>
		alert ("文が削除されました。");
		location.href = "review.do?pageNum="+${pageMaker.cri.pageNum }+"&amount="+${pageMaker.cri.amount};
	</script>
	</c:if>
   

<%@ include file="../footer.jsp"%>
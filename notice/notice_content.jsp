<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>


	<div class="container">
		<div class="board_view">
			<h2>${view.title }</h2>
			<p class="info"><span class="user">${view.writer }</span> 
			${view.regdate } <i class="fa fa-eye"></i> ${view.readcount }</p>
			<div class="board_body">
				<p>${view.content }</p>
				<img src="noticeUpload/${view.appfile }" alt="">
			</div>
			
			
			<div class="prev_next">
			<c:choose>
			<c:when test = "${preview.num == null}">
				<a href="javascript:void(0)" class="btn_prev">
				<i class="fa fa-chevron-left"></i></a>
				</c:when>
				
				<c:when test = "${preview.num != null}">
				<a href="notice_content.do?num=${preview.num}" class="btn_prev">
				<i class="fa fa-chevron-left"></i></a>
				</c:when>
				</c:choose>
				
				<div class="rvcont_btn_wrap">
					<a href="notice.do?pageNum=${pageMaker.cri.pageNum }&amount=${pageMaker.cri.amount}">
					<i class="fa fa-align-justify" aria-hidden="true"></i></a>
					<c:if test="${user eq 'admin@artcenter.com' }"> 
					<p>
					<a href="notice_modify.do?num=${view.num }&pageNum=${pageMaker.cri.pageNum }&amount=${pageMaker.cri.amount}">修正 </a> 
					<a href="notice_delete.do?num=${view.num }" onClick="return confirm('削除しますか?')">削除</a>
					</p>
					</c:if>
				</div>
				
				<c:choose>
				<c:when test ="${nextview.num == null}">
				<a href="javascript:void(0)" class="btn_next">
				<i class="fa fa-chevron-right"></i></a>
				</c:when>
				
				<c:when test ="${nextview.num != null}">
				<a href="notice_content.do?num=${nextview.num}" class="btn_next">
				<i class="fa fa-chevron-right"></i></a>
				</c:when>
				
				</c:choose>
				
			</div>
		</div>
	</div>
	
	<c:if test="${modifyresult == 1 }">
		<script>
			alert ("修正が完了しました。")
			location.href = "notice_content.do?num="+${view.num}+"&pageNum="+${pageMaker.cri.pageNum }+"&amount="+${pageMaker.cri.amount};
		</script>
	</c:if>
	


<%@ include file = "../footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>


<div id="myPage_login">

	<div class="title-all text-center">
		<h1> 会員情報本人確認 </h1>
		<p>会員様ご本人確認のため、もう一度パスワードをご入力ください。 </p>
	</div>

	<div class="recheck">
		<input type="hidden" value="${user }" name="email" id="email">
		<p class="password_check">
		<label class="image-replace password" for="recheck-password">パスワード</label>
		<input class="full-width has-padding has-border" name="recheck-password" id="recheck-password" type="password"  placeholder="パスワード">
		<a href="#0" class="hide-password">暗号表示</a>
		</p>
		
		<p class="resubmit">
		<input class="full-width" id="recheck_submit" type="submit" value="確認">
	
		</p>
	</div>

	
</div>	




 <script>

 $(function() {
	 $("#recheck_submit").on("click", function(){
		 
		 var pw = $.trim($("#recheck-password").val());
		 var email = $.trim($("#email").val());
			
			if (pw == "") {
				alert ("パスワードを入力してください。");
				$("#recheck-password").focus();
				
			} else {
				$.ajax ({
		 			type: "post",
		 			dataType: "json",
		 			async: false,
		 			data: {"pw":pw, "email":email},
		 			url: "mypageCheck.do",
		 			success: function(data){
		 				alert (data.msg);
		 				if(data.check == "ok") {

		 				location.href="mypageok.do";
		 				
		 			} else {
		 				location.href="mypageCheck.do";
		 			 }
		 			},
		 			
		 			error: function(){
		 				alert ("error!");
		 			}
		 			
		 		})
			}
		 
	 })

});


</script>

<%-- <c:if test="${updateok == 1 }">
	<script>
		alert ("회원정보 수정이 완료되었습니다. ");
	</script>
</c:if> --%>


<%@ include file = "../footer.jsp" %>
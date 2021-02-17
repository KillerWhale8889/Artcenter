<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>



<div class="container">
<div class="row">
<div class="col-lg-12">

<div class="mypageok">
<div class="title-all text-center">
		<h1>私の情報（マイページ） </h1>
		<p> 自分の情報を確認、修正することができます。 </p>
</div>


<form class="form" id="updateacc_form" name="updateacc_form" onsubmit="return updateCheck();">
	
	<p class="fieldset">
		<label class="image-replace username" for="username">名前</label>
		<input class="full-width has-padding has-border" name="username" id="username" type="text" value="${myprofile.name }" readonly> 
	</p>

	<p class="fieldset">
		<label class="image-replace email" for="email">メール</label> 
		<input class="full-width has-padding has-border" name="email" id="email" type="email" value="${myprofile.email }" readonly> 
	</p>


	<p class="fieldset">
		<label class="image-replace password" for="password">パスワード</label>
		<input class="full-width has-padding has-border" name="password" id="password" type="password" placeholder="パスワード"> 
		<a href="#0" class="hide-password">暗号表示</a>
		
	</p>

	<p class="fieldset">
		<label class="image-replace password" for="password2">パスワード</label>
		<input class="full-width has-padding has-border" name="password2" id="password2" type="password" placeholder="パスワード"> 
		<a href="#0" class="hide-password">暗号表示</a>
	</p>


	<p class="fieldset full-width has-padding signupsubmit">
		<input id="updateacc_submit" class="full-width has-padding" type="submit" value="情報を修正する">
		<input id="updateacc_remove" class="full-width has-padding" type="button" value="退会する" onclick="javascript:removeCheck();">
	</p>
	   
	   
</form>

</div>
</div>
</div>
</div>


<script>
		
		function updateCheck() {
			/* if($.trim($("#username").val()) == ""){
				alert("이름을 입력하세요 ");
				$("#username").val("").focus();
				return false;
			} */
		
			if($.trim($("#password").val()) == ""){
				alert("パスワードを入力してください。");
				$("#password").val("").focus();
				return false;
			}
			
			if($.trim($("#password2").val()) == ""){
				alert("パスワードを確認するため、もう一度入力してください。");
				$("#password2").val("").focus();
				return false;
			}
			
			if($.trim($("#password").val()) != $.trim($("#password2").val())){
				alert("2つのパスワードが一致しません。");
				$("#password2").val("").focus();
				return false;
			}
			
		updateacc_form.submit();
		
	}
	
</script>

<script>
$(function(){
	$("#updateacc_submit").on("click", function(e){
		e.preventDefault();
		
		var email = $("#email").val();
		var pw = $("#password").val();
		
		$.ajax ({
			type: "post",
			dataType: "json",
			data: {"pw":pw, "email":email},
			async: false,
			url: "updateacc.do",
			success: function(data){
				alert(data.msg);
				location.href="mypageok.do";
			},
			error: function(){}
			
		})
		
	})
	
})


</script>

<script>
	function removeCheck() {
		alert ("会員退会時、一部の特典に制限があります。");
		
	}

</script>
	
	
	<script>
	$(function (){
		$("#updateacc_remove").on("click", function(e){
			e.preventDefault();
			
			var email = $("#email").val();
			
			$.ajax ({
				type: "post",
				dataType: "json",
				data: {"email":email},
				url: "remove_account.do",
				async: false,
				success: function(data){
					alert(data.msg);
					location.href="signout.do";
				},
				error: function(data){
					alert ("Error!");
				}
				
			})
			
			
			
		})
	})
	
	
	</script>
	

	


<%@ include file = "../footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>



	<div class="container">
	  <div class="rvwrite_wrap">
	  <div class="col-lg-12">
                <div class="title-all text-center">
                        <h1> お知らせの作成(管理者)  </h1>
                        <p> アートセンターのお知らせを作成します。 </p>
                    </div>
                </div>
	  <form class ="form_rvwrite" name="form_rvwrite" method="post" enctype="multipart/form-data" action="notice_modifypro.do" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="rv_write_table">
				<caption class="sr-only">お知らせ入力フォーム </caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<!-- <th>제목</th> -->
						<td>
						<input type="hidden" name="num" value="${modify.num }">
						<input type="text" name="title" value="${modify.title } " class="rv_title"></td>
					</tr>
					<tr>
						<!-- <th>내용</th> -->
						<td><textarea name="content" class="rv_content">${modify.content }</textarea></td>
					</tr>
					 <tr>
						<!-- <th>첨부</th> -->
						<td class="rv_file">
						<label for="rv_appfile">アップロード</label>
						<input type="file" id="rv_appfile" name="appfile" value="${modify.appfile }"></td>
					</tr>
				</tbody>
			</table>
			
			<div class="rvbtn_wrap">
				<input type="submit" value="修正 " class="btn_ok">
				<input type="reset" value="書き直し" class="btn_reset">
				<input type="button" value="目録" class="btn_list" onClick="location.href='notice.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(form_rvwrite.title.value=="") {
				alert("タイトルを入力してください。");
				form_rvwrite.title.focus();
				return false;
			}
			
			if(document.getElementById("appfile").value!=""){
			    var fileSize = document.getElementById("appfile").files[0].size;
			    var maxSize = 3*1024*1024;
			 	 
			    if(fileSize > maxSize){
			       alert("添付ファイルのサイズは、3MB以内で登録可能です。");
			        $("#appfile").val("");
			        return false;
			     }
			} 
			
			if( $("#appfile").val() != "" ){
		          var ext = $('#appfile').val().split('.').pop().toLowerCase();
		  	  if($.inArray(ext, ['gif','png','jpg','jpeg','webp']) == -1) {
		  	     alert('登録できないファイル名です。');
		  	     $("#appfile").val(""); // input file 파일명을 다시 지워준다.
		  	     return false;
		 	 	 }
		      }

			return true;
		}
	</script>
	
	
	



<%@ include file = "../footer.jsp" %>
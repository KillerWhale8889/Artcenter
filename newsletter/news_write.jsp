<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>



	<div class="container">
	  <div class="rvwrite_wrap">
	  <div class="col-lg-12">
                <div class="title-all text-center">
                        <h1> ニュースレターの作成(管理者)</h1>
                        <p> 毎月発行するニュースレターを作成します。 </p>
                    </div>
                </div>
	  <form class ="form_rvwrite" name="form_newswrite" method="post" enctype="multipart/form-data" action="new_send.do" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="rv_write_table">
				<caption class="sr-only"> ニュースレター作成フォーム </caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<!-- <th>제목</th> -->
						<td><input type="text" name="title" placeholder="ニュースレターVol. " class="rv_title"></td>
					</tr>
					<tr>
						<!-- <th>내용</th> -->
						<td><textarea name="content" class="rv_content" placeholder="内容を入力してください。"></textarea></td>
					</tr>
					 <tr>
						<!-- <th>첨부</th> -->
						<td class="rv_file">
						<label for="rv_appfile">アップロード</label>
						<input type="file" id="rv_appfile" name="appfile"></td>
					</tr>
				</tbody>
			</table>
			
			<div class="rvbtn_wrap">
				<input type="submit" value="発送" class="btn_ok">
				<input type="reset" value="書き直し" class="btn_reset">
				<input type="button" value="後ろへ" class="btn_list" onClick="history.back();">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			/* if(form_rvwrite.writer.value=="") {
				alert("글쓴이를 입력하세요");
				form_rvwrite.writer.focus();
				return false;
			} */
			
			if(form_newswrite.title.value=="") {
				alert("タイトルを入力してください。");
				form_newswrite.title.focus();
				return false;
			}
			
			if(form_newswrite.content.value=="") {
				alert("内容を入力してください。");
				form_newswrite.content.focus();
				return false;
			}
			
			if(document.getElementById("appfile").value!=""){
			    var fileSize = document.getElementById("appfile").files[0].size;
			    var maxSize = 3*1024*1024;
			 	 
			    if(fileSize > maxSize){
			       alert("添付ファイルのサイズは、3MB  以内で登録可能です。");
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
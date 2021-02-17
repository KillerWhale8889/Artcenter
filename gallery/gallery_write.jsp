<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>



	<div class="container">
	  <div class="rvwrite_wrap">
	  <div class="col-lg-12">
                <div class="title-all text-center">
                        <h1> ギャラリー作品登録(管理者)</h1>
                    </div>
                </div>
	  <form class ="form_rvwrite" name="form_gallwrite" method="post" enctype="multipart/form-data" action="gallery_writepro.do" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="rv_write_table">
				<caption class="sr-only">ギャラリー作品登録フォーム </caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<!-- <th>제목</th> -->
						<td><input type="text" name="title" placeholder="作品名を登録してください。" class="rv_title"></td>
					</tr>
					
					 <tr>
						<!-- <th>첨부</th> -->
						<td class="rv_file">
						<label for="rv_appfile">アップロード</label>
						<span></span>
						<input type="file" id="rv_appfile" name="appfile"></td>
					</tr>
					
					<tr>
						<!-- <th>구분 </th> -->
						<td><input type="text" name="section" placeholder="公演はperformance、展示はexhibitionで登録してください。" class="rv_title"></td>
					</tr>
					
					<tr>
						<!-- <th>아티스트  </th> -->
						<td><input type="text" name="artist" placeholder="作家のお名前を登録してください。" class="rv_title"></td>
					</tr>
					
				</tbody>
			</table>
			
			<div class="rvbtn_wrap">
				<input type="submit" value="貯蔵" class="btn_ok">
				<input type="reset" value="書き直し" class="btn_reset">
				<input type="button" value="目録" class="btn_list" onClick="location.href='gallery.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(form_gallwrite.title.value=="") {
				alert("作品名がありません。");
				form_gallwrite.title.focus();
				return false;
			}
			
			if(form_gallwrite.appfile.value=="") {
				alert("作品イメージを必ずアップロードしてください。");
				form_gallwrite.appfile.focus();
				return false;
			}
			
			if(document.getElementById("appfile").value!=""){
			    var fileSize = document.getElementById("appfile").files[0].size;
			    var maxSize = 3*1024*1024;
			 	 
			    if(fileSize > maxSize){
			       alert("添付ファイルのサイズは、3MB 以内で登録可能です。");
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
			
			if(form_gallwrite.section.value=="") {
				alert("公演と展示区分が必要です。");
				form_gallwrite.section.focus();
				return false;
			}
			
			if(form_gallwrite.artist.value=="") {
				alert("作家の名前を入力してください。");
				form_gallwrite.artist.focus();
				return false;
			}

			return true;
		}
	</script>
	
	
	



<%@ include file = "../footer.jsp" %>
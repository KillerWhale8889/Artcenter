<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>



	<div class="container">
	  <div class="rvwrite_wrap">
	  <div class="col-lg-12">
                <div class="title-all text-center">
                        <h1> 公演と展示日程登録(管理者) </h1>
                        <p> 公演と展示日程を登録します。 </p>
                    </div>
                </div>
	  <form class ="form_rvwrite" name="form_peschewrite" method="post" enctype="multipart/form-data" action="schedule_writepro.do" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="rv_write_table">
				<caption class="sr-only">公演と展示日程の入力フォーム</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td>
							<select name="sel" class="sche_select">
								<option value="performance"> 公演 </option>
								<option value="exhibition"> 展示会 </option>
							</select>
						</td>
					<tr>
					
					<tr>
						<!-- <th>제목</th> -->
						<td><input type="text" name="title" placeholder="公演と展示会の名前を入力してください。" class="rv_title"></td>
					</tr>
					
					<tr>
						<!-- <th>년도 </th> -->
						<td>
						<input type="number" name="beginyear" value="2020" min="2020" max="2022" step="1" class="c-input-text qty text">
						<input type="number" name="beginmonth" value="1" min="1" max="12" step="1" class="c-input-text qty text">
						<input type="number" name="beginday" value="1" min="1" max="31" step="1" class="c-input-text qty text">
						&nbsp; 公演及び展示会が開始する日付を入力してください。
						<!-- <input type="text" name="begindate" placeholder="公演及び展示会が開始する日付を入力してください。(yyyy-mm-dd)" class="rv_title"></td>  -->
					
					</tr>
					
					<!-- <tr>
						<th>시작 월 </th>
						<td><input type="number" name="beginmonth" value="7" min="1" max="12" step="1" class="c-input-text qty text">
						<input type="text" name="beginmonth" placeholder="공연 및 전시회가 시작하는 달을 숫자로만 입력하세요 " class="rv_title"></td>
					</tr>
					
					<tr>
						<th>시작 날짜 </th>
						<td><input type="number" name="begindate" value="29" min="1" max="31" step="1" class="c-input-text qty text">
						<input type="text" name="begindate" placeholder="공연 및 전시회가 시작하는 날짜를 숫자로만 입력하세요 " class="rv_title"></td>
					</tr> -->
					
					<tr>
						<!-- <th>년도 </th> -->
						<td>
						<input type="number" name="endyear" value="2020" min="2020" max="2022" step="1" class="c-input-text qty text">
						<input type="number" name="endmonth" value="1" min="1" max="12" step="1" class="c-input-text qty text">
						<input type="number" name="endday" value="1" min="1" max="31" step="1" class="c-input-text qty text">
						&nbsp; 公演及び展示会が終了する日付を入力してください。
						<!-- <input type="text" name="enddate" placeholder="公演及び展示会が終了する日付を入力してください。(yyyy-mm-dd)" class="rv_title"></td> -->
					</tr>
					
					<!-- <tr>
						<th>끝 월 </th>
						<td><input type="number" name="endnmonth" value="7" min="1" max="12" step="1" class="c-input-text qty text">
						<input type="text" name="beginmonth" placeholder="공연 및 전시회가 끝나는 달을 숫자로만 입력하세요 " class="rv_title"></td>
					</tr>
					
					<tr>
						<th>끝 날짜 </th>
						<td><input type="number" name="enddata" value="2020" min="2020" max="2020" step="1" class="c-input-text qty text">
						<input type="text" name="beginmonth" placeholder="공연 및 전시회가 끝나는 날짜를 숫자로만 입력하세요 " class="rv_title"></td>
					</tr> -->
					
					<tr>
						<!-- <th>첨부</th> -->
						<td class="rv_file">
						<label for="rv_appfile">アップロード</label>
						<input type="file" id="rv_appfile" name="appfile">
						*イメージアップロード</td>
					</tr>
					
					<tr>
						<!-- <th>내용</th> -->
						<td><textarea name="content" class="rv_content" placeholder="公演及び展示会の詳しい情報を入力してください。"></textarea></td>
					</tr>
					
					
					 
				</tbody>
			</table>
			
			<div class="rvbtn_wrap">
				<input type="submit" value="登録" class="btn_ok">
				<input type="reset" value="書き直し" class="btn_reset">
				<input type="button" value="後ろに" class="btn_list" onClick="history.back();">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(form_peschewrite.title.value=="") {
				alert("公演及び展示会の名前が登録されていません。");
				form_peschewrite.title.focus();
				return false;
			}
			
			if(form_peschewrite.begindate.value=="") {
				alert("公演及び展示会の開始日付が登録されていません。");
				form_peschewrite.begindate.focus();
				return false;
			}
			
			if(form_peschewrite.enddate.value=="") {
				alert("公演及び展示会の終了日が登録されていません。");
				form_peschewrite.enddate.focus();
				return false;
			}
			
			if(form_peschewrite.appfile.value=="") {
				alert("公演及び展示会のイメージが登録されていません。");
				form_peschewrite.appfile.focus();
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
			
			if(form_peschewrite.content.value=="") {
				alert("公演及び展示会の詳しい情報は登録されていません。");
				form_peschewrite.content.focus();
				return false;
			}
			
			return true;
		}
	</script>
	
	
	



<%@ include file = "../footer.jsp" %>
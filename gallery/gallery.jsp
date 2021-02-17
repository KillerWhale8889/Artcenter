<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>





    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>ギャラリー </h1>
                        <p>作品の画像をご覧いただけます。 </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="special-menu text-center">
                        <div class="button-group filter-button-group">
                            <button class="active" data-filter="*">すべて</button>
                            <button data-filter=".performance">公演</button>
                            <button data-filter=".exhibition">展示会</button>
                        </div>
                    </div>
                </div>
            </div>
            
<!--            performance  -->

 <div class="row special-list">
 

            	<c:forEach var="glist" items="${list }">
                <div class="col-lg-3 col-md-6 special-grid ${glist.section }">
                    <div class="products-single fix ">
                    	<a href="#" class="colorbox" rel="${glist.artist }">
                        <div class="box-img-hover galleryimg">
                            <img src="galleryUpload/${glist.image }" title="${glist.title }" class="img-fluid ${glist.num }" alt="Image">
                        </div>
                        <div class="why-text">
                            <h4>${glist.title } </h4>
                        </div>
                        </a>
                    </div>
                </div>
                </c:forEach>

               

                
                
                
                
                
            </div>
            
            <div class="rv_write">
			<c:if test="${user eq 'admin@artcenter.com'}">
			<a href="gallery_write.do" class="btn_write">書取り</a>
			</c:if>
			</div>
			
        </div>        
        </div>
    
    <!-- End Products  -->
   <script>
   $('a.gallery').colorbox({rel:'gal'});

   </script> 
 	
<script>

$(".colorbox").on("click", function(){
	var name = $(this).children("div").children("img").attr("title");
    var url = $(this).children("div").children("img").attr("src");	
    var artist = $(this).attr("rel");
    var num = $(this).children("div").children("img").attr("class");
    
	console.log(url);
	console.log(name);
    console.log(artist);
    console.log(num);
	
	$(".colorbox").colorbox({
		title:name,
		rel:artist,
		href:url
	}); 
	
	
	
})	

</script> 

<script>

</script>
   
<c:if test="${result == 1}">
<script>
alert ("イメージ登録が完了しました。");

</script>
</c:if>   
  

<%@ include file="../footer.jsp"%>



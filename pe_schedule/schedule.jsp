<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>


 <div class="d-calendar">
            <div class="month">
                <strong>
                <span id="pick_year"> ${year }</span>.<span id="pick_month">${month }</span>
                </strong>
                <a href="#" class="prev">prev</a>
                <a href="#" class="next">next</a>
            </div>
            <div class="date">
                <ul>
                	<input type="hidden" value="${day }" class="today">
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=01" data-day="1">1</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=02" data-day="2">2</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=03" data-day="3">3</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=04" data-day="4">4</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=05" data-day="5">5</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=06" data-day="6">6</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=07" data-day="7">7</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=08" data-day="8">8</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=09" data-day="9">9</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=10" data-day="10">10</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=11" data-day="11">11</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=12" data-day="12">12</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=13" data-day="13">13</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=14" data-day="14">14</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=15" data-day="15">15</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=16" data-day="16">16</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=17" data-day="17">17</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=18" data-day="18">18</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=19" data-day="19">19</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=20" data-day="20">20</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=21" data-day="21">21</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=22" data-day="22">22</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=23" data-day="23">23</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=24" data-day="24">24</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=25" data-day="25">25</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=26" data-day="26">26</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=27" data-day="27">27</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=28" data-day="28">28</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=29" data-day="29">29</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=30" data-day="30">30</a></li>
                    <li><a href="datepicklist.do?year=${year }&month=${month }&day=31" data-day="31">31</a></li>
                </ul>
            </div>
        </div>
 

<div class="viewdate">
<div class="viewcontents">
	<div class="effect-wrap">
   <div class="shop-listbox">
     
        <div class="main-instagram owl-carousel">
     
    <div class="effect8">
      <c:forEach var="pe_list" items="${schedule_list }">
        <figure class="front">
            <img src="pe_scheduleUpload/${pe_list.image }" class="list_image" alt="">
            <!-- <figcaption>
                <h3></h3>
                <p></p>
            </figcaption> -->
        </figure>
        
        <figure class="back">
            <img src="pe_scheduleUpload/${pe_list.image }" class="list_image" alt="">
            <!-- <figcaption>
                <h3></h3>
                <p></p>
            </figcaption> -->
        </figure>
      </c:forEach>
    </div>
    
     
    </div>
   
   
    </div>
    
    </div>
</div>
	
	<div class="rv_write">
			<c:if test="${user eq 'admin@artcenter.com'}">
			<a href="schedule_write.do" class="btn_write">スケジュール登録 </a>
			</c:if>
			</div>
	
	
	</div>


<script>

	for(var i=1;i<=31;i++){
		
		var today = Number($(".today").val());
		var li = $(".today").next("li");
		console.log(li);
        console.log(today);
        if(today == i ){
        	li.addClass("selected");
            /*  $($("li").children("a").attr("data-day"+i)).addClass("selected"); */
         
        }
    }




</script>





<script>
$(function(){
	 $(".prev").on("click", function (e) {
	        e.preventDefault();
	        var month = $("#pick_month").text();
	        console.log(month);
	        month++;
	        /* $.ajax ({
	        	type:"post",
	        	dataType:"json",
	        	data: {"month":month},
	        	url: "datepicklist.do",
	        	async: false,
	        	success: function(data){
	        		alert ("ok");
	        	},
	        	error: function(data){
	        		alert ("nope");
	        	}
	        	
	        
	        }) */
	        if (month < 10 && month > 0){
	        $("#pick_month").html("0"+month); }
	        else if (month >= 10 && month < 13 ){
	        	$("#pick_month").html(month);
	        } else if (month < 0 ){
	        	$("#pick_month").html("01");
	        } else if (month > 12){
	        	$("#pick_month").html("12");
	        }
	        
	    });

	    $(".next").on("click",function(e) {
	    	e.preventDefault();
	        var month = $("#pick_month").text();
	        console.log(month);
	        month--;
	        if (month < 10 && month > 0){
		        $("#pick_month").html("0"+month); }
		        else if (month >= 10 && month < 13 ){
		        	$("#pick_month").html(month);
		        } else if (month < 0 ){
		        	$("#pick_month").html("01");
		        } else if (month > 12){
		        	$("#pick_month").html("12");
		        }
	    });
});
</script>

<!-- <script>
$(function(){
	$("li > a").on("click",function(e){
		e.preventDefault();
		$($(this).parent("li")).addClass("selected");
	})
	
})

</script> -->


<c:if test="${result == 1 }">
<script>
 alert ("公演及び展示日程が登録されました。");
 </script>
</c:if>




<%@ include file = "../footer.jsp" %>


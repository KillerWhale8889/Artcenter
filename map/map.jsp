<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

 <script type="text/javascript" src="http://maps.google.com/maps/api/js?v=3.3&sensor=true"></script>
 
  <script> 
  
  function initialize() {
   var myLatlng = new google.maps.LatLng(36.327010, 127.407670);
   var myOptions = {
    zoom: 15,
    center: myLatlng,
    mapTypeId: google.maps.MapTypeId.TERRAIN
   }
   var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
   var marker = new google.maps.Marker( {
    position: myLatlng, 
    map: map, 
    title:"Art Center" 
   });   
   var infowindow = new google.maps.InfoWindow( {
    content: "Art Center"
   });
   infowindow.open(map,marker);
  }
  window.onload=function() {
   initialize();
  }
  </script>



<div class="invite_map">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div id="map_canvas">
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
					<div class="detail_invite">
						<p class="pinn"> 住所:   </p>
						<p class="pinn"> 連絡先:   </p>
						<p class="pinn"> 交通:  </p>
			</div>
				</div>
			</div>
		
		</div>
	</div>





<%@ include file="../footer.jsp" %>

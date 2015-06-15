<%@ page language="java" contentType="text/html;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Foursquare Integration</title>
<script src="https://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<!-- Search Area -->
<div class="row">
	<div class="col-lg-12">
    	<div class="input-group">
      		<input type="text" class="form-control" placeholder="Search for...">
      		<span class="input-group-btn">
        	<input class="btn btn-default" type="submit" method="POST" action="/search">Search!</button>
      		</span>
    	</div><!-- /input-group -->
  	</div><!-- /.col-lg-12 -->
</div><!-- /.row -->

<!-- Map Area -->
<div id="map-canvas" style="height:600px; width:100%"></div>

<script>
	var locations = [
                 ['Bondi Beach', -33.890542, 151.274856, 4],
                 ['Coogee Beach', -33.923036, 151.259052, 5],
                 ['Cronulla Beach', -34.028249, 151.157507, 3],
                 ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],
                 ['Maroubra Beach', -33.950198, 151.259302, 1]
               ];

               var map = new google.maps.Map(document.getElementById('map-canvas'), {
                 zoom: 10,
                 center: new google.maps.LatLng(-33.92, 151.25),
                 mapTypeId: google.maps.MapTypeId.ROADMAP
               });

               var infowindow = new google.maps.InfoWindow();

               var marker, i;

               for (i = 0; i < locations.length; i++) {  
                 marker = new google.maps.Marker({
                   position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                   map: map
                 });

                 google.maps.event.addListener(marker, 'click', (function(marker, i) {
                   return function() {
                     infowindow.setContent(locations[i][0]);
                     infowindow.open(map, marker);
                   }
                 })(marker, i));
               }
	</script>
</body>
</html>
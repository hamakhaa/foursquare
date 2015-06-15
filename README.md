# whitbreadtest

This is a technical test requested from the employer. 

# How to use/run the project
This is a maven based project that would require maven setup on your machine. I have developed using eclipse ide. 
I have not committed any eclipse specific file which means you can use this on any project.

This is a java web based application which means it will run on a servlet container like tomcat. 
When you run maven clean install it will generate a WAR file that you can deploy to servlet container like tomcat

#Technologies used
1. Java
2. Spring MVC
3. Google Map API
4. FourSquare API
5. Bootstrap
6. HTML/CSS/Javascript

# The Implementation
I have implemented the application as java spring mvc based web application,the flow is something like below:

1. A jsp with url http://localhost:8080/foursquare-integration/index.jsp is the main page. In the first instance it will show a text field to search for a place.
2. Based on the value entered like 'Slough','London' it will go to the Spring MVC based controller to search.
3. In turn it will use the PlaceSearchService class to find the nearest places using the foursquare API.
4. The PlaceSearchService will get the response convert the objects into Place object and return back to PlaceSearchController that will return the data in the model.
5. The index.jsp will access the model data to populate on the google map, if there are places returned in the model.
6. For each venue/place foursquare returns lot of data. For this demo type of app and to make it simple, we have chosen to use the place name and latitude and longitude coordinates.  

# Why I havn't just used html/css/js
A typical app like this will be much more complex with n-tier architecture and will have server side components for business logic. While implementing with HTML/CSS/JS/AJAX is easy and straight forward but I wanted to implement 
something that is more close to the real implementation i.e. Java MVC based web application. 

# Things that should have been added
1. Due to time constraints have not added unit tests for controller and service layer.
2. In a real world app I would have added more validations

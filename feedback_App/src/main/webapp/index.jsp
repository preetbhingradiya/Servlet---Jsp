<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <%@ include file="components/link.jsp" %>
  </head>
  <body>
  	<%@ include file="sections/header.jsp" %>
    
    <div style="height: 80vh" class="content_conatiner py-4 d-flex flex-column justify-content-center align-items-center">
    	<a href="<%= application.getContextPath() %>/sections/feedback.jsp" class="btn btn-outline-primary">Give us feedback</a>
    </div> 
    
    <%@ include file="components/script.jsp" %>
  </body>
</html>
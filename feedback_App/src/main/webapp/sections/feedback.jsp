<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback Form</title>
    <%@ include file="../components/link.jsp" %>
  </head>
  <body>
  
  	<%@ include file="header.jsp" %>
    
    <div  class="content_conatiner py-4 d-flex flex-column justify-content-center align-items-center">
    	<h3>Fill the feedback form</h3>
    	
    	<form action="<%= application.getContextPath() %>/form" method="post">
			  <div class="mb-3">
			    	<label for="exampleInputEmail1" class="form-label">Email address</label>
			    	<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			    	<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    	<label for="exampleInputPassword1" class="form-label">Phone number</label>
			    	<input name="phone" type="text" class="form-control" id="exampleInputPassword1">
			  </div>
			  <div class="mb-3">
			    	<label for="exampleInputPassword1" class="form-label">Your feedback messahe</label>
			    	<textarea name="text" rows="3" cols="" class="form-control"></textarea>
			  </div>
			  <div class="container text-center">
			  		<button type="submit" class="btn btn-warning">Submit</button>
			  	    <button type="submit" class="btn btn-outline-primary">Reset</button>
			  </div>
		</form>
    </div> 
    
    <%@ include file="../components/script.jsp" %>
  </body>
</html>
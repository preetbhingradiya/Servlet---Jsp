<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Web App</title>
    <!-- Link to CSS file -->
    <%--  <link rel="stylesheet" type="text/css" href="css/style.css"> --%>
     <%-- use of application path so any time change project name this is also change  --%>
    <link rel="stylesheet" href=" <%= application.getContextPath() %>/css/style.css ">
</head>
<body>
	
	<%@ include file="menu.jsp" %>  <%-- include the menu file --%>
    <h2>Hello World!</h2>
    
    <form action="<%= application.getContextPath() %>/api" method="post">
    	<input name="message" type="text" placeholder="enter text here" />
    	
    	<button type="submit">Submit</button>
    </form>

    <script src="js/script.js"></script>
 

    <script>
        // Call the showAlert function when the page loads
        window.onload = function() {
            showAlert();
        };

    </script>
</body>
</html>

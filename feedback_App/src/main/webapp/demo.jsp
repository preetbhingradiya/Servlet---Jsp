<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 	Script tag -->
	<h1>Declaration Tag : </h1> <%! int num = 10, num2 = 20; String name = "jhon done"; %>
	
	<h1>Expression Tag : <%= num %>  <%= name %> </h1>
	
	<% int sum = num + num2;
		int sub = num - num2;
	%>
	<p>Sum is <%= sum %></p>
	<p>Sum is <%= sub %></p>

<!-- 	Directive -->
	<h1>Page Directive </h1>
	<%@ page import = "java.util.Date" %>
	<% Date d = new Date();%>
   <p>Current Date and Time: <%= d %></p>
   
<%--    	<%@page contentType = "text/html" %>	 --%>
	<%= "This is sparta" %>
	 
</body>	
</html>
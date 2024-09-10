<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Example</title>
</head>
<body>
	<h1>Taglib Directive</h1>
	<c:set var="name" value="Yogesh"></c:set>
	<c:out value="${name}" />

	<c:if test="${3 > 2 }">
		<h1>Codition true (3>2)</h1>
	</c:if>
	
	<c:set var="ans" value="${ 400*200}"/>
	<c:out value="${ ans}"/>

	<c:choose>
		<c:when test="${user.age >= 18}">
			<p>You are an adult.</p>
		</c:when>
		<c:otherwise>
			<p>You are a minor.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>

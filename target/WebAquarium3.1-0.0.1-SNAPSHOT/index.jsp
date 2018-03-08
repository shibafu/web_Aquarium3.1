<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Web水族館プロトプログラム</title>
	</head> 
	<body>
	<pre>${mybean}</pre>
		<c:url value="/hello" var="messageUrl" />
		<a href="${messageUrl}">Click to enter</a>
		
		<form action="sample" method="post">
			<input type="text" id ="message" name="message">
			<input type="submit" value="add">
		</form>
	</body>
</html>

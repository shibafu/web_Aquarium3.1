<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ page import="com.TsugaruInfo.*" %> 
<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>ユーザー登録フォーム&nbsp; 名前を決めてユーザー登録をしよう</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
</style>
</head>

<body>

<spring:url value="/register/confirm" var="action" />
<form:form modelAttribute="RegisterForm" action="${action}">

	<div class="auto-style1">
		ユーザー登録フォーム<br />
		<br />
		名前を決めてユーザー登録をしよう！<br />
		<br />
		<br />
		ユーザー名<br />
		<form:input path="username" style="width: 210px" />
		<br />
		E-mail<br />
		<form:input path="email" style="width: 210px" />
		<br />
		パスワード<br />
		<form:password path="password" style="width: 210px" />
		<br />
		パスワード（確認）<br />
		<form:password path="passwordConfirm" style="width: 210px" /><br />
		<br />
		<input type="submit" value="登録！" />
	</div>
</form:form>

</body>

</html>

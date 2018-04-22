<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>以下のユーザー情報で登録します</title>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
.auto-style2 {
	margin-left: 40px;
}
.auto-style3 {
	margin-left: 200px;
}
</style>
</head>

<body>

<p class="auto-style1">以下のユーザー情報で登録します。よろしいですか？</p>
<p class="auto-style1">ユーザー名</p>
<p class="auto-style1"><c:out value="${dummyDisplay.username}" /></p>
<p class="auto-style1">E-mail</p>
<p class="auto-style1"><c:out value="${dummyDisplay.email}" /></p>
<p class="auto-style1">パスワード</p>
<p class="auto-style1"><c:out value="${dummyDisplay.password}" /></p>
<p class="auto-style1">
<form method="post">
	<div class="auto-style1">
		<p class="auto-style2">
		<input class="auto-style3" name="submit" style="width: 142px" type="submit" value="登録！くコ:彡" /></p>
	</div>
</form>

</body>

</html>

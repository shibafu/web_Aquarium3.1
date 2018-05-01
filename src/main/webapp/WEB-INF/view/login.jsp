<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>ユーザー名がある場合はログインして下さい</title>
<style type="text/css">
.auto-style1 {
	margin-left: 120px;
}
</style>
</head>

<body>

<h3 class="auto-style1">ユーザー名がある場合はログインして下さい</h>

<c:if test="${param.containsKey('error')}">
	<span style="color: red">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
	</span>
</c:if>

<p class="auto-style1">ユーザー名</p>

<c:url var="loginUrl" value="/login" />
<form:form action="${loginUrl}" >

	<input name="username" type="text" class="auto-style1" />
<p class="auto-style1">パスワード</p>
	<input name="password" type="password" class="auto-style1" /></p>

<input name="Submit" type="submit" value="submit" class="auto-style1" />


</form:form>

</body>

</html>

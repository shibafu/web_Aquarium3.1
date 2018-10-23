<!DOCTYPE>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>

<style type="text/css">
.title-animation {
	font-size: 70pt;
	color: #6666FF;
	font-family: メイリオ;
	font-weight: normal;
}
.auto-style1 {
	text-align: center;
	font-family: メイリオ;
}

  .ui-menu { width: 150px; }
</style>

<!-- textllateをインポート -->
<script src="<c:url value="/resources/js/jquery.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/jquery.textillate.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.fittext.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.lettering.js" />" type="text/javascript"></script>

<!-- 開発jsをインポート -->
<script src="<c:url value="/resources/js/webAqua.js" />" type="text/javascript"></script>

<!-- stylesheetをインポート -->
<link rel = "stylesheet" href="<c:url value="/resources/css/animate.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-uistructure.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-uistructure.min.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-ui.theme.css" />">
<link rel = "stylesheet" href="<c:url value="/resources/css/jquery-ui.theme.min.css" />">

<c:url var="common_header_url" value="/common/header" />

<!-- textllateを作動 -->
<!-- textllateを作動 -->
<script type="text/javascript">
/**
 * 共通ヘッダーをインポート
 */
	$(function(){
		$("header").load("${common_header_url}");
});


/**
 *　jQueryの色を変えるテスト
 */
 	$(function(){
 		$('.attention').css("color", "hotpink");

 		  $('#ukon').button({
 			    icons: {
 			      primary: 'ui-icon-scissors'
 			    },
 			    text: false
 		});


 		  $('.Button').button();

	});

</script>

<style type="text/css">
.ui-icon {
    zoom: 150%;
    -moz-transform: scale(1.50);
    -webkit-zoom: 1.50;
    -ms-zoom: 1.50;
}
</style>
</head>

<body style="background-color: #CCFFFF">
<header></header>

<c:if test="${param.containsKey('error')}">
	<span style="color: red">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
	</span>
</c:if>
<br/>
<div class="Button">
<h3 class="auto-style1">ユーザー名がある場合はログインして下さい</h>


<c:url var="loginUrl" value="/login" />
<form:form action="${loginUrl}" >

<div class="Button">
	<p class="auto-style1 Button">ユーザー名</p>
	<input name="username" type="text" class="auto-style1 Button" /><br/>
	<p class="auto-style1 Button">パスワード</p>
	<input name="password" type="password" class="auto-style1 Button" /><br/>

<input name="Submit" type="submit" value="submit" class="auto-style1 Button" /><br/>
</div>

</form:form>

</body>

</html>

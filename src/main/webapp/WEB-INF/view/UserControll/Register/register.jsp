<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<head>

<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Web水族館プロトプログラム</title>
<style type="text/css">
.title-animation {
	font-size: 70pt;
	color: #6666FF;
	font-family: メイリオ;
	font-weight: normal;
}
.auto-style3 {
	text-align: right;
	font-family: メイリオ;
}
.auto-style4 {
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

<c:url var="common_header_url" value="/resources/common/header.html" />
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

<header>
</header>

<spring:url value="/register/confirm" var="action" />
<form:form modelAttribute="RegisterForm" action="${action}">

	<div class="auto-style1 Button">
		ユーザー登録フォーム<br />
		<br />
		名前を決めてユーザー登録をしよう！<br />
		<br />
		<br />
		ユーザー名<br />
		<form:input path="username" style="width: 210px" class="Button"/>
		<br />
		E-mail<br />
		<form:input path="email" style="width: 210px"  class="Button"/>
		<br />
		パスワード<br />
		<form:password path="password" style="width: 210px"  class="Button"/>
		<br />
		パスワード（確認）<br />
		<form:password path="passwordConfirm" style="width: 210px"  class="Button"/><br />
		<br />
		<input type="submit" value="登録！"  class="Button"/>
	</div>
</form:form>

</body>

</html>

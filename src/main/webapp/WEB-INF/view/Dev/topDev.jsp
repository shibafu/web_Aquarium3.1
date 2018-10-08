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

<h1 class="title-animation">Welcome</h1>
<p class="auto-style3">ログイン　管理コンソール　</p>
<p class="auto-style4">ここはWeb水族館（予定地）です。</p>
<p class="auto-style4">きれいな魚の写真や海の情報を集めていく予定です。</p>
<p class="auto-style4">&nbsp;</p>


<p class="attention">jqueryのエフェクトテストです</p>
<p>このタグは反映されません。</p>


<button class="WarnButton" name="alertButton">ウィンドウを表示します</button>


	<button id="ukon" name="Button">うこん</button>


</body>

</html>

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

<header>
</header>

<div class="Button">
<form:form action="imageComplete"  method="post"
modelAttribute="ImageUploadForm" enctype="multipart/form-data">
	<p>お気に入りの海とか水の画像を入力してください！＞＜</p>
	<input name="image" type="file"  class="Button"/>


	<p>ファイル名</p>
	<input name="filename" type="text" class="Button" />

	<input name="登録する" type="submit" class="Button">
</form:form>
</div>

</body>

</html>

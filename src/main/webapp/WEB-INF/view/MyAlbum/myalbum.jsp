<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>マイアルバム</title>


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
<script src="<c:url value="/resources/js/fotorama/fotorama.js" />"></script>

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
<link rel = "stylesheet" href="<c:url value="/resources/css/fotorama/fotorama.css" />" >


<c:url var="common_header_url" value="/common/header" />

<!-- スクリプトを起動 -->
<script type="text/javascript">
/**
 * 共通ヘッダーをインポート
 */
	$(function(){
		$("header").load("${common_header_url}");
});
</script>
</head>
<body style="background-color: #CCFFFF">

<header></header>

<p>マイアルバム</p>
<!-- fotoramaプラグインを導入　サムネイルスライドショーにする。 -->
<div style="width:800; height:600;" >
<div class="fotorama"
     data-nav="thumbs" data-fit="cover" >
<!-- 画像表示ループ -->
<c:forEach var="picture" items="${albumPicutresList}" varStatus="status">

		<img src="data:image/${picture.extension};base64,${picture.base64string}"data-caption="${picture.pictureName}"  data-fit="contain"/>
</c:forEach>
</div>
</div>

</body>

</html>

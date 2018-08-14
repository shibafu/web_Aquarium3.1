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
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />" type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/jquery.textillate.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.fittext.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.lettering.js" />" type="text/javascript"></script>

<!-- stylesheetをインポート -->
<link rel = "stylesheet" href="<c:url value="/resources/css/animate.css" />"></link>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />


<!-- textllateを作動 -->
<script>

/**
 * texillateのアニメーション
 */
	$(function () {
		$('.title-animation').textillate({

			in: {
				effect: 'rollIn',	// エフェクトの指定
				callback: function () {}	// コールバック関数
			},
		});
	})

/**
 *　jQueryの色を変えるテスト
 */
 	$(document).ready(function(){
 		$('.attention').css("color", "hotpink")


 		$('.listElement').css("color", "darkblue")

 		//ボタンをかっこよくする
 		$('#menu').menu()
	});

</script>
</head>

<body style="background-color: #CCFFFF">

<h1 class="title-animation">Welcome</h1>
<p class="auto-style3">ログイン　管理コンソール　</p>
<p class="auto-style4">ここはWeb水族館（予定地）です。</p>
<p class="auto-style4">きれいな魚の写真や海の情報を集めていく予定です。</p>
<p class="auto-style4">&nbsp;</p>


<p class="attention">jqueryのエフェクトテストです</p>
<p>このタグは反映されません。</p>
<table style="width: 100%; height: 123px">

<!-- リストに対してjQueryエフェクトをかける -->

<ul id="menu">
	<li class="listElement"><a href="#">マイページ</a></li>
	<li class="listElement"><a href="#">アルバム</a></li>
	<li class="listElement"><a href="#">アカウント設定</a></li>
	<li class="listElement"><a href="#">サイトスレッド</a></li>
</ul>

</table>

</body>

</html>

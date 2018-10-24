<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div  style=\"left:85%; position:relative\">

<c:url var="imageUpload" value="/imageUpload" />
<c:url var="login" value="/login" />
<c:url var="register" value="/register" />
<c:url var="MyAlbum" value="/MyAlbum" />

	<ul id="menu">
		<li><a href="#">サイトメニュー</a>
			<ul class="child">
				<li><a href="">マイページ　　</a></li>
				<li><a href="${MyAlbum}">アルバム　　　</a></li>
				<li><a href="${imageUpload}">画像追加　　　</a></li>
				<li><a href="${login}">ログイン　　　</a></li>
				<li><a href="${register}">ユーザー登録　</a></li>
				<li><a href="">サイトスレッド</a></li>
				<li><a href="">管理メニュー　</a></li>
			</ul>
		</li>
	</ul>

</div>
<br/>
<br/>
<br/>
<br/>



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
	});

/**
 *　jQueryの色を変えるテスト
 */
 	$(function(){


 		//メニューをかっこよくする
 		$('#menu').menu({
 			position: { my: "left top", at: "left top+26" }
		  });

		//マウスホバー実装

		$('#menu li')
			.hover(function() {
				$('ul:not(:animated)', this).slideDown();
				},
			function() {
				$('ul.child', this).slideUp();
		});
 		  $('.Button').button();


 		  $('.WarnButton').button();


	});
</script>
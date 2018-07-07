<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<meta content="ja" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>お気に入りの海とか水の画像を入力してください</title>
</head>

<body>
<p>
${UserName}さんが登録した画像ですヾ(｡>﹏<｡)ﾉﾞ</p>
<c:forEach var="picture" items="${UserPictures}" varStatus="status">

	<p>${picture.pictureName}</p>
	<<img src="data:image/${picture.extension};base64,${picture.base64string}">

</c:forEach>
</body>

</html>

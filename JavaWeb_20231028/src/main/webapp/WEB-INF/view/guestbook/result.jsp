<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Result</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
</head>
<body style="padding: 15px">
	<form class="pure-form">
		<fieldset>
			<legend>
				資料新增: ${ rowcount == 0 ? "失敗" : "成功" }
			</legend>
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/controller/guestbook/guestbook?pageNo=${pageNo}&recordsOfPage=${recordsOfPage}';">返回</button>
			<a href="${pageContext.request.contextPath}/controller/guestbook/guestbook?pageNo=${pageNo}&recordsOfPage=${recordsOfPage}">
				返回
			</a>
		</fieldset>
	</form>
</body>
</html>
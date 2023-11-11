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
	<form class="pure-form" method="get" action="${pageContext.request.contextPath}/controller/guestbook/guestbook">
		<fieldset>
			<legend>
				資料新增: ${ rowcount == 0 ? "失敗" : "成功" }
			</legend>
			<button type="submit">返回</button>
		</fieldset>
	</form>
</body>
</html>
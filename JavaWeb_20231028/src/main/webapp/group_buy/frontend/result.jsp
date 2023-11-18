<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網-新增結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<!-- menu -->
		<%@include file="./menu.jspf" %>
		Hello: John
		<form class="pure-form">
			<fieldset>
				<legend>團購網-新增結果</legend>
				商品: 雞腳凍(50元/包)<p />
				數量: 5 包<p />	 
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='./main.jsp';">返回</button>	 
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='./cart.jsp';">查看購物車</button>	 
			</fieldset>
		</form>
	</body>
</html>
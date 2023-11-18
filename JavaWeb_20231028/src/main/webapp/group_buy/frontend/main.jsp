<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網首頁</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		Hello: John
		<form method="post" action="./result.jsp" class="pure-form">
			<fieldset>
				<legend>團購網首頁</legend>
				商品: <select id="productId" name="productId">
						<option value="1">雞腳凍(50元/包)</option>
						<option value="2">肉羹(80元/包)</option>
						<option value="3">肉丸(60元/包)</option>
					 </select><p />
				數量: <input type="number" id="amount" name="amount" value="5" /><p />	 
				<button type="submit" class="pure-button pure-button-primary">新增</button>	 
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='./cart.jsp';">購物車</button>	 
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='../login.jsp';">登出</button>	 
			</fieldset>
		</form>
	</body>
</html>
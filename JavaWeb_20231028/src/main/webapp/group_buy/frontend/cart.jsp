<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網-購物車</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="../../css/group_buy.css">
	</head>
	<body style="padding: 15px">
		<form class="pure-form">
			<fieldset>
				<legend>團購網-購物車</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr><th>序號</th><th>品名</th><th>價格</th><th>單位</th><th>數量</th><th>修改</th><th>刪除</th></tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td><td>肉羹</td><td>80</td><td>包</td><td>7</td>
							<td><button class="button-success pure-button">修改</button></td>
							<td><button class="button-error pure-button">刪除</button></td>
						</tr>
					</tbody>
				</table>
				<p />
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='./main.jsp';">返回</button>	 
				<button type="button" class="pure-button pure-button-primary" onclick="location.href='../cart.jsp';">查看購物車</button>	 
			</fieldset>
		</form>
	</body>
</html>
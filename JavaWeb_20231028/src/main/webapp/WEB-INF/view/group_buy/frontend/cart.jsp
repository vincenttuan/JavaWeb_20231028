<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網-購物車</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="../../css/group_buy.css">
	</head>
	<body>
		<!-- menu -->
		<%@include file="./menu.jspf" %>
		
		<div style="padding: 15px">
			<form class="pure-form">
				<fieldset>
					<legend>團購網-購物車</legend>
					<table class="pure-table pure-table-bordered">
						<thead>
							<tr><th>序號</th><th>品名</th><th>價格</th><th>單位</th><th>數量</th><th>小計</th><th>修改數量</th><th>刪除</th></tr>
						</thead>
						<tbody>
							<c:forEach items="${ cart.cartItems }" var="item">
								<tr>
									<td>${ item.itemId }</td>
									<td>${ item.product.productName }</td>
									<td>${ item.product.price }</td>
									<td>${ item.product.unit }</td>
									<td>
										<input type="number" value="${ item.quantity }" />
									</td>
									<td>${ item.product.price * item.quantity }</td>
									<td>
										<button 
											onClick="location.href='./?_method=Put&itemId=${ item.itemId }&quantity=${ item.quantity }'"
											class="button-success pure-button">修改</button></td>
									<td>
										<button 
											onClick="location.href='./?_method=Delete&itemId=${ item.itemId }'"
											class="button-error pure-button">刪除</button>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">總計</td>
								<td>${ total }</td>
								<td colspan="2"></td>
							</tr>
						</tbody>
					</table>
					<p />
					<button type="button" class="pure-button pure-button-primary" onclick="location.href='./finish.jsp';">結帳</button>	 
				</fieldset>
			</form>
		</div>
		
	</body>
</html>
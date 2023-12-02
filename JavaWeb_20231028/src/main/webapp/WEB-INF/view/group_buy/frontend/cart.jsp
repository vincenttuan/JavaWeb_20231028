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
		
		<script type="text/javascript">
			function updateItem(itemId) {
				var quantity = document.getElementById('item_' + itemId + '_quantity').value;
				window.location.href='./cart.jsp?_method=Put&itemId=' + itemId + '&quantity=' + quantity;
			}
			
			function deleteItem(itemId) {
				window.location.href='./cart.jsp?_method=Delete&itemId=' + itemId;
			}
			
		</script>
		
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
										<input type="number" id="item_${ item.itemId }_quantity" value="${ item.quantity }" />
									</td>
									<td>${ item.product.price * item.quantity }</td>
									<td>
										<a href="javascript:void(0);" onClick="updateItem(${ item.itemId })">Update</a>
									</td>	
									<td>
										<a href="javascript:void(0);" onClick="deleteItem(${ item.itemId })">Delete</a>
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
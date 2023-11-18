<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網-後臺商品維護</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="../../css/group_buy.css">
	</head>
	<body style="padding: 15px">
		<!-- menu -->
		<table>
			<tr>
				<td valign="top">
					<form method="post" action="./result.jsp" class="pure-form">
						<fieldset>
							<legend>團購網-商品新增</legend>
							品名: <input type="text" id="productName" name="productName" value="水果茶" /><p />
							價格: <input type="number" id="productPrice" name="productPrice" value="40" /><p />
							單位: <select id="productUnit" name="productUnit">
									<option value="1">捆</option>
									<option value="2" selected>包</option>
									<option value="3">打</option>
									<option value="4">箱</option>
									<option value="5">組</option>
								 </select>
							<p />
							<button type="submit" class="pure-button pure-button-primary">新增</button>
						</fieldset>
					</form>
				</td>
				<td valign="top" style="padding-left: 15px">
					<form class="pure-form">
						<fieldset>
							<legend>團購網-後臺商品維護</legend>
							<table class="pure-table pure-table-bordered">
								<thead>
									<tr><th>序號</th><th>品名</th><th>價格</th><th>單位</th><th>上架</th></tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td><td>肉羹</td><td>80</td><td>包</td><td><input type="checkbox" checked> 上架</td>
									</tr>
									<tr>
										<td>2</td><td>肉丸</td><td>60</td><td>包</td><td><input type="checkbox" checked> 上架</td>
									</tr>
									<tr>
										<td>3</td><td>雞腳凍</td><td>50</td><td>包</td><td><input type="checkbox" checked> 上架</td>
									</tr>
								</tbody>
							</table>
							<p />
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
		
		
	</body>
</html>
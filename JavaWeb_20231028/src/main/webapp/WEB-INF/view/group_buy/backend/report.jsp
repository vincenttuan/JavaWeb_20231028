<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>團購網-後台報表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="../../css/group_buy.css">
	</head>
	<body>
		<!-- menu -->
		<%@include file="./menu.jspf" %>
		
		<div style="padding: 15px">
			<table>
				<tr>
					<td valign="top">
						<form class="pure-form">
							<fieldset>
								<legend>團購網-後台報表</legend>
								<table class="pure-table">
								    <thead>
								        <tr>
								            <th>#</th>
								            <th>帳號</th>
								            <th>金額</th>
								            <th>明細</th>
								        </tr>
								    </thead>
								    <tbody>
								        <tr class="pure-table-odd">
								            <td>1</td>
								            <td>John</td>
								            <td>$1,410</td>
								            <td>
								            	<button class="button-secondary pure-button">明細</button>
								            </td>
								        </tr>
								        <tr>
								            <td>2</td>
								            <td>Mary</td>
								            <td>$250</td>
								            <td>
								            	<button class="button-secondary pure-button">明細</button>
								            </td>
								        </tr>
								        <tr class="pure-table-odd">
								            <td>3</td>
								            <td>Mark</td>
								            <td>$560</td>
								            <td>
								            	<button class="button-secondary pure-button">明細</button>
								            </td>
								        </tr>
								        <tr>
								            <td>4</td>
								            <td>Helen</td>
								            <td>$2,850</td>
								            <td>
								            	<button class="button-secondary pure-button">明細</button>
								            </td>
								        </tr>
								        <tr class="pure-table-odd">
								            <td>5</td>
								            <td>Alen</td>
								            <td>$50</td>
								            <td>
								            	<button class="button-secondary pure-button">明細</button>
								            </td>
								        </tr>
								    </tbody>
								</table>
							</fieldset>
						</form>
					</td>
					<td valign="top" style="padding-left: 15px">
						<form class="pure-form">
							<fieldset>
								<legend>團購網- John 結帳明細</legend>
								<table class="pure-table pure-table-bordered">
									<thead>
										<tr><th>序號</th><th>品名</th><th>價格</th><th>單位</th><th>數量</th><th>小計</th></tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td><td>肉羹</td><td>80</td><td>包</td>
											<td>7</td>
											<td>560</td>
										</tr>
										<tr>
											<td>2</td><td>肉丸</td><td>60</td><td>包</td>
											<td>10</td>
											<td>600</td>
										</tr>
										<tr>
											<td>3</td><td>雞腳凍</td><td>50</td><td>包</td>
											<td>5</td>
											<td>250</td>
										</tr>
										<tr>
											<td colspan="5" align="right">總計</td>
											<td>1,410</td>
										</tr>
									</tbody>
								</table>
								<p />
							</fieldset>
						</form>
					</td>
				</tr>
			</table>
		
			
		</div>
		
		
	</body>
</html>
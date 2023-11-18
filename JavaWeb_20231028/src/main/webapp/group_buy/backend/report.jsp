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
					            <td>$1040</td>
					            <td>
					            	<button class="button-secondary pure-button">明細</button>
					            </td>
					        </tr>
					        <tr>
					            <td>1</td>
					            <td>John</td>
					            <td>$1040</td>
					            <td>
					            	<button class="button-secondary pure-button">明細</button>
					            </td>
					        </tr>
					        <tr class="pure-table-odd">
					            <td>1</td>
					            <td>John</td>
					            <td>$1040</td>
					            <td>
					            	<button class="button-secondary pure-button">明細</button>
					            </td>
					        </tr>
					        <tr>
					            <td>1</td>
					            <td>John</td>
					            <td>$1040</td>
					            <td>
					            	<button class="button-secondary pure-button">明細</button>
					            </td>
					        </tr>
					        <tr class="pure-table-odd">
					            <td>1</td>
					            <td>John</td>
					            <td>$1040</td>
					            <td>
					            	<button class="button-secondary pure-button">明細</button>
					            </td>
					        </tr>
					    </tbody>
					</table>
						 
				</fieldset>
			</form>
		</div>
		
		
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guest book (MySQL)</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		<form class="pure-form" method="post" action="${pageContext.request.contextPath}/controller/guestbook/guestbook">
			<fieldset>
				<legend>留言輸入 (MySQL)</legend>
				姓名: <input type="text" id="username" name="username" placeholder="請輸入姓名" required /><p />
				留言: <input type="text" id="message" name="message" placeholder="請輸入留言" required /><p />
				<button type="reset" class="pure-button">清除</button>
				<button type="submit" class="pure-button pure-button-primary">傳送</button>
			</fieldset>
		</form>
		<p />
		<form class="pure-form">
			<fieldset>
				<legend>留言紀錄 (MySQL)</legend>
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>
								<a href="" title="由小到大排序">▲</a> 
								序號
								<a href="" title="由大到小排序">▼</a>
							</th><th>姓名</th><th>留言</th><th>時間</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ guestbooks }" var="guestbook" varStatus="status">
							<tr>
								<td>${ guestbook.id }</td>
								<td>${ guestbook.username }</td>
								<td>${ guestbook.message }</td>
								<td>${ guestbook.createtime }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
</html>
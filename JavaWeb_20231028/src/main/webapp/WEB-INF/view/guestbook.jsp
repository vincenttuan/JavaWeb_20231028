<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Guest book</title>
	</head>
	<body>
		<form>
			<fieldset>
				<legend>留言輸入</legend>
				姓名: <input type="text" id="name" name="name" placeholder="請輸入姓名" required /><p />
				留言: <input type="text" id="message" name="message" placeholder="請輸入留言" required /><p />
				<button type="reset">清除</button>
				<button type="submit">傳送</button>
			</fieldset>
		</form>
		<p />
		<form>
			<fieldset>
				<legend>留言紀錄</legend>
				<table border="1">
					<thead>
						<tr>
							<th>序號</th><th>姓名</th><th>留言</th><th>時間</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ records }" var="record" varStatus="status">
							<tr>
								<td>${ status.index }</td>
								<td>${ records.name }</td>
								<td>${ records.message }</td>
								<td>${ records.datetime }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</form>
	</body>
</html>
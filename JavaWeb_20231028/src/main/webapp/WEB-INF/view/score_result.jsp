<%@ page import="java.util.Arrays"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Score Result</title>
		<style type="text/css">
			.failing { color: red; }
		</style>
	</head>
	<body>
		所有成績: ${ scores }<br />
		列出成績: 
		<table border="1">
			<thead>
				<tr>
					<th>序號</th><th>分數</th><th>評鑑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ scores }" var="score" varStatus="status">
					<tr>
						<td>${ status.index }</td>
						<td>${ score }</td>
						<td class="${ score >= 60 ? "" : "failing" }">
							${ score >= 60 ? "及格" : "不及格" }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		成績個數: ${ scoreMap.count }<br />
		成績總分: ${ scoreMap.sum }<br />
		成績平均: <fmt:formatNumber type="number" value="${ scoreMap.avg }" maxFractionDigits="1" /><br />
		最高成績: ${ scoreMap.max }<br />
		最低成績: ${ scoreMap.min }<br />
		
	</body>
</html>
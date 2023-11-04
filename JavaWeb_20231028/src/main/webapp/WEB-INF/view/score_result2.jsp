<%@page import="java.util.Map"%>
<%@ page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 取得傳過來的參數
	Object obj1 = request.getAttribute("scores");
	Object obj2 = request.getAttribute("scoreMap");
	// 適當的轉型
	String[] scores = null;
	Map<String, Number> scoreMap = null;
	if(obj1 != null) {
		scores = (String[])obj1;
	}
	if(obj2 != null && obj2 instanceof Map) {
		scoreMap = (Map<String, Number>)obj2;
	}
	
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Score Result</title>
	</head>
	<body>
		所有成績: <%=scores %><br />
		列出成績: 
		<table border="1">
			<thead>
				<tr>
					<th>序號</th><th>分數</th><th>評鑑</th>
				</tr>
			</thead>
			<tbody>
				<% if (scores != null) { %>
					
					<% for(int i=0;i<scores.length;i++) { %>
						
						<tr>
							<td><%=i %></td>
							<td><%=scores[i] %></td>
							<td><%=(Integer.parseInt(scores[i]) >= 60 ? "及格" : "不及格") %></td>
						</tr>
						
					<% } %>
									
				<% } %>
			</tbody>
		</table>
		<br />
		<% if (scoreMap != null) { %>
			成績個數: <%=scoreMap.get("count") %><br />
			成績總分: <%=scoreMap.get("sum") %><br />
			成績平均: <%=scoreMap.get("avg") %><br />
			最高成績: <%=scoreMap.get("max") %><br />
			最低成績: <%=scoreMap.get("min") %><br />
		<% } %>
	</body>
</html>
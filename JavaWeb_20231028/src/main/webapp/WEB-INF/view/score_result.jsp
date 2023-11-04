<%@ page import="java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Score Result</title>
	</head>
	<body>
		所有成績: ${ scores }<br />
		列出成績: 
		<c:forEach items="${ scores }" var="score">
			${ score }
		</c:forEach>
		<br />
		成績個數: ${ scoreMap.count }<br />
		成績總分: ${ scoreMap.sum }<br />
		成績平均: ${ scoreMap.avg }<br />
		最高成績: ${ scoreMap.max }<br />
		最低成績: ${ scoreMap.min }<br />
		
	</body>
</html>
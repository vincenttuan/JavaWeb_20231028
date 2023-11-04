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
		成績個數: ${ scoreMap.count }<br />
		成績總分: ${ scoreMap.sum }<br />
		成績平均: ${ scoreMap.avg }<br />
		最高成績: ${ scoreMap.max }<br />
		最低成績: ${ scoreMap.min }<br />
		
	</body>
</html>
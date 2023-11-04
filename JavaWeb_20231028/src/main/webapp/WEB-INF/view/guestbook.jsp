<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				${ records }
			</fieldset>
		</form>
	</body>
</html>
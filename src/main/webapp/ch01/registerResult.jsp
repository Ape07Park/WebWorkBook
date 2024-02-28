<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 결과</title>
</head>
<body>
	<table border="1">
		<tr><td>아이디</td><td>${user.uid}</td>
		<tr><td>비번</td><td>${user.pwd}</td>
		<tr><td>이름</td><td>${user.uname}</td>
		<tr><td>이메일</td><td>${user.email}</td>
	</table>
</body>
</html>
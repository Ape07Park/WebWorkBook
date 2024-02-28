<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--post 방식: 주소와 데이터 분리해서 전달--%> 
	<form action="calcResult.jsp" method="post"> 
		<input type ="number" name="num1">
		<input type ="number" name="num2">
		<button type="submit">send</button>
	</form>
</body>
</html>
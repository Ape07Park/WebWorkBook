<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>num1 ${param.num1}</h1>
	<h1>num2 ${param.num2}</h1>
	
	<%-- 모든 데이터가 문자열로 처리되어 전달되기에 int로 변환--%>
	<h1>sum ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>
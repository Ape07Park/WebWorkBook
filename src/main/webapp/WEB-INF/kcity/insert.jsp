<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>kcity insert</h1>
	<%-- 장소는 insert로, 방식은 post로 전송 --%>
	<form action="/wb/world/kcity/insert" method="post">
	<input type="text" name="name" placeholder="도시이름 입력"><br>
	<input type="text" name="countryCode" placeholder="나라이름 입력"><br>
	<input type="text" name="district" placeholder="지역 입력"><br>
	<input type="text" name="population" placeholder="인구수 입력"><br>
	<button type="submit">제출</button>
	<button type="reset">취소</button>
</body>
</html>
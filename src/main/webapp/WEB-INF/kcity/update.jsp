<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update 및 delete</h1>
	<%-- id는 수정 불가하게 하기 및 그대로 전송, 나머지는 수정 o --%>
	<%-- 장소는 insert로, 방식은 post로 전송 --%>
	<form action="/wb/world/kcity/update" method="post">
	
	<input type="hidden" name="id" value="${kcity.id}"><br>  <%-- id 값을 안보이게 전송. 이유는 id값도 같이 세팅해야하기에 그렇지만 id값은 primary key라서(다음 줄)  --%>
	<input type="text" name="id" value="${kcity.id}" disabled><br> <%-- id 값을 함부로 수정할 수 없게 함 --%>
	
	<input type="text" name="name" value="${kcity.name}" placeholder="도시이름 입력"><br>
	<input type="text" name="countryCode" value="${kcity.countryCode}" placeholder="나라이름 입력"><br>
	<input type="text" name="district" value="${kcity.district}" placeholder="지역 입력"><br>
	<input type="text" name="population" value="${kcity.population}" placeholder="인구수 입력"><br>
	<button type="submit">수정</button>
	
</body>
</html>
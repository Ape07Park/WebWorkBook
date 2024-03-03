<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
	th, td {text-align:center;}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>kcity list</h1>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>countryCode</th>
			<th>district</th>
			<th>population</th>
		</tr>
		
		<c:forEach var="kcity" items="${list}">
		<tr>
			<td>${kcity.id}</td>
			<td>${kcity.name}</td>
			<td>${kcity.countryCode}</td>
			<td>${kcity.district}</td>
			<td>${kcity.population}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/member/update" method="POST" name="updateForm">
	
	id : <input type="text" name="id" value="${member.id}" readonly>
	email : <input type="text" name="memberEmail" value="${member.memberEmail}" readonly >
	password : <input type="text" name="memberPassword" value="${member.memberPassword}" >
	name : <input type="text" name="memberName" value="${member.memberName}">
	age :<input type="text" name="memberAge" value="${member.memberAge}">
	mobile :<input type="text" name="memberMobile" value="${member.memberMobile}">

	<input type="button" value="수정" onclick="update()">
	</form>

</body>
</html>
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
	password : <input type="text" name="memberPassword" id="memberPassword" value="${member.memberPassword}"  >
	name : <input type="text" name="memberName" value="${member.memberName}" readonly>
	age :<input type="text" name="memberAge" value="${member.memberAge}">
	mobile :<input type="text" name="memberMobile" value="${member.memberMobile}">

	<input type="button" value="수정" onclick="update()">
	</form>
	
	<script>
	
	 const update = () => {
	 const passwordDB = '${member.memberPassword}' ;
	 //사용자가입력한 비밀번호가 일치하다면 
	 const password = document.getElementById("memberPassword").value;
	 
	 if(passwordDB == password){
		 document.updateForm.submit();
	 }else{
		 alert("비밀번호가 일치하지 않습니다.");
	 }
	 
	}
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
 <h2>Hello Spring Framework 회원 프로젝트</h2>
 <a href="/member/save">회원가입</a>
 <a href="/member/login">로그인</a>
 <a href="/member/">회원목록조회</a>
 
 
 <h2>${sessionScope.loginEmail} 님 환영합니다. </h2>
 <button onClick="update()">내정보 수정하기</button>
 <button onClick="logout()">로그아웃</button>

<script>
const update = () => {
	location.href="/member/update";
}
/* const logout = () => {
	location.href="/member/logout";
} */
</script>
</body>



</html>
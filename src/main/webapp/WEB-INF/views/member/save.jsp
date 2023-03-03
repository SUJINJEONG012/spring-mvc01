<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script
  src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
  
</head>

<body>
<form action="/member/save" method="post">
 <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
 <p id="check-result"></p>
 <input type="text" name="memberPassword" placeholder="비밀번호">
 <input type="text" name="memberName" placeholder="이름">
 <input type="text" name="memberAge" placeholder="나이">
 <input type="text" name="memberMobile" placeholder="전화번호">
 <input type="submit" value="회원 가입">
</form>

<script>
/*
 * 이메일 입력값을 가져오고,입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크 후
   사용가능 여부를 이메일 입력창 아래에 표시
 */
 const emailCheck = () =>{
	 const email = document.getElementById("memberEmail").value;
	 const checkResult = document.getElementById("check-result");
	 
	 console.log("입력한 이메일 ", email);
	 $.ajax({
		 //요청방식 post, url: "email-check",  데이터: 이메일 
		 type : "post",
		 url : "/member/email-check",
		 data : {"memberEmail"  : email //파라미터이름 , 담기는 데이터
	     }, 
	     success: function(res){
	    	 console.log("요청성공 : ", res);
	    	 if(res == "ok"){
	    		 console.log("사용가능한 이메일");
	    		 checkResult.style.color = "green";
	    		 checkResult.innerHTML = "사용가능한 이메일 입니다.";
	    	 }else{
	    		 console.log("이미 사용중인 이메일");
	    		 checkResult.style.color = "red";
	    		 checkResult.innerHTML = "사용중인 이메일 입니다.";
	    	 }
	     },  
	     error: function(err){
	    	 console.log("에러발생", err);
	     }
	     
 	 })
 }
 
</script>

</body>
</html>
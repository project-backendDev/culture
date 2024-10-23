<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
	
	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script>
		function loginChk() {
			alert("로그인");
		}
	</script>
</head>
<body>

	로그인
	<form method="POST" action="${pageContext.request.contextPath }/login/userLogin.do" onSubmit="loginChk();">
		<div>
			<span>
				아이디	
			</span>
			<span>
				<input type="text" name="userId" id="userId" />
			</span>
		</div>
		
		<div>
			<span>
				비밀번호
			</span>
			<span>
				<input type="text" name="userPw" id="userPw" />
			</span>
		</div>
		<input type="submit" value="로그인" />
	</form>
	
	<div>
		<span>
			<a href="${pageContext.request.contextPath }/user/registView">회원가입</a>
		</span>
	</div>
</body>
</html>
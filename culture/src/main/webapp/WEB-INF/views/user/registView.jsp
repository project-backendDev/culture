<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원가입 페이지 </title>

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

	<!-- 다음 우편번호 검색 스크립트 -->
	<!-- 
	<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	 -->
	<!-- -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/daumPostCode.js"></script>
	
	<script>
		function submitChk() {
			alert("회원가입!!");
		}
	</script>
</head>
<body>

	<strong> 
		회원가입 페이지
	</strong>
	
	<form method="POST" action="${pageContext.request.contextPath }/user/registUser" onsubmit="submitChk();">
		<input type="hidden" name="regDate" id="regDate" />
		<input type="hidden" name="editDate" id="editDate" />
		<input type="hidden" name="lastLogin" id="lastLogin" />
		<input type="hidden" name="userType" id="userType" value="NORMAL" />
		<input type="hidden" name="loginType" id="loginType" value="site" />
		<input type="hidden" name="addItem01" id="addItem01" />
		<input type="hidden" name="addItem02" id="addItem02" />
		<input type="hidden" name="addItem03" id="addItem03" />
		
		아이디
		<input type="text" name="userId" id="userId" />
		
		<br />
		
		비밀번호
		<input type="text" name="userPw" id="userPw" />
		
		<br />
		
		이름
		<input type="text" name="name" id="name" />
		
		<br />
		
		전화번호
		<span style="display: flex;">
			<input type="text" name="tel" id="tel_1" /> - <input type="text" name="tel" id="tel_2" /> - <input type="text" name="tel" id="tel_3" />
		</span>
		
		<br />
		
		생년월일
		<input type="text" name="birthday" id="birthday" />
		
		<br />
		
		성별
		<span style="display: flex">
			<input type="radio" name="gender" value="F"> 여성
			<input type="radio" name="gender" value="M"> 남성
		</span>
		
		<br />
		
		우편번호
		<span style="display: flex">
			<input type="text" name="postcode" id="postcode" required />
			<input type="button" class="postcodeBtn" onClick='execDaumPostcode("postcode", "addr1", "addr2")' value="우편번호 검색" />
			<input type="text" name="addr1" id="addr1" placeholder="주소를 입력하세요" />
			<input type="text" name="addr2" id="addr2" placeholder="상세주소를 입력하세요" />
		</span>
		
		<input type="submit" value="회원가입" />
	</form>
</body>
</html>
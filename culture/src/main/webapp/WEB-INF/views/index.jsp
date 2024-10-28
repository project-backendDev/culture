<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script>
		function userLogout() {
			var con = confirm("로그아웃하시겠습니까?");
			
			if (con) {
				alert("로그아웃이 완료되었습니다.");
			}
		}
	</script>
</head>
<body>

	<div>
		<c:choose>
			<c:when test="${configList != null && fn:length(configList) > 0 }">
				<c:forEach var="list" items="${configList }" varStatus="staus">
					<span style="border: 1px solid red; padding-right: 10px;">
						<a href="${pageContext.request.contextPath }/board/${list.configSeq}/artclList">
							${list.boardNm }				
						</a>
					</span>
				</c:forEach>
			</c:when>
		</c:choose>
	</div>

	메인 페이지
	
	<c:choose>
		<c:when test="${empty sessionScope }">
			<a href="${pageContext.request.contextPath }/login/loginView">로그인</a>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="sUserId" value="${sessionScope.userInfo.userId }" />
			<a href="${pageContext.request.contextPath }/login/userLogout.do" onClick="javascript:userLogout();">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	<div style="border: 1px solid red;">
		<c:forEach var="list" items="${moviList }" varStatus="status">
			${list.original_title }
		</c:forEach>
	</div>
</body>
</html>
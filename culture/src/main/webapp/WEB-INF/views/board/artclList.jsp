<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>
					<input type="checkbox" id="allCheck" name="allCheck">
				</th>
				<th>
					번호
				</th>
				<th>
					제목
				</th>
				<th>
					내용
				</th>
				<th>
					작성자
				</th>
				<th>
					작성일자
				</th>
				<th>
					조회수
				</th>		
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${artclList != null && fn:length(artclList) > 0 }">
					<c:forEach var="list" items="${artclList }" varStatus="status">
						<tr>
							<td>
								<input type="checkbox" name="checkbox" class="deleteBbsSetupSeqs" value="${list.boardSeq }" />
							</td>
							<td>
								${list.boardSeq }
							</td>
							<td>
								${list.title }
							</td>
							<td>
								${list.content }
							</td>
							<td>
								${list.writer }
							</td>
							<td>
								${list.regDate }
							</td>
							<td>
								${list.viewCo }
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					등록된 게시글이 없습니다.
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<input type="hidden" name="glems" value="${vo.configSeq }" />
	<div>
		<span>
			<a href="${pageContext.request.contextPath }/board/${config.configSeq }/artclRegistView">
				<button>게시글 작성</button>
			</a>
		</span>
	</div>
	
</body>
</html>
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
					게시판 이름
				</th>
				<th>
					게시판 사용 여부
				</th>
				<th>
					댓글 사용 여부
				</th>
				<th>
					에디터 사용 여부
				</th>
				<th>
					익명 사용 여부
				</th>
				<th>
					비밀글 사용 여부
				</th>
				<th>
					게시판 생성일자
				</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test='${configList != null && fn:length(configList) > 0 }'>
					<c:forEach var="list" items="${configList }" varStatus="status">
						<tr>
							<td>
								<input type="checkbox" name="checkbox" class="deleteBbsSetupSeqs" value="${list.configSeq }" />
							</td>
							<td>
								${list.configSeq }
							</td>
							<td>
								${list.boardNm }
							</td>
							<td>
								${list.boardUseYn }
							</td>
							<td>
								${list.commentUseYn }
							</td>
							<td>
								${list.editorUseYn }
							</td>
							<td>
								${list.anonymousUseYn }
							</td>
							<td>
								${list.secretUseYn }
							</td>
							<td>
								${list.regDate }
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/admin/board/${list.configSeq }/configUpdtView">
									<button>수정</button>
								</a>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/admin/board/${list.configSeq }/configDelete.do">
									<button>삭제</button>
								</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise> 
					생성된 게시판이 없습니다.
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<div>
		<span>
			<a href="${pageContext.request.contextPath }/admin/board/configRegistView">
				<button>게시판 추가</button>
			</a>
		</span>
	</div>
</body>
</html>
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
	<form method="POST" action="${pageContext.request.contextPath }/admin/board/${config.configSeq }/configUpdt.do">
		<div>
			<label for="boardNm">게시판명</label>
			<div>
				<input type="text" name="boardNm" id="boardNm" value="${config.boardNm }">
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="board_use_yn">게시판 사용여부</label>
			<div>
				<c:choose>
					<c:when test="${config.boardUseYn == 'Y' }">
						<span>
							<label for="boardUse_Y">
								<input type="radio" id="boardUseY" name="boardUseYn" value="Y" checked /> 사용
							</label>
						</span>
						<span>
							<label for="boardUse_N">
								<input type="radio" id="boardUseN" name="boardUseYn" value="N" /> 미사용
							</label>
						</span>
					</c:when>
					<c:otherwise>
						<span>
							<label for="boardUse_Y">
								<input type="radio" id="boardUseY" name="boardUseYn" value="Y" /> 사용
							</label>
						</span>
						<span>
							<label for="boardUse_N">
								<input type="radio" id="boardUseN" name="boardUseYn" value="N" checked /> 미사용
							</label>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="comment_use_yn">댓글 사용여부</label>
			<div>
				<c:choose>
					<c:when test="${config.commentUseYn == 'Y' }">
						<span>
							<label for="commentUse_Y">
								<input type="radio" id="commentUseY" name="commentUseYn" value="Y" checked /> 사용
							</label>
						</span>
						<span>
							<label for="commentUse_N">
								<input type="radio" id="commentUseY" name="commentUseYn" value="N" /> 미사용
							</label>
						</span>
					</c:when>
					<c:otherwise>
						<span>
							<label for="commentUse_Y">
								<input type="radio" id="commentUseY" name="commentUseYn" value="Y" /> 사용
							</label>
						</span>
						<span>
							<label for="commentUse_N">
								<input type="radio" id="commentUseY" name="commentUseYn" value="N" checked /> 미사용
							</label>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="editor_use_yn" > 에디터 사용여부 </label>
			<div>
				<c:choose>
					<c:when test="${config.editorUseYn == 'Y' }">
						<span>
							<label for="commentUse_Y">
								<input type="radio" id="editorUseY" name="editorUseYn" value="Y" checked /> 사용
							</label>
						</span>
						<span>
							<label for="commentUse_N">
								<input type="radio" id="editorUseN" name="editorUseYn" value="N" /> 미사용
							</label>
						</span>
					</c:when>
					<c:otherwise>
						<span>
							<label for="commentUse_Y">
								<input type="radio" id="editorUseY" name="editorUseYn" value="Y" /> 사용
							</label>
						</span>
						<span>
							<label for="commentUse_N">
								<input type="radio" id="editorUseN" name="editorUseYn" value="N" checked /> 미사용
							</label>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="anonymous_use_yn" > 익명 사용여부 </label>
			<div>
				<c:choose>
					<c:when test="${config.anonymousUseYn == 'Y' }">
						<span>
							<label for="anonymousUse_Y">
								<input type="radio" id="anonymousUseY" name="anonymousUseYn" value="Y" checked /> 사용
							</label>
						</span>
						<span>
							<label for="anonymousUse_N">
								<input type="radio" id="anonymousUseN" name="anonymousUseYn" value="N" /> 미사용
							</label>
						</span>
					</c:when>
					<c:otherwise>
						<span>
							<label for="anonymousUse_Y">
								<input type="radio" id="anonymousUseY" name="anonymousUseYn" value="Y" /> 사용
							</label>
						</span>
						<span>
							<label for="anonymousUse_N">
								<input type="radio" id="anonymousUseN" name="anonymousUseYn" value="N" checked /> 미사용
							</label>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="secret_use_yn" > 비밀글 사용여부 </label>
			<div>
				<c:choose>
					<c:when test="${config.secretUseYn == 'Y' }">
						<span>
							<label for="secretUse_Y">
								<input type="radio" id="secretUseY" name="secretUseYn" value="Y" checked /> 사용
							</label>
						</span>
						<span>
							<label for="secretUse_N">
								<input type="radio" id="secretUseN" name="secretUseYn" value="N" /> 미사용
							</label>
						</span>
					</c:when>
					<c:otherwise>
						<span>
							<label for="secretUse_Y">
								<input type="radio" id="secretUseY" name="secretUseYn" value="Y" /> 사용
							</label>
						</span>
						<span>
							<label for="secretUse_N">
								<input type="radio" id="secretUseN" name="secretUseYn" value="N" checked /> 미사용
							</label>
						</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<div>
			<button type="submit">수정하기</button>
		</div>
		
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath }/admin/board/configRegist.do" id="registForm">
		<div>
			<label for="boardNm">게시판명</label>
			<div>
				<input type="text" name="boardNm" id="boardNm" required>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="board_use_yn">게시판 사용여부</label>
			<div>
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
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="comment_use_yn" > 댓글 사용여부 </label>
			<div>
				<span>
					<label for="commentUse_Y">
						<input type="radio" id="commentUseY" name="commentUseYn" value="Y" checked /> 사용
					</label>
				</span>
				<span>
					<label for="commentUse_N">
						<input type="radio" id="commentUseN" name="commentUseYn" value="N" /> 미사용
					</label>
				</span>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="editor_use_yn" > 에디터 사용여부 </label>
			<div>
				<span>
					<label for="editorUse_Y">
						<input type="radio" id="editorUseY" name="editorUseYn" value="Y" checked /> 사용
					</label>
				</span>
				<span>
					<label for="editorUse_N">
						<input type="radio" id="editorUseN" name="editorUseYn" value="N" /> 미사용
					</label>
				</span>
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="anonymous_use_yn" > 익명 사용여부 </label>
			<div>
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
			</div>
		</div>
		
		<hr />
		
		<div>
			<label for="secret_use_yn" > 비밀글 사용여부 </label>
			<div>
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
			</div>
		</div>
		
		<%-- 버튼 영역 --%>
		<div>
			<button type="submit" id="regist"> 생성하기 </button>
		</div>
	</form>
</body>
</html>
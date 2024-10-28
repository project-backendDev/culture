<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- Jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- CKEditor4 -->
    <!--  <script src="http://cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>   -->
    <script src="${pageContext.request.contextPath}/ckeditor4/ckeditor.js"></script>
	
</head>
<body>
	<div>
		<span>
			<h1>게시글 작성</h1>
		</span>
	</div>
	
	<div>
		<form method="POST" action="${pageContext.request.contextPath }/board/${vo.configSeq}/artclRegist.do">
			<input type="hidden" name="configSeq" value="${vo.configSeq }" />
			
			<div>
				<span>제목</span>
				<input type="text" id="title" name="title" />
			</div>
			
			<div>
				<span>작성자</span>
				<input type="text" id="writer" name="writer" />
			</div>
			
			<div>
				<span>내용</span>
				<textarea name="content" id="content" class="ckedditor"></textarea>
                <!-- CKEditor 사용할때 꼭 넣어야되는 스크립트 -->
                <script>
                    /** CKEditor 4 */
                    CKEDITOR.replace('content', {
                    	filebrowserUploadUrl        : '${pageContext.request.contextPath }/board/${vo.configSeq}/imageUpload.do',
                    	height : '500px'
                    });
                </script>
			</div>
			
			<div>
				<button type="submit">글 작성</button>	
			</div>
		</form>
	</div>
</body>
</html>
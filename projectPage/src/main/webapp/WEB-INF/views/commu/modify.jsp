<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-main-style">
	<h2>글 수정</h2>
	<form:form action="modify.do" enctype="multipart/form-data" commandName="commuVO">
	<form:hidden path="board_num"/>
		<ul>    
			<li>
				<label for="board_name">제목</label>
				<form:input path="board_name"/>
				<form:errors path="board_name" cssClass="error-color"/>
			</li>
			<li>
				<label for="board_con">내용</label>
				<form:textarea path="board_con"/>
				<form:errors path="board_con" cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일업로드</label>
				<input type="file" name="upload" id="upload">
				<c:if test="${!empty commuVO.board_filename}">
				<br>
				<span>(${commuVO.board_filename})파일이 등록되어 있습니다.
				다시 업로드 하면 파일은 삭제됩니다.</span>
				</c:if>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='community.do'">
		</div>
	</form:form>
</div>
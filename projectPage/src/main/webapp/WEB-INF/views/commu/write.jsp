<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-main-style">
	<h2>글 쓰기</h2>
	<form:form action="write.do" enctype="multipart/form-data" commandName="commuVO">
		<form:hidden path="board_num" />
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
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록" onclick="location.href='community.do'">
		</div>
	</form:form>
</div>
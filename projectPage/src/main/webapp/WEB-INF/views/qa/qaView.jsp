<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="../css/board.css">
<style>
textarea.commentForm{
	rows: 10;
	width: 100%;
	border: 1;
	height: 100px;
	overflow: visible;
	text-overflow:ellipsis;

}
</style>
<script>
	function delete_btn(){
		if(confirm('삭제 하시겠습니까?')){
			alert('삭제 되었습니다.');
			location.href='delete.do?num=${qa.num}';
		}
	}
</script>
<div class="page-main-style">
	<table class="boardView">
	<tr>
		<td colspan="5"><h2>${qa.title}</h2></td>
	</tr>
	<tr>
		<th width="12%">번호</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
		<th>수정일</th>
	</tr>
	<tr>
		<td>${qa.num}</td>
		<td>${qa.mem_id}</td>
		<td>${qa.hit}</td>
		<td>${qa.reg_date}</td>
		<td>${qa.modify_date}</td>
	</tr>
	<tr>
		<th colspan="5">내용</th>
	</tr>
	<c:if test="${!empty qa.filename}">
		<td colspan="5">첨부파일 : <a href="file.do?num=${qa.num}">${qa.filename}</a></td>
	</c:if>
	<c:if test="${fn:endsWith(qa.filename,'.jpg') ||  
				  fn:endsWith(qa.filename,'.JPG') ||
				  fn:endsWith(qa.filename,'.gif') ||
				  fn:endsWith(qa.filename,'.GIF') ||
				  fn:endsWith(qa.filename,'.png') ||
				  fn:endsWith(qa.filename,'.PNG')}">
	</c:if>
	<tr>
		<td colspan="5" align="left"><p>${qa.content}</p></td>
	</tr>
	</table>
	
		<!-- 댓글 목록 영역 -->
	<table class="commentView">
		<tr>
			<th colspan="5">관리자 답변</th>
		</tr>
		<tr>
			<td class="writer" width="12%"><strong>SELLCAR</strong></td>				
			<td class="content">
				<c:forEach var="reply" items="${reply}">
				   <p><c:out value="${reply.content}"/></p>
				</c:forEach>
			</td>
		</tr>
	</table>
	<!-- 댓글쓰기 영역 -->
	<c:if test="${user_auth == 3}">
	<table class="commentView">
		<tr>
			<th colspan="2">댓글</th>
		</tr>		
		<tr>
			<td class="writer" width="12%"><strong>댓글 쓰기</strong></td>
			<td class="content">			
					<textarea name="content" class="textarea" style="width: 1110px"></textarea>
					<input type="submit" value="확인" class="replyBt" onclick="location.href='replyWrite.do'" />	
			</td>
		</tr>
	</table>
	</c:if>
		
	<div class="align-right">
		<!-- 글 수정 및 삭제를 하려면 로그인한 후 로그인 아이디와 작성자 아이디가 일치 -->
		<c:if test="${!empty user_id && user_id == qa.mem_id}">
		<input type="button" value="수정" onclick="location.href='update.do?num=${qa.num}'">
		<input type="button" value="삭제" onclick="delete_btn()">
		</c:if>
		<input type="button" value="목록으로" style="margin-top: 10px" onclick="location.href='list.do'">
	</div>
</div>






    
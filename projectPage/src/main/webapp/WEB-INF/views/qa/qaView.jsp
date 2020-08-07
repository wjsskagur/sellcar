<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="page-main-style">
	<table class="boardView">
	<tr>
		<td colspan="5"><h2>${qa.title}</h2></td>
	</tr>
	<tr>
		<th>번호</th>
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
	<table class="commentView">
		<tr>
			<th colspan="2">댓글</th>
		</tr>		
		<c:forEach var="comment" items="${commentList}">
		<tr>
			<td class="writer">				
				<p>${comment.writer}
				<c:if test="${comment.writerId == user_id}">
					<br /><a onclick="commentDelete(${comment.idx}, ${board.idx})"><small>댓글 삭제</small></a>					
				</c:if>
				</p>
			</td>
			<td class="content" align="left">
				<span class="date">${comment.reg_date}</span>
				<p>${comment.content}</p>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td class="writer"><strong>댓글 쓰기</strong></td>
			<td class="content">
				<form action="commentWrite.do" method="post">
					<input type="hidden" id="writer" name="writer" value="${mem_id}" />
					<input type="hidden" id="linkedArticleNum" name="linkedArticleNum" value="${board.idx}" />
					<textarea id="content" name="content" class="commentForm"></textarea>
					<input type="submit" value="확인" class="commentBt" />
				</form>
			</td>
		</tr>
	</table>
	<div class="align-right">
		<!-- 글 수정 및 삭제를 하려면 로그인한 후 로그인 아이디와 작성자 아이디가 일치 -->
		<c:if test="${!empty user_id && user_id == qa.mem_id}">
		<input type="button" value="수정" onclick="location.href='update.do?num=${qa.num}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?num=${qa.num}'">
		</c:if>
		<input type="button" value="목록으로" onclick="location.href='list.do'">
	</div>
</div>






    
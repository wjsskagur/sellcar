<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="page-main-style">
	<h2>${qa.title}</h2>
	<ul>
		<li>번호 : ${qa.num}</li>
		<li>작성자 : ${qa.mem_id}</li>
		<li>조회수 : ${qa.hit}</li>
		<li>작성일 : ${qa.reg_date}</li>
		<li>수정일 : ${qa.modify_date}</li>
		<c:if test="${!empty qa.filename}">
		<li>첨부파일 : <a href="file.do?num=${qa.num}">${qa.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(qa.filename,'.jpg') ||  
				  fn:endsWith(qa.filename,'.JPG') ||
				  fn:endsWith(qa.filename,'.gif') ||
				  fn:endsWith(qa.filename,'.GIF') ||
				  fn:endsWith(qa.filename,'.png') ||
				  fn:endsWith(qa.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?num=${qa.num}" style="max-width:500px">
	</div>
	</c:if>
	<p>
		${qa.content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<!-- 글 수정 및 삭제를 하려면 로그인한 후 로그인 아이디와 작성자 아이디가 일치 -->
		<c:if test="${!empty user_id && user_id == qa.id}">
		<input type="button" value="수정" onclick="location.href='update.do?num=${qa.num}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?num=${qa.num}'">
		</c:if>
		<input type="button" value="목록으로" onclick="location.href='list.do'">
	</div>
</div>






    
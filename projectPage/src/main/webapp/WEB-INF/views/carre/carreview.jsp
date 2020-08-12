<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="page-main-style">
	<h2>${carre.title}</h2>
	<ul>
		<li>번호 : ${carre.num}</li>
		<li>작성자 : ${carre.mem_id}</li>
		<li>조회수 : ${carre.hit}</li>
		<li>작성일 : ${carre.reg_date}</li>
		<li>수정일 : ${carre.modify_date}</li>
		<c:if test="${!empty carre.filename}">
		<li>첨부파일 : <a href="file.do?num=${carre.num}">${carre.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(carre.filename,'.jpg') ||  
				  fn:endsWith(carre.filename,'.JPG') ||
				  fn:endsWith(carre.filename,'.gif') ||
				  fn:endsWith(carre.filename,'.GIF') ||
				  fn:endsWith(carre.filename,'.png') ||
				  fn:endsWith(carre.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?num=${carre.num}" style="max-width:500px">
	</div>
	</c:if>
	<p>
		${carre.content}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<!-- 글 수정 및 삭제를 하려면 로그인한 후 로그인 아이디와 작성자 아이디가 일치 -->
		<c:if test="${!empty user_id && user_id == carre.mem_id}">
		<input type="button" value="수정" onclick="location.href='update.do?num=${carre.num}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?num=${carre.num}'">
		</c:if>
		<input type="button" value="목록으로" onclick="location.href='carrelist.do'">
	</div>
</div>
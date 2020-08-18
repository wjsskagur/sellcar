<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="page-main-style">
	<h2>${board.board_name}</h2>
	<ul>
		<li>번호 : ${board.board_num}</li>
		<li>작성자 : ${board.mem_id}</li>
		<li>조회수 : ${board.board_hit}</li>
		<li>작성일 : ${board.reg_date}</li>
		<li>최근 수정일 : ${board.mod_date}</li>
		<c:if test="${!empty board.board_filename}">
		<li>첨부 파일 : <a href="file.do?board_num=${board.board_num}">${board.board_filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width="100%">
	<c:if test="${
	fn:endsWith(board.board_filename,'.jpg') ||
	fn:endsWith(board.board_filename,'.JPG') ||
	fn:endsWith(board.board_filename,'.gif') ||
	fn:endsWith(board.board_filename,'.GIF') ||
	fn:endsWith(board.board_filename,'.png') ||
	fn:endsWith(board.board_filename,'.PNG')
	 		}">
	 		<div class="align-center">
	 			 <img src="imageView.do?board_num=${board.board_num}" style="max-width:500px"> 
	 		</div>
	</c:if>
	<p>
		${board.board_con}
	</p>
	<hr size="1" width="100%">
	<div class="align-right">
		<%-- 글수정 ㅅ각제를 하려면 로그인  --%>
		<c:if test="${!empty user_id && user_id == board.mem_id}">
		<input type="button" value="수정" onclick="location.href='modify.do?board_num=${board.board_num}'">
		<input type="button" value="삭제" onclick="location.href='delete.do?board_num=${board.board_num}'">
		</c:if>
		<input type="button" value="목록" onclick="location.href='community.do'">
	</div>
</div>
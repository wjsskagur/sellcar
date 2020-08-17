<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<div class="page-main-style">
	<h2>게시판 목록</h2>
	<form action="community.do" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="id">아이디</option>
				</select>
			</li>
			<li>
				<input type="search" size="16" name="keyword" id="keyword">
			</li>
			<li>
				<input type="submit" value="찾기">
			</li>
		</ul>
	</form>
	<div class="align-right">
		<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count==0}">
	<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
	<table class="table table-striped">
	<tr>
		<th>번호</th>
		<th width="300">제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="board" items="${list}">
	<tr>
		<td>${board.board_num}</td>
		<td><a href="detail.do?board_num=${board.board_num}">${board.board_name}</a></td>
		<td>${board.mem_id}</td>
		<td>${board.reg_date}</td>
		<td>${board.board_hit}</td>
	</tr>
	</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
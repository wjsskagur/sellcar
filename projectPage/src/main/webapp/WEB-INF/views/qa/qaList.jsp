<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-main-style">
		<h2>게시판 목록</h2>
		<c:if test="${count == 0}">
			<div class="result-display">등록된 게시물이 없습니다.</div>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr>
					<th>번호</th>
					<th width="300">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="qa" items="${list}">
					<tr>
						<td>${qa.num}</td>
						<td><a href="detail.do?num=${qa.num}">${qa.title}</a></td>
						<td>${qa.mem_id}</td>
						<td>${qa.reg_date}</td>
						<td>${qa.hit}</td>
					</tr>
				</c:forEach>
			</table>	
	<div class="align-center">${pagingHtml}</div>
	<div class="align-right">
		<c:if test="${!empty user_id}">
			<input type="button" value="글쓰기" onclick="location.href='write.do'">
		</c:if>
	</div>
	</c:if>
	<form id="search_form" action="list.do" method="get">
		<ul class="search">
			<li><select name="keyfield">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="id">id</option>
			</select></li>
			<li><input type="search" size="16" name="keyword" id="keyword">
			</li>
			<li><input type="submit" value="찾기"></li>
		</ul>
	</form>
</div>





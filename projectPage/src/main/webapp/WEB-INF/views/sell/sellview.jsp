<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
<h2>내차 사진 등록</h2>
	<form action="list.do" id="search_form" method="get">
		<!-- <ul class="search">
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
		</ul> -->
	</form>
	<div class="align-right">
		
	</div>
	<c:if test="${count==0}">
	<div class="result-display">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
	<table>
	<tr>
		<th>차량번호</th>
		<th>제조사</th>
		<th>차량모델</th>
		<th>연식</th>
		<th>작성자</th>
		<th>등록일</th>
		
	</tr>
	<c:forEach var="board" items="${list}">
	
	<tr>
		<td><a href="sellphoto.do?car_num=${board.car_num}">${board.car_number}</a></td>
		<td>${board.car_cate1}</td>
		<td>${board.car_cate2}</td>
		<td>${board.car_cate3}</td>
		<td>${board.mem_id}</td>
		<td>${board.mod_date}</td>
		
	</tr>
	
	</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
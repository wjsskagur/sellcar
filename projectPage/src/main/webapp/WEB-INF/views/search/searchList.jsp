<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="page-main-style">
		<h2>회원목록</h2>
		<div class="align-right">
			<input type="button" value="등록" onclick="location.href='insert.do'">
		</div>
		<c:if test="${count == 0}">
			<div class="result-display">출력할 내용이 없습니다.</div>
		</c:if>
		<c:if test="${count > 0}">
			<table>
				<tr>
					<th>번호</th>
					<th>차이름</th>
					<th>제조사</th>
				</tr>
				<c:forEach var="search" items="${list}">
					<tr>
						<td>${search.car_num}</td>
						<td>${search.car_name}</td>
						<td>${search.car_make}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="align-center">${pagingHtml}</div>
		</c:if>
	</div>